package com.uk.sec.framework.extremeImpl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.util.WebUtils;

import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.exception.SecRuntimeException;

import cn.org.rapid_framework.extremecomponents.ExtremeTablePageRequestFactory;
import cn.org.rapid_framework.page.PageRequest;

/**
 * 用于分页组件覆盖的类,新的分页组件覆盖此类的newPageRequest()方法以适合不同的分页创建
 * 
 * @author xzw
 */
public class PageRequestFactory {
    
    private static Log log               = LogFactory.getLog(PageRequestFactory.class);
    
    static int         DEFAULT_PAGE_SIZE = 10;
    static int         MAX_PAGE_SIZE     = 500;
    
    static {
        log.debug("PageRequestFactory.DEFAULT_PAGE_SIZE=" + DEFAULT_PAGE_SIZE);
        log.debug("PageRequestFactory.MAX_PAGE_SIZE=" + MAX_PAGE_SIZE);
    }
    
    public static <T> PageRequest<T> newPageRequest(HttpServletRequest request,
                                                    String defaultSortColumns,
                                                    T filters,
                                                    String tableId) {
        PageRequest pr = newPageRequest(request, defaultSortColumns, DEFAULT_PAGE_SIZE, tableId);
        pr.setFilters(filters);
        return pr;
    }
    
    public static PageRequest newPageRequest(HttpServletRequest request, String defaultSortColumns, String tableId) {
        return newPageRequest(request, defaultSortColumns, DEFAULT_PAGE_SIZE, tableId);
    }
    
    public static PageRequest newPageRequest(HttpServletRequest request,
                                             String defaultSortColumns,
                                             int defaultPageSize,
                                             String tableId) {
        if ("".equals(tableId)) {
            throw new SecRuntimeException("tableId must be send");
        }
        PageRequest<Map> result = new PageRequest<Map>();
        ExtremeTablePageRequestFactory.bindPageRequest(result,
                                                       SecExtremeTablePage.getLimit(request,
                                                                                    Integer.MAX_VALUE,
                                                                                    defaultPageSize,
                                                                                    tableId),
                                                       defaultSortColumns);
        
        // PageRequest<Map> result =
        // ExtremeTablePageRequestFactory.createFromLimit(SecExtremeTablePage.getLimit(request,
        // Integer.MAX_VALUE,
        // defaultPageSize,
        // tableId),
        // defaultSortColumns);
        Map autoIncludeFilters = null;
        String stateAttrValue = request.getParameter(BaseStruts2Action.NOTIFY_ATTR);
        if ("true".equalsIgnoreCase(stateAttrValue)) {
            autoIncludeFilters = (Map) WebUtils.getSessionAttribute(request, tableId + "_autoIncludeFilters");
            if (autoIncludeFilters == null) {
                autoIncludeFilters = WebUtils.getParametersStartingWith(request, "s_");
            }
        } else {
            autoIncludeFilters = WebUtils.getParametersStartingWith(request, "s_");
        }
        WebUtils.setSessionAttribute(request, tableId + "_autoIncludeFilters", autoIncludeFilters);
        result.getFilters().putAll(autoIncludeFilters);
        
        // if (result.getPageSize() > MAX_PAGE_SIZE) {
        // result.setPageSize(MAX_PAGE_SIZE);
        // }
        return result;
    }
    
    private static String getTableId(HttpServletRequest request) {
        return request.getParameter("ec_i");
    }
}
