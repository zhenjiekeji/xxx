<%@page import="com.uk.sec.framework.system.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecSysRulevalue.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
</rapid:override>
<rapid:override name="container">
    <div class="positionPanel">
        <em></em>当前位置>><%=SecSysRulevalue.TABLE_ALIAS%> 维护
    </div>
    <div class="queryPanel">
        <form action="<c:url value="/framework/system/SecSysRulevalue/list.do"/>" method="post">
        <div class="queryPanelHead">搜索</div>
        <div class="queryPanelBody">
            <table class="queryTable" cellpadding="0" cellspacing="0">
                <tr>
                    <td class="tdLabel">
                        <%=SecSysRulevalue.ALIAS_RULE_KEYVALUE%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.ruleKeyvalue}"  name="s_ruleKeyvalue"  />
                    </td>
                    <td class="tdLabel">
                        <%=SecSysRulevalue.ALIAS_SEQ_CURRENTVALUE%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.seqCurrentvalue}"  name="s_seqCurrentvalue"  />
                    </td>
                    <td class="tdLabel">
                        <%=SecSysRulevalue.ALIAS_RULE_ID%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.ruleId}"  name="s_ruleId"  />
                    </td>
                </tr>
            </table>
        </div>
        <div class="queryPanelFoot">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <input type="submit" class="queryBtn" value="查询" />
                    <input type="reset" class="clearBtn" value="重置" />
                </td>
            </tr>
        </table>
        </div>
        </form>
    </div>
    <div class="toolbarPanel">
        <form action="<c:url value="/framework/system/SecSysRulevalue/create.do"/>" method="post">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <input type="submit" class="createBtn" value="新增" />
                    <input type="button" class="deleteBtn" value="删除" onclick="batchDelete('${ctx}/framework/system/SecSysRulevalue/delete.do','items',document.forms.SecSysRulevalue_list)" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div class="dataGridPanel">
    <ec:table items="SecSysRulevalue_list_page.result" var="item" state="notifyToPersist"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/system/SecSysRulevalue/list.do" tableId="SecSysRulevalue_list">
        <ec:exportXls fileName="export.xls" tooltip="导出"/>
        <ec:row>
            <ec:column headerCell="selectAll" style="text-align:center;" width="35" viewsAllowed="html" property="items" >
                <input type="checkbox" name="items" onclick="javascript:clickCurrentCheck(this,event);" value="id=${item.id}&" />
            </ec:column>
            <ec:column alias="secSysRulevalue_ruleKeyvalue" property="ruleKeyvalue"  title="<%=SecSysRulevalue.ALIAS_RULE_KEYVALUE%>"/>
            <ec:column alias="secSysRulevalue_seqCurrentvalue" property="seqCurrentvalue"  title="<%=SecSysRulevalue.ALIAS_SEQ_CURRENTVALUE%>"/>
            <ec:column alias="secSysRulevalue_ruleId" property="ruleId"  title="<%=SecSysRulevalue.ALIAS_RULE_ID%>"/>
            <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
                <a href="${ctx}/framework/system/SecSysRulevalue/show.do?id=${item.id}&" class="btn_grid_link_show"><em></em>查看</a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/framework/system/SecSysRulevalue/edit.do?id=${item.id}&" class="btn_grid_link_edit"><em></em>修改</a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/framework/system/SecSysRulevalue/deleteById.do?id=${item.id}&" class="btn_grid_link_deleteRow" onclick="return deleteConfirm();"><em></em>删除</a>
            </ec:column>
        </ec:row>
    </ec:table>
    </div>

</rapid:override>


<%@ include file="/base.jsp"  %>