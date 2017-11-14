<%@page import="com.uk.sec.framework.system.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecSysRulevalue.TABLE_ALIAS%>信息</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecSysRulevalue.TABLE_ALIAS%>信息<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/system/SecSysRulevalue/list.do" method="post" theme="simple">
		<div class="formPanelHead">
			<ul>
				<li>信息</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
            		<td class="tdLabel"><%=SecSysRulevalue.ALIAS_RULE_KEYVALUE%>：</td>
            		<td><s:property value="%{model.ruleKeyvalue}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysRulevalue.ALIAS_SEQ_CURRENTVALUE%>：</td>
            		<td><s:property value="%{model.seqCurrentvalue}" /></td>
        		</tr>
        		<tr>
            		<td class="tdLabel"><%=SecSysRulevalue.ALIAS_RULE_ID%>：</td>
            		<td><s:property value="%{model.ruleId}" /></td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/system/SecSysRulevalue/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
   			<s:hidden name="id" id="id" value="%{model.id}"/>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>