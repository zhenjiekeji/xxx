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
import com.uk.sec.framework.security.model.SecUserDetails;
import com.uk.sec.framework.security.model.UserInfo;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */


public class SecPrivilegeUser extends BaseEntity implements SecUserDetails, UserInfo<String> {

	//alias
	public static final String TABLE_ALIAS = "用户表";
	public static final String ALIAS_LOGIN_ID = "用户ID";
	public static final String ALIAS_PASSWD = "登陆密码";
	public static final String ALIAS_USER_NAME = "用户名";
	public static final String ALIAS_USER_EMAIL = "电子邮件地址";
	public static final String ALIAS_USER_PHONE = "固定电话";
	public static final String ALIAS_USER_MOBILEPHONE = "移动电话";
	public static final String ALIAS_USER_DEPT = "所属部门";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_LOGIN_NAME = "登陆账号";

	//date formats
	public static final String FORMAT_CREATE_TIME = DATE_FORMAT;

	//columns START
	private java.lang.String loginId;
	private java.lang.String passwd;
	private java.lang.String userName;
	private java.lang.String userEmail;
	private java.lang.String userPhone;
	private java.lang.String userMobilephone;
	private java.lang.String userDept;
	private java.util.Date createTime;
	private java.lang.String loginName;
	//columns END

	private java.lang.String userDeptName;
	
	public SecPrivilegeUser(){
	}

	public SecPrivilegeUser(
		java.lang.String loginId
	){
		this.loginId = loginId;
	}

	public void setLoginId(java.lang.String value) {
		this.loginId = value;
	}

	public java.lang.String getLoginId() {
		return this.loginId;
	}
	public void setPasswd(java.lang.String value) {
		this.passwd = value;
	}

	public java.lang.String getPasswd() {
		return this.passwd;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}

	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserEmail(java.lang.String value) {
		this.userEmail = value;
	}

	public java.lang.String getUserEmail() {
		return this.userEmail;
	}
	public void setUserPhone(java.lang.String value) {
		this.userPhone = value;
	}

	public java.lang.String getUserPhone() {
		return this.userPhone;
	}
	public void setUserMobilephone(java.lang.String value) {
		this.userMobilephone = value;
	}

	public java.lang.String getUserMobilephone() {
		return this.userMobilephone;
	}

	public java.lang.String getUserDept() {
		return userDept;
	}

	public void setUserDept(java.lang.String userDept) {
		this.userDept = userDept;
	}

	public String getCreateTimeString() {
		return date2String(getCreateTime(), FORMAT_CREATE_TIME);
	}
	public void setCreateTimeString(String value) {
		setCreateTime(string2Date(value, FORMAT_CREATE_TIME,java.util.Date.class));
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setLoginName(java.lang.String value) {
		this.loginName = value;
	}

	public java.lang.String getLoginName() {
		return this.loginName;
	}

	private Set secPrivilegeUserRoles = new HashSet(0);
	public void setSecPrivilegeUserRoles(Set<SecPrivilegeUserRole> secPrivilegeUserRole){
		this.secPrivilegeUserRoles = secPrivilegeUserRole;
	}

	public Set<SecPrivilegeUserRole> getSecPrivilegeUserRoles() {
		return secPrivilegeUserRoles;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("LoginId",getLoginId())
			.append("Passwd",getPasswd())
			.append("UserName",getUserName())
			.append("UserEmail",getUserEmail())
			.append("UserPhone",getUserPhone())
			.append("UserMobilephone",getUserMobilephone())
			.append("UserDept",getUserDept())
			.append("CreateTime",getCreateTime())
			.append("LoginName",getLoginName())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLoginId())
			.append(getPasswd())
			.append(getUserName())
			.append(getUserEmail())
			.append(getUserPhone())
			.append(getUserMobilephone())
			.append(getUserDept())
			.append(getCreateTime())
			.append(getLoginName())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SecPrivilegeUser == false) return false;
		if(this == obj) return true;
		SecPrivilegeUser other = (SecPrivilegeUser)obj;
		return new EqualsBuilder()
			.append(getLoginId(),other.getLoginId())
			.append(getPasswd(),other.getPasswd())
			.append(getUserName(),other.getUserName())
			.append(getUserEmail(),other.getUserEmail())
			.append(getUserPhone(),other.getUserPhone())
			.append(getUserMobilephone(),other.getUserMobilephone())
			.append(getUserDept(),other.getUserDept())
			.append(getCreateTime(),other.getCreateTime())
			.append(getLoginName(),other.getLoginName())
			.isEquals();
	}

	@Override
	public String getPassword() {
		return this.passwd;
	}

	@Override
	public String getLoginDisplayName() {
		return this.userName;
	}

	@Override
	public String getSecLoginId() {
		return this.loginId;
	}

	public java.lang.String getUserDeptName() {
		return userDeptName;
	}
	public void setUserDeptName(java.lang.String userDeptName) {
		this.userDeptName = userDeptName;
	}
}

