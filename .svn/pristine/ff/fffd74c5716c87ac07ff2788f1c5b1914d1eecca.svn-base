package com.uk.sec.framework.mail;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.Assert;

import com.uk.sec.framework.log.LogFactory;

import cn.org.rapid_framework.freemarker.FreemarkerTemplateProcessor;
import cn.org.rapid_framework.mail.AsyncJavaMailSender;
import cn.org.rapid_framework.mail.SimpleMailMessageUtils;
import cn.org.rapid_framework.util.concurrent.async.AsyncToken;
import cn.org.rapid_framework.util.concurrent.async.IResponder;

/**
 * mailer基类,用于其它mailer继承. 现本mailer与freemarker模板结合,用于生成邮件内容 本类你也可以自由修改
 * 
 * <pre>
 * Mailer使用规范:
 * 1. 包名: 放在mailer包内,如com.company.project.mailer
 * 2. 类名: 以Mailer结尾,如UserMailer
 * 3. 模板名：放在email_template/usermailer/目录下，名称随意
 * 4. 方法名: 
 * 			使用UserMailer.createXXXX()来创建邮件消息,如UserMailer.createConfirmMail()
 * 			使用UserMailer.sendXXXX()来发送邮件,如UserMailer.sendConfirmMail()
 * 5.必须继承之BaseMailer
 * 6.单元测试一般情况下测试testCreateXXXX()即可
 * </pre>
 * 
 * @author xzw
 */
public abstract class BaseMailer implements InitializingBean {
    
    private AsyncJavaMailSender           asyncJavaMailSender;
    protected SimpleMailMessage           simpleMailMessageTemplate;
    protected FreemarkerTemplateProcessor freemarkerTemplateProcessor;
    protected String                      mailSubjectPrefix;          // 邮件前缀,子类可以使用
                                                                       
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(asyncJavaMailSender, "asyncJavaMailSender must be not null");
        Assert.notNull(freemarkerTemplateProcessor, "freemarkerTemplateProcessor must be not null");
    }
    
    public void setAsyncJavaMailSender(AsyncJavaMailSender asyncJavaMailSender) {
        this.asyncJavaMailSender = asyncJavaMailSender;
    }
    
    public AsyncJavaMailSender getAsyncJavaMailSender() {
        return asyncJavaMailSender;
    }
    
    public JavaMailSender getJavaMailSender() {
        return getAsyncJavaMailSender().getJavaMailSender();
    }
    
    public void setSimpleMailMessageTemplate(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessageTemplate = simpleMailMessage;
    }
    
    public FreemarkerTemplateProcessor getFreemarkerTemplateProcessor() {
        return freemarkerTemplateProcessor;
    }
    
    public void setFreemarkerTemplateProcessor(FreemarkerTemplateProcessor freemarkerTemplateProcessor) {
        this.freemarkerTemplateProcessor = freemarkerTemplateProcessor;
    }
    
    public void setMailSubjectPrefix(String subjectPrefix) {
        this.mailSubjectPrefix = subjectPrefix;
    }
    
    public String getMailSubjectPrefix() {
        return mailSubjectPrefix;
    }
    
    /** 为模板增加前缀,现格式为: lowercase_classname/templateName */
    protected String addTemplateNamePrefix(String templateName) {
        String className = getClass().getSimpleName();
        String realTemplateName = className.toLowerCase() + "/" + templateName;
        return realTemplateName;
    }
    
    public String processTemplate(String templateName, Object model) {
        String realTemplateName = addTemplateNamePrefix(templateName);
        return getFreemarkerTemplateProcessor().processTemplate(realTemplateName, model);
    }
    
    public String processTemplate(String templateName, MailModel model) {
        String realTemplateName = addTemplateNamePrefix(templateName);
        return getFreemarkerTemplateProcessor().processTemplate(realTemplateName, model.freemarkMode());
    }
    
    protected SimpleMailMessage newSimpleMsgFromTemplate(String subject) {
        SimpleMailMessage msg = new SimpleMailMessage();
        if (simpleMailMessageTemplate != null) {
            simpleMailMessageTemplate.copyTo(msg);
        }
        
        String prefix = getMailSubjectPrefix();
        msg.setSubject(((prefix == null ? "" : prefix) + subject));
        
        return msg;
    }
    
    @SuppressWarnings( { "unchecked", "deprecation" })
    public boolean sendConfirmMail(SimpleMailMessage msg, String from) {
        
        AsyncToken token = getAsyncJavaMailSender().send(SimpleMailMessageUtils.toHtmlMsg(msg, from));
        // 处理邮件发送结果
        token.addResponder(new IResponder() {
            public void onFault(Exception fault) {
                LogFactory.LOGGER_FRAMEWORK.info("[ERROR] mail send fail,cause:" + fault);
            }
            
            public void onResult(Object result) {
                LogFactory.LOGGER_FRAMEWORK.info("[INFO] mail send success");
            }
        });
        try {
            token.waitForResult();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public SimpleMailMessage createMail(final String title,
                                        final String template,
                                        final MailModel mailModel,
                                        final String... sendTo) {
        SimpleMailMessage msg = newSimpleMsgFromTemplate(title);
        msg.setTo(sendTo);
        String text = processTemplate(template, mailModel);
        msg.setText(text);
        return msg;
    }
}
