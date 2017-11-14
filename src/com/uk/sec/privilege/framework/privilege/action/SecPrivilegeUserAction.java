/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
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
import com.uk.sec.framework.security.util.SecurityUtils;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRole;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUser;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserRole;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeUserManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeUserRoleManager;
import com.uk.sec.privilege.framework.privilege.util.PFUtils.SplitSignal;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecPrivilegeUserAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String       DEFAULT_SORT_COLUMNS  = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 列表页面.
     */
    protected static final String       LIST_JSP              = "/framework/privilege/SecPrivilegeUser/list.jsp";
    /**
     * 编辑页面.
     */
    protected static final String       EDIT_JSP              = "/framework/privilege/SecPrivilegeUser/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String       SHOW_JSP              = "/framework/privilege/SecPrivilegeUser/show.jsp";
    /**
     * 创建页面.
     */
    protected static final String       CREATE_JSP            = "/framework/privilege/SecPrivilegeUser/create.jsp";
    /**
     * 关联角色页面.
     */
    protected static final String       USER_RELATE_ROLES_JSP = "/framework/privilege/SecPrivilegeUser/userRelateRoles.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String       LIST_ACTION           = "!/framework/privilege/SecPrivilegeUser/list.do"
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
    private SecPrivilegeUserManager     secPrivilegeUserManager;
    
    private SecPrivilegeUserRoleManager secPrivilegeUserRoleManager;
    
    private SecPrivilegeRoleManager     secPrivilegeRoleManager;
    /**
     * model.
     */
    private SecPrivilegeUser            secPrivilegeUser;
    
    private List<SecPrivilegeRole>      selectAllRoleList;                                                                  // 数据库权限表中的所有角色列表（除去角色级别为最高级别:1的内置角色）
                                                                                                                             
    private List<SecPrivilegeRole>      selectUserRoleList;                                                                 // 当前选中的用户对应的所有角色列表
                                                                                                                             
    /**
     * id.
     */
    java.lang.String                    id                    = null;
    /**
     * items 删除记录id数组.
     */
    private String[]                    items;
    private String[]                    roleId;                                                                             // 选中的角色id数组
                                                                                                                             
    private InputStream                 inputStream;                                                                        // 定义返回的输入流（用于异步验证帐户注册信息）
    private String                      editLoginName;                                                                      // 异步验证编辑用户时的登陆账号
    private String                      originalPasswd;                                                                     // 编辑用户时,如果密码不修改,则不需要重新对密码MD5加密
                                                                                                                             
    private String                      candidateLoginIds;                                                                  // 
    private String                      loginIdByDept;                                                                      // 
    private String                      loginIdByRole;                                                                      // 
                                                                                                                             
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
            secPrivilegeUser = new SecPrivilegeUser();
        } else {
            secPrivilegeUser = secPrivilegeUserManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return secPrivilegeUser;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setSecPrivilegeUserManager(SecPrivilegeUserManager manager) {
        this.secPrivilegeUserManager = manager;
    }
    
    public void setSecPrivilegeUserRoleManager(SecPrivilegeUserRoleManager secPrivilegeUserRoleManager) {
        this.secPrivilegeUserRoleManager = secPrivilegeUserRoleManager;
    }
    
    public void setSecPrivilegeRoleManager(SecPrivilegeRoleManager secPrivilegeRoleManager) {
        this.secPrivilegeRoleManager = secPrivilegeRoleManager;
    }
    
    public List<SecPrivilegeRole> getSelectAllRoleList() {
        return selectAllRoleList;
    }
    
    public List<SecPrivilegeRole> getSelectUserRoleList() {
        return selectUserRoleList;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setLoginId(java.lang.String val) {
        this.id = val;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    public void setRoleId(String[] roleId) {
        this.roleId = roleId;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
    
    public void setEditLoginName(String editLoginName) {
        this.editLoginName = editLoginName;
    }
    
    public void setOriginalPasswd(String originalPasswd) {
        this.originalPasswd = originalPasswd;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest("LOGIN_NAME");
        Page page = secPrivilegeUserManager.findByPageRequest(pageRequest);
        savePage(page, pageRequest);
        return LIST_JSP;
    }
    
    /**
     * 异步验证用户帐户是否被注册
     * 
     * @return
     * @throws Exception
     */
    public String ajaxValidLoginName() {
        // 验证loginName是否被注册
        // 定义返回值：只能为Boolean类型
        Boolean valid = false;
        if (this.editLoginName != null && StringUtils.isNotBlank(this.editLoginName)
            && this.editLoginName.equals(secPrivilegeUser.getLoginName())) {
            valid = true;
        } else {
            valid = secPrivilegeUserManager.existLoginName(secPrivilegeUser) ? false : true;
        }
        inputStream = new ByteArrayInputStream(valid.toString().getBytes());
        return SUCCESS;
    }
    
    /**
     * 查询用户树，以json形式返回 用户列表
     */
    public void zTreeUser() throws Exception {
        Map map = new HashMap();
        System.out.println("candidateLoginIds:" + candidateLoginIds);
        System.out.println("loginIdByDept:" + loginIdByDept);
        System.out.println("loginIdByRole:" + loginIdByRole);
        if (candidateLoginIds != null && !"".equals(candidateLoginIds)) {
            String[] candidatesUserIds = this.candidateLoginIds.split(SplitSignal.SPLIT_SIGNAL_AIT.getSignal());
            for (String id : candidatesUserIds) {
                map.put(id, null);
            }
        }
        
        List<Map> userMap = secPrivilegeUserManager.getUserZtreeMap(map, loginIdByDept, loginIdByRole);
        this.getResponse().getWriter().print(JSONArray.toJSONString(userMap));// 把数据回传页面
    }
    
    /**
     * 查看对象.
     * 
     * @return 查看页面.
     */
    public String show() {
    	secPrivilegeUser = secPrivilegeUserManager.findUserDeptInfoByLoginName(secPrivilegeUser.getLoginName());
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
        secPrivilegeUser.setCreateTime(new Date());
        secPrivilegeUser.setPasswd(SecurityUtils.encoderByMd5(secPrivilegeUser.getPasswd()));
        secPrivilegeUserManager.save(secPrivilegeUser);
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
        if (secPrivilegeUser.getCreateTime() == null) {
            secPrivilegeUser.setCreateTime(new Date());
        }
        if (isNullOrEmptyString(secPrivilegeUser.getPasswd())) {
            secPrivilegeUser.setPasswd(this.originalPasswd);
        } else {
            secPrivilegeUser.setPasswd(SecurityUtils.encoderByMd5(secPrivilegeUser.getPasswd()));
        }
        secPrivilegeUserManager.update(this.secPrivilegeUser);
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
            java.lang.String id = new java.lang.String((String) params.get("loginId"));
            // 删除用户、角色关联表该用户关联角色
            secPrivilegeUserRole.setLoginId(id);
            secPrivilegeUserRoleManager.deleteUserAndRole(secPrivilegeUserRole);
            // 删除用户表中相应用户
            secPrivilegeUserManager.removeById(id);
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
            SecPrivilegeUserRole secPrivilegeUserRole = new SecPrivilegeUserRole();
            // 删除用户、角色关联表该用户关联角色
            secPrivilegeUserRole.setLoginId(id);
            secPrivilegeUserRoleManager.deleteUserAndRole(secPrivilegeUserRole);
            // 删除用户表中相应用户
            secPrivilegeUserManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    /**
     * 用户关联角色.
     * 
     * @return 关联角色页面.
     */
    public String userRelateRoles() {
        selectAllRoleList = secPrivilegeRoleManager.selectAllRoleListOrder();
        selectUserRoleList = secPrivilegeRoleManager.selectUserRoleList(this.id);
        return USER_RELATE_ROLES_JSP;
    }
    
    public String saveUserRelateRoles() {
        secPrivilegeUserRoleManager.saveUserRelateRoles(roleId, this.id);
        return LIST_ACTION;
    }
    
    @Override
    public String getEctableId() {
        return "SecPrivilegeUser_list";
    }
    
    public String getCandidateLoginIds() {
        return candidateLoginIds;
    }
    
    public void setCandidateLoginIds(String candidateLoginIds) {
        this.candidateLoginIds = candidateLoginIds;
    }
    
    public String getLoginIdByDept() {
        return loginIdByDept;
    }
    
    public void setLoginIdByDept(String loginIdByDept) {
        this.loginIdByDept = loginIdByDept;
    }
    
    public String getLoginIdByRole() {
        return loginIdByRole;
    }
    
    public void setLoginIdByRole(String loginIdByRole) {
        this.loginIdByRole = loginIdByRole;
    }
}
