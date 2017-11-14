/*
 * Copyright (c) 2010 , All Rights Reserved. Project: limulus Version : 1.0
 * Create Date: 2010/5/4 7:20 Description:
 */

package com.uk.sec.framework.extremeImpl;

import java.util.ArrayList;
import java.util.List;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.slf4j.Logger;
import org.springframework.web.context.ContextLoader;

import com.uk.sec.framework.ectable.model.EctableColumn;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;
import com.uk.sec.framework.ectable.service.EctableColumnDetailManager;
import com.uk.sec.framework.ectable.service.EctableColumnManager;
import com.uk.sec.framework.log.LogFactory;
import com.uk.sec.framework.security.action.UserView;


/**
 * User: Nick Date: 2010-4-30 Time: 23:52:27
 */
public class ColSortXlsView extends SecXlsView {
    
    private static Logger logger = LogFactory.LOGGER_FRAMEWORK;
    /**
     * 排序前的最后一列列名.
     */
    private String        lastColumnName;
    /**
     * 是否经过重排序.
     */
    private boolean       sorted = true;                        ;
    
    @Override
    public void beforeBody(TableModel model) {
        ColSortHtmlView.sortColumns(model, EctableColumnDetail.VIEW_XLS);
        super.beforeBody(model);
    }
    
    @Override
    public void body(TableModel model, Column column) {
        if (sorted) {
            if (lastColumnName.equals(column.getTitle())) {
                List<Column> list = model.getColumnHandler().getColumns();
                for (Column sortColumn : list) {
                    super.body(model, sortColumn);
                }
            }
        } else {
            super.body(model, column);
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
    public void sortColumns(TableModel model, String viewType) {
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
            lastColumnName = columns.get(columns.size() - 1).getTitle();
            List<Column> temp = new ArrayList<Column>();
            temp.addAll(columns);
            columns.clear();
            
            // 依据排序清单的列名匹配顺序后加入列对象。
            // String columnName = null;
            // for (Object obj : ecds) {
            // columnName = ((EctableColumnDetail) obj).getColumnName();
            // // 获取第一个与最后一个之间的列，匹配顺序定义。
            // for (int i = 0; i < temp.size(); i++) {
            // if (columnName.equals(temp.get(i).getProperty())) {
            // columns.add(temp.get(i));
            // temp.remove(i);
            // break;
            // }
            // }
            // }
            
            // 依据排序清单的列名匹配顺序后加入列对象。
            for (int i = 0; i < ecds.size(); i++) {
                EctableColumnDetail e = ecds.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    Column c = temp.get(j);
                    if (e.getColumnName().equals(c.getProperty())) {
                        temp.remove(j);
                        // c.setFirstColumn(false);
                        // c.setLastColumn(false);
                        columns.add(c);
                        break;
                    }
                }
            }
            
            columns.addAll(temp);
            
            // // 补充排序清单中未定义的列
            // for (int i = 0; i < temp.size(); i++) {
            // log.info("viewType='" + viewType + "' ,table ='" + tableId + "'
            // ,column ='" + temp.get(i).getAlias()
            // + "'is undefined in ectable_column_detail");
            // if (temp.get(i).getProperty().equals("endColumn")) {
            // columns.add(temp.get(i));
            // // } else {
            // // columns.add(temp.get(i));
            // }
            // }
            //            
            // // columns.add(new Column(model));
            // // 最后一列 为操作按钮时特殊处理
            // if ("endColumn".equals(lastColumn.getProperty())) {
            // columns.add(lastColumn);
            // }
            // 修正第一列与最后一列标记
            for (Object obj : columns) {
                ((Column) obj).setFirstColumn(false);
                ((Column) obj).setLastColumn(false);
            }
            columns.get(0).setFirstColumn(true);
            columns.get(columns.size() - 1).setLastColumn(true);
            
        } else {
            sorted = false;
            logger.info("viewType='" + viewType + "' ,table ='" + tableId + "' is undefined in  ectable_column ");
        }
    }
}
