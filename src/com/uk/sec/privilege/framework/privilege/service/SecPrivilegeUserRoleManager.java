/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeUserRoleDao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserRole;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeUserRoleManager extends BaseManager<SecPrivilegeUserRole,java.lang.String>{
    /**
     * historyDao
     */
    private SecPrivilegeUserRoleDao secPrivilegeUserRoleDao;

    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     *
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeUserRoleDao(SecPrivilegeUserRoleDao dao) {
        this.secPrivilegeUserRoleDao = dao;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    public EntityDao getEntityDao() {
        return this.secPrivilegeUserRoleDao;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Transactional(readOnly=true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeUserRoleDao.findByPageRequest(pr);
    }

    public void deleteUserAndRole(SecPrivilegeUserRole secPrivilegeUserRole){
    	this.secPrivilegeUserRoleDao.deleteUserAndRole(secPrivilegeUserRole);
    }

    public void saveUserRelateRoles(String[] roleId,String loginId){
    	//将用户角色表中该用户关联的原有记录全部删除
    	SecPrivilegeUserRole secPrivilegeUserRole=new SecPrivilegeUserRole();
    	secPrivilegeUserRole.setLoginId(loginId);
    	secPrivilegeUserRoleDao.deleteUserAndRole(secPrivilegeUserRole);
    	//往用户角色中插入该用户关联的新角色记录
    	if(roleId!=null){
    		for(String id:roleId){
    			secPrivilegeUserRole.setRoleId(id);
    			secPrivilegeUserRoleDao.save(secPrivilegeUserRole);
    		}
    	}
    }

}
