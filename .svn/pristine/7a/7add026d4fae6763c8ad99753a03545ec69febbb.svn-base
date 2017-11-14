<%@page import="com.uk.sec.framework.system.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecSysSeqrule.TABLE_ALIAS%> 维护</title>
    <link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet" />
</rapid:override>
<rapid:override name="container">
    <div class="positionPanel">
        <em></em>当前位置>><%=SecSysSeqrule.TABLE_ALIAS%> 维护
    </div>
    <div class="queryPanel">
        <form action="<c:url value="/framework/system/SecSysSeqrule/list.do"/>" method="post">
        <div class="queryPanelHead">搜索</div>
        <div class="queryPanelBody">
            <table class="queryTable" cellpadding="0" cellspacing="0">
                <tr>
                    <td class="tdLabel">
                        <%=SecSysSeqrule.ALIAS_RULE_CNAME%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.ruleCname}"  name="s_ruleCname"  />
                    </td>
                    <td class="tdLabel">
                        <%=SecSysSeqrule.ALIAS_RULE_ENAME%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.ruleEname}"  name="s_ruleEname"  />
                    </td><%--
                    <td class="tdLabel">
                        <%=SecSysSeqrule.ALIAS_SEQ_LENGTH%>
                    </td>
                    
                    <td>
                        <input value="${pageRequest.filters.seqLength}"  name="s_seqLength"  />
                    </td>
                    <td class="tdLabel">
                        <%=SecSysSeqrule.ALIAS_SEQ_STARTVALUE%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.seqStartvalue}"  name="s_seqStartvalue"  />
                    </td>
                    <td class="tdLabel">
                        <%=SecSysSeqrule.ALIAS_SEQ_STEP%>
                    </td>
                    <td>
                        <input value="${pageRequest.filters.seqStep}"  name="s_seqStep"  />
                    </td>
                --%></tr>
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
        <form action="<c:url value="/framework/system/SecSysSeqrule/create.do"/>" method="post">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <input type="submit" class="createBtn" value="新增" />
                    <input type="button" class="deleteBtn" value="删除" onclick="batchDelete('${ctx}/framework/system/SecSysSeqrule/delete.do','items',document.forms.SecSysSeqrule_list)" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div class="dataGridPanel">
    <ec:table items="page.result" var="item" state="notifyToPersist"
    retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
    action="${ctx}/framework/system/SecSysSeqrule/list.do" tableId="SecSysSeqrule_list">
        <ec:exportXls fileName="export.xls" tooltip="导出"/>
        <ec:row>
            <ec:column headerCell="selectAll" style="text-align:center;" width="35" viewsAllowed="html" property="items" >
                <input type="checkbox" name="items" onclick="javascript:clickCurrentCheck(this,event);" value="ruleId=${item.ruleId}&" />
            </ec:column>
            <ec:column alias="secSysSeqrule_ruleCname" property="ruleCname"  title="<%=SecSysSeqrule.ALIAS_RULE_CNAME%>"/>
            <ec:column alias="secSysSeqrule_ruleEname" property="ruleEname"  title="<%=SecSysSeqrule.ALIAS_RULE_ENAME%>"/>
            <ec:column alias="secSysSeqrule_seqLength" property="seqLength"  title="<%=SecSysSeqrule.ALIAS_SEQ_LENGTH%>"/>
            <ec:column alias="secSysSeqrule_seqStartvalue" property="seqStartvalue"  title="<%=SecSysSeqrule.ALIAS_SEQ_STARTVALUE%>"/>
            <ec:column alias="secSysSeqrule_seqStep" property="seqStep"  title="<%=SecSysSeqrule.ALIAS_SEQ_STEP%>"/>
            <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
                <a href="${ctx}/framework/system/SecSysSeqrule/show.do?ruleId=${item.ruleId}&" class="btn_grid_link_show"><em></em>查看</a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/framework/system/SecSysSeqrule/edit.do?ruleId=${item.ruleId}&" class="btn_grid_link_edit"><em></em>修改</a>&nbsp;&nbsp;&nbsp;
                <a href="${ctx}/framework/system/SecSysSeqrule/deleteById.do?ruleId=${item.ruleId}&" class="btn_grid_link_deleteRow" onclick="return deleteConfirm();"><em></em>删除</a>
            </ec:column>
        </ec:row>
    </ec:table>
    </div>

</rapid:override>


<%@ include file="/base.jsp"  %>