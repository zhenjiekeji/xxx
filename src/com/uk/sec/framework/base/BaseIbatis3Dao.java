package com.uk.sec.framework.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;

import com.uk.sec.framework.log.LogFactory;
import com.uk.sec.framework.util.ReflectHelper;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author xzw
 * @version 1.0
 */
public abstract class BaseIbatis3Dao<E, PK extends Serializable> extends SqlSessionDaoSupport implements
        EntityDao<E, PK> {
    protected final Logger logger = LogFactory.LOGGER_DAO;

    public abstract Class getEntityClass();

    public Object getById(PK primaryKey) {
        Object object = getSqlSession().selectOne(getFindByPrimaryKeyQuery(), primaryKey);
        return object;
    }

    public void deleteById(PK id) {
        getSqlSession().delete(getDeleteQuery(), id);
    }

    public void save(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        Object primaryKey = getSqlSession().insert(getInsertQuery(), entity);
    }
    /** 
     * insert:插入操作. <br/> 
     * 
     * @author waite 
     * @param method 插入操作的方法名 
     * @param entity 查询参数或实体类 
     * @return 返回影响的行数 
     * @since JDK 1.6 
     */  
    public int insert(String method,Object entity){  
        return this.getSqlSession().insert(method, entity);  
    } 
    public void update(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        Object primaryKey = getSqlSession().update(getUpdateQuery(), entity);
    }

    /**
     * 用于子类覆盖,在insert,update之前调用
     *
     * @param o
     */
    protected void prepareObjectForSaveOrUpdate(E o) {
    }

    public String getFindByPrimaryKeyQuery() {
        return getEntityClass().getSimpleName() + ".getById";
    }

    public String getInsertQuery() {
        return getEntityClass().getSimpleName() + ".insert";
    }

    public String getUpdateQuery() {
        return getEntityClass().getSimpleName() + ".update";
    }

    public String getDeleteQuery() {
        return getEntityClass().getSimpleName() + ".delete";
    }

    public String getCountQuery() {
        return getEntityClass().getSimpleName() + ".count";
    }

    public String getFindAllQuery() {
        return getEntityClass().getSimpleName() + ".findAll";
    }

    public String getFindAllByMapQuery() {
        return getEntityClass().getSimpleName() + ".findAllByMap";
    }

    protected Page pageQuery(String statementName, PageRequest pageRequest) {
        return pageQuery(statementName, this.getCountQuery(), pageRequest);

    }

    protected Page pageQuery(String statementName, String countStatement, PageRequest pageRequest) {

        Number totalCount = (Number) this.getSqlSession().selectOne(countStatement, pageRequest.getFilters());
        if (totalCount == null || totalCount.intValue() <= 0) {
            return new Page(pageRequest, 0);
        }

        Page page = new Page(pageRequest, totalCount.intValue());

        // 其它分页参数,用于不喜欢或是因为兼容性而不使用方言(Dialect)的分页用户使用.
        // 与getSqlMapClientTemplate().queryForList(statementName,
        // parameterObject)配合使用
        Map filters = new HashMap();
        filters.put("offset", page.getFirstResult());
        filters.put("pageSize", page.getPageSize());
        filters.put("lastRows", page.getFirstResult() + page.getPageSize());
        filters.put("sortColumns", pageRequest.getSortColumns());

        // 混合两个filters为一个filters,MapAndObject.get()方法将在两个对象取值,Map如果取值为null,则再在Bean中取值
        if (pageRequest.getFilters() instanceof Map) {
            filters.putAll((Map) pageRequest.getFilters());
        } else {
            Map parameterObject = BeanUtils.describe(pageRequest.getFilters());
            filters.putAll(parameterObject);
        }

        List list = getSqlSession().selectList(statementName,
                                               filters,
                                               new RowBounds(page.getFirstResult(), page.getPageSize()));
        page.setResult(list);
        return page;
    }

    public boolean isUnique(E entity, String uniquePropertyNames) {
        throw new UnsupportedOperationException();
    }

    public void flush() {
        // ignore
    }

    /** **************************************************** */

    public List<E> findAll(E e) {
        return getSqlSession().selectList(getFindAllQuery(), e);
    }

    public List findAll() {
        return getSqlSession().selectList(getFindAllQuery());
    }

    public List findAll(String sql, HashMap paraMap) {
        throw new UnsupportedOperationException();
    }

    public List<E> findAll(String sql) {
        throw new UnsupportedOperationException();
    }

    public List<E> findAllBy(String propertyName, Object value) {
        Class c = getEntityClass();
        Object o = null;
        try {
            o = c.newInstance();
            ReflectHelper.setFieldValue(o, propertyName, value);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getSqlSession().selectList(getFindAllQuery(), o);
    }

    public List<E> findAllBy(Map paraMap) {
        Class c = getEntityClass();
        Object o = null;
        try {
            o = c.newInstance();
            Iterator it = paraMap.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                ReflectHelper.setFieldValue(o, key, paraMap.get(key));
            }
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getSqlSession().selectList(getFindAllQuery(), o);
    }

    public List<E> findAllByMap(Map paraMap) {
        return getSqlSession().selectList(getFindAllByMapQuery(), paraMap);
    }

    public E findByProperty(String propertyName, Object value) {
        Class c = getEntityClass();
        Object o = null;
        try {
            o = c.newInstance();
            ReflectHelper.setFieldValue(o, propertyName, value);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return (E) getSqlSession().selectOne(getFindAllQuery(), o);
    }

    public E loadById(PK id) {
        throw new UnsupportedOperationException();
    }

    public void saveOrUpdate(E entity) {
        // ignore
    }

    public Number getCountNumBySpecificCondition(){
    	return (Number)this.getSqlSession().selectOne(getEntityClass().getSimpleName() + ".countBySpecificCondition");
    }
    public Number getCountNumBySpecificCondition(Object obj){
    	return (Number)this.getSqlSession().selectOne(getEntityClass().getSimpleName() + ".countBySpecificCondition",obj);
    }

}
