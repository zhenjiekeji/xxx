/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.system.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecSysRulevalue extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS            = "SecSysRulevalue";
    public static final String ALIAS_ID               = "主键";
    public static final String ALIAS_RULE_KEYVALUE    = "规则KEY值";
    public static final String ALIAS_SEQ_CURRENTVALUE = "流水号当前值";
    public static final String ALIAS_RULE_ID          = "规则编号";
    
    // date formats
    
    // columns START
    private java.lang.String   id;
    private java.lang.String   ruleKeyvalue;
    private java.lang.Long     seqCurrentvalue;
    private java.lang.String   ruleId;
    
    // columns END
    
    public SecSysRulevalue() {
    }
    
    public SecSysRulevalue(java.lang.String id) {
        this.id = id;
    }
    
    public void setId(java.lang.String value) {
        this.id = value;
    }
    
    public java.lang.String getId() {
        return this.id;
    }
    
    public void setRuleKeyvalue(java.lang.String value) {
        this.ruleKeyvalue = value;
    }
    
    public java.lang.String getRuleKeyvalue() {
        return this.ruleKeyvalue;
    }
    
    public void setRuleId(java.lang.String value) {
        this.ruleId = value;
    }
    
    public java.lang.String getRuleId() {
        return this.ruleId;
    }
    
    private SecSysSeqrule secSysSeqrule;
    
    public void setSecSysSeqrule(SecSysSeqrule secSysSeqrule) {
        this.secSysSeqrule = secSysSeqrule;
    }
    
    public SecSysSeqrule getSecSysSeqrule() {
        return secSysSeqrule;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("Id", getId())
                                        .append("RuleKeyvalue", getRuleKeyvalue())
                                        .append("SeqCurrentvalue", getSeqCurrentvalue())
                                        .append("RuleId", getRuleId())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                                    .append(getRuleKeyvalue())
                                    .append(getSeqCurrentvalue())
                                    .append(getRuleId())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecSysRulevalue == false)
            return false;
        if (this == obj)
            return true;
        SecSysRulevalue other = (SecSysRulevalue) obj;
        return new EqualsBuilder().append(getId(), other.getId())
                                  .append(getRuleKeyvalue(), other.getRuleKeyvalue())
                                  .append(getSeqCurrentvalue(), other.getSeqCurrentvalue())
                                  .append(getRuleId(), other.getRuleId())
                                  .isEquals();
    }
    
    public java.lang.Long getSeqCurrentvalue() {
        return seqCurrentvalue;
    }
    
    public void setSeqCurrentvalue(java.lang.Long seqCurrentvalue) {
        this.seqCurrentvalue = seqCurrentvalue;
    }
}
