package com.uk.sec.framework.extremeImpl;

import javax.servlet.http.HttpServletRequest;

import org.extremecomponents.table.context.Context;
import org.extremecomponents.table.context.HttpServletRequestContext;
import org.extremecomponents.table.core.TableConstants;
import org.extremecomponents.table.limit.Limit;
import org.extremecomponents.table.limit.LimitFactory;
import org.extremecomponents.table.limit.TableLimit;
import org.extremecomponents.table.limit.TableLimitFactory;

public class SecExtremeTablePage {
    private final static String STATE = "notifyToPersist";
    
    static public Limit getLimit(HttpServletRequest request, int totalRows, int defautPageSize, String tableId) {
        Context context = new HttpServletRequestContext(request);
        LimitFactory limitFactory = null;
        if (tableId == null) {
            limitFactory = new TableLimitFactory(context, TableConstants.EXTREME_COMPONENTS, STATE, null);
        } else {
            limitFactory = new TableLimitFactory(context, tableId, STATE, null);
        }
        TableLimit limit = new TableLimit(limitFactory);
        limit.setRowAttributes(totalRows, defautPageSize);
        return limit;
    }
    
    // static public Limit getLimit(HttpServletRequest request, int
    // defautPageSize) {
    // return getLimit(request, Integer.MAX_VALUE, defautPageSize, null);
    // }
    //    
    // static public Limit getLimit(HttpServletRequest request, int totalRows,
    // int defautPageSize) {
    // return getLimit(request, totalRows, defautPageSize, null);
    // }
    
    // static public Limit getLimit(HttpServletRequest request, int totalRows,
    // int defautPageSize, String tableId) {
    // Context context = new HttpServletRequestContext(request);
    // LimitFactory limitFactory = null;
    // if (tableId == null) {
    // limitFactory = new TableLimitFactory(context);
    // } else {
    // limitFactory = new TableLimitFactory(context, tableId);
    // }
    // TableLimit limit = new TableLimit(limitFactory);
    // limit.setRowAttributes(totalRows, defautPageSize);
    // return limit;
    // }
}
