/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecPrivilegeMenu extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS            = "菜单表";
    public static final String ALIAS_MENU_ID          = "菜单ID";
    public static final String ALIAS_MENU_TITLE       = "菜单名称";
    public static final String ALIAS_MENU_DESCRIPTION = "菜单描述";
    public static final String ALIAS_MENU_URL         = "连接地址";
    public static final String ALIAS_MENU_VIEWORDER   = "菜单的显示顺序（4位一级），便于菜单分级显示";
    public static final String ALIAS_PARENT_ID        = "当前菜单的父菜单ID，其中最顶层菜单的父菜单为null";
    public static final String ALIAS_MENU_FLAG        = "菜单标志位，0：不可现1：可现";
    public static final String ALIAS_MENU_ISLEAF      = "是否叶子节点，0：非叶子节点1：叶子节点";
    
    // date formats
    
    // columns START
    private java.lang.String   menuId;
    private java.lang.String   menuTitle;
    private java.lang.String   menuDescription;
    private java.lang.String   menuUrl;
    private java.lang.String   menuVieworder;
    private java.lang.String   parentId;
    private java.lang.Short    menuFlag;
    private java.lang.Short    menuIsleaf;
    // 贫血模型添加字段
    private java.lang.Boolean  menuHaveson;
    // columns END
    
    public static final Short  MENU_VIEWORDER_LEVEL   = 4;                            // 菜单显示级别，4位一级
                                                                                       
    public static final Short  MENU_FLAG_VISIBLE      = 1;                            // 菜单可现
    public static final Short  MENU_FLAG_INVISIBLE    = 0;                            // 菜单不可现
                                                                                       
    public static final Short  MENU_IS_LEAF           = 1;                            // 叶子节点
    public static final Short  MENU_NOT_LEAF          = 0;                            // 非叶子节点
                                                                                       
    public SecPrivilegeMenu() {
    }
    
    public SecPrivilegeMenu(java.lang.String menuId) {
        this.menuId = menuId;
    }
    
    public void setMenuId(java.lang.String value) {
        this.menuId = value;
    }
    
    public java.lang.String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuTitle(java.lang.String value) {
        this.menuTitle = value;
    }
    
    public java.lang.String getMenuTitle() {
        return this.menuTitle;
    }
    
    public void setMenuDescription(java.lang.String value) {
        this.menuDescription = value;
    }
    
    public java.lang.String getMenuDescription() {
        return this.menuDescription;
    }
    
    public void setMenuUrl(java.lang.String value) {
        this.menuUrl = value;
    }
    
    public java.lang.String getMenuUrl() {
        return this.menuUrl;
    }
    
    public void setMenuVieworder(java.lang.String value) {
        this.menuVieworder = value;
    }
    
    public java.lang.String getMenuVieworder() {
        return this.menuVieworder;
    }
    
    public void setParentId(java.lang.String value) {
        this.parentId = value;
    }
    
    public java.lang.String getParentId() {
        return this.parentId;
    }
    
    public void setMenuFlag(java.lang.Short value) {
        this.menuFlag = value;
    }
    
    public java.lang.Short getMenuFlag() {
        return this.menuFlag;
    }
    
    public void setMenuIsleaf(java.lang.Short menuIsleaf) {
        this.menuIsleaf = menuIsleaf;
    }
    
    public java.lang.Short getMenuIsleaf() {
        return menuIsleaf;
    }
    
    private Set secPrivilegeRoleMenuOpers = new HashSet(0);
    
    public void setSecPrivilegeRoleMenuOpers(Set<SecPrivilegeRoleMenuOper> secPrivilegeRoleMenuOper) {
        this.secPrivilegeRoleMenuOpers = secPrivilegeRoleMenuOper;
    }
    
    public Set<SecPrivilegeRoleMenuOper> getSecPrivilegeRoleMenuOpers() {
        return secPrivilegeRoleMenuOpers;
    }
    
    private Set secPrivilegeMenuOpers = new HashSet(0);
    
    public void setSecPrivilegeMenuOpers(Set<SecPrivilegeMenuOper> secPrivilegeMenuOper) {
        this.secPrivilegeMenuOpers = secPrivilegeMenuOper;
    }
    
    public Set<SecPrivilegeMenuOper> getSecPrivilegeMenuOpers() {
        return secPrivilegeMenuOpers;
    }
    
    public java.lang.Boolean getMenuHaveson() {
        return menuHaveson;
    }
    
    public void setMenuHaveson(java.lang.Boolean menuHaveson) {
        this.menuHaveson = menuHaveson;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("MenuId", getMenuId())
                                        .append("MenuTitle", getMenuTitle())
                                        .append("MenuDescription", getMenuDescription())
                                        .append("MenuUrl", getMenuUrl())
                                        .append("MenuVieworder", getMenuVieworder())
                                        .append("ParentId", getParentId())
                                        .append("MenuFlag", getMenuFlag())
                                        .append("MenuIsLeaf", getMenuIsleaf())
                                        .append("MenuHaveson", getMenuHaveson())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getMenuId())
                                    .append(getMenuTitle())
                                    .append(getMenuDescription())
                                    .append(getMenuUrl())
                                    .append(getMenuVieworder())
                                    .append(getParentId())
                                    .append(getMenuFlag())
                                    .append(getMenuIsleaf())
                                    .append(getMenuHaveson())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecPrivilegeMenu == false)
            return false;
        if (this == obj)
            return true;
        SecPrivilegeMenu other = (SecPrivilegeMenu) obj;
        return new EqualsBuilder().append(getMenuId(), other.getMenuId())
                                  .append(getMenuTitle(), other.getMenuTitle())
                                  .append(getMenuDescription(), other.getMenuDescription())
                                  .append(getMenuUrl(), other.getMenuUrl())
                                  .append(getMenuVieworder(), other.getMenuVieworder())
                                  .append(getParentId(), other.getParentId())
                                  .append(getMenuFlag(), other.getMenuFlag())
                                  .append(getMenuIsleaf(), other.getMenuIsleaf())
                                  .append(getMenuHaveson(), other.getMenuHaveson())
                                  .isEquals();
    }
    
}
