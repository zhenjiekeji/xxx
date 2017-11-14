/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRole;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserRole;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuOperManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleMenuOperManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeUserRoleManager;
import com.uk.sec.privilege.framework.privilege.util.PFUtils.SplitSignal;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecPrivilegeRoleAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String            DEFAULT_SORT_COLUMNS        = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 列表页面.
     */
    protected static final String            LIST_JSP                    = "/framework/privilege/SecPrivilegeRole/list.jsp";
    /**
     * 编辑页面.
     */
    protected static final String            EDIT_JSP                    = "/framework/privilege/SecPrivilegeRole/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String            SHOW_JSP                    = "/framework/privilege/SecPrivilegeRole/show.jsp";
    /**
     * 创建页面.
     */
    protected static final String            CREATE_JSP                  = "/framework/privilege/SecPrivilegeRole/create.jsp";
    /**
     * 角色关联菜单、操作页面.
     */
    protected static final String            ROLE_RELATE_MENUS_OPERS_JSP = "/framework/privilege/SecPrivilegeRole/roleRelateMenusOpers.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String            LIST_ACTION                 = "!/framework/privilege/SecPrivilegeRole/list.do"
                                                                           + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private SecPrivilegeRoleManager          secPrivilegeRoleManager;
    
    private SecPrivilegeRoleMenuOperManager  secPrivilegeRoleMenuOperManager;
    
    private SecPrivilegeUserRoleManager      secPrivilegeUserRoleManager;
    
    private SecPrivilegeMenuManager          secPrivilegeMenuManager;
    
    private SecPrivilegeMenuOperManager      secPrivilegeMenuOperManager;
    /**
     * model.
     */
    private SecPrivilegeRole                 secPrivilegeRole;
    
    private List<SecPrivilegeMenu>           selectAllMenuList;                                                                             // 菜单表中的所有可见菜单列表
    private Map<String, List<SecBasDicItem>> menuOperationList;                                                                             // 菜单关联的所有操作列表
    private Map<String, List<SecBasDicItem>> roleMenuOperationList;                                                                         // 角色关联的菜单对应的操作列表
                                                                                                                                             
    /**
     * id.
     */
    java.lang.String                         id                          = null;
    java.lang.String                         roleIds                     = null;
    
    private String                           message;
    /**
     * items 删除记录id数组.
     */
    private String[]                         items;
    
    private String                           menuIdOperation;           // 格式为menuId@@@menuId@@@menuId
                                                                                                                                             
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
            secPrivilegeRole = new SecPrivilegeRole();
        } else {
            secPrivilegeRole = secPrivilegeRoleManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secPrivilegeRole;
    }
    
    public List<SecPrivilegeMenu> getSelectAllMenuList() {
        return selectAllMenuList;
    }
    
    public Map<String, List<SecBasDicItem>> getMenuOperationList() {
        return menuOperationList;
    }
    
    public Map<String, List<SecBasDicItem>> getRoleMenuOperationList() {
        return roleMenuOperationList;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecPrivilegeRoleManager(SecPrivilegeRoleManager manager) {
        this.secPrivilegeRoleManager = manager;
    }
    
    public void setSecPrivilegeRoleMenuOperManager(SecPrivilegeRoleMenuOperManager secPrivilegeRoleMenuOperManager) {
        this.secPrivilegeRoleMenuOperManager = secPrivilegeRoleMenuOperManager;
    }
    
    public void setSecPrivilegeUserRoleManager(SecPrivilegeUserRoleManager secPrivilegeUserRoleManager) {
        this.secPrivilegeUserRoleManager = secPrivilegeUserRoleManager;
    }
    
    public void setSecPrivilegeMenuManager(SecPrivilegeMenuManager secPrivilegeMenuManager) {
        this.secPrivilegeMenuManager = secPrivilegeMenuManager;
    }
    
    public void setSecPrivilegeMenuOperManager(SecPrivilegeMenuOperManager secPrivilegeMenuOperManager) {
        this.secPrivilegeMenuOperManager = secPrivilegeMenuOperManager;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setRoleId(java.lang.String val) {
        this.id = val;
    }
    
    public String getMessage() {
        return message;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    public void setMenuIdOperation(String menuIdOperation) {
        this.menuIdOperation = menuIdOperation;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest("ROLE_LEVEL,ROLE_NAME");
        // pageRequest.getFilters().put("key",value); //add custom filter
        Page page = secPrivilegeRoleManager.findByPageRequest(pageRequest);
        savePage(page, pageRequest);
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
     * 创建对象.
     * 
     * @return 创建页面.
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
        secPrivilegeRole.setRoleLevel(SecPrivilegeRole.DEFAULT_ROLE_LEVEL);
        secPrivilegeRoleManager.save(secPrivilegeRole);
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
        secPrivilegeRoleManager.update(this.secPrivilegeRole);
        return LIST_ACTION;
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String delete() {
        SecPrivilegeUserRole secPrivilegeUserRole = new SecPrivilegeUserRole();
        for (int i = 0; i < items.length; i++) {
            Hashtable params = HttpUtils.parseQueryString(items[i]);
            java.lang.String id = new java.lang.String((String) params.get("roleId"));
            // 删除角色菜单操作表中该角色关联的所有菜单、操作
            secPrivilegeRoleMenuOperManager.deleteByRoleId(id);
            // 删除用户角色表中所有用户关联的该角色
            secPrivilegeUserRole.setRoleId(id);
            secPrivilegeUserRoleManager.deleteUserAndRole(secPrivilegeUserRole);
            // 删除角色表中该角色
            secPrivilegeRoleManager.removeById(id);
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
            // 删除角色菜单操作表中该角色关联的所有菜单、操作
            secPrivilegeRoleMenuOperManager.deleteByRoleId(id);
            // 删除用户角色表中所有用户关联的该角色
            SecPrivilegeUserRole secPrivilegeUserRole = new SecPrivilegeUserRole();
            secPrivilegeUserRole.setRoleId(id);
            secPrivilegeUserRoleManager.deleteUserAndRole(secPrivilegeUserRole);
            // 删除角色表中该角色
            secPrivilegeRoleManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    /**
     * 查询角色树，以json形式返回 角色列表
     */
    public void zTreeRoleGroup() throws Exception {
        System.out.println("roleIds:" + roleIds);
        Map<String, Object> selectedItemMap = new HashMap<String, Object>();
        String roleIdstr = this.roleIds;
        if (roleIdstr != null && !"".equals(roleIdstr)) {
            String[] deptids = roleIdstr.split(SplitSignal.SPLIT_SIGNAL_AIT.getSignal());
            for (String id : deptids) {
                selectedItemMap.put(id, null);
            }
        }
        List<Map> sysInfoGroupMap = secPrivilegeRoleManager.getRoleGroupZtreeMap(selectedItemMap);
        this.getResponse().getWriter().print(JSONArray.toJSONString(sysInfoGroupMap));// 把数据回传页面
    }
    
    public String roleRelateMenusOpers() {
//        selectAllMenuList = secPrivilegeMenuManager.selectAllMenuListOrder();
//        menuOperationList = secPrivilegeMenuOperManager.selectMenuOperationList();
//        roleMenuOperationList = secPrivilegeRoleMenuOperManager.selectRoleMenuOperationList(id);
        return ROLE_RELATE_MENUS_OPERS_JSP;
    }
    
    /**
     * 查询角色关联的菜单树，以json形式返回 角色列表
     */
    public void zTreeMenuOrder() throws Exception {
        Map<String, Object> selectedItemMap = new HashMap<String, Object>();
        if (!isNullOrEmptyString(this.id)) {
        	List<String> menuIdList = secPrivilegeRoleMenuOperManager.selectMenuListByRoleId(this.id);
            for (String menuId : menuIdList) {
                selectedItemMap.put(menuId, null);
            }
        }
        List<Map> roleRelateMenuMap = secPrivilegeMenuManager.getRoleRelateMenuZtreeMap(selectedItemMap);
        this.getResponse().getWriter().print(JSONArray.toJSONString(roleRelateMenuMap));// 把数据回传页面
    }    
    
    
    /**
     * 给相应角色重新分配相应的菜单及其对应的操作信息
     * 
     * @return status,提交新的数据是否成功
     */
    public String assignRoleMenuOperation() {
        // 首先删除原来分配的旧的权限，然后再插入新分配的所有权限
        String errorMessage = secPrivilegeRoleMenuOperManager.assignRoleMenuOperation(id, menuIdOperation);
        this.getRequest().setAttribute("errorMessage", errorMessage);
        return list();
    }
    
    @Override
    public String getEctableId() {
        return "SecPrivilegeRole_list";
    }
    
    public java.lang.String getRoleIds() {
        return roleIds;
    }
    
    public void setRoleIds(java.lang.String roleIds) {
        this.roleIds = roleIds;
    }
}
