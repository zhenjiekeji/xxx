/*
 * Copyright (c) 2010 , All Rights Reserved. Project: limulus Version : 1.0
 * Create Date: 2010/4/30 11:52 Description:
 */

package com.uk.sec.framework.extremeImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.UserCompactView;
import org.springframework.web.context.ContextLoader;

import com.uk.sec.framework.ectable.model.EctableColumn;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;
import com.uk.sec.framework.ectable.service.EctableColumnDetailManager;
import com.uk.sec.framework.ectable.service.EctableColumnManager;
import com.uk.sec.framework.security.action.UserView;


/**
 * User: Nick Date: 2010-4-30 Time: 23:52:27 功能描述：扩展了框架的
 * UserCompactView定义，在原有基础上提供了列排顺序自定义功能能。
 * 功能实现：1.在表ectable_column和ectable_column_detail中定义列表中除第一列（数据选择列）和最后一列（数据操作列）之外的其它列的显示顺序，
 * 2.此定义与用户ID绑定，提供特定用户的显示定制。对与未设置定制的数据用户，使用默认排序，默认排序的user_id为0.
 * 3.如定义列少于页面中的实际列，多余的列自动显示于定义列的后边。
 */
public class ColSortHtmlView extends UserCompactView {
    protected static Log log = LogFactory.getLog(ColSortHtmlView.class);
    
    /**
     * 依据当前用户ID和tableId获取显示定义，并依据显示定义输出列表表头信息 如当前用户没有自定义显示项目，使用默认值。
     * 
     * @param model
     *            TableModel
     */
    @Override
    protected void beforeBodyInternal(TableModel model) {
        sortColumns(model, EctableColumnDetail.VIEW_HTML);
        super.beforeBodyInternal(model);
    }
    
    /**
     * 依据当前用户ID和tableId获取显示定义，并依据显示定义输出列表属性项目 如当前用户没有自定义显示项目，使用默认值。
     * 
     * @param model
     * @param column
     */
    @Override
    public void body(TableModel model, Column column) {
        if (column.isLastColumn()) {
            List<Column> list = model.getColumnHandler().getColumns();
            for (Column myColumn : list) {
                super.body(model, myColumn);
            }
        }
    }
    
    /**
     * 依据当前用户ID和tableId获取显示定义，并依据显示定义输出列表表头信息 如当前用户没有自定义显示项目，使用默认值。
     * 
     * @param model
     *            TableModel
     * @param viewType
     *            视图类型,参考EctableColumnDetail定义
     */
    // TODO ectable导出 需要更改userId默认值
    public static void sortColumns(TableModel model, String viewType) {
        String tableId = model.getTableHandler().getTable().getTableId();
        
        EctableColumnDetailManager ecdm = ContextLoader.getCurrentWebApplicationContext()
                                                       .getBean(EctableColumnDetailManager.class);
        EctableColumnManager ecm = ContextLoader.getCurrentWebApplicationContext().getBean(EctableColumnManager.class);
        EctableColumn ec = ecm.findByUniqueName(tableId);
        if (ec != null) {
            String userId = "1";
            UserView<String> userView = (UserView<String>) model.getContext()
                                                                .getSessionAttribute(UserView.SESSION_USER_VIEW);
            if (userView != null) {
                userId = userView.getLoginId();
            }
            List<EctableColumnDetail> ecds = ecdm.findByUserIdAndViewType(ec.getId(), userId, viewType);
            List<Column> columns = model.getColumnHandler().getColumns();
            List<Column> temp = new ArrayList<Column>();
            temp.addAll(columns);
            columns.clear();
            
            // 依据排序清单的列名匹配顺序后加入列对象。
            for (int i = 0; i < ecds.size(); i++) {
                EctableColumnDetail e = ecds.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    Column c = temp.get(j);
                    c.setFirstColumn(false);
                    c.setLastColumn(false);
                    if (e.getColumnName().equals(c.getProperty())) {
                        temp.remove(j);
                        columns.add(c);
                        break;
                    }
                }
            }
            
            columns.addAll(temp);
            
            // 修正第一列与最后一列标记
            columns.get(0).setFirstColumn(true);
            columns.get(columns.size() - 1).setLastColumn(true);
        } else {
            log.info("viewType='" + viewType + "' ,table ='" + tableId + "' is undefined in  ectable_column ");
        }
    }
}
