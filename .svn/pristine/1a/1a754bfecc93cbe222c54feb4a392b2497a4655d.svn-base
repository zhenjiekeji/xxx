/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */


public class BasicTemptollbooth extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicTemptollbooth";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_TTB_ID = "ttbId";
	public static final String ALIAS_TTB_SECTION_PKID = "ttbSectionPkid";
	public static final String ALIAS_TTB_SECTIONID = "ttbSectionid";
	public static final String ALIAS_TTB_NUM = "ttbNum";

	//date formats

	//columns START
	private java.lang.String pkId;
	private java.lang.String ttbId;
	private java.lang.String ttbSectionPkid;
	private java.lang.String ttbSectionid;
	private java.lang.String ttbNum;
	//columns END

	public BasicTemptollbooth(){
	}

	public BasicTemptollbooth(
		java.lang.String pkId
	){
		this.pkId = pkId;
	}

	public void setPkId(java.lang.String value) {
		this.pkId = value;
	}

	public java.lang.String getPkId() {
		return this.pkId;
	}
	public void setTtbId(java.lang.String value) {
		this.ttbId = value;
	}

	public java.lang.String getTtbId() {
		return this.ttbId;
	}
	public void setTtbSectionPkid(java.lang.String value) {
		this.ttbSectionPkid = value;
	}

	public java.lang.String getTtbSectionPkid() {
		return this.ttbSectionPkid;
	}
	public void setTtbSectionid(java.lang.String value) {
		this.ttbSectionid = value;
	}

	public java.lang.String getTtbSectionid() {
		return this.ttbSectionid;
	}
	public void setTtbNum(java.lang.String value) {
		this.ttbNum = value;
	}

	public java.lang.String getTtbNum() {
		return this.ttbNum;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("PkId",getPkId())
			.append("TtbId",getTtbId())
			.append("TtbSectionPkid",getTtbSectionPkid())
			.append("TtbSectionid",getTtbSectionid())
			.append("TtbNum",getTtbNum())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getTtbId())
			.append(getTtbSectionPkid())
			.append(getTtbSectionid())
			.append(getTtbNum())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicTemptollbooth == false) return false;
		if(this == obj) return true;
		BasicTemptollbooth other = (BasicTemptollbooth)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getTtbId(),other.getTtbId())
			.append(getTtbSectionPkid(),other.getTtbSectionPkid())
			.append(getTtbSectionid(),other.getTtbSectionid())
			.append(getTtbNum(),other.getTtbNum())
			.isEquals();
	}
}

