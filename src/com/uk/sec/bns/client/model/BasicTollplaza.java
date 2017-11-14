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


public class BasicTollplaza extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicTollplaza";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_OLD_ID = "oldCode";
	public static final String ALIAS_TP_ID = "tpId";
	public static final String ALIAS_TP_TOLLSTATION_PKID = "tpTollstationPkid";
	public static final String ALIAS_TP_TOLLSTATIONID = "tpTollstationid";
	public static final String ALIAS_TP_TYPE = "tpType";
	public static final String ALIAS_TP_NUM = "tpNum";
	public static final String ALIAS_TP_RESERVEDNUM = "tpReservednum";
	public static final String ALIAS_TP_NAME = "tpName";
	public static final String ALIAS_TP_PLAZATYPE = "tpPlazatype";
	public static final String ALIAS_TP_LNG = "tpLng";
	public static final String ALIAS_TP_LAT = "tpLat";
	public static final String ALIAS_TP_STAKENUM = "tpStakenum";
	public static final String ALIAS_TP_ETCLANECOUNT = "tpEtclanecount";
	public static final String ALIAS_TP_MTCLANECOUNT = "tpMtclanecount";
	public static final String ALIAS_TP_MIXLANECOUNT = "tpMixlanecount";

	//date formats

	//columns START
	private java.lang.String pkId;
	private java.lang.String oldCode;
	private java.lang.String tpId;
	private java.lang.String tpTollstationPkid;
	private java.lang.String tpTollstationid;
	private java.lang.String tpType;
	private java.lang.String tpNum;
	private java.lang.String tpReservednum;
	private java.lang.String tpName;
	private java.lang.Integer tpPlazatype;
	private java.lang.String tpLng;
	private java.lang.String tpLat;
	private java.lang.String tpStakenum;
	private java.lang.Integer tpEtclanecount;
	private java.lang.Integer tpMtclanecount;
	private java.lang.Integer tpMixlanecount;
	private java.lang.String remarks;
	private java.lang.String menuId;
	private java.lang.Integer flag;   //表示是否删除状态
	//columns END

	public BasicTollplaza(){
	}

	public BasicTollplaza(
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
	
	public java.lang.String getOldCode() {
		return oldCode;
	}

	public void setOldCode(java.lang.String oldCode) {
		this.oldCode = oldCode;
	}

	public void setTpId(java.lang.String value) {
		this.tpId = value;
	}

	public java.lang.String getTpId() {
		return this.tpId;
	}
	public void setTpTollstationPkid(java.lang.String value) {
		this.tpTollstationPkid = value;
	}

	public java.lang.String getTpTollstationPkid() {
		return this.tpTollstationPkid;
	}
	public void setTpTollstationid(java.lang.String value) {
		this.tpTollstationid = value;
	}

	public java.lang.String getTpTollstationid() {
		return this.tpTollstationid;
	}
	public void setTpType(java.lang.String value) {
		this.tpType = value;
	}

	public java.lang.String getTpType() {
		return this.tpType;
	}
	public void setTpNum(java.lang.String value) {
		this.tpNum = value;
	}

	public java.lang.String getTpNum() {
		return this.tpNum;
	}
	public void setTpReservednum(java.lang.String value) {
		this.tpReservednum = value;
	}

	public java.lang.String getTpReservednum() {
		return this.tpReservednum;
	}
	public void setTpName(java.lang.String value) {
		this.tpName = value;
	}

	public java.lang.String getTpName() {
		return this.tpName;
	}
	public void setTpPlazatype(java.lang.Integer value) {
		this.tpPlazatype = value;
	}

	public java.lang.Integer getTpPlazatype() {
		return this.tpPlazatype;
	}
	public void setTpLng(java.lang.String value) {
		this.tpLng = value;
	}

	public java.lang.String getTpLng() {
		return this.tpLng;
	}
	public void setTpLat(java.lang.String value) {
		this.tpLat = value;
	}

	public java.lang.String getTpLat() {
		return this.tpLat;
	}
	public void setTpStakenum(java.lang.String value) {
		this.tpStakenum = value;
	}

	public java.lang.String getTpStakenum() {
		return this.tpStakenum;
	}
	public void setTpEtclanecount(java.lang.Integer value) {
		this.tpEtclanecount = value;
	}

	public java.lang.Integer getTpEtclanecount() {
		return this.tpEtclanecount;
	}
	public void setTpMtclanecount(java.lang.Integer value) {
		this.tpMtclanecount = value;
	}

	public java.lang.Integer getTpMtclanecount() {
		return this.tpMtclanecount;
	}
	public void setTpMixlanecount(java.lang.Integer value) {
		this.tpMixlanecount = value;
	}

	public java.lang.Integer getTpMixlanecount() {
		return this.tpMixlanecount;
	}
	
	public java.lang.String getRemarks() {
		return remarks;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	public java.lang.String getMenuId() {
		return menuId;
	}

	public void setMenuId(java.lang.String menuId) {
		this.menuId = menuId;
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
			.append("OldCode",getOldCode())
			.append("TpId",getTpId())
			.append("TpTollstationPkid",getTpTollstationPkid())
			.append("TpTollstationid",getTpTollstationid())
			.append("TpType",getTpType())
			.append("TpNum",getTpNum())
			.append("TpReservednum",getTpReservednum())
			.append("TpName",getTpName())
			.append("TpPlazatype",getTpPlazatype())
			.append("TpLng",getTpLng())
			.append("TpLat",getTpLat())
			.append("TpStakenum",getTpStakenum())
			.append("TpEtclanecount",getTpEtclanecount())
			.append("TpMtclanecount",getTpMtclanecount())
			.append("TpMixlanecount",getTpMixlanecount())
			.append("Remarks",getRemarks())
			.append("MenuId",getMenuId())
			.append("Flag",getFlag())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getOldCode())
			.append(getTpId())
			.append(getTpTollstationPkid())
			.append(getTpTollstationid())
			.append(getTpType())
			.append(getTpNum())
			.append(getTpReservednum())
			.append(getTpName())
			.append(getTpPlazatype())
			.append(getTpLng())
			.append(getTpLat())
			.append(getTpStakenum())
			.append(getTpEtclanecount())
			.append(getTpMtclanecount())
			.append(getTpMixlanecount())
			.append(getRemarks())
			.append(getMenuId())
			.append(getFlag())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicTollplaza == false) return false;
		if(this == obj) return true;
		BasicTollplaza other = (BasicTollplaza)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getOldCode(),other.getOldCode())
			.append(getTpId(),other.getTpId())
			.append(getTpTollstationPkid(),other.getTpTollstationPkid())
			.append(getTpTollstationid(),other.getTpTollstationid())
			.append(getTpType(),other.getTpType())
			.append(getTpNum(),other.getTpNum())
			.append(getTpReservednum(),other.getTpReservednum())
			.append(getTpName(),other.getTpName())
			.append(getTpPlazatype(),other.getTpPlazatype())
			.append(getTpLng(),other.getTpLng())
			.append(getTpLat(),other.getTpLat())
			.append(getTpStakenum(),other.getTpStakenum())
			.append(getTpEtclanecount(),other.getTpEtclanecount())
			.append(getTpMtclanecount(),other.getTpMtclanecount())
			.append(getTpMixlanecount(),other.getTpMixlanecount())
			.append(getRemarks(),other.getRemarks())
			.append(getMenuId(),other.getMenuId())
			.append(getFlag(),other.getFlag	())
			.isEquals();
	}
}

