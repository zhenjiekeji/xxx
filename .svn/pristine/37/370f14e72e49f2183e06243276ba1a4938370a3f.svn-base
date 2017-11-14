/*
 * Copyright (c) 2010 , All Rights Reserved. Project: limulus Version : 1.0
 * Create Date: 2010/5/2 0:48 Description:
 */

package com.uk.sec.framework.extremeImpl;

import java.util.List;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.PdfView;

import com.uk.sec.framework.ectable.model.EctableColumnDetail;


/**
 * User: Nick Date: 2010-4-30 Time: 23:52:27
 */
public class ColSortPdfView extends PdfView {
    @Override
    public void beforeBody(TableModel model) {
        ColSortHtmlView.sortColumns(model, EctableColumnDetail.VIEW_PDF);
        super.beforeBody(model);
    }
    
    @Override
    public void body(TableModel model, Column column) {
        if (column.isLastColumn()) {
            List<Column> list = model.getColumnHandler().getColumns();
            for (Column sortColumn : list) {
                super.body(model, sortColumn);
            }
        }
    }
    
}
