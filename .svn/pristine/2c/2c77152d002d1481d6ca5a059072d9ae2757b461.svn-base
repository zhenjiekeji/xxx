/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRoleMenuOper;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeRoleMenuOperDao extends BaseIbatis3Dao<SecPrivilegeRoleMenuOper,java.lang.String>{
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    public Class getEntityClass() {
        return SecPrivilegeRoleMenuOper.class;
    }
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(SecPrivilegeRoleMenuOper entity) {
        if(entity.getRmoId() == null)
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
        return pageQuery("SecPrivilegeRoleMenuOper.pageSelect",pageRequest);
    }

    public void deleteByRoleId(String roleId){
    	this.getSqlSession().delete("SecPrivilegeRoleMenuOper.deleteByRoleId",roleId);
    }

    public void deleteByMenuId(String menuId){
    	this.getSqlSession().delete("SecPrivilegeRoleMenuOper.deleteByMenuId",menuId);
    }
    /**
	 * 角色菜单操作表中去重的menuId列表.
	 */
	public List<String> selectDistinctMenuId(String roleId) {
		return this.getSqlSession().selectList("SecPrivilegeRoleMenuOper.selectDistinctMenuId",roleId);
	}

}
