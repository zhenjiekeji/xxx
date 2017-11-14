var menuId='';
var isParentNode=true;
var isMoveNode=false;
jQuery(function($){
	//提交菜单
	$("#submitZtreeButton").click(function(){
		if(!isMoveNode){
			return false;
		}
	    var zMenuTreeObj=$.fn.zTree.getZTreeObj("menuTree");
	    var array=zMenuTreeObj.transformToArray(zMenuTreeObj.getNodes());
	    var ztreeIdAndPidArray=new Array();
	    for(var i=1;i<array.length;i++){
	    	var element=array[i].id+"@"+array[i].pId;	//数组中元素的指定格式为id@pId,后台处理时应按照此格式解析
	    	ztreeIdAndPidArray.push(element);
	    }
		var form = "<form id='submitZtreeForm' method='post'>"+
						"<input type='hidden' name='ztreeIdAndPid' value='"+ztreeIdAndPidArray+"'/>"+
		   		   "</form>";
		$("#submitZtreeForm").remove();
		$("body").append(form);
		$("#submitZtreeForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeMenu/submitZtreeMenu.do';
		$("#submitZtreeForm").submit();
	});
	//添加下级菜单
	$("#addLowerLevelButton").click(function(){	//叶子节点不允许添加下级菜单
		if(isMoveNode){
			alert("请先点击 提交菜单 按钮，保存拖拽后的菜单顺序！");
			return false;
		}
		if(!isParentNode){
			alert("叶子节点不允许添加下级菜单！");
			return false;
		}
		var form = "<form id='addMenuForm' method='post'>"+
						"<input type='hidden' name='menuId' value='"+menuId+"'/>"+
		   		   "</form>";
		$("#addMenuForm").remove();
		$("body").append(form);
		$("#addMenuForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeMenu/addLowerLevelMenu.do';
		$("#addMenuForm").submit();
	});
	//修改菜单
	$("#editMenuButton").click(function(){
		if(isMoveNode){
			alert("请先点击 提交菜单 按钮，保存拖拽后的菜单顺序！");
			return false;
		}
		if(menuId == '' || menuId == '0' || menuId == undefined){
			alert("请先选择相应菜单！");
			return false;
		}
		var form = "<form id='editMenuForm' method='post'>"+
						"<input type='hidden' name='menuId' value='"+menuId+"'/>"+
		   		   "</form>";
		$("#editMenuForm").remove();
		$("body").append(form);
		$("#editMenuForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeMenu/edit.do';
		$("#editMenuForm").submit();
	});
	//删除菜单
	$("#deleteMenuButton").click(function(){
		if(isMoveNode){
			alert("请先点击 提交菜单 按钮，保存拖拽后的菜单顺序！");
			return false;
		}
		if(menuId == '' || menuId == '0' || menuId == undefined){
			alert("请先选择相应菜单！");
			return false;
		}
		var zMenuTreeObj=$.fn.zTree.getZTreeObj("menuTree");
		var selectNodeChildren=zMenuTreeObj.getSelectedNodes()[0].children;
		if(isParentNode && selectNodeChildren!=undefined){
			alert("非叶子节点不允许删除操作！");
			return false;
		}
		if (confirm('确定执行[删除]操作，删除菜单及其所有关联角色、操作？')){
			var form = "<form id='deleteMenuForm' method='post'>"+
							"<input type='hidden' name='menuId' value='"+menuId+"'/>"+
			   		   "</form>";
			$("#deleteMenuForm").remove();
			$("body").append(form);
			$("#deleteMenuForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeMenu/deleteById.do';
			$("#deleteMenuForm").submit();
    	}
	});
	//菜单关联操作
	$("#relateOperationButton").click(function(){
		if(isMoveNode){
			alert("请先点击 提交菜单 按钮，保存拖拽后的菜单顺序！");
			return false;
		}
		if(isParentNode){
			alert("非叶子节点不允许关联操作！");
			return false;
		}
		var form = "<form id='relateOperationForm' method='post'>"+
						"<input type='hidden' name='menuId' value='"+menuId+"'/>"+
		   		   "</form>";
		$("#relateOperationForm").remove();
		$("body").append(form);
		$("#relateOperationForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecPrivilegeMenu/menuRelateOperations.do';
		$("#relateOperationForm").submit();
	});
});
function beforeDrag(treeId, treeNodes) {
	for (var i=0,l=treeNodes.length; i<l; i++) {
		if (treeNodes[i].drag === false) {
			return false;
		}
	}
	return true;
}
function beforeDrop(treeId, treeNodes, targetNode, moveType) {	//父子节点均不可移动到根节点外面
	for(i=0; i<treeNodes.length; i++){
		if(treeNodes[i].isParent){return targetNode ? targetNode.drop !== false : true;}
		else{
			return (targetNode ? targetNode.drop !== false : true)&&!(targetNode == null || (moveType != "inner" && !targetNode.parentTId ));
		}
	}
}
function zTreeOnDrop(event, treeId, treeNodes, targetNode, moveType) {
    isMoveNode=true;
};

function zTreeOnClick(event, treeId, treeNode) {
	menuId=treeNode.id;
	isParentNode=treeNode.isParent;
	$(".formTable tr:eq(0) td:eq(1)").empty();
	$(".formTable tr:eq(1) td:eq(1)").empty();
	$(".formTable tr:eq(2) td:eq(1)").empty();
	$(".formTable tr:eq(3) textarea").val('');
	if(menuId != '' && menuId != undefined && menuId != null){	//菜单详细信息显示
		$(".formTable tr:eq(0) td:eq(1)").text(treeNode.name);
		$(".formTable tr:eq(1) td:eq(1)").text(treeNode.menuVieworder);
		$(".formTable tr:eq(2) td:eq(1)").text(treeNode.menuUrl);
		$(".formTable tr:eq(3) textarea").val(treeNode.menuDescription);
	}
}
/**
* 菜单管理验证规则
*/
jQuery(function($){
	$("#menuIsleaf").change(function(){
		if($(this).val()==0) {
			$("#menuUrlTr").hide();
			$("#menuUrlTr input").attr("disabled","disabled");
		} else {
			$("#menuUrlTr").show();
			$("#menuUrlTr input").removeAttr("disabled");
		}
	});
	var menuValidateRules = {
		"menuTitle":{
			required: true,
			maxlength: 50
		},
		/*"menuUrl":{
			required: true,
			maxlength: 100
		},*/
		"menuDescription":{
			maxlength: 1000
		}
	};
	validate("#menuForm",menuValidateRules,"td");					// 不传递errorPlace，则使用默认的
});