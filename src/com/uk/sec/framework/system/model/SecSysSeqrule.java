/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecSysSeqrule extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS          = "流水号规则表";
    public static final String ALIAS_RULE_ID        = "规则编号";
    public static final String ALIAS_RULE_CNAME     = "规则中文名称";
    public static final String ALIAS_RULE_ENAME     = "规则英文名称";
    public static final String ALIAS_SEQ_LENGTH     = "流水号长度";
    public static final String ALIAS_SEQ_STARTVALUE = "流水号开始值";
    public static final String ALIAS_SEQ_STEP       = "流水号步长";
    
    // date formats
    
    // columns START
    private java.lang.String   ruleId;
    private java.lang.String   ruleCname;
    private java.lang.String   ruleEname;
    private Long               seqLength;
    private java.lang.Long     seqStartvalue;
    private java.lang.Long     seqStep;
    // columns END
    
    // columns
    private SecSysRulevalue    secSysRulevalue;
    
    public SecSysSeqrule() {
    }
    
    public SecSysSeqrule(java.lang.String ruleId) {
        this.ruleId = ruleId;
    }
    
    public void setRuleId(java.lang.String value) {
        this.ruleId = value;
    }
    
    public java.lang.String getRuleId() {
        return this.ruleId;
    }
    
    public void setRuleCname(java.lang.String value) {
        this.ruleCname = value;
    }
    
    public java.lang.String getRuleCname() {
        return this.ruleCname;
    }
    
    public void setRuleEname(java.lang.String value) {
        this.ruleEname = value;
    }
    
    public java.lang.String getRuleEname() {
        return this.ruleEname;
    }
    
    public void setSeqLength(Long value) {
        this.seqLength = value;
    }
    
    public Long getSeqLength() {
        return this.seqLength;
    }
    
    public void setSeqStartvalue(java.lang.Long value) {
        this.seqStartvalue = value;
    }
    
    public java.lang.Long getSeqStartvalue() {
        return this.seqStartvalue;
    }
    
    public void setSeqStep(java.lang.Long value) {
        this.seqStep = value;
    }
    
    public java.lang.Long getSeqStep() {
        return this.seqStep;
    }
    
    private Set secSysRulevalues = new HashSet(0);
    
    public void setSecSysRulevalues(Set<SecSysRulevalue> secSysRulevalue) {
        this.secSysRulevalues = secSysRulevalue;
    }
    
    public Set<SecSysRulevalue> getSecSysRulevalues() {
        return secSysRulevalues;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("RuleId", getRuleId())
                                        .append("RuleCname", getRuleCname())
                                        .append("RuleEname", getRuleEname())
                                        .append("SeqLength", getSeqLength())
                                        .append("SeqStartvalue", getSeqStartvalue())
                                        .append("SeqStep", getSeqStep())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getRuleId())
                                    .append(getRuleCname())
                                    .append(getRuleEname())
                                    .append(getSeqLength())
                                    .append(getSeqStartvalue())
                                    .append(getSeqStep())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecSysSeqrule == false)
            return false;
        if (this == obj)
            return true;
        SecSysSeqrule other = (SecSysSeqrule) obj;
        return new EqualsBuilder().append(getRuleId(), other.getRuleId())
                                  .append(getRuleCname(), other.getRuleCname())
                                  .append(getRuleEname(), other.getRuleEname())
                                  .append(getSeqLength(), other.getSeqLength())
                                  .append(getSeqStartvalue(), other.getSeqStartvalue())
                                  .append(getSeqStep(), other.getSeqStep())
                                  .isEquals();
    }
    
    public SecSysRulevalue getSecSysRulevalue() {
        return secSysRulevalue;
    }
    
    public void setSecSysRulevalue(SecSysRulevalue secSysRulevalue) {
        this.secSysRulevalue = secSysRulevalue;
    }
}
