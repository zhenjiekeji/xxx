<%@page import="com.uk.sec.framework.system.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<rapid:override name="head">
    <title><%=SecSysSeqrule.TABLE_ALIAS%>查询</title>
</rapid:override>
<rapid:override name="container">
	<div class="positionPanel">
		<em></em>当前位置>><%=SecSysSeqrule.TABLE_ALIAS%>查询<a href="javascript:void(0)" onclick="window.history.go(-1)" class="back"></a>
	</div>
	<div class="formPanel">
		<form action="${ctx}/framework/system/SecSysSeqrule/list.do" method="post">
		<div class="formPanelHead">
			<ul>
				<li>查询</li>
			</ul>
		</div>
		<div class="formPanelBody">
			<table class="formTable" cellpadding="0" cellspacing="0">
        		<tr>
           			<td class="tdLabel"><%=SecSysSeqrule.ALIAS_RULE_CNAME%>：</td>
           			<td>
                		<input  type="text" name="s_ruleCname" size="30" maxlength="100" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecSysSeqrule.ALIAS_RULE_ENAME%>：</td>
           			<td>
                		<input  type="text" name="s_ruleEname" size="30" maxlength="100" class=""/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_LENGTH%>：</td>
           			<td>
                		<input  type="text" name="s_seqLength" size="30" maxlength="30" class="validate-number "/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_STARTVALUE%>：</td>
           			<td>
                		<input  type="text" name="s_seqStartvalue" size="30" maxlength="10" class="validate-integer "/>
           			</td>
        		</tr>
        		<tr>
           			<td class="tdLabel"><%=SecSysSeqrule.ALIAS_SEQ_STEP%>：</td>
           			<td>
                		<input  type="text" name="s_seqStep" size="30" maxlength="10" class="validate-integer "/>
           			</td>
        		</tr>
    		</table>
    	</div>
    	<div class="formPanelFoot">
    		<table cellpadding="0" cellspacing="0">
    			<tr>
    				<td>
    					<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
    					<input type="button" value="返回列表" onclick="window.location='${ctx}/framework/system/SecSysSeqrule/list.do'"/>
    					<input type="button" value="后退" onclick="history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</div>
		</form>
	</div>
</rapid:override>
<%@ include file="/base.jsp"  %>