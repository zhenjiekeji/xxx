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


public class BasicTolllane extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicTolllane";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_OLD_STATIONID = "oldStationid";
	public static final String ALIAS_OLD_LANECODE = "oldLanecode";
	public static final String ALIAS_TL_ID = "tlId";
	public static final String ALIAS_TL_TOLLPLAZA_PKID = "tlTollplazaPkid";
	public static final String ALIAS_TL_TOLLPLAZAID = "tlTollplazaid";
	public static final String ALIAS_TL_NUM = "tlNum";
	public static final String ALIAS_TL_RESERVEDNUM = "tlReservednum";
	public static final String ALIAS_TL_TYPE = "tlType";
	public static final String ALIAS_TL_GREENTRAFFIC = "tlGreentraffic";
	public static final String ALIAS_TL_TIDALTIME = "tlTidaltime";
	public static final String ALIAS_TL_STARTTIME = "tlStarttime";
	public static final String ALIAS_TL_ENDTIME = "tlEndtime";
	public static final String ALIAS_TL_STATUS = "tlStatus";
	public static final String ALIAS_TL_WEIGHTCHARGE = "tlWeightcharge";

	//date formats

	//columns START
	private java.lang.String pkId;
	private java.lang.String oldStationid;
	private java.lang.String oldLanecode;
	private java.lang.String tlId;
	private java.lang.String tlTollplazaPkid;
	private java.lang.String tlTollplazaid;
	private java.lang.String tlNum;
	private java.lang.String tlReservednum;
	private java.lang.Integer tlType;
	private java.lang.Integer tlGreentraffic;
	private java.lang.String tlTidaltime;
	private java.lang.String tlStarttime;
	private java.lang.String tlEndtime;
	private java.lang.Integer tlStatus;
	private java.lang.Integer tlWeightcharge;
	private java.lang.String remarks;
	private java.lang.String menuId;
	private java.lang.Integer flag;   //表示是否删除状态
	//columns END

	public BasicTolllane(){
	}

	public BasicTolllane(
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
	
	public java.lang.String getOldLanecode() {
		return oldLanecode;
	}

	public void setOldLanecode(java.lang.String oldLanecode) {
		this.oldLanecode = oldLanecode;
	}

	public void setTlId(java.lang.String value) {
		this.tlId = value;
	}

	public java.lang.String getTlId() {
		return this.tlId;
	}
	public void setTlTollplazaPkid(java.lang.String value) {
		this.tlTollplazaPkid = value;
	}

	public java.lang.String getTlTollplazaPkid() {
		return this.tlTollplazaPkid;
	}
	public void setTlTollplazaid(java.lang.String value) {
		this.tlTollplazaid = value;
	}

	public java.lang.String getTlTollplazaid() {
		return this.tlTollplazaid;
	}
	public void setTlNum(java.lang.String value) {
		this.tlNum = value;
	}

	public java.lang.String getTlNum() {
		return this.tlNum;
	}
	public void setTlReservednum(java.lang.String value) {
		this.tlReservednum = value;
	}

	public java.lang.String getTlReservednum() {
		return this.tlReservednum;
	}
	public void setTlType(java.lang.Integer value) {
		this.tlType = value;
	}

	public java.lang.Integer getTlType() {
		return this.tlType;
	}
	public void setTlGreentraffic(java.lang.Integer value) {
		this.tlGreentraffic = value;
	}

	public java.lang.Integer getTlGreentraffic() {
		return this.tlGreentraffic;
	}
	public void setTlTidaltime(java.lang.String value) {
		this.tlTidaltime = value;
	}

	public java.lang.String getTlTidaltime() {
		return this.tlTidaltime;
	}
	public void setTlStarttime(java.lang.String value) {
		this.tlStarttime = value;
	}

	public java.lang.String getTlStarttime() {
		return this.tlStarttime;
	}
	public void setTlEndtime(java.lang.String value) {
		this.tlEndtime = value;
	}

	public java.lang.String getTlEndtime() {
		return this.tlEndtime;
	}
	public void setTlStatus(java.lang.Integer value) {
		this.tlStatus = value;
	}

	public java.lang.Integer getTlStatus() {
		return this.tlStatus;
	}
	public void setTlWeightcharge(java.lang.Integer value) {
		this.tlWeightcharge = value;
	}

	public java.lang.Integer getTlWeightcharge() {
		return this.tlWeightcharge;
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
			.append("OldStationid",getOldStationid())
			.append("OldLanecode",getOldLanecode())
			.append("TlId",getTlId())
			.append("TlTollplazaPkid",getTlTollplazaPkid())
			.append("TlTollplazaid",getTlTollplazaid())
			.append("TlNum",getTlNum())
			.append("TlReservednum",getTlReservednum())
			.append("TlType",getTlType())
			.append("TlGreentraffic",getTlGreentraffic())
			.append("TlTidaltime",getTlTidaltime())
			.append("TlStarttime",getTlStarttime())
			.append("TlEndtime",getTlEndtime())
			.append("TlStatus",getTlStatus())
			.append("TlWeightcharge",getTlWeightcharge())
			.append("Remarks",getRemarks())
			.append("MenuId",getMenuId())
			.append("Flag",getFlag())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getOldStationid())
			.append(getOldLanecode())
			.append(getTlId())
			.append(getTlTollplazaPkid())
			.append(getTlTollplazaid())
			.append(getTlNum())
			.append(getTlReservednum())
			.append(getTlType())
			.append(getTlGreentraffic())
			.append(getTlTidaltime())
			.append(getTlStarttime())
			.append(getTlEndtime())
			.append(getTlStatus())
			.append(getTlWeightcharge())
			.append(getRemarks())
			.append(getMenuId())
			.append(getFlag())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicTolllane == false) return false;
		if(this == obj) return true;
		BasicTolllane other = (BasicTolllane)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getOldStationid(),other.getOldStationid())
			.append(getOldLanecode(),other.getOldLanecode())
			.append(getTlId(),other.getTlId())
			.append(getTlTollplazaPkid(),other.getTlTollplazaPkid())
			.append(getTlTollplazaid(),other.getTlTollplazaid())
			.append(getTlNum(),other.getTlNum())
			.append(getTlReservednum(),other.getTlReservednum())
			.append(getTlType(),other.getTlType())
			.append(getTlGreentraffic(),other.getTlGreentraffic())
			.append(getTlTidaltime(),other.getTlTidaltime())
			.append(getTlStarttime(),other.getTlStarttime())
			.append(getTlEndtime(),other.getTlEndtime())
			.append(getTlStatus(),other.getTlStatus())
			.append(getTlWeightcharge(),other.getTlWeightcharge())
			.append(getRemarks(),other.getRemarks())
			.append(getMenuId(),other.getMenuId())
			.append(getFlag(),other.getFlag	())
			.isEquals();
	}
}

