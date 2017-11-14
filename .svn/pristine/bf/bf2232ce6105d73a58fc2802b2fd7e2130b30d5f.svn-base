/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenuOper;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeMenuOperDao extends BaseIbatis3Dao<SecPrivilegeMenuOper,java.lang.String>{
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    public Class getEntityClass() {
        return SecPrivilegeMenuOper.class;
    }
    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(SecPrivilegeMenuOper entity) {
        if(entity.getMenuOperId() == null)
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
        return pageQuery("SecPrivilegeMenuOper.pageSelect",pageRequest);
    }

    /**
	 * 菜单操作表中去重的menuId列表.
	 */
	public List<String> selectDistinctMenuId() {
		return this.getSqlSession().selectList("SecPrivilegeMenuOper.selectDistinctMenuId");
	}

    /**
	 * 根据菜单id删除关联的原有操作
	 */
	public void deleteByMenuId(String menuId) {
		this.getSqlSession().delete("SecPrivilegeMenuOper.deleteByMenuId",menuId);
	}

}
