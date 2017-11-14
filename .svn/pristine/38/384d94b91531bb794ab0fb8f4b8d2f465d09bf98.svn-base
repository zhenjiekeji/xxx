/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.aop.ValidationAware;
import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.framework.ectable.dao.EctableColumnDao;
import com.uk.sec.framework.ectable.model.EctableColumn;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class EctableColumnManager extends BaseManager<EctableColumn, java.lang.String> implements ValidationAware {
    /**
     * historyDao
     */
    private EctableColumnDao           ectableColumnDao;
    private EctableColumnDetailManager ectableColumnDetailManager;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setEctableColumnDao(EctableColumnDao dao) {
        this.ectableColumnDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.ectableColumnDao;
    }
    
    public void validateFindByPageRequest(PageRequest pr) {
        logger.info("EctableColumnManager: testFindByPageRequest");
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        this.ectableColumnDetailManager.findByPageRequest(pr);
        return ectableColumnDao.findByPageRequest(pr);
    }
    
    /**
     * 根据唯一名称查询.
     * 
     * @param uniqueName
     * @return
     * @author xzw
     */
    public EctableColumn findByUniqueName(String uniqueName) {
        return this.ectableColumnDao.findByProperty("uniqueName", uniqueName);
    }
    
    /**
     * 根据ectableColumn和userId查询viewType为html的.
     * 
     * @param ectableColumn
     * @param userId
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findEcdListByEc(EctableColumn ectableColumn, String userId) {
        return ectableColumnDetailManager.findByUserIdAndViewType(ectableColumn.getId(), userId, "html");
    }
    
    /**
     * @return the ectableColumnDetailManager
     */
    public EctableColumnDetailManager getEctableColumnDetailManager() {
        return ectableColumnDetailManager;
    }
    
    /**
     * @param ectableColumnDetailManager
     *            the ectableColumnDetailManager to set
     */
    public void setEctableColumnDetailManager(EctableColumnDetailManager ectableColumnDetailManager) {
        this.ectableColumnDetailManager = ectableColumnDetailManager;
    }
}
