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


public class SecPrivilegeMenuOper extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "菜单与操作关联表";
	public static final String ALIAS_MENU_ID = "菜单ID";
	public static final String ALIAS_OPERATION_ID = "字典项表中“操作”GROUP_ID的相应ITEM_ID";
	public static final String ALIAS_MENU_OPER_ID = "菜单、操作ID";

	//date formats

	//columns START
	private java.lang.String menuId;
	private java.lang.Long operationId;
	private java.lang.String menuOperId;
	//columns END

	public SecPrivilegeMenuOper(){
	}

	public SecPrivilegeMenuOper(
		java.lang.String menuOperId
	){
		this.menuOperId = menuOperId;
	}

	public void setMenuId(java.lang.String value) {
		this.menuId = value;
	}

	public java.lang.String getMenuId() {
		return this.menuId;
	}
	public void setOperationId(java.lang.Long value) {
		this.operationId = value;
	}

	public java.lang.Long getOperationId() {
		return this.operationId;
	}
	public void setMenuOperId(java.lang.String value) {
		this.menuOperId = value;
	}

	public java.lang.String getMenuOperId() {
		return this.menuOperId;
	}

	private SecPrivilegeMenu secPrivilegeMenu;

	public void setSecPrivilegeMenu(SecPrivilegeMenu secPrivilegeMenu){
		this.secPrivilegeMenu = secPrivilegeMenu;
	}

	public SecPrivilegeMenu getSecPrivilegeMenu() {
		return secPrivilegeMenu;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("MenuId",getMenuId())
			.append("OperationId",getOperationId())
			.append("MenuOperId",getMenuOperId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMenuId())
			.append(getOperationId())
			.append(getMenuOperId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SecPrivilegeMenuOper == false) return false;
		if(this == obj) return true;
		SecPrivilegeMenuOper other = (SecPrivilegeMenuOper)obj;
		return new EqualsBuilder()
			.append(getMenuId(),other.getMenuId())
			.append(getOperationId(),other.getOperationId())
			.append(getMenuOperId(),other.getMenuOperId())
			.isEquals();
	}
}

