/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecBasDicGroupDao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicGroup;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecBasDicGroupManager extends BaseManager<SecBasDicGroup, java.lang.String> {
    /**
     * historyDao
     */
    private SecBasDicGroupDao secBasDicGroupDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecBasDicGroupDao(SecBasDicGroupDao dao) {
        this.secBasDicGroupDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secBasDicGroupDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secBasDicGroupDao.findByPageRequest(pr);
    }
    
    Long dicGroupCount = 0L;
    
    public List<SecBasDicGroup> findAllDicGroupListByOrder() {
        List<SecBasDicGroup> secBasDicGroupOrders = new ArrayList<SecBasDicGroup>();
        this.dicGroupCount = secBasDicGroupDao.dicGroupCount();
        this.sortDicGroup(null, secBasDicGroupOrders);
        return secBasDicGroupOrders;
    }
    
    public void sortDicGroup(String fatherId, List<SecBasDicGroup> secBasDicGroupOrders) {
        
        if (this.dicGroupCount == 0L) {
            return;
        } else {
            List<SecBasDicGroup> sonGroupInfoOrders = secBasDicGroupDao.querySonTreeByFatherId(fatherId);
            Integer length = sonGroupInfoOrders == null ? 0 : sonGroupInfoOrders.size();
            for (int i = 0; i < length; i++) {
                secBasDicGroupOrders.add(sonGroupInfoOrders.get(i));
                sortDicGroup(sonGroupInfoOrders.get(i).getGroupId(), secBasDicGroupOrders);
            }
        }
    }
    
    public List<SecBasDicGroup> selectAllGroupListOrder() {
        return secBasDicGroupDao.selectAllGroupListOrder();
    }
    
    public String selectGroupVieworder(SecBasDicGroup secBasDicGroup) {
        String vieworder = secBasDicGroupDao.selectGroupVieworderMax(secBasDicGroup);
        int viewOrderLength = vieworder == null ? SecBasDicGroup.GROUP_VIEWORDER_LEVEL : vieworder.length();
        String revertVieworder = vieworder == null ? "1" : String.valueOf(Integer.valueOf(vieworder) + 1);
        int circleNumber = viewOrderLength - revertVieworder.length();
        StringBuffer bf = new StringBuffer();
        if (secBasDicGroup != null && vieworder == null) {
            bf.append(secBasDicGroup.getGroupVieworder());
        }
        for (int i = 1; i <= circleNumber; i++) {
            bf.append('0');
        }
        bf.append(revertVieworder);
        return bf.toString();
    }
    public List<SecBasDicGroup> querySonTreeByFatherId(String fatherId) {
        return secBasDicGroupDao.querySonTreeByFatherId(fatherId);
    }
}
