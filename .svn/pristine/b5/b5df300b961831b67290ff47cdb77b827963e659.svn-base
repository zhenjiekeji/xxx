<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.uk.sec.bns.client.model.*"%>
<%@ include file="/commons/taglibs.jsp"%>
<!-- 查看资料 -->
<div id="myModal" class="reveal-modal examine"></div>

<div id="demand">
	<dl class="demand_dl" style="display: none" id="demandNUMBERID">
		<table width="940" border="0" align="center" cellpadding="0"
			cellspacing="0"
			style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px">
			<tr>
				<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>收费车道信息<em>1</em></strong></td>
				<td height="40" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px" class="add_opt">
					<div class="demand_add">
						<span style="cursor: pointer" class="add_jcxx" title="添加本组信息"><img
							src="images/add.gif" align="absmiddle" /> 增加本组信息</span>&nbsp;&nbsp;
					</div>
					<div class="demand_del" style="display: none">
						<span style="cursor: pointer" class="add_jcxx" title="删除本组信息"><a
							href="javascript:void(0);" style=""><img
								src="images/remmod.gif" align="absmiddle"> 删除本组信息</a></span>
					</div>
				</td>
				<td width="50px">
									<div>
							<span style="cursor: pointer" title="保存" id="savePlaza"><img
					src="images/filesave.png" align="absmiddle" /> 保存</span>
					</div>
				</td>
			</tr>
			<s:if test="basicTolllanes.size() != 0">
			<s:iterator value="basicTolllanes">
			<input type="hidden" name="basicTolllanePkIdlistnum" id="basicTolllanePkIdlistnum" value="<s:property value="pkId" />">	
			<tr>
				<td align="right" width="186" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道老编号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTolllanes[listnum].oldLanecode" id="basicTolllanes[listnum].oldLanecode" value="<s:property value="oldLanecode" />" class="shuru" type="text" size="50" /><label
									class="red" id="oldLanecode_error"><s:fielderror>
											<s:param>oldLanecode</s:param>
										</s:fielderror></label>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道顺序号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTolllanes[listnum].tlNum" id="basicTolllanes[listnum].tlNum" value="<s:property value="tlNum" />" class="shuru" type="text" size="50" /><label
									class="red" id="tlNum_error"><s:fielderror>
											<s:param>tlNum</s:param>
										</s:fielderror></label></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道类型：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px"><select
					name="basicTolllanes[listnum].tlType" id="basicTolllanes[listnum].tlType" >
						<option value="1" <s:if test="tlType==1">selected</s:if>>etc</option>
						<option value="2" <s:if test="tlType==2">selected</s:if>>mtc</option>
						<option value="3" <s:if test="tlType==3">selected</s:if>>混合</option>
				</select><label
									class="red" id="tlType_error"><s:fielderror>
											<s:param>tlType</s:param>
										</s:fielderror></label></td>
			</tr>
			</s:iterator>
     		</s:if>
     		<s:else>							
			<tr>
				<td align="right" width="186" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道老编号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<input name="basicTolllanes[listnum].oldLanecode" id="basicTolllanes[listnum].oldLanecode" value="<s:property value="oldLanecode" />" class="shuru" type="text" size="50" /><label
									class="red" id="oldLanecode_error"><s:fielderror>
											<s:param>oldLanecode</s:param>
										</s:fielderror></label>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道顺序号：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
					name="basicTolllanes[listnum].tlNum" id="basicTolllanes[listnum].tlNum" value="<s:property value="tlNum" />" class="shuru" type="text" size="50" /><label
									class="red" id="tlNum_error"><s:fielderror>
											<s:param>tlNum</s:param>
										</s:fielderror></label></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>车道类型：</td>
				<td height="40" colspan="3" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px"><select
					name="basicTolllanes[listnum].tlType" id="basicTolllanes[listnum].tlType" >
						<option value="1" <s:if test="tlType==1">selected</s:if>>etc</option>
						<option value="2" <s:if test="tlType==2">selected</s:if>>mtc</option>
						<option value="3" <s:if test="tlType==3">selected</s:if>>混合</option>
				</select><label
									class="red" id="tlType_error"><s:fielderror>
											<s:param>tlType</s:param>
										</s:fielderror></label></td>
			</tr>
     		</s:else>
		</table>
	</dl>
</div>