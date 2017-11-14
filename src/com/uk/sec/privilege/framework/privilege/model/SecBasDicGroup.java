/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.model;

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

public class SecBasDicGroup extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS             = "字典组表";
    public static final String ALIAS_GROUP_ID          = "字典组ID";
    public static final String ALIAS_GROUP_NAME        = "字典组名称";
    public static final String ALIAS_GROUP_DESCRIPTION = "字典组描述";
    public static final String ALIAS_PARENT_ID         = "当前字典组的父ID，其中最顶层字典组的父ID为null";
    public static final String ALIAS_GROUP_VIEWORDER   = "字典组的显示顺序（4位一级），便于字典组分级显示";
    public static final String ALIAS_GROUP_FLAG        = "字典组标志位，0：不可现1：可现";
    
    // date formats
    
    // columns START
    private java.lang.String   groupId;
    private java.lang.String   groupName;
    private java.lang.String   groupDescription;
    private java.lang.String   parentId;
    private java.lang.String   groupVieworder;
    private java.lang.Short    groupFlag;
    // columns END
    
    public static final Short  GROUP_VIEWORDER_LEVEL   = 4;                            // 分组显示级别，4位一级
                                                                                        
    public static final Short  GROUP_FLAG_VISIBLE      = 1;                            // 分组可现
    public static final Short  GROUP_FLAG_INVISIBLE    = 0;                            // 分组不可现
                                                                                        
    public enum DicGroupEnum {
        MENU_OPERATION_ENUM("CF891D14C2001D0AE04014AC06124962"), // 菜单对应的操作枚举
        RISK_DIC_PERIOD_ENUM("0316158F9E4E47589EDB4F8F785D42F5"), // 有效期字典
        RISK_DIC_SOURCEFROM_ENUM("8DCDFB51CE1948E1B0897A4F279C3A18"), // 风险来源
        RISK_DIC_RISK_CLASS_ENUM("F6A7C70B182F430CA3EA27B0A8125D2D"), // 预警类别
        FOREWARM_DIC_STATE_ENUM("CCA117297A6A46CFB7E5176F3783F563"), // 预警状态
        RISK_INFO_STATE_ENUM("12FFEE7C910B42129F185CC497BF2A39"), // 风险信息单状态
        RISK_INFO_SOURCE_FROM_ENUM("03D316575A134A6F993FD6B071EE59B6"), // 风险信息来源
        BJ_RISK_JUDGE_CLASS_ENUM("735FBF70459B4625B324D39F42C91037"), // 北京局风险预警种类
        
        // 指标相关
        INFO_DATATYPE_ENUM("4ED0B0014324466DA66233546B345239"), // 指标数据类型
        INFO_INPUT_DATATYPE_ENUM("FD19E2493F684B13BEC752DCACCD1A46"), // 单行文本指标数据类型
        INFO_DATA_SOURCE_ENUM("F7185BC7EF344561AB9D9447BDCD2693"), // 指标数据来源枚举
        SEC_INFO_STATE_ENUM("1CC601C77BEA48E5BD8BBCDDE6CE00FE"), // 指标状态
        SEC_INFO_ISKEY_ENUM("92A5BA5DB79A4D609CB84B9A2EA18591"), // 指标状态
        
        SEC_INFO_SYSTEM_TYPE_ENUM("991429713C9A4C629CB3C502BC935738"), // 系统集成类型
        SEC_INFO_SYSTEM_ALTERTABLE_ENUM("9BB0834633C54B76A722A3969BE8F314"), // 备选表
        SEC_INFO_TEMPLATE_CLASS_ENUM("6C468934160549BBA302F016268F5367"), // 模板类型
        SEC_INFO_TEMPLATE_STATE_ENUM("D9A5A9E114B44310A2EC20EE07D7EEE4"), // 模板状态
        
        SEC_INFO_ITEM_INPUT_DATAFORMAT_ENUM("E13081387CA64351B7313A9CB761FC23"), // 数字数据格式
        SEC_INFO_ITEM_INPUT_DATATYPE_ENUM("87B9DE1F573C48DA9F4B2D878780F3DE"), // 数字数据类型
        
        SEC_INFO_ITEM_DATE_DATAFOMAT_ENUM("485AC7CEFB5D4451ACC660E621ACD100"), // 日期数据格式
        
        SEC_INFO_ITEM_LINKYPE_ENUM("73EBE0AB7D684D769153E35B18A7DCB8"), // 链接类型
        SEC_INFO_ITME_LINKTARGET_ENUM("2C848A52C2A7410E863247684EBA0654"), // 链接目标
        
        // 风险评估指数矩阵
        RISK_EVAL_MATRIX_POSSIBILITY_ENUM("F3D4BECD8E0F4E9C81542A8DC4326EAF"), // 可能性
        RISK_EVAL_MATRIX_SERIOUS_ENUM("450B08C1FFED408AAE3F27FFA903EDCF"), // 严重性
        
        // 产品风险评估
        RISK_TRADEMODE_TYPE_ENUM("1478D401002543D3A661258E3280F0CF"), // 贸易模式
        PRODUCT_RISK_STATE_ENUM("491EC06762754A5984E502ED670336A1"), // 风险评估审单状态
        RISK_EVAL_APPROVE_STATE_ENUM("84FA6AD653344A388F69744345E1FB0F"), // 产品风险评估审核单状态
        RISK_CLASS_TYPE_ENUM("2642CC81EFBB4BC2AB561B5833D4ACED"), // 产品风险级别
        
        // 备选项字典表,通过找关联的
        
        // 进口旧机电用途字典组GROUP_ID
        OLDMACHINE_USAGE_ENUM("05AF555EA5C4446A81FE4EB6D600D391"),
        // 收货人档案 相关字典组的GROUP_ID
        CONSIGNEE_CLASS_ENUM("26411B1B9BB143A2ABD8571F927F73F9"), 
        CONSIGNEE_AREA_ENUM("4907125F21354AE48DA7FFAE1072E3A5"), 
        CONSIGNEE_TYPE_ENUM("EE124CDF9C5C4C56BBA7EC0A660F9612"),
        CONSIGNEE_PROPERTY_ENUM("9EDB79F122D84B3EB698FCF24927396D"), 
        CONSIGNEE_BSCOPE_ENUM("534D747857A34374B1DD3148C376B523"), 
        CONSIGNEE_SENSITIVE_ENUM("3442ED566C004842A6A092DEF10732C8"),
        
        //专家单位性质
        EXPERT_UTIL_PROPERTIE("BD48D231CD424F148CBF86BB5E99CCAF"), 
        //产品类别
        PRODUCT_CLASS("6EEF18469ADB4479ADFB1E27086D1AC3");
        
        private final String groupId;
        
        DicGroupEnum(String groupId) {
            this.groupId = groupId;
        }
        
        public String getGroupId() {
            return groupId;
        }
    }
    
    public SecBasDicGroup() {
    }
    
    public SecBasDicGroup(java.lang.String groupId) {
        this.groupId = groupId;
    }
    
    public void setGroupId(java.lang.String value) {
        this.groupId = value;
    }
    
    public java.lang.String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupName(java.lang.String value) {
        this.groupName = value;
    }
    
    public java.lang.String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupDescription(java.lang.String value) {
        this.groupDescription = value;
    }
    
    public java.lang.String getGroupDescription() {
        return this.groupDescription;
    }
    
    public void setParentId(java.lang.String value) {
        this.parentId = value;
    }
    
    public java.lang.String getParentId() {
        return this.parentId;
    }
    
    public void setGroupVieworder(java.lang.String value) {
        this.groupVieworder = value;
    }
    
    public java.lang.String getGroupVieworder() {
        return this.groupVieworder;
    }
    
    public void setGroupFlag(java.lang.Short value) {
        this.groupFlag = value;
    }
    
    public java.lang.Short getGroupFlag() {
        return this.groupFlag;
    }
    
    private Set secBasDicItems = new HashSet(0);
    
    public void setSecBasDicItems(Set<SecBasDicItem> secBasDicItem) {
        this.secBasDicItems = secBasDicItem;
    }
    
    public Set<SecBasDicItem> getSecBasDicItems() {
        return secBasDicItems;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("GroupId", getGroupId())
                                        .append("GroupName", getGroupName())
                                        .append("GroupDescription", getGroupDescription())
                                        .append("ParentId", getParentId())
                                        .append("GroupVieworder", getGroupVieworder())
                                        .append("GroupFlag", getGroupFlag())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getGroupId())
                                    .append(getGroupName())
                                    .append(getGroupDescription())
                                    .append(getParentId())
                                    .append(getGroupVieworder())
                                    .append(getGroupFlag())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecBasDicGroup == false)
            return false;
        if (this == obj)
            return true;
        SecBasDicGroup other = (SecBasDicGroup) obj;
        return new EqualsBuilder().append(getGroupId(), other.getGroupId())
                                  .append(getGroupName(), other.getGroupName())
                                  .append(getGroupDescription(), other.getGroupDescription())
                                  .append(getParentId(), other.getParentId())
                                  .append(getGroupVieworder(), other.getGroupVieworder())
                                  .append(getGroupFlag(), other.getGroupFlag())
                                  .isEquals();
    }
}
