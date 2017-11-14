/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserRole;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeUserRoleDao extends BaseIbatis3Dao<SecPrivilegeUserRole,java.lang.String>{
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    public Class getEntityClass() {
        return SecPrivilegeUserRole.class;
    }
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(SecPrivilegeUserRole entity) {
        if(entity.getUserRoleId() == null)
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
        return pageQuery("SecPrivilegeUserRole.pageSelect",pageRequest);
    }

    public void deleteUserAndRole(SecPrivilegeUserRole secPrivilegeUserRole){
    	this.getSqlSession().delete("SecPrivilegeUserRole.deleteUserAndRole",secPrivilegeUserRole);
    }

}
