<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>



<div class="tab_tops">
	<form id="fenpei" name="fenpei" action="${ctx }/bns/client/UkClientInfo/fenPeiSave.do"  method="post" >
		<table width="940" border="0" align="center" cellpadding="0" cellspacing="0" style="border:1px solid #BFC2CA;border-top:none;font-family:微软雅黑;font-size:14px">
			<tr>
				<td width="266" height="40" align="left" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA;padding-left:10px"><strong>项目名称</strong></td>
				<td width="131" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA;padding-left:10px"><strong>所属公司</strong></td>
				<td width="96" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA;padding-left:10px"><strong>签约人</strong></td>
				<td width="134" align="center" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA;padding-left:10px"><strong>区域</strong></td>
				<td width="93" align="center" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA"><strong>签约时间</strong></td>
				<td width="179" align="center" valign="middle" bgcolor="#F8F8F8" style="border-top:1px solid #BFC2CA"><strong>操作</strong></td>
			</tr>
			
			<s:if test="#request.totalRows > 0">
			<s:iterator value="#request.page.result" id="project" status="status">
			<tr>
				<td height="40" valign="middle" style="border-top:1px solid #BFC2CA;padding-left:10px">${project.name }</td>
				<td valign="middle" style="border-top:1px solid #BFC2CA;padding-left:10px">${project.companyid }</td>
				<td valign="middle" style="border-top:1px solid #BFC2CA;padding-left:10px">
				<s:if
					test="#project.orders!=null && #project.orders.size()>0">
					<s:property value="#project.orders[0].signatory" />
				</s:if>
				</td>
				<td valign="middle" style="border-top:1px solid #BFC2CA;padding-left:10px">${merchantprovince}${merchantcity}${merchantdistrict }</td>
				<td align="center" valign="middle" style="border-top:1px solid #BFC2CA;">
				<s:if
					test="#project.orders!=null && #project.orders.size()>0">
					<s:property value="#project.orders[0].signdate" />
				</s:if>
				</td>
				<td align="center" valign="middle" style="border-top:1px solid #BFC2CA;">
					<select name="zsId">
						<option value="">选择招商员</option>
						<s:iterator value="secPrivilegeUsers">
							<option value="${project.projectid }#||#${loginId}#||#${groupId}">${userName }</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			</s:iterator>
			<input type="hidden" name="clientIdArray" value="<s:property value="@com.uk.sec.bns.client.util.MyUtils@ttt(clientId, 3, 35)"/>" />
			
			<%-- <s:iterator value="#parameters.clientId" id="y" >
				<input type="hidden" name="clientIdArray" value="${x.substring(3, 35) }" />
			</s:iterator> --%>
			</s:if>	
		</table>
	</form>
</div>