/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.bns.client.dao.BasicTolllaneDao;
import com.uk.sec.bns.client.model.BasicTolllane;
import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class BasicTolllaneManager extends BaseManager<BasicTolllane, java.lang.String> {
    /**
     * historyDao
     */
    private BasicTolllaneDao basicTolllaneDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setBasicTolllaneDao(BasicTolllaneDao dao) {
		this.basicTolllaneDao = dao;
	}
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.basicTolllaneDao;
    }

	/**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return basicTolllaneDao.findByPageRequest(pr);
    }
    
}
