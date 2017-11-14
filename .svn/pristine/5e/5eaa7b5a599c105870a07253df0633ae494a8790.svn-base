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


public class BasicTollbooth extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicTollbooth";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_OLD_STATIONID = "oldStationid";
	public static final String ALIAS_OLD_TOLLBOOTHCODE = "oldTollboothcode";
	public static final String ALIAS_TB_ID = "tbId";
	public static final String ALIAS_TB_TOLLLANE_PKID = "tbTolllanePkid";
	public static final String ALIAS_TB_TOLLLANEID = "tbTolllaneid";
	public static final String ALIAS_TB_NUM = "tbNum";
	public static final String ALIAS_TB_RESERVEDNUM = "tbReservednum";
	public static final String ALIAS_TB_TYPE = "tbType";
	public static final String ALIAS_TB_CLASS = "tbClass";
	public static final String ALIAS_TB_STARTTIME = "tbStarttime";
	public static final String ALIAS_TB_ENDTIME = "tbEndtime";
	public static final String ALIAS_TB_STATUS = "tbStatus";

	//date formats

	//columns START
	private java.lang.String pkId;
	private java.lang.String oldStationid;
	private java.lang.String oldTollboothcode;
	private java.lang.String tbId;
	private java.lang.String tbTolllanePkid;
	private java.lang.String tbTolllaneid;
	private java.lang.String tbNum;
	private java.lang.String tbReservednum;
	private java.lang.Integer tbType;
	private java.lang.Integer tbClass;
	private java.lang.String tbStarttime;
	private java.lang.String tbEndtime;
	private java.lang.Integer tbStatus;
	private java.lang.String remarks;
	private java.lang.Integer flag;   //表示是否删除状态
	//columns END

	public BasicTollbooth(){
	}

	public BasicTollbooth(
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
	public void setOldStationid(java.lang.String value) {
		this.oldStationid = value;
	}

	public java.lang.String getOldStationid() {
		return this.oldStationid;
	}
	
	public java.lang.String getOldTollboothcode() {
		return oldTollboothcode;
	}

	public void setOldTollboothcode(java.lang.String oldTollboothcode) {
		this.oldTollboothcode = oldTollboothcode;
	}

	public void setTbId(java.lang.String value) {
		this.tbId = value;
	}

	public java.lang.String getTbId() {
		return this.tbId;
	}
	public void setTbTolllanePkid(java.lang.String value) {
		this.tbTolllanePkid = value;
	}

	public java.lang.String getTbTolllanePkid() {
		return this.tbTolllanePkid;
	}
	public void setTbTolllaneid(java.lang.String value) {
		this.tbTolllaneid = value;
	}

	public java.lang.String getTbTolllaneid() {
		return this.tbTolllaneid;
	}
	public void setTbNum(java.lang.String value) {
		this.tbNum = value;
	}

	public java.lang.String getTbNum() {
		return this.tbNum;
	}
	public void setTbReservednum(java.lang.String value) {
		this.tbReservednum = value;
	}

	public java.lang.String getTbReservednum() {
		return this.tbReservednum;
	}
	public void setTbType(java.lang.Integer value) {
		this.tbType = value;
	}

	public java.lang.Integer getTbType() {
		return this.tbType;
	}
	public void setTbClass(java.lang.Integer value) {
		this.tbClass = value;
	}

	public java.lang.Integer getTbClass() {
		return this.tbClass;
	}
	public void setTbStarttime(java.lang.String value) {
		this.tbStarttime = value;
	}

	public java.lang.String getTbStarttime() {
		return this.tbStarttime;
	}
	public void setTbEndtime(java.lang.String value) {
		this.tbEndtime = value;
	}

	public java.lang.String getTbEndtime() {
		return this.tbEndtime;
	}
	public void setTbStatus(java.lang.Integer value) {
		this.tbStatus = value;
	}

	public java.lang.Integer getTbStatus() {
		return this.tbStatus;
	}
	
	public java.lang.String getRemarks() {
		return remarks;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	public java.lang.Integer getFlag() {
		return flag;
	}

	public void setFlag(java.lang.Integer flag) {
		this.flag = flag;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("PkId",getPkId())
			.append("OldStationid",getOldStationid())
			.append("OldTollboothcode",getOldTollboothcode())
			.append("TbId",getTbId())
			.append("TbTolllanePkid",getTbTolllanePkid())
			.append("TbTolllaneid",getTbTolllaneid())
			.append("TbNum",getTbNum())
			.append("TbReservednum",getTbReservednum())
			.append("TbType",getTbType())
			.append("TbClass",getTbClass())
			.append("TbStarttime",getTbStarttime())
			.append("TbEndtime",getTbEndtime())
			.append("TbStatus",getTbStatus())
			.append("Remarks",getRemarks())
			.append("Flag",getFlag())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getOldStationid())
			.append(getOldTollboothcode())
			.append(getTbId())
			.append(getTbTolllanePkid())
			.append(getTbTolllaneid())
			.append(getTbNum())
			.append(getTbReservednum())
			.append(getTbType())
			.append(getTbClass())
			.append(getTbStarttime())
			.append(getTbEndtime())
			.append(getTbStatus())
			.append(getRemarks())
			.append(getFlag())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicTollbooth == false) return false;
		if(this == obj) return true;
		BasicTollbooth other = (BasicTollbooth)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getOldStationid(),other.getOldStationid())
			.append(getOldTollboothcode(),other.getOldTollboothcode())
			.append(getTbId(),other.getTbId())
			.append(getTbTolllanePkid(),other.getTbTolllanePkid())
			.append(getTbTolllaneid(),other.getTbTolllaneid())
			.append(getTbNum(),other.getTbNum())
			.append(getTbReservednum(),other.getTbReservednum())
			.append(getTbType(),other.getTbType())
			.append(getTbClass(),other.getTbClass())
			.append(getTbStarttime(),other.getTbStarttime())
			.append(getTbEndtime(),other.getTbEndtime())
			.append(getTbStatus(),other.getTbStatus())
			.append(getRemarks(),other.getRemarks())
			.append(getFlag(),other.getFlag	())
			.isEquals();
	}
}

