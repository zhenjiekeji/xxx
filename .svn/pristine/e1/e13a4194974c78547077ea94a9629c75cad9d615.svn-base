/*
 * Copyright 2001-2011 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.file.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.file.callback.UploadFileCallback;


/**
 * 用于文件的上传和下载.其中,文件上传的功能只是提供一个演示的例子,仅供参考.
 * 
 * @author xzw
 * @version 1.0
 * @since 1.0
 */

public class FileAction extends BaseStruts2Action implements UploadFileCallback {
    protected static final String UPLOAD_JSP    = "/framework/file/File/file_upload.jsp";
    protected static final String DOWNLOAD_JSP  = "/framework/file/File/file_download.jsp";
    protected static final String UPLOAD_ACTION = "!/framework/file/File/up.do";
    protected static final String DOWN_ACTION   = "!/framework/file/File/down.do";
    
    public String up() {
        return UPLOAD_JSP;
        
    }
    
    public String upload() {
        String[] uploadResult = this.processUploadFile();
        for (String s : uploadResult) {
            logger.info(s);
        }
        return UPLOAD_ACTION;
        
    }
    
    public String callback(File uploadFile, String uploadFileFileName) {
        return "callback:" + uploadFile + "--" + uploadFileFileName;
        
    }
    
    public String down() {
        return DOWNLOAD_JSP;
    }
    
    private String filePath;
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void downloadAbsolute() throws Exception {
        download(this.filePath);
    }
    
    public void downloadRelative() throws Exception {
        String appDir = this.getRequest().getSession().getServletContext().getRealPath("/") + File.separator;
        download(appDir + this.filePath);
    }
    
    private void download(String path) throws Exception {
        logger.info(path);
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(fileInputStream, byteArrayOutputStream);
        this.getResponse().setContentType("application/file");
        this.getResponse().setContentLength(byteArrayOutputStream.size());
        String fileName = StringUtils.substringAfterLast(path, File.separator);
        String n = new String(fileName.getBytes(), "ISO-8859-1");
        this.getResponse().setHeader("Content-disposition", "attachment;filename=" + n);
        byteArrayOutputStream.writeTo(this.getResponse().getOutputStream());
    }
}
