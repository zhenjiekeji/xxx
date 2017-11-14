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


public class SecPrivilegeRole extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "角色表";
	public static final String ALIAS_ROLE_ID = "角色ID";
	public static final String ALIAS_ROLE_NAME = "角色名称";
	public static final String ALIAS_ROLE_DESCRIPTION = "角色描述";
	public static final String ALIAS_ROLE_LEVEL = "角色级别（便于高级别角色控制低级别角色，其中角色级别为1是系统内置角色，不能修改）";

	//date formats

	//columns START
	private java.lang.String roleId;
	private java.lang.String roleName;
	private java.lang.String roleDescription;
	private java.lang.Short roleLevel;
	//columns END

	public static final Short DEFAULT_ROLE_LEVEL = 2;	//新增角色时默认的角色级别

	public SecPrivilegeRole(){
	}

	public SecPrivilegeRole(
		java.lang.String roleId
	){
		this.roleId = roleId;
	}

	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}

	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}

	public java.lang.String getRoleName() {
		return this.roleName;
	}
	public void setRoleDescription(java.lang.String value) {
		this.roleDescription = value;
	}

	public java.lang.String getRoleDescription() {
		return this.roleDescription;
	}
	public void setRoleLevel(java.lang.Short value) {
		this.roleLevel = value;
	}

	public java.lang.Short getRoleLevel() {
		return this.roleLevel;
	}

	private Set secPrivilegeUserRoles = new HashSet(0);
	public void setSecPrivilegeUserRoles(Set<SecPrivilegeUserRole> secPrivilegeUserRole){
		this.secPrivilegeUserRoles = secPrivilegeUserRole;
	}

	public Set<SecPrivilegeUserRole> getSecPrivilegeUserRoles() {
		return secPrivilegeUserRoles;
	}

	private Set secPrivilegeRoleMenuOpers = new HashSet(0);
	public void setSecPrivilegeRoleMenuOpers(Set<SecPrivilegeRoleMenuOper> secPrivilegeRoleMenuOper){
		this.secPrivilegeRoleMenuOpers = secPrivilegeRoleMenuOper;
	}

	public Set<SecPrivilegeRoleMenuOper> getSecPrivilegeRoleMenuOpers() {
		return secPrivilegeRoleMenuOpers;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("RoleId",getRoleId())
			.append("RoleName",getRoleName())
			.append("RoleDescription",getRoleDescription())
			.append("RoleLevel",getRoleLevel())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleId())
			.append(getRoleName())
			.append(getRoleDescription())
			.append(getRoleLevel())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SecPrivilegeRole == false) return false;
		if(this == obj) return true;
		SecPrivilegeRole other = (SecPrivilegeRole)obj;
		return new EqualsBuilder()
			.append(getRoleId(),other.getRoleId())
			.append(getRoleName(),other.getRoleName())
			.append(getRoleDescription(),other.getRoleDescription())
			.append(getRoleLevel(),other.getRoleLevel())
			.isEquals();
	}
}

