<%@page import="com.uk.sec.framework.system.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecSysSeqrule.TABLE_ALIAS%>信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecSysSeqrule.TABLE_ALIAS%>信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/system/SecSysSeqrule/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel"><%=SecSysSeqrule.ALIAS_RULE_CNAME%>：</td>
            		<td><s:property value="%{model.ruleCname}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysSeqrule.ALIAS_RULE_ENAME%>：</td>
            		<td><s:property value="%{model.ruleEname}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_LENGTH%>：</td>
            		<td><s:property value="%{model.seqLength}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_STARTVALUE%>：</td>
            		<td><s:property value="%{model.seqStartvalue}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_STEP%>：</td>
            		<td><s:property value="%{model.seqStep}" /></td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/system/SecSysSeqrule/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="ruleId" id="ruleId" value="%{model.ruleId}"/>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>