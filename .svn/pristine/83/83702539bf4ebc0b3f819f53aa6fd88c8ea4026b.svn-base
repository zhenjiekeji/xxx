/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.example.mailer;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.uk.sec.framework.mail.BaseMailer;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
@Component
public class ExampleMailer extends BaseMailer {
    public void send() {
        final SimpleMailMessage msg = createMail("邮件标题：邮件发送演示", "example.flt", new ExampleMailModel(), "csun@sec.ac.cn");
        sendConfirmMail(msg, "发信人：框架系统邮件演示");
    }
}
