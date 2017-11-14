/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.example.action;

import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.example.mailer.ExampleMailer;

/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class ExampleAction extends BaseStruts2Action {
    
    public void mail() {
        exampleMailer.send();
    }
    
    private ExampleMailer exampleMailer;
    
    /**
     * @return the exampleMailer
     */
    public ExampleMailer getExampleMailer() {
        return exampleMailer;
    }
    
    /**
     * @param exampleMailer
     *            the exampleMailer to set
     */
    public void setExampleMailer(ExampleMailer exampleMailer) {
        this.exampleMailer = exampleMailer;
    }
    
}
