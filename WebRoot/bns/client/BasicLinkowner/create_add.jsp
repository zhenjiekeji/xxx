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
				<td height="40" colspan="4" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>路段信息<em>1</em></strong></td>
				<td height="40" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA;"
					class="add_opt">
					<div class="demand_add">
						<span style="cursor: pointer;" class="add_jcxx" title="添加本组信息"><img
							src="images/add.gif" /> 增加本组信息</span>&nbsp;&nbsp;
					</div>
					<div class="demand_del" style="display: none">
						<span style="cursor: pointer" class="add_jcxx" title="删除本组信息"><a
							href="javascript:void(0);" style=""><img
								src="images/remmod.gif"> 删除本组信息</a></span>
					</div>
				</td>
				<td style="border-bottom: 1px solid #BFC2CA;" align="center">
									<div>
							<span style="cursor: pointer" title="保存" id="saveSection"><img
					src="images/filesave.png" /> 保存</span>
					</div>
				</td>
			</tr>
 			<s:if test="basicSections.size != 0">
			<s:iterator value="basicSections">
			<input type="hidden" name="basicSectionPkIdlistnum" id="basicSectionPkIdlistnum" value="<s:property value="pkId" />">				
			<tr>
				<td align="right" width="150" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费路段名称：</td>
				<td height="25" width="150" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<s:property value="seName" />
				</td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span class="red">*</span>起始计费位置桩号：</td>
				<td height="25" width="120" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
					<s:property value="seStartstakenum" /></td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span class="red">*</span>终止计费位置桩号：</td>
				<td height="25" width="80" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px"><s:property value="seEndstakenum" /></td>
			</tr>
     		</s:iterator>
     		</s:if>
			　　 <s:else>			
			<tr>
				<td align="right" width="150" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费路段名称：</td>
				<td height="25" width="150" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px; border-right: 1px solid #BFC2CA">
					<input name="basicSections[listnum].trName" id="basicSections[listnum].trName" value="<s:property value="trName" />" class="shuru" type="text" size="20" /><label
									class="red" id="trName_error"><s:fielderror>
											<s:param>trName</s:param>
										</s:fielderror></label>
				</td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>起始计费位置桩号：</td>
				<td height="25" width="120" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px; border-right: 1px solid #BFC2CA"><input
					name="basicSections[listnum].seStartstakenum" id="basicSections[listnum].seStartstakenum" value="<s:property value="seStartstakenum" />" class="shuru" type="text" size="15" /><label
									class="red" id="seStartstakenum_error"><s:fielderror>
											<s:param>seStartstakenum</s:param>
										</s:fielderror></label></td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>终止计费位置桩号：</td>
				<td height="25" width="80" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px;"><input
					name="basicSections[listnum].seEndstakenum" id="basicSections[listnum].seEndstakenum" value="<s:property value="seEndstakenum" />" class="shuru" type="text" size="15" /><label
									class="red" id="seEndstakenum_error"><s:fielderror>
											<s:param>seEndstakenum</s:param>
										</s:fielderror></label></td>
			</tr>
			  </s:else>
		</table>
	</dl>
</div>
<div id="demandNew">
	<dl class="demand_dl" style="display: none" id="demandNUMBERID">
		<table width="940" border="0" align="center" cellpadding="0"
			cellspacing="0"
			style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px">
			<tr>
				<td height="40" colspan="4" align="left" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
					class="numbers"><strong>路段信息<em>1</em></strong></td>
				<td height="40" align="right" bgcolor="#FFFFFF"
					style="border-bottom: 1px solid #BFC2CA;"
					class="add_opt">
					<div class="demand_add">
						<span style="cursor: pointer;" class="add_jcxx" title="添加本组信息"><img
							src="images/add.gif" /> 增加本组信息</span>&nbsp;&nbsp;
					</div>
					<div class="demand_del" style="display: none">
						<span style="cursor: pointer" class="add_jcxx" title="删除本组信息"><a
							href="javascript:void(0);" style=""><img
								src="images/remmod.gif"> 删除本组信息</a></span>
					</div>
				</td>
				<td style="border-bottom: 1px solid #BFC2CA;" align="center">
									<div>
							<span style="cursor: pointer" title="保存" id="saveSection"><img
					src="images/filesave.png" /> 保存</span>
					</div>
				</td>
			</tr>		
			<tr>
				<td align="right" width="150" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>收费路段名称：</td>
				<td height="25" width="150" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px; border-right: 1px solid #BFC2CA">
					<input name="basicSections[listnum].trName" id="basicSections[listnum].trName" value="<s:property value="trName" />" class="shuru" type="text" size="20" /><label
									class="red" id="trName_error"><s:fielderror>
											<s:param>trName</s:param>
										</s:fielderror></label>
				</td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>起始计费位置桩号：</td>
				<td height="25" width="120" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding-left: 10px; border-right: 1px solid #BFC2CA"><input
					name="basicSections[listnum].seStartstakenum" id="basicSections[listnum].seStartstakenum" value="<s:property value="seStartstakenum" />" class="shuru" type="text" size="15" /><label
									class="red" id="seStartstakenum_error"><s:fielderror>
											<s:param>seStartstakenum</s:param>
										</s:fielderror></label></td>
				<td align="right" width="130" bgcolor="#F8F8F8"
					style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span class="red">*</span>终止计费位置桩号：</td>
				<td height="25" width="80" align="left"
					style="border-bottom: 1px solid #BFC2CA; padding: 10px;"><input
					name="basicSections[listnum].seEndstakenum" id="basicSections[listnum].seEndstakenum" value="<s:property value="seEndstakenum" />" class="shuru" type="text" size="15" /><label
									class="red" id="seEndstakenum_error"><s:fielderror>
											<s:param>seEndstakenum</s:param>
										</s:fielderror></label></td>
			</tr>
		</table>
	</dl>
</div>