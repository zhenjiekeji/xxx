<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2010-12-19
  Time: 11:07:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<script type="text/javascript">
    $(function () {
        /** 动态表格列的窗口 **/
        $("#dialog-form").dialog({
            autoOpen: false,
            height: 350,
            width: 250,
            modal: true,
            buttons: {
                '确定': function() {
                    $("#propSelectMenu li [name='orderNums']").each(function (i) {
                        $(this).val("order=" + parseInt(i + 1));
                    });
                    var contentDIV = $("#contentDIV").val();
                    if (contentDIV != "") {
                        $("#editcolumn").submit();
                    } else {
                        var options = { beforeSubmit: function(formData, jqForm) {
                            $.param(formData);
                            return true;
                        } ,
                            success: function(responseText) {
                                $('#contentDiv').html(responseText);
                            } };
                        $('#editcolumn').ajaxSubmit(options);
                        $(this).dialog('close');
                        refresh();
                    }
                },
                '取消': function() {
                    $(this).dialog('close');
                }
            }
        });

        //点击打开模式窗口
        $('#edit-column').live("click", function() {
            $('#dialog-form').dialog('open');
            $.get("${ctx}/framework/ectable/EctableColumnDetail/generateEcList.do?tableId=${param.tableId}", function (data) {

                $("#ec_column_dialog").html(data);
            });
        });

        //选中改变颜色
        $("#propSelectMenu li").live("click", function () {
            $("#propSelectMenu li").css("background", "");
            $(this).css("background", "#ccc");
            window.$activeOption = this;
        });
        //置顶
        $("#moveTop").live("click", function () {
            if ($activeOption) {
                var current = $($activeOption);
                var parent = current.parent();
                current.detach();
                parent.prepend(current);
            }
        });
        //上移
        $("#moveUp").live("click", function () {
            if ($activeOption) {
                var current = $($activeOption);
                var prev = current.prev();
                current.insertBefore(prev);
            }
        });
        //下移
        $("#moveDown").live("click", function() {
            if ($activeOption) {
                var current = $($activeOption);
                var next = current.next();
                current.insertAfter(next);
            }
        });
        //置底
        $("#moveBottom").live("click", function () {
            if ($activeOption) {
                var current = $($activeOption);
                var parent = current.parent();
                current.detach();
                parent.append(current);
            }
        });

    });
</script>
<div id="dialog-form" title="列">
    <form action="${ctx}/framework/ectable/EctableColumnDetail/batchUpdate.do" method="post" class="queryForm"
          id="editcolumn" theme="simple">
        <input type="hidden" id="contentDiv" value="${param.contentDIV}"/>
        <input type="hidden" id="action" name="action" value="${param.action}"/>

        <div class="clearfix" id="ec_column_dialog">
            <img src="${ctx }\scripts\jquery\base\images\ui-anim_basic_16x16.gif" alt="" border="0"/>
        </div>
    </form>
</div>