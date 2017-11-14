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


public class BasicTollroad extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicTollroad";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_TR_ID = "trId";
	public static final String ALIAS_TR_ROADNUM = "trRoadnum";
	public static final String ALIAS_TR_PROVINCEID = "trProvinceid";
	public static final String ALIAS_TR_NAME = "trName";
	public static final String ALIAS_TR_LEVEL = "trLevel";
	public static final String ALIAS_TR_STARTSITE = "trStartsite";
	public static final String ALIAS_TR_STARTSTAKENUM = "trStartstakenum";
	public static final String ALIAS_TR_STARTLNG = "trStartlng";
	public static final String ALIAS_TR_STARTLAT = "trStartlat";
	public static final String ALIAS_TR_STARTSTATIONID = "trStartstationid";
	public static final String ALIAS_TR_ENDSITE = "trEndsite";
	public static final String ALIAS_TR_ENDSTAKENUM = "trEndstakenum";
	public static final String ALIAS_TR_ENDLNG = "trEndlng";
	public static final String ALIAS_TR_ENDLAT = "trEndlat";
	public static final String ALIAS_TR_ENDSTATIONID = "trEndstationid";
	public static final String ALIAS_TR_SECTIONOWNERID = "trSectionownerid";

	//date formats

	//columns START
	private java.lang.String pkId;
	private java.lang.String trId;
	private java.lang.String trRoadnum;
	private java.lang.String trProvinceid;
	private java.lang.String trName;
	private java.lang.Integer trLevel;
	private java.lang.String trStartsite;
	private java.lang.String trStartstakenum;
	private java.lang.String trStartlng;
	private java.lang.String trStartlat;
	private java.lang.String trStartstationid;
	private java.lang.String trEndsite;
	private java.lang.String trEndstakenum;
	private java.lang.String trEndlng;
	private java.lang.String trEndlat;
	private java.lang.String trEndstationid;
	private java.lang.String trSectionownerid;
	private java.lang.String trSectionownerCode;
	//columns END

	public BasicTollroad(){
	}

	public BasicTollroad(
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
	public void setTrId(java.lang.String value) {
		this.trId = value;
	}

	public java.lang.String getTrId() {
		return this.trId;
	}
	public void setTrRoadnum(java.lang.String value) {
		this.trRoadnum = value;
	}

	public java.lang.String getTrRoadnum() {
		return this.trRoadnum;
	}
	public void setTrProvinceid(java.lang.String value) {
		this.trProvinceid = value;
	}

	public java.lang.String getTrProvinceid() {
		return this.trProvinceid;
	}
	public void setTrName(java.lang.String value) {
		this.trName = value;
	}

	public java.lang.String getTrName() {
		return this.trName;
	}
	public void setTrLevel(java.lang.Integer value) {
		this.trLevel = value;
	}

	public java.lang.Integer getTrLevel() {
		return this.trLevel;
	}
	public void setTrStartsite(java.lang.String value) {
		this.trStartsite = value;
	}

	public java.lang.String getTrStartsite() {
		return this.trStartsite;
	}
	public void setTrStartstakenum(java.lang.String value) {
		this.trStartstakenum = value;
	}

	public java.lang.String getTrStartstakenum() {
		return this.trStartstakenum;
	}
	public void setTrStartlng(java.lang.String value) {
		this.trStartlng = value;
	}

	public java.lang.String getTrStartlng() {
		return this.trStartlng;
	}
	public void setTrStartlat(java.lang.String value) {
		this.trStartlat = value;
	}

	public java.lang.String getTrStartlat() {
		return this.trStartlat;
	}
	public void setTrStartstationid(java.lang.String value) {
		this.trStartstationid = value;
	}

	public java.lang.String getTrStartstationid() {
		return this.trStartstationid;
	}
	public void setTrEndsite(java.lang.String value) {
		this.trEndsite = value;
	}

	public java.lang.String getTrEndsite() {
		return this.trEndsite;
	}
	public void setTrEndstakenum(java.lang.String value) {
		this.trEndstakenum = value;
	}

	public java.lang.String getTrEndstakenum() {
		return this.trEndstakenum;
	}
	public void setTrEndlng(java.lang.String value) {
		this.trEndlng = value;
	}

	public java.lang.String getTrEndlng() {
		return this.trEndlng;
	}
	public void setTrEndlat(java.lang.String value) {
		this.trEndlat = value;
	}

	public java.lang.String getTrEndlat() {
		return this.trEndlat;
	}
	public void setTrEndstationid(java.lang.String value) {
		this.trEndstationid = value;
	}

	public java.lang.String getTrEndstationid() {
		return this.trEndstationid;
	}
	public void setTrSectionownerid(java.lang.String value) {
		this.trSectionownerid = value;
	}

	public java.lang.String getTrSectionownerid() {
		return this.trSectionownerid;
	}

	public java.lang.String getTrSectionownerCode() {
		return trSectionownerCode;
	}

	public void setTrSectionownerCode(java.lang.String trSectionownerCode) {
		this.trSectionownerCode = trSectionownerCode;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("PkId",getPkId())
			.append("TrId",getTrId())
			.append("TrRoadnum",getTrRoadnum())
			.append("TrProvinceid",getTrProvinceid())
			.append("TrName",getTrName())
			.append("TrLevel",getTrLevel())
			.append("TrStartsite",getTrStartsite())
			.append("TrStartstakenum",getTrStartstakenum())
			.append("TrStartlng",getTrStartlng())
			.append("TrStartlat",getTrStartlat())
			.append("TrStartstationid",getTrStartstationid())
			.append("TrEndsite",getTrEndsite())
			.append("TrEndstakenum",getTrEndstakenum())
			.append("TrEndlng",getTrEndlng())
			.append("TrEndlat",getTrEndlat())
			.append("TrEndstationid",getTrEndstationid())
			.append("TrSectionownerid",getTrSectionownerid())
			.append("TrSectionownerCode",getTrSectionownerCode())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getTrId())
			.append(getTrRoadnum())
			.append(getTrProvinceid())
			.append(getTrName())
			.append(getTrLevel())
			.append(getTrStartsite())
			.append(getTrStartstakenum())
			.append(getTrStartlng())
			.append(getTrStartlat())
			.append(getTrStartstationid())
			.append(getTrEndsite())
			.append(getTrEndstakenum())
			.append(getTrEndlng())
			.append(getTrEndlat())
			.append(getTrEndstationid())
			.append(getTrSectionownerid())
			.append(getTrSectionownerCode())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicTollroad == false) return false;
		if(this == obj) return true;
		BasicTollroad other = (BasicTollroad)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getTrId(),other.getTrId())
			.append(getTrRoadnum(),other.getTrRoadnum())
			.append(getTrProvinceid(),other.getTrProvinceid())
			.append(getTrName(),other.getTrName())
			.append(getTrLevel(),other.getTrLevel())
			.append(getTrStartsite(),other.getTrStartsite())
			.append(getTrStartstakenum(),other.getTrStartstakenum())
			.append(getTrStartlng(),other.getTrStartlng())
			.append(getTrStartlat(),other.getTrStartlat())
			.append(getTrStartstationid(),other.getTrStartstationid())
			.append(getTrEndsite(),other.getTrEndsite())
			.append(getTrEndstakenum(),other.getTrEndstakenum())
			.append(getTrEndlng(),other.getTrEndlng())
			.append(getTrEndlat(),other.getTrEndlat())
			.append(getTrEndstationid(),other.getTrEndstationid())
			.append(getTrSectionownerid(),other.getTrSectionownerid())
			.append(getTrSectionownerCode(),other.getTrSectionownerCode())
			.isEquals();
	}
}

