package com.uk.sec.framework.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xzw
 */
public interface EntityDao<E, PK extends Serializable> {
    
    public Object getById(PK id);
    
    public E loadById(PK id);
    
    public void deleteById(PK id);
    
    public void save(E entity);
    
    public void update(E entity);
    
    public void saveOrUpdate(E entity);
    
    public boolean isUnique(E entity, String uniquePropertyNames);
    
    public void flush();
    
    public List<E> findAll(E e);
    
    public List<E> findAll();
    
    public List<E> findAllBy(final String propertyName, final Object value);
    
    public List<E> findAllBy(final Map paraMap);
    
    public List<E> findAllByMap(Map paraMap);
    
    public List findAll(String sql, HashMap paraMap);
    
    public List<E> findAll(String sql);
    
    public E findByProperty(final String propertyName, final Object value);
    
}
