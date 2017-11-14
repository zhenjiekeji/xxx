/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeRoleDao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRole;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeRoleManager extends BaseManager<SecPrivilegeRole, java.lang.String> {
    /**
     * historyDao
     */
    private SecPrivilegeRoleDao secPrivilegeRoleDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeRoleDao(SecPrivilegeRoleDao dao) {
        this.secPrivilegeRoleDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secPrivilegeRoleDao;
    }
    
    /**
     * 根据zTree要求的格式构造模板map名单
     * 
     * @param 已经勾选的树的key组成的map
     */
    public List<Map> getRoleGroupZtreeMap(Map<String, Object> selectedItemMap) {
        List<SecPrivilegeRole> secPrivilegeRole = secPrivilegeRoleDao.selectAllRoleListOrder();
        List<Map> sonTrees = new ArrayList<Map>();
        // 根据zTree要求的格式构造角色map名单
        for (SecPrivilegeRole secPrivilegeRoleList : secPrivilegeRole) {
            Map map = makeRoleTree(secPrivilegeRoleList, selectedItemMap);
            sonTrees.add(map);
        }
        return sonTrees;
    }
    
    private Map makeRoleTree(SecPrivilegeRole secPrivilegeRole, Map<String, Object> selectedItemMap) {
        Map tree = new HashMap();
        tree.put("id", secPrivilegeRole.getRoleId());
        tree.put("pId", "0");
        tree.put("name", secPrivilegeRole.getRoleName());
        if (selectedItemMap != null && selectedItemMap.containsKey(String.valueOf(secPrivilegeRole.getRoleId()))) {
            tree.put("checked", true);
            tree.put("open", true);
        } else {
            tree.put("checked", false);
        }
        return tree;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeRoleDao.findByPageRequest(pr);
    }
    
    public List<SecPrivilegeRole> selectAllRoleListOrder() {
        return secPrivilegeRoleDao.selectAllRoleListOrder();
    }
    
    public List<SecPrivilegeRole> selectUserRoleList(String loginId) {
        return secPrivilegeRoleDao.selectUserRoleList(loginId);
    }
    
}
