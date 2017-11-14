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


public class BasicLinkinvestor extends BaseEntity {

	//alias
	public static final String TABLE_ALIAS = "BasicLinkinvestor";
	public static final String ALIAS_PK_ID = "pkId";
	public static final String ALIAS_LI_CODE = "liCode";
	public static final String ALIAS_LI_NAME = "liName";
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
	private java.lang.String liCode;
	private java.lang.String liName;
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
	private java.lang.Integer flag;   //表示删除状态
	//columns END

	public BasicLinkinvestor(){
	}

	public BasicLinkinvestor(
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
	public void setLiCode(java.lang.String value) {
		this.liCode = value;
	}

	public java.lang.String getLiCode() {
		return this.liCode;
	}
	public void setLiName(java.lang.String value) {
		this.liName = value;
	}

	public java.lang.String getLiName() {
		return this.liName;
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

	public java.lang.Integer getFlag() {
		return flag;
	}

	public void setFlag(java.lang.Integer flag) {
		this.flag = flag;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("PkId",getPkId())
			.append("LiCode",getLiCode())
			.append("LiName",getLiName())
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
			.append("Flag",getFlag())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPkId())
			.append(getLiCode())
			.append(getLiName())
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
			.append(getFlag())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof BasicLinkinvestor == false) return false;
		if(this == obj) return true;
		BasicLinkinvestor other = (BasicLinkinvestor)obj;
		return new EqualsBuilder()
			.append(getPkId(),other.getPkId())
			.append(getLiCode(),other.getLiCode())
			.append(getLiName(),other.getLiName())
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
			.append(getFlag(),other.getFlag())
			.isEquals();
	}
}

