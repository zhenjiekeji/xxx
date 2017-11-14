/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserRole;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeUserRoleManager;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */


public class SecPrivilegeUserRoleAction extends BaseStruts2Action implements Preparable,ModelDriven{
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String DEFAULT_SORT_COLUMNS = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 查询页面.
     */
    protected static final String QUERY_JSP = "/framework/privilege/SecPrivilegeUserRole/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String LIST_JSP = "/framework/privilege/SecPrivilegeUserRole/list.jsp";
    /**
     * 新建页面.
     */
    protected static final String CREATE_JSP = "/framework/privilege/SecPrivilegeUserRole/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String EDIT_JSP = "/framework/privilege/SecPrivilegeUserRole/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String SHOW_JSP = "/framework/privilege/SecPrivilegeUserRole/show.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String LIST_ACTION = "!/framework/privilege/SecPrivilegeUserRole/list.do"+NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecPrivilegeUserRoleManager secPrivilegeUserRoleManager;
    /**
     * model.
     */
    private SecPrivilegeUserRole secPrivilegeUserRole;
    /**
     * id.
     */
    java.lang.String id = null;
    /**
     * items 删除记录id数组.
     */
    private String[] items;
    /*
     * 内部成员定义.---------------E N D---------------
     */

    /**
     * {@inheritDoc}
     *
     * @see com.opensymphony.xwork2.Preparable#prepare()
     */
    public void prepare() throws Exception {
        if (isNullOrEmptyString(id)) {
            secPrivilegeUserRole = new SecPrivilegeUserRole();
        } else {
            secPrivilegeUserRole = (SecPrivilegeUserRole)secPrivilegeUserRoleManager.getById(id);
        }
    }

    /**
     * {@inheritDoc}
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secPrivilegeUserRole;
    }

    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     *
     * @param manager
     *            manager.
     */
    public void setSecPrivilegeUserRoleManager(SecPrivilegeUserRoleManager manager) {
        this.secPrivilegeUserRoleManager = manager;
    }

    /**
     * @param val
     *            id.
     */
    public void setUserRoleId(java.lang.String val) {
        this.id = val;
    }

    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }

    /**
     * 进入查询页面.
     *
     * @return 查询页面.
     */
    public String query() {
        return QUERY_JSP;
    }

    /**
     * 执行搜索.
     *
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
        //pageRequest.getFilters().put("key",value);     //add custom filter
        Page page = secPrivilegeUserRoleManager.findByPageRequest(pageRequest);
        savePage(page,pageRequest);
        return LIST_JSP;
    }

    /**
     * 查看对象.
     *
     * @return 查看页面.
     */
    public String show() {
        return SHOW_JSP;
    }

    /**
     * 进入新增页面
     *
     * @return 新增页面.
     */
    public String create() {
        return CREATE_JSP;
    }

    /**
     * 保存新增对象.
     *
     * @return 重定向到列表页面.
     */
    public String save() {
        secPrivilegeUserRoleManager.save(secPrivilegeUserRole);
        return LIST_ACTION;
    }

    /**
     * 进入更新页面.
     *
     * @return 更新页面.
     */
    public String edit() {
        return EDIT_JSP;
    }

    /**
     * 保存更新对象.
     *
     * @return 重定向到列表页面.
     */
    public String update() {
        secPrivilegeUserRoleManager.update(this.secPrivilegeUserRole);
        return LIST_ACTION;
    }

    /**
     * 删除对象.
     *
     * @return 重定向到列表页面.
     */
    public String delete() {
        for(int i = 0; i < items.length; i++) {
            Hashtable params = HttpUtils.parseQueryString(items[i]);
            java.lang.String id = new java.lang.String((String)params.get("userRoleId"));
            secPrivilegeUserRoleManager.removeById(id);
        }
        return LIST_ACTION;
    }

    /**
	 * 删除对象.
	 *
	 * @return 重定向到列表页面.
	 */
	public String deleteById() {
		if (StringUtils.isNotBlank(id)) {
			secPrivilegeUserRoleManager.removeById(id);
		}
		return LIST_ACTION;
	}

    public String getEctableId() {
        return "SecPrivilegeUserRole_list";
    }
}
