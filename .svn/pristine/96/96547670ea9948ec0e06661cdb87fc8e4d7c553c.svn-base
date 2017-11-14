/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRole;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeRoleDao extends BaseIbatis3Dao<SecPrivilegeRole,java.lang.String>{
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    public Class getEntityClass() {
        return SecPrivilegeRole.class;
    }
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(SecPrivilegeRole entity) {
        if(entity.getRoleId() == null)
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
        return pageQuery("SecPrivilegeRole.pageSelect",pageRequest);
    }

    public List<SecPrivilegeRole> selectAllRoleListOrder(){
    	return this.getSqlSession().selectList("SecPrivilegeRole.selectAllRoleListOrder");
    }

    public List<SecPrivilegeRole> selectUserRoleList(String loginId){
    	return this.getSqlSession().selectList("SecPrivilegeRole.selectUserRoleList",loginId);
    }


}
