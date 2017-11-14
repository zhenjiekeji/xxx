/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class EctableColumnDetailDao extends BaseIbatis3Dao<EctableColumnDetail, java.lang.String> {
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return EctableColumnDetail.class;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(EctableColumnDetail entity) {
        if (entity.getId() == null) {
            save(entity);
        } else {
            update(entity);
        }
    }
    
    /**
     * 分页查询.
     * 
     * @param pageRequest
     *            查询参数.
     * @return page.
     */
    public Page findByPageRequest(PageRequest pageRequest) {
        return pageQuery("EctableColumnDetail.pageSelect", pageRequest);
    }
    
    /**
     * 依据 表单ID、 用户、视图类型获取显示定义
     * 
     * @param ectableColumnId
     * @param userId
     * @param viewType
     * @return
     */
    public List<EctableColumnDetail> findByUserIdAndViewType(String ectableColumnId, String userId, String viewType) {
        List<EctableColumnDetail> list = this.findByuserIdAndViewType(ectableColumnId, userId, viewType);
        if (list.isEmpty()) {
            list = this.findByuserIdAndViewType(ectableColumnId, "1", viewType);
        }
        return list;
    }
    
    /**
     * 根据ectableColumnId,用户id,视图类型查询.
     * 
     * @param ectableColumnId
     * @param userId
     * @param viewType
     * @return
     * @author xzw
     */
    private List<EctableColumnDetail> findByuserIdAndViewType(String ectableColumnId, String userId, String viewType) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ectableColumnId", ectableColumnId);
        param.put("userId", userId);
        param.put("viewType", viewType);
        return this.findAllByMap(param);
    }
    
    /**
     * 根据ectableColumnId,用户id,视图类型查询showStatus为不显示的.
     * 
     * @param ectableColumnId
     * @param userId
     * @param viewType
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findDeniedByViewType(String ectableColumnId, String userId, String viewType) {
        
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ectableColumnId", ectableColumnId);
        param.put("userId", userId);
        param.put("viewType", viewType);
        param.put("showStatus", 0L);
        return this.findAllByMap(param);
        
    }
    
    /**
     * 查询下一个排序号
     * 
     * @param ectableColumnId
     * @param viewType
     * @return
     * @author xzw
     */
    public int findECDByMaxOrderNum(String ectableColumnId, String viewType) {
        
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ectableColumnId", ectableColumnId);
        param.put("viewType", viewType);
        param.put("showStatus", 0L);
        List<EctableColumnDetail> list = this.findAllByMap(param);
        if (list.size() > 0) {
            return (list.get(list.size() - 1)).getOrderNum() + 1;
        }
        return 1;
    }
    
    /**
     * 根据ectableColumnId和columnName查找一条记录
     * 
     * @param ectableColumnId
     * @param columnName
     * @return
     * @author xzw
     */
    public EctableColumnDetail findECDByColumnNameAndId(String ectableColumnId, String columnName) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ectableColumnId", ectableColumnId);
        param.put("columnName", columnName);
        List<EctableColumnDetail> list = this.findAllByMap(param);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据ectableColumnId和columnName删除记录.
     * 
     * @param ectableColumnId
     * @param columnName
     * @author xzw
     */
    public void removeECDByColumnNameAndId(String ectableColumnId, String columnName) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ectableColumnId", ectableColumnId);
        param.put("columnName", columnName);
        getSqlSession().delete("EctableColumnDetail.deleteByParams", param);
        
    }
    
    /**
     * 根据视图类型为html 的一个ectableColumnDetail查询同一属性的视图类型为xls的ectableColumnDetail.
     * 
     * @param ectableColumnDetail
     * @return
     * @author xzw
     */
    public EctableColumnDetail findByHtml(EctableColumnDetail ectableColumnDetail) {
        
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("columnName", ectableColumnDetail.getColumnName());
        param.put("userId", ectableColumnDetail.getUserId());
        param.put("ectableColumnId", ectableColumnDetail.getEctableColumnId());
        param.put("viewType", "xls");
        List<EctableColumnDetail> list = this.findAllByMap(param);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 批量保存.
     * 
     * @param entities
     * @author xzw
     */
    public void saveAll(List<EctableColumnDetail> entities) {
        for (EctableColumnDetail e : entities) {
            this.save(e);
        }
    }
}
