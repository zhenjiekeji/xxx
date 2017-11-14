package com.uk.sec.framework.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;

import com.uk.sec.framework.log.LogFactory;
import com.uk.sec.framework.security.action.UserView;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author xzw
 */
@SuppressWarnings("unchecked")
public abstract class BaseManager<E, PK extends Serializable> {
    protected final Logger logger = LogFactory.LOGGER_SERVICE;
    
    protected abstract EntityDao getEntityDao();
    
    public E getById(PK id) {
        return (E) this.getEntityDao().getById(id);
    }
    
    public E loadById(PK id) {
        return (E) this.getEntityDao().loadById(id);
    }
    
    public List<E> findAll() {
        return this.getEntityDao().findAll();
    }
    
    public void saveOrUpdate(E entity) {
        this.getEntityDao().saveOrUpdate(entity);
    }
    
    public void save(E entity) {
        this.getEntityDao().save(entity);
    }
    
    public void removeById(PK id) {
        this.getEntityDao().deleteById(id);
    }
    
    public void removeById(PK[] ids) {
        for (PK id : ids) {
            this.removeById(id);
        }
    }
    
    public void update(E entity) {
        this.getEntityDao().update(entity);
    }
    
    public boolean isUnique(E entity, String uniquePropertyNames) {
        return this.getEntityDao().isUnique(entity, uniquePropertyNames);
    }
    
    public List<E> findAllBy(final String propertyName, final Object value) {
        return this.getEntityDao().findAllBy(propertyName, value);
    }
    
    public List<E> findAllBy(final Map paraMap) {
        return this.getEntityDao().findAllBy(paraMap);
    }
    public List<E> findAll(E e) {
        return this.getEntityDao().findAll(e);
    }
    
    public List<E> findAll(String sql, HashMap paraMap) {
        return this.getEntityDao().findAll(sql, paraMap);
    }
    
    public List<E> findAll(String sql) {
        return this.getEntityDao().findAll(sql);
    }
    
    public E findByProperty(final String propertyName, final Object value) {
        return (E) this.getEntityDao().findByProperty(propertyName, value);
    }
    
    public Page findByPageRequest(PageRequest request) {
        return null;
    }
    
    /**
     * 获得session中的登录信息
     * 
     * @return
     */
    public UserView<String> getUserView() {
        UserView<String> userView = (UserView<String>) ServletActionContext.getRequest()
                                                                           .getSession()
                                                                           .getAttribute(UserView.SESSION_USER_VIEW);
        
        return userView;
    }
    
    /**
     * 把UserView对象放入session中.
     * 
     * @param userView
     */
    public void setUserView(UserView<Long> userView) {
        ServletActionContext.getRequest().getSession().setAttribute(UserView.SESSION_USER_VIEW, userView);
    }
    
    /**
     * 获得登录的用户ID.
     * 
     * @return
     */
    public String getLoginId() {
        return this.getUserView().getLoginId();
    }
    
    /**
     * 获得登录的用户名.
     * 
     * @return
     */
    public String getLoginName() {
        return this.getUserView().getLoginName();
    }
    
    /**
     * 获得登录的用户的显示名.
     * 
     * @return
     */
    public String getLoginDisplayName() {
        return this.getUserView().getLoginDisplayName();
    }
    
    private MessageSource messageSource;
    
    /**
     * @return the messageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }
    
    /**
     * @param messageSource
     *            the messageSource to set
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    public String getMessages(String key) {
        return this.getMessages(key, new String[0]);
    }
    
    public String getMessages(String key, String[] args) {
        return this.messageSource.getMessage(key, args, Locale.SIMPLIFIED_CHINESE);
    }
}
