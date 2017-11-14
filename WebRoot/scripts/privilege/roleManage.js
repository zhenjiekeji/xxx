/**
*删除多个角色
*/
function batchRoleDelete(action,checkboxName,form){
    if (!hasOneChecked(checkboxName)){
            alert('请选择要操作的对象！');
            return;
    }
    if (confirm('确定执行[删除]操作，删除角色及其所有关联用户、菜单？')){
        form.action = action;
        form.submit();
    }
}
//文档加载完毕，让tr中的第一列中插入空格，以标识菜单的上下级关系
window.onload=function(){
	var menuLevelSpace;
	$("#roleMenuOperationTable tr").each(function(){
		menuLevelSpace="";
		var menuLevel=(($.trim($(this).children("td.menuVieworder").text())).length)/2;
		for(var i=1;i<menuLevel;i++){
			menuLevelSpace+="&nbsp;&nbsp;&nbsp;";
		}
		$(this).children("td.menuSelect").prepend(menuLevelSpace);
	});
};
jQuery(function($){
	/**
	*父子菜单及其操作的级联控制，现阶段只支持2级的级联,对于多级情况可能不是想要的结果
	*/
	$("#roleMenuOperationTable input.menuOption").click(function(){
		$tr=$(this).closest("tr");
		var menuId=$(this).val();
		var parentId=$.trim($tr.children("td.parentId").text());
		$tr.children("td.operationSelect").find("input.operationOption").attr("checked",this.checked);
		if(this.checked){
			$tr.siblings("tr").each(function(){
				 var siblingMenuId=$(this).children("td.menuSelect").find("input.menuOption").val();
				 var siblingparentId=$.trim($(this).children("td.parentId").text());
				 //其父菜单及其对应的操作也应默认选中
				 if(parentId==siblingMenuId){
				 	$(this).children("td").find("input:checkbox").attr("checked","checked");
				 }
				 //其子菜单及其对应的操作也应默认选中
				 if(menuId==siblingparentId){
				 	$(this).children("td").find("input:checkbox").attr("checked","checked");
				 }
			});
		}else{
			//其子菜单及其对应的操作应该去掉
			$tr.siblings("tr").each(function(){
				 var siblingparentId=$.trim($(this).children("td.parentId").text());
				 if(menuId==siblingparentId){
				 	$(this).children("td").find("input:checkbox").removeAttr("checked");
				 }
			});
		}
	});

	//表单提交
	$("#relateMenusSubmitButton").click(function(){
		if($("input[name='menuId']:checked").val() == null){
		   var result="必须至少选择一个菜单权限，然后再提交！";
		   alert(result);
		   return false;
		}else{
			var menuIdOperation=new Array();
			$("#roleMenuOperationTable input.menuOption").filter(":checked").each(function(){
				$tr=$(this).closest("tr");
				var menuId=$(this).val();
				var operationId="";
				//判断当前tr的菜单对应的操作列中是否有复选框
				$operationCheckbox=$tr.children("td.operationSelect").find("input.operationOption");
				var hasCheckboxCount=$operationCheckbox.length;
				if(hasCheckboxCount>0){
					var operationLength=$operationCheckbox.filter(":checked").length;
					if(operationLength>0){
						for(var i=0;i<operationLength;i++){
							if(i==operationLength-1){
								operationId+=$operationCheckbox.filter(":checked").eq(i).val();
							}else{
								operationId+=$operationCheckbox.filter(":checked").eq(i).val()+"#";
							}
						}
					}else{
						operationId="0";				//如果该菜单没有选中任何操作,则默认其操作id为0
					}
				}else{
					operationId="0";					//如果该菜单没有任何操作,则默认其操作id为0
				}
				var element=menuId+"@"+operationId;		//数组中元素的指定格式为menuid@operationId,后台处理时应按照此格式解析
				menuIdOperation.push(element);
			});

			var form = "<form id='roleMenuOperForm' method='post'>"+
							"<input type='hidden' name='roleId' value='"+$("#roleId").val()+"'/>"+
							"<input type='hidden' name='menuIdOperation' value='"+menuIdOperation+"'/>"+
   		  			   "</form>";
			$("#roleMenuOperForm").remove();
			$("body").append(form);
			$("#roleMenuOperForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeRole/assignRoleMenuOperation.do';
			$("#roleMenuOperForm").submit();
		}
	});
});
/**
* 角色管理验证规则
*/
jQuery(function($){
	var roleValidateRules = {
		"roleName":{
			required: true,
			maxlength: 50
		},
		"roleDescription":{
			maxlength: 1000
		}
	};
	validate("#roleForm",roleValidateRules,"td");					// 不传递errorPlace，则使用默认的
});
