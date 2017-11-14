var groupId='';
var isParentNode=true;
jQuery(function($){

	//添加下级菜单
	$("#addLowerLevelButton").click(function(){	//叶子节点不允许添加下级菜单
		var form = "<form id='addGroupForm' method='post'>"+
						"<input type='hidden' name='groupId' value='"+groupId+"'/>"+
		   		   "</form>";
		$("#addGroupForm").remove();
		$("body").append(form);
		$("#addGroupForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecBasDicGroup/create.do';
		$("#addGroupForm").submit();
	});
	//修改菜单
	$("#editGroupButton").click(function(){

		if(groupId == '' || groupId == undefined){
			alert("请先选择相应菜单！");
			return false;
		}
		var form = "<form id='editGroupForm' method='post'>"+
						"<input type='hidden' name='groupId' value='"+groupId+"'/>"+
		   		   "</form>";
		$("#editGroupForm").remove();
		$("body").append(form);
		$("#editGroupForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecBasDicGroup/edit.do';
		$("#editGroupForm").submit();
	});


	//删除菜单
	$("#deleteGroupButton").click(function(){

		if(groupId == '' || groupId == undefined){
			alert("请先选择相应菜单！");
			return false;
		}
		var zGroupTreeObj=$.fn.zTree.getZTreeObj("zTreeGroup");

		var selectNodeChildren=zGroupTreeObj.getSelectedNodes()[0].children;
		if(isParentNode && selectNodeChildren!=undefined){
			alert("非叶子节点不允许删除操作！");
			return false;
		}

		if (confirm('确定执行[删除]操作，删除改字典组及其所有子字典组和字典项？')){
			var form = "<form id='deleteGroupForm' method='post'>"+
							"<input type='hidden' name='groupId' value='"+groupId+"'/>"+
			   		   "</form>";
			$("#deleteGroupForm").remove();
			$("body").append(form);
			$("#deleteGroupForm").get(0).action=$("#contentPath").val()+'/framework/privilege/SecBasDicGroup/deleteById.do';
			$("#deleteGroupForm").submit();
    	}
	});

});


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
	groupId=treeNode.id;
	if(groupId==0 || groupId=='0'){
		$("#editGroupButton").attr('disabled','disabled');
		$("#deleteGroupButton").attr('disabled','disabled');
	}else{
		$("#editGroupButton").removeAttr("disabled");
		$("#deleteGroupButton").removeAttr("disabled");

		isParentNode=treeNode.isParent;
		$(".formTable tr:eq(0) td:eq(1)").empty();
		$(".formTable tr:eq(1) td:eq(1)").empty();
		$(".formTable tr:eq(2) textarea").val('');
		if(groupId != '' && groupId != undefined && groupId != null){	//菜单详细信息显示
			$(".formTable tr:eq(0) td:eq(1)").text(treeNode.name);
			$(".formTable tr:eq(1) td:eq(1)").text(treeNode.groupVieworder);
			$(".formTable tr:eq(2) textarea").val(treeNode.groupDescription);
		}
	}

}
/**
* 添加、修改字典组的验证规则
*/
jQuery(function($){
	var groupValidateRules = {
		"groupName":{
			required: true,
			maxlength: 50
		},
		"groupDescription":{
			maxlength: 1000
		}
	};
	validate("#groupForm",groupValidateRules,"td");
});