<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>营改增管理系统</title>
<base href="${ctx}/bns/client/" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery.inputbox.css" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="../../scripts/jquery-easyui-1.3.6/themes/default/easyui.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.inputbox.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<script type="text/javascript"
	src="../../scripts/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>

<script src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>

<body>
	<%@ include file="../head.jsp"%>

	<div class="nrv">
		<div class="nrvs">
			<%@ include file="../left.jsp"%>
			<div class="neir">
				<input type="hidden" name="menuId" id="menuId"
					value="<s:property value='menuId'/>">
					<div style="float: left">
						<form action="BasicSection/save.do" method="post" name="frm"
							id="frm">
							<input type="hidden" name="pkId" id="pkId"
								value="<s:property value='model.pkId'/>">
								<table id="addBaseInfo" width="940" border="0" align="center"
									cellpadding="0" cellspacing="0"
									style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none"
									class="scxxa">
									<tr>
										<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
											class="numbers"><strong>基本信息</strong></td>
										<td height="40" align="right" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
											class="add_opt">
											<div class="demand_add">
												<span style="cursor: pointer" title="保存" id="saveBase"><img
													src="images/filesave.png" align="absmiddle" /> 保存</span>
											</div>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站老编号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="oldCode" id="oldCode" class="shuru" type="text"
											size="20" value="<s:property value="model.oldCode" />" /> <label
											class="red" id="oldCode_error"><s:fielderror>
													<s:param>oldCode</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站名称：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="tsName" id="tsName" class="shuru" type="text"
											size="20" value="<s:property value="model.tsName" />" /> <label
											class="red" id="tsName_error"><s:fielderror>
													<s:param>tsName</s:param>
												</s:fielderror></label>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站类型：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<select name="tsType" id="tsType">
												<option value="1" <s:if test="tsType==1">selected</s:if>>共建省界站</option>
												<option value="2" <s:if test="tsType==2">selected</s:if>>分建省界站</option>
												<option value="3" <s:if test="tsType==3">selected</s:if>>非省界主线站</option>
												<option value="4" <s:if test="tsType==4">selected</s:if>>匝道站</option>
										</select> <label class="red" id="seType_error"><s:fielderror>
													<s:param>tsType</s:param>
												</s:fielderror></label>
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">
											收费广场数量：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="tsTollplazacount" id="tsTollplazacount"
											class="shuru phonezl" size="30"
											value="<s:property value="model.tsTollplazacount" />" /><label
											class="red" id="tsTollplazacount_error"><s:fielderror>
													<s:param>tsTollplazacount</s:param>
												</s:fielderror></label></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">该站在邻省编号：</td>
										<td height="40" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											class="shuru" name="tsNeighborid" id="tsNeighborid" type="text"
											size="20" value="<s:property value="model.tsNeighborid" />" />
											<span class="red" id="tsNeighborid_error"><s:fielderror>
													<s:param>tsNeighborid</s:param>
												</s:fielderror></span></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">桩号：</td>
										<td width="304" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><input
											type="text" name="tsStakenum" id="tsStakenum"
											class="shuru phonezl" size="30"
											value="<s:property value="model.tsStakenum" />" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">备注：</td>
										<td height="40" colspan="3" align="left"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<input name="remarks" id="remarks" class="shuru" type="text"
											size="50" value="<s:property value="model.remarks" />" /> <span
											class="red" id="remarks_error"><s:fielderror>
													<s:param>remarks</s:param>
												</s:fielderror></span>
										</td>
									</tr>
								</table>
								<table id="showBaseInfo" width="940" border="0" align="center"
									cellpadding="0" cellspacing="0"
									style="border: 1px solid #BFC2CA; border-bottom: none; font-family: 微软雅黑; font-size: 14px; margin-top: 20px; display: none">
									<tr>
										<td height="40" colspan="3" align="left" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"
											class="numbers"><strong>基本信息</strong></td>
										<td height="40" align="right" bgcolor="#FFFFFF"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px"
											class="add_opt">
											<div class="demand_add">
												<span style="cursor: pointer" id="showBase" title="修改基本信息"><img
													src="images/pencil.png" align="absmiddle" /> 修改</span>&nbsp;&nbsp;
												<c:if test="${model.pkId !=''}">
													<span style="cursor: pointer" id="deleteBase"
														title="删除基本信息"><img src="images/cancel.png"
														align="absmiddle" /> 删除</span>
												</c:if>
											</div>
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站老编号：</td>
										<td height="40" align="left" id="showOldCode"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.oldCode" />
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站名称：</td>
										<td height="40" align="left" id="showTsName"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.tsName" />
										</td>
									</tr>
									<tr>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA"><span
											class="red">*</span> 收费站类型：</td>
										<td height="40" align="left" id="showTsType"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.tsType" />
										</td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">
											收费广场数量：</td>
										<td width="304" align="left" id="showTsTollplazacount"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property value="model.tsTollplazacount" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">该站在邻省编号：</td>
										<td height="40" align="left" id="showTsNeighborid"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property value="model.tsNeighborid" /></td>
										<td width="210" align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA; border-left: 1px solid #BFC2CA">桩号：</td>
										<td width="304" align="left" id="showTsStakenum"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px"><s:property value="model.tsStakenum" /></td>
									</tr>
									<tr>
										<td align="right" bgcolor="#F8F8F8"
											style="border-bottom: 1px solid #BFC2CA; padding-right: 10px; border-right: 1px solid #BFC2CA">备注：</td>
										<td height="40" colspan="3" align="left" id="showRemarks"
											style="border-bottom: 1px solid #BFC2CA; padding-left: 10px">
											<s:property value="model.remarks" />
										</td>
									</tr>
								</table>
							<div class="fatie" id="fatie">
								<div class="options"></div>
							</div>
							<!-- <a href="javascript:void(0);" value="1" class="submit"><button
											class="enters">保存</button></a> -->
						</form>
					</div>
			</div>
		</div>
		<%@ include file="../foot.jsp"%>
		<%@ include file="create_add.jsp"%>
	</div>
</body>
</html>
<script type="text/javascript">
	$(document)
			.ready(
					function() {//选项增减控制
						var menuCss = "<s:property value='#request.menuId'/>";
						var demandHTML = $('#demand').html();
						var fatie = $("#fatie");
						var option = fatie.find(".options dl");
						var j = option.length + 1;
						add(j);
						function list_again() {//选项重新排序
							option.each(function() {
								var i = $(this).index();
								$(this).find("em").html(i + 1);
							});
						}
						fatie
								.find(".add_opt span")
								.click(
										function() {//增加选项
											j = option.length + 2;
											b = demandHTML
													.replace(
															eval("/NUMBERID/gi"),
															j)
													.replace(
															eval("/listnum/gi"),
															option.length);
											fatie.find(".options").append(b);
											$("#demand" + j + "").show();
											$("#demand" + j + " .demand_del")
													.show();
											$("#demand" + j + " .demand_add")
													.hide();
											option = fatie.find(".options dl");
											list_again();
										});
						option.find("a").live(
								"click",
								function() {//删除选项
									$(this).parent().parent().parent().parent()
											.parent().parent().parent()
											.remove();
									list_again();
								});
						//初始化基础信息1
						function add(j) {
							var b = demandHTML.replace(eval("/NUMBERID/gi"), j)
									.replace(eval("/listnum/gi"), j - 1);
							$(".options").append(b);
							$("#demand" + j + "").show();
							$("#demand" + j + " .demand_del").hide();
							$("#demand" + j + " .demand_add").show();
							$("#demand" + j + " .demand_add").show();
							option = fatie.find(".options dl");
							list_again();
						}
						//初始化页面内容
						$("#addBase").click(function() {
							$("#showBaseInfo").show();
							$("#addBaseInfo").hide();

						});
						$("#showBase").click(function() {
							$("#addBaseInfo").show();
							$("#showBaseInfo").hide();
						});
						if ($("#pkId").val() != "")
							$("#showBaseInfo").show();
						else
							$("#addBaseInfo").show();
						//保存收费站基本信息
						$("#saveBase")
								.click(
										function() {
											var pkId = $("#pkId").val();
											var menuId = $("#menuId").val();
											var oldCode = $("#oldCode").val();
											if (oldCode == ""
													|| oldCode == null) {
												alert("收费站老编号不允许为空!");
												return;
											}
											var tsName = $("#tsName").val();
											if (tsName == "" || tsName == null) {
												alert("收费站名称不允许为空!");
												return;
											}
											var tsType = $("#tsType").val();
											if (tsType == "" || tsType == null) {
												alert("收费站性质不允许为空!");
												return;
											}
											var tsTollplazacount = $("#tsTollplazacount").val();
											var tsNeighborid = $("#tsNeighborid")
													.val();
											var tsStakenum = $("#tsStakenum")
													.val();
											var remarks = $("#remarks").val();
											var basicSection = {
												"model.pkId" : pkId,
												"model.menuId" : menuId,
												"model.oldCode" : oldCode,
												"model.tsName" : tsName,
												"model.tsType" : tsType,
												"model.tsTollplazacount" : tsTollplazacount,
												"model.tsNeighborid" : tsNeighborid,
												"model.tsStakenum" : tsStakenum,
												"model.remarks" : remarks
											};
											$.ajax({
												type : "POST",
												url : "BasicTollstation/saveByAjax.do",
												dataType : "json",
												data : basicSection,
												async : false,
												cache : false,
												success : function(res) {
													if (res.result != "fail") {
														alert("添加成功");
														$("#pkId").val(res.result);
														//重新加载基本信息
														$("#showBaseInfo").show();
														$("#addBaseInfo").hide();
														$("#showOldCode").html(oldCode);
														$("#showTsName").html(tsName);
														$("#showTsType").html(tsType);
														$("#showTsTollplazacount").html(tsTollplazacount);
														$("#showTsTollplazacount").html(tsTollplazacount);
														$("#showTsNeighborid").html(tsNeighborid);
														$("#showTsStakenum").html(tsNeighborid);
														$("#showRemarks").html(remarks);
													}
												},
												error : function() {
													alert("添加失败");
												}
											});
										});
						//删除基本信息
						$("#deleteBase").click(function() {
							//Ajax调用处理
							$.ajax({
								type : "POST",
								url : "BasicTollstation/deleteByAjax.do",
								dataType : "json",
								data : {
									"pkId" : $("#pkId").val()
								},
								async : false,
								cache : false,
								success : function(res) {
									if (res.result != "fail") {
										alert("删除成功");
										$("#pkId").val("");
										$("#showBaseInfo").hide();
										$("#addBaseInfo").show();
									}
								},
								error : function() {
									alert("删除失败");
								}
							});
						});

						//保存收费广场信息
						$("#savePlaza").click(function() {
								if ($("#pkId").val() == "") {
									alert("请先添加基本信息");
									return;
								}
								//Ajax调用处理
								var array = [];
								var fatie = $("#fatie");
								var option = fatie.find("table");
								var flg = false;
								option.each(function(index, val) {
									var plazaPkId = $("#basicTollPlazaPkId"+index).val();
									var txt = "";
									$(this).find("tr:gt(0)").each(function(sx,val) {
											var tdArr = $(this).children();
											if (sx == 2) {
												if (tdArr.eq(1).find('select').val() == "") {
													flg = true;
												}
												txt += tdArr.eq(1).find('select').val()+ ",";//收入金额
											} else {
												if (tdArr.eq(1).find('input').val() == "") {
														flg = true;
												}
												txt += tdArr.eq(1).find('input').val()+ ",";//收入金额
											}
								});
								var txtArr = txt.split(",");
								var temp = {
									"pkId":plazaPkId,
									"tsCode" : txtArr[0],
									"tsName" : txtArr[1],
									"tsType" : Number(txtArr[2])
								};
								array.push(temp);
							});
											if (flg == true) {
												alert("必填项不允许为空");
												return;
											}
											var basicTollplazas = JSON.stringify(array);
											$.ajax({
												type : "POST",
												url : "BasicTollstation/saveTollplaza.do?menuId="+ $("#menuId").val()+ "&pkId="+ $("#pkId").val(),
												dataType : "json",
												data : {
													"jsonarray" : basicTollplazas
												},
												success : function(res) {
													if (res.result != "fail") {
														alert("添加成功");
													}
												},
												error : function() {
													alert("添加失败");
												}
											});
										});
						$('#'+menuCss).css("background", '#FF8000');
					});
	$(function() {
		$('#frm').validate({
			errorClass : "error",
			submitHandler : function(form) {
				//如果想提交表单, 需要使用form.submit()而不要使用$(form).submit()
				//alert("submitted!");
				if ($('#myModal').html() != '') {
					alert('首要联系人联系电话号码已存在，请查看资料或输入其它电话号码！');
				} else {
					areapatch();
					frm.submit();
				}
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.next());
			},
			rules : {

				loName : {
					required : true
				},
				loContact : {
					required : true
				},
				loTel : {
					required : true
				},
				loAddress : {
					required : true
				},
				liCode : {
					required : true
				},
				liName : {
					required : true
				},
				//loBankaccount: {required: true},
				trRoadnum : {
					required : true
				},
				//area: {required: true},
				trName : {
					required : true
				},
				trLevel : {
					required : true
				},
				error_id : {
					required : true
				}
			},

			messages : {}
		});
	});
</script>