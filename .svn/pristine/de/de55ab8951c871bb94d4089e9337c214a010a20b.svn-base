/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uk.sec.bns.client.model.BasicInvestorOwner;
import com.uk.sec.framework.base.BaseIbatis3Dao;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class BasicInvestorOwnerDao extends BaseIbatis3Dao<BasicInvestorOwner, java.lang.String> {
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return BasicInvestorOwner.class;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(BasicInvestorOwner entity) {
        if (entity.getLiPkId() == null)
            save(entity);
        else
            update(entity);
    }
    
    /**
     * 分页查询.
     * 
     * @param pageRequest
     *            查询参数.
     * @return page.
     */
    public Page findByPageRequest(PageRequest pageRequest) {
        return pageQuery("BasicInvestorOwner.pageSelect", pageRequest);
    }
    
    public List<BasicInvestorOwner> selectAllProductListOrder() {
        return this.getSqlSession().selectList("BasicInvestorOwner.selectAllListOrder");
    }    
}
