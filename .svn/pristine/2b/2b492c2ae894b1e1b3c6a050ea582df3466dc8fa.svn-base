/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;



/**
 * @author
 * @version 1.0
 * @since 1.0
 */


public class SecPrivilegeRoleMenuOper extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "角色、菜单、操作的关联表";
	public static final String ALIAS_ROLE_ID = "角色ID";
	public static final String ALIAS_MENU_ID = "菜单ID";
	public static final String ALIAS_RMO_ID = "角色、菜单、操作ID";
	public static final String ALIAS_OPERATION_ID = "字典项表中“操作”GROUP_ID的相应ITEM_ID";

	//date formats

	//columns START
	private java.lang.String roleId;
	private java.lang.String menuId;
	private java.lang.String rmoId;
	private java.lang.Long operationId;
	//columns END

	public SecPrivilegeRoleMenuOper(){
	}

	public SecPrivilegeRoleMenuOper(
		java.lang.String rmoId
	){
		this.rmoId = rmoId;
	}

	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}

	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setMenuId(java.lang.String value) {
		this.menuId = value;
	}

	public java.lang.String getMenuId() {
		return this.menuId;
	}
	public void setRmoId(java.lang.String value) {
		this.rmoId = value;
	}

	public java.lang.String getRmoId() {
		return this.rmoId;
	}
	public void setOperationId(java.lang.Long value) {
		this.operationId = value;
	}

	public java.lang.Long getOperationId() {
		return this.operationId;
	}

	private SecPrivilegeMenu secPrivilegeMenu;

	public void setSecPrivilegeMenu(SecPrivilegeMenu secPrivilegeMenu){
		this.secPrivilegeMenu = secPrivilegeMenu;
	}

	public SecPrivilegeMenu getSecPrivilegeMenu() {
		return secPrivilegeMenu;
	}

	private SecPrivilegeRole secPrivilegeRole;

	public void setSecPrivilegeRole(SecPrivilegeRole secPrivilegeRole){
		this.secPrivilegeRole = secPrivilegeRole;
	}

	public SecPrivilegeRole getSecPrivilegeRole() {
		return secPrivilegeRole;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("RoleId",getRoleId())
			.append("MenuId",getMenuId())
			.append("RmoId",getRmoId())
			.append("OperationId",getOperationId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleId())
			.append(getMenuId())
			.append(getRmoId())
			.append(getOperationId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SecPrivilegeRoleMenuOper == false) return false;
		if(this == obj) return true;
		SecPrivilegeRoleMenuOper other = (SecPrivilegeRoleMenuOper)obj;
		return new EqualsBuilder()
			.append(getRoleId(),other.getRoleId())
			.append(getMenuId(),other.getMenuId())
			.append(getRmoId(),other.getRmoId())
			.append(getOperationId(),other.getOperationId())
			.isEquals();
	}
}

