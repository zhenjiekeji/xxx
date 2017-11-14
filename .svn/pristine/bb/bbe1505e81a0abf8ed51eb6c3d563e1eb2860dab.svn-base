/*
 * Copyright (c) 2010 , All Rights Reserved. Project: limulus Version : 1.0
 * Create Date: 2010/4/28 1:36 Description:
 */

package com.uk.sec.framework.extremeImpl;

import java.io.UnsupportedEncodingException;

import org.extremecomponents.table.filter.ExportFilter;

/**
 * User: Nick Date: 2010-4-28 Time: 13:36:00
 * 功能描述：扩展ExportFilter，提供ectable支持中文名称文件下载。
 */
public class ExtremeExportFilter extends ExportFilter {
    /**
     * 重载 父类AbstractExportFilter的 setResponseHeaders,处理下载文件名为中文的乱码情况。
     * 
     * @param response
     *            HttpServletResponse
     * @param exportFileName
     *            下载文件名。
     */
    @Override
    protected void setResponseHeaders(javax.servlet.http.HttpServletResponse response, java.lang.String exportFileName) {
        try {
            int index = exportFileName.lastIndexOf(".") + 1;
            String fileName = exportFileName.substring(0, index);
            String extName = exportFileName.substring(index);
            response.setContentType(getContentType(extName) + "; CHARSET=utf8");
            response.setHeader("Content-Disposition", "attachment;filename=\""
                                                      + new String(fileName.getBytes(), "ISO8859-1") + extName + "\"");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private String getContentType(String extName) {
        if ("pdf".equalsIgnoreCase(extName)) {
            return "application/pdf";
        }
        if ("xls".equalsIgnoreCase(extName)) {
            return "application/excel";
        }
        if ("csv".equalsIgnoreCase(extName)) {
            return "application/excel";
        } else {
            return "application/octet-stream";
        }
    }
    
}
