/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author xzw
 * @since 1.0
 * @version 1.0
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {
    
    private Map<String, String[]> sanitized;
    private Map<String, String[]> orig;
    
    @SuppressWarnings("unchecked")
    public XssRequestWrapper(HttpServletRequest req) {
        super(req);
        orig = req.getParameterMap();
        sanitized = getParameterMap();
    }
    
    @Override
    public String getParameter(String name) {
        String[] vals = getParameterMap().get(name);
        if (vals != null && vals.length > 0) {
            return vals[0];
        } else {
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String[]> getParameterMap() {
        if (sanitized == null) {
            sanitized = sanitizeParamMap(orig);
        }
        return sanitized;
        
    }
    
    @Override
    public String[] getParameterValues(String name) {
        return getParameterMap().get(name);
    }
    
    private Map<String, String[]> sanitizeParamMap(Map<String, String[]> raw) {
        Map<String, String[]> res = new HashMap<String, String[]>();
        if (raw == null) {
            return res;
        }
        
        for (String key : raw.keySet()) {
            String[] rawVals = raw.get(key);
            String[] snzVals = new String[rawVals.length];
            for (int i = 0; i < rawVals.length; i++) {
                HTMLInputFilter filter = new HTMLInputFilter();
                snzVals[i] = filter.filter(rawVals[i]);
            }
            res.put(key, snzVals);
        }
        return res;
    }
}
