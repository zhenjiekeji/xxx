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


public class SecPrivilegeUserRole extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "用户与角色的关联表";
	public static final String ALIAS_LOGIN_ID = "用户ID";
	public static final String ALIAS_ROLE_ID = "角色ID";
	public static final String ALIAS_USER_ROLE_ID = "用户、角色ID";

	//date formats

	//columns START
	private java.lang.String loginId;
	private java.lang.String roleId;
	private java.lang.String userRoleId;
	//columns END

	public SecPrivilegeUserRole(){
	}

	public SecPrivilegeUserRole(
		java.lang.String userRoleId
	){
		this.userRoleId = userRoleId;
	}

	public void setLoginId(java.lang.String value) {
		this.loginId = value;
	}

	public java.lang.String getLoginId() {
		return this.loginId;
	}
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}

	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setUserRoleId(java.lang.String value) {
		this.userRoleId = value;
	}

	public java.lang.String getUserRoleId() {
		return this.userRoleId;
	}

	private SecPrivilegeRole secPrivilegeRole;

	public void setSecPrivilegeRole(SecPrivilegeRole secPrivilegeRole){
		this.secPrivilegeRole = secPrivilegeRole;
	}

	public SecPrivilegeRole getSecPrivilegeRole() {
		return secPrivilegeRole;
	}

	private SecPrivilegeUser secPrivilegeUser;

	public void setSecPrivilegeUser(SecPrivilegeUser secPrivilegeUser){
		this.secPrivilegeUser = secPrivilegeUser;
	}

	public SecPrivilegeUser getSecPrivilegeUser() {
		return secPrivilegeUser;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("LoginId",getLoginId())
			.append("RoleId",getRoleId())
			.append("UserRoleId",getUserRoleId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLoginId())
			.append(getRoleId())
			.append(getUserRoleId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SecPrivilegeUserRole == false) return false;
		if(this == obj) return true;
		SecPrivilegeUserRole other = (SecPrivilegeUserRole)obj;
		return new EqualsBuilder()
			.append(getLoginId(),other.getLoginId())
			.append(getRoleId(),other.getRoleId())
			.append(getUserRoleId(),other.getUserRoleId())
			.isEquals();
	}
}

