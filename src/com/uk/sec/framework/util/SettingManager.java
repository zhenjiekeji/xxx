/*
 * 版权所有 科技有限公司 Copyright(c) 2015 All Rights Reserved. Project: waite
 * Description:
 */
package com.uk.sec.framework.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class SettingManager {
    private static String         FILE_PATH = "/settings.properties";
    private static SettingManager INSTANCE  = new SettingManager();
    
    public static SettingManager getInstance() {
        return INSTANCE;
    }
    
    private Configuration config;
    
    private SettingManager() {
        try {
            config = new PropertiesConfiguration(SettingManager.class.getResource(FILE_PATH));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 用于读取配置文件
     * 
     * @return
     */
    public Configuration getConfig() {
        return config;
    }
    
    /**
     * 获取sheettemplatedir字符
     * 
     * @return
     */
    public String getSheetTemplateDir() {
        return config.getString("sheettemplate.dir");
    }
    
    /**
     * 获取是否显示医疗器械复选框字符
     * 
     * @return
     */
    public String getIsViewMedicalChk() {
        return config.getString("system.config.isViewMedicalChk");
    }
    
    /**
     * css引用文件
     * 
     * @return
     */
    public String getCssLinkPath() {
        return config.getString("system.css.linkPath");
    }
    
    /**
     * 风险等级计算 >12
     * 
     * @return
     */
    public double getRiskLow() {
        return Double.parseDouble(config.getString("system.risk.low"));
    }
    
    /**
     * 风险等级计算<8
     * 
     * @return
     */
    public double getRiskHigh() {
        return Double.parseDouble(config.getString("system.risk.high"));
    }
    /**
     * 新增收货人的默认密码
     * 
     * @return
     */
    public String getCosigneeDefaultPassword() {
        return config.getString("consignee.default.password");
    }
    
    /**
     * 企业产品监管方式:报检单货物单批货值,单位:USD
     * 
     * @return
     */    
    public Double getDeclGoodsUSDBatch() {
        return Double.valueOf(config.getString("decl.goods.usd.batch"));
    }    
    /**
     * 企业产品监管方式:报检单一般贸易方式代码
     * 
     * @return
     */
    public String getDeclCommonTradeModeCode() {
        return config.getString("decl.common.tradeModeCode");
    }  
    /**
     * 企业产品监管方式:产品制造商评价总分百分比
     * 
     * @return
     */
    public String getProManuTotalScore() {
        return config.getString("product.manufacture.totalScore");
    }   
    /**
     * 上传附件最大尺寸,单位:字节
     * 
     * @return
     */
    public Long getAttachmentUploadMaxsize() {
        return Long.valueOf(config.getString("attachment.upload.maxsize"));
    }          
    
}
