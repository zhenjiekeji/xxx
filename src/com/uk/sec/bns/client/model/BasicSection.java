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


public class BasicSection extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicSection";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_OLD_CODE = "oldCode";
	public static final String ALIAS_SE_CODE = "seCode";
	public static final String ALIAS_SE_TOLLROAD_CODE = "seTollroadCode";
	public static final String ALIAS_SE_TOLLROADNAME = "seTollroadname";
	public static final String ALIAS_SE_NUM = "seNum";
	public static final String ALIAS_SE_RESERVEDNUM = "seReservednum";
	public static final String ALIAS_SE_NAME = "seName";
	public static final String ALIAS_SE_TYPE = "seType";
	public static final String ALIAS_SE_LENGTH = "seLength";
	public static final String ALIAS_SE_STARTSITE = "seStartsite";
	public static final String ALIAS_SE_STARTLNG = "seStartlng";
	public static final String ALIAS_SE_STARTLAT = "seStartlat";
	public static final String ALIAS_SE_STARTSTAKENUM = "seStartstakenum";
	public static final String ALIAS_SE_ENDSITE = "seEndsite";
	public static final String ALIAS_SE_ENDLNG = "seEndlng";
	public static final String ALIAS_SE_ENDLAT = "seEndlat";
	public static final String ALIAS_SE_ENDSTAKENUM = "seEndstakenum";
	public static final String ALIAS_SE_TAX = "seTax";
	public static final String ALIAS_SE_TAXRATE = "seTaxrate";
	public static final String ALIAS_SE_SECTIONOWNER_CODE = "seSectionownerCode";
	public static final String ALIAS_SE_SECTIONOWNER_ID = "seSectionownerId";
	public static final String ALIAS_SE_CHARGETYPE = "seChargetype";
	public static final String ALIAS_SE_TOLLROADS = "seTollroads";
	public static final String ALIAS_SE_BUILTTIME = "seBuilttime";
	public static final String ALIAS_SE_STARTTIME = "seStarttime";
	public static final String ALIAS_SE_ENDTIME = "seEndtime";
	public static final String ALIAS_SE_OLD_ROADNO = "seOldRoadno";
	public static final String ALIAS_IV_PRE_PKID = "ivPrePkid";
	public static final String ALIAS_IV_CURRENTFLAG = "ivCurrentflag";
	public static final String ALIAS_IV_OPERATE = "ivOperate";
	public static final String ALIAS_IV_OPERATOR = "ivOperator";
	public static final String ALIAS_IV_OPERATETIME = "ivOperatetime";
	public static final String ALIAS_IV_REVIEWSTATUS = "ivReviewstatus";
	public static final String ALIAS_IV_REVIEWSTATUSTIME = "ivReviewstatustime";
	public static final String ALIAS_IV_REVIEWER1 = "ivReviewer1";
	public static final String ALIAS_IV_REVIEW1TIME = "ivReview1time";
	public static final String ALIAS_IV_REVIEWER2 = "ivReviewer2";
	public static final String ALIAS_IV_REVIEW2TIME = "ivReview2time";
	public static final String ALIAS_REMARKS = "remarks";

	//date formats
	public static final String FORMAT_IV_OPERATETIME = DATE_TIME_FORMAT;
	public static final String FORMAT_IV_REVIEWSTATUSTIME = DATE_TIME_FORMAT;
	public static final String FORMAT_IV_REVIEW1TIME = DATE_TIME_FORMAT;
	public static final String FORMAT_IV_REVIEW2TIME = DATE_TIME_FORMAT;

	//columns START
	private java.lang.String pkId;
	private java.lang.String oldCode;
	private java.lang.String seCode;
	private java.lang.String seTollroadCode;
	private java.lang.String seTollroadname;
	private java.lang.String seNum;
	private java.lang.String seReservednum;
	private java.lang.String seName;
	private java.lang.Integer seType;
	private java.lang.Integer seLength;
	private java.lang.String seStartsite;
	private java.lang.String seStartlng;
	private java.lang.String seStartlat;
	private java.lang.String seStartstakenum;
	private java.lang.String seEndsite;
	private java.lang.String seEndlng;
	private java.lang.String seEndlat;
	private java.lang.String seEndstakenum;
	private java.lang.Integer seTax;
	private java.lang.Integer seTaxrate;
	private java.lang.String seSectionownerCode;
	private java.lang.String seSectionownerId;
	private java.lang.Integer seChargetype;
	private java.lang.String seTollroads;
	private java.lang.String seBuilttime;
	private java.lang.String seStarttime;
	private java.lang.String seEndtime;
	private java.lang.String seOldRoadno;
	private java.lang.Integer ivPrePkid;
	private java.lang.Integer ivCurrentflag;
	private java.lang.Integer ivOperate;
	private java.lang.Integer ivOperator;
	private java.util.Date ivOperatetime;
	private java.lang.Integer ivReviewstatus;
	private java.util.Date ivReviewstatustime;
	private java.lang.String ivReviewer1;
	private java.util.Date ivReview1time;
	private java.lang.String ivReviewer2;
	private java.util.Date ivReview2time;
	private java.lang.String remarks;
	private java.lang.String menuId;
	private java.lang.Integer flag;   //表示是否删除状态
	//columns END

	public BasicSection(){
	}

	public BasicSection(
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
	public void setOldCode(java.lang.String value) {
		this.oldCode = value;
	}

	public java.lang.String getOldCode() {
		return this.oldCode;
	}
	public void setSeCode(java.lang.String value) {
		this.seCode = value;
	}

	public java.lang.String getSeCode() {
		return this.seCode;
	}
	public void setSeTollroadCode(java.lang.String value) {
		this.seTollroadCode = value;
	}

	public java.lang.String getSeTollroadCode() {
		return this.seTollroadCode;
	}
	public void setSeTollroadname(java.lang.String value) {
		this.seTollroadname = value;
	}

	public java.lang.String getSeTollroadname() {
		return this.seTollroadname;
	}
	public void setSeNum(java.lang.String value) {
		this.seNum = value;
	}

	public java.lang.String getSeNum() {
		return this.seNum;
	}
	public void setSeReservednum(java.lang.String value) {
		this.seReservednum = value;
	}

	public java.lang.String getSeReservednum() {
		return this.seReservednum;
	}
	public void setSeName(java.lang.String value) {
		this.seName = value;
	}

	public java.lang.String getSeName() {
		return this.seName;
	}
	public void setSeType(java.lang.Integer value) {
		this.seType = value;
	}

	public java.lang.Integer getSeType() {
		return this.seType;
	}
	public void setSeLength(java.lang.Integer value) {
		this.seLength = value;
	}

	public java.lang.Integer getSeLength() {
		return this.seLength;
	}
	public void setSeStartsite(java.lang.String value) {
		this.seStartsite = value;
	}

	public java.lang.String getSeStartsite() {
		return this.seStartsite;
	}
	public void setSeStartlng(java.lang.String value) {
		this.seStartlng = value;
	}

	public java.lang.String getSeStartlng() {
		return this.seStartlng;
	}
	public void setSeStartlat(java.lang.String value) {
		this.seStartlat = value;
	}

	public java.lang.String getSeStartlat() {
		return this.seStartlat;
	}
	public void setSeStartstakenum(java.lang.String value) {
		this.seStartstakenum = value;
	}

	public java.lang.String getSeStartstakenum() {
		return this.seStartstakenum;
	}
	public void setSeEndsite(java.lang.String value) {
		this.seEndsite = value;
	}

	public java.lang.String getSeEndsite() {
		return this.seEndsite;
	}
	public void setSeEndlng(java.lang.String value) {
		this.seEndlng = value;
	}

	public java.lang.String getSeEndlng() {
		return this.seEndlng;
	}
	public void setSeEndlat(java.lang.String value) {
		this.seEndlat = value;
	}

	public java.lang.String getSeEndlat() {
		return this.seEndlat;
	}
	public void setSeEndstakenum(java.lang.String value) {
		this.seEndstakenum = value;
	}

	public java.lang.String getSeEndstakenum() {
		return this.seEndstakenum;
	}
	public void setSeTax(java.lang.Integer value) {
		this.seTax = value;
	}

	public java.lang.Integer getSeTax() {
		return this.seTax;
	}
	public void setSeTaxrate(java.lang.Integer value) {
		this.seTaxrate = value;
	}

	public java.lang.Integer getSeTaxrate() {
		return this.seTaxrate;
	}
	public void setSeSectionownerCode(java.lang.String value) {
		this.seSectionownerCode = value;
	}

	public java.lang.String getSeSectionownerCode() {
		return this.seSectionownerCode;
	}
	
	public java.lang.String getSeSectionownerId() {
		return seSectionownerId;
	}

	public void setSeSectionownerId(java.lang.String seSectionownerId) {
		this.seSectionownerId = seSectionownerId;
	}

	public void setSeChargetype(java.lang.Integer value) {
		this.seChargetype = value;
	}

	public java.lang.Integer getSeChargetype() {
		return this.seChargetype;
	}
	public void setSeTollroads(java.lang.String value) {
		this.seTollroads = value;
	}

	public java.lang.String getSeTollroads() {
		return this.seTollroads;
	}
	public void setSeBuilttime(java.lang.String value) {
		this.seBuilttime = value;
	}

	public java.lang.String getSeBuilttime() {
		return this.seBuilttime;
	}
	public void setSeStarttime(java.lang.String value) {
		this.seStarttime = value;
	}

	public java.lang.String getSeStarttime() {
		return this.seStarttime;
	}
	public void setSeEndtime(java.lang.String value) {
		this.seEndtime = value;
	}

	public java.lang.String getSeEndtime() {
		return this.seEndtime;
	}
	public void setSeOldRoadno(java.lang.String value) {
		this.seOldRoadno = value;
	}

	public java.lang.String getSeOldRoadno() {
		return this.seOldRoadno;
	}
	public void setIvPrePkid(java.lang.Integer value) {
		this.ivPrePkid = value;
	}

	public java.lang.Integer getIvPrePkid() {
		return this.ivPrePkid;
	}
	public void setIvCurrentflag(java.lang.Integer value) {
		this.ivCurrentflag = value;
	}

	public java.lang.Integer getIvCurrentflag() {
		return this.ivCurrentflag;
	}
	public void setIvOperate(java.lang.Integer value) {
		this.ivOperate = value;
	}

	public java.lang.Integer getIvOperate() {
		return this.ivOperate;
	}
	public void setIvOperator(java.lang.Integer value) {
		this.ivOperator = value;
	}

	public java.lang.Integer getIvOperator() {
		return this.ivOperator;
	}
	public String getIvOperatetimeString() {
		return date2String(getIvOperatetime(), FORMAT_IV_OPERATETIME);
	}
	public void setIvOperatetimeString(String value) {
		setIvOperatetime(string2Date(value, FORMAT_IV_OPERATETIME,java.util.Date.class));
	}

	public void setIvOperatetime(java.util.Date value) {
		this.ivOperatetime = value;
	}

	public java.util.Date getIvOperatetime() {
		return this.ivOperatetime;
	}
	public void setIvReviewstatus(java.lang.Integer value) {
		this.ivReviewstatus = value;
	}

	public java.lang.Integer getIvReviewstatus() {
		return this.ivReviewstatus;
	}
	public String getIvReviewstatustimeString() {
		return date2String(getIvReviewstatustime(), FORMAT_IV_REVIEWSTATUSTIME);
	}
	public void setIvReviewstatustimeString(String value) {
		setIvReviewstatustime(string2Date(value, FORMAT_IV_REVIEWSTATUSTIME,java.util.Date.class));
	}

	public void setIvReviewstatustime(java.util.Date value) {
		this.ivReviewstatustime = value;
	}

	public java.util.Date getIvReviewstatustime() {
		return this.ivReviewstatustime;
	}
	public void setIvReviewer1(java.lang.String value) {
		this.ivReviewer1 = value;
	}

	public java.lang.String getIvReviewer1() {
		return this.ivReviewer1;
	}
	public String getIvReview1timeString() {
		return date2String(getIvReview1time(), FORMAT_IV_REVIEW1TIME);
	}
	public void setIvReview1timeString(String value) {
		setIvReview1time(string2Date(value, FORMAT_IV_REVIEW1TIME,java.util.Date.class));
	}

	public void setIvReview1time(java.util.Date value) {
		this.ivReview1time = value;
	}

	public java.util.Date getIvReview1time() {
		return this.ivReview1time;
	}
	public void setIvReviewer2(java.lang.String value) {
		this.ivReviewer2 = value;
	}

	public java.lang.String getIvReviewer2() {
		return this.ivReviewer2;
	}
	public String getIvReview2timeString() {
		return date2String(getIvReview2time(), FORMAT_IV_REVIEW2TIME);
	}
	public void setIvReview2timeString(String value) {
		setIvReview2time(string2Date(value, FORMAT_IV_REVIEW2TIME,java.util.Date.class));
	}

	public void setIvReview2time(java.util.Date value) {
		this.ivReview2time = value;
	}

	public java.util.Date getIvReview2time() {
		return this.ivReview2time;
	}
	public void setRemarks(java.lang.String value) {
		this.remarks = value;
	}

	public java.lang.String getRemarks() {
		return this.remarks;
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
			.append("SeCode",getSeCode())
			.append("SeTollroadCode",getSeTollroadCode())
			.append("SeTollroadname",getSeTollroadname())
			.append("SeNum",getSeNum())
			.append("SeReservednum",getSeReservednum())
			.append("SeName",getSeName())
			.append("SeType",getSeType())
			.append("SeLength",getSeLength())
			.append("SeStartsite",getSeStartsite())
			.append("SeStartlng",getSeStartlng())
			.append("SeStartlat",getSeStartlat())
			.append("SeStartstakenum",getSeStartstakenum())
			.append("SeEndsite",getSeEndsite())
			.append("SeEndlng",getSeEndlng())
			.append("SeEndlat",getSeEndlat())
			.append("SeEndstakenum",getSeEndstakenum())
			.append("SeTax",getSeTax())
			.append("SeTaxrate",getSeTaxrate())
			.append("SeSectionownerCode",getSeSectionownerCode())
			.append("SeChargetype",getSeChargetype())
			.append("SeTollroads",getSeTollroads())
			.append("SeBuilttime",getSeBuilttime())
			.append("SeStarttime",getSeStarttime())
			.append("SeEndtime",getSeEndtime())
			.append("SeOldRoadno",getSeOldRoadno())
			.append("IvPrePkid",getIvPrePkid())
			.append("IvCurrentflag",getIvCurrentflag())
			.append("IvOperate",getIvOperate())
			.append("IvOperator",getIvOperator())
			.append("IvOperatetime",getIvOperatetime())
			.append("IvReviewstatus",getIvReviewstatus())
			.append("IvReviewstatustime",getIvReviewstatustime())
			.append("IvReviewer1",getIvReviewer1())
			.append("IvReview1time",getIvReview1time())
			.append("IvReviewer2",getIvReviewer2())
			.append("IvReview2time",getIvReview2time())
			.append("Remarks",getRemarks())
			.append("MenuId",getMenuId())
			.append("Flag",getFlag())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getOldCode())
			.append(getSeCode())
			.append(getSeTollroadCode())
			.append(getSeTollroadname())
			.append(getSeNum())
			.append(getSeReservednum())
			.append(getSeName())
			.append(getSeType())
			.append(getSeLength())
			.append(getSeStartsite())
			.append(getSeStartlng())
			.append(getSeStartlat())
			.append(getSeStartstakenum())
			.append(getSeEndsite())
			.append(getSeEndlng())
			.append(getSeEndlat())
			.append(getSeEndstakenum())
			.append(getSeTax())
			.append(getSeTaxrate())
			.append(getSeSectionownerCode())
			.append(getSeChargetype())
			.append(getSeTollroads())
			.append(getSeBuilttime())
			.append(getSeStarttime())
			.append(getSeEndtime())
			.append(getSeOldRoadno())
			.append(getIvPrePkid())
			.append(getIvCurrentflag())
			.append(getIvOperate())
			.append(getIvOperator())
			.append(getIvOperatetime())
			.append(getIvReviewstatus())
			.append(getIvReviewstatustime())
			.append(getIvReviewer1())
			.append(getIvReview1time())
			.append(getIvReviewer2())
			.append(getIvReview2time())
			.append(getRemarks())
			.append(getMenuId())
			.append(getFlag())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicSection == false) return false;
		if(this == obj) return true;
		BasicSection other = (BasicSection)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getOldCode(),other.getOldCode())
			.append(getSeCode(),other.getSeCode())
			.append(getSeTollroadCode(),other.getSeTollroadCode())
			.append(getSeTollroadname(),other.getSeTollroadname())
			.append(getSeNum(),other.getSeNum())
			.append(getSeReservednum(),other.getSeReservednum())
			.append(getSeName(),other.getSeName())
			.append(getSeType(),other.getSeType())
			.append(getSeLength(),other.getSeLength())
			.append(getSeStartsite(),other.getSeStartsite())
			.append(getSeStartlng(),other.getSeStartlng())
			.append(getSeStartlat(),other.getSeStartlat())
			.append(getSeStartstakenum(),other.getSeStartstakenum())
			.append(getSeEndsite(),other.getSeEndsite())
			.append(getSeEndlng(),other.getSeEndlng())
			.append(getSeEndlat(),other.getSeEndlat())
			.append(getSeEndstakenum(),other.getSeEndstakenum())
			.append(getSeTax(),other.getSeTax())
			.append(getSeTaxrate(),other.getSeTaxrate())
			.append(getSeSectionownerCode(),other.getSeSectionownerCode())
			.append(getSeChargetype(),other.getSeChargetype())
			.append(getSeTollroads(),other.getSeTollroads())
			.append(getSeBuilttime(),other.getSeBuilttime())
			.append(getSeStarttime(),other.getSeStarttime())
			.append(getSeEndtime(),other.getSeEndtime())
			.append(getSeOldRoadno(),other.getSeOldRoadno())
			.append(getIvPrePkid(),other.getIvPrePkid())
			.append(getIvCurrentflag(),other.getIvCurrentflag())
			.append(getIvOperate(),other.getIvOperate())
			.append(getIvOperator(),other.getIvOperator())
			.append(getIvOperatetime(),other.getIvOperatetime())
			.append(getIvReviewstatus(),other.getIvReviewstatus())
			.append(getIvReviewstatustime(),other.getIvReviewstatustime())
			.append(getIvReviewer1(),other.getIvReviewer1())
			.append(getIvReview1time(),other.getIvReview1time())
			.append(getIvReviewer2(),other.getIvReviewer2())
			.append(getIvReview2time(),other.getIvReview2time())
			.append(getRemarks(),other.getRemarks())
			.append(getMenuId(),other.getMenuId())
			.append(getFlag(),other.getFlag	())
			.isEquals();
	}
}

