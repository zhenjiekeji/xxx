/*
*模板指标项树设置
*/
var templateItemTreeNodes =[
	{ id:1, pId:0, name:"树形菜单", open:true,isParent:true}
];
var templateItemTree = {
	view: {
		removeHoverDom: removeHoverDom,
		selectedMulti: false
	},
	edit: {
		enable: true,
		showRemoveBtn: true,
		showRenameBtn: false,
		editNameSelectAll: true,
		drag:{
			isCopy:false,
			isMove:true
		}
	},
	data: {
		simpleData: {
			enable: true,
			rootPId: 0
		},
		keep: {
			leaf:true,
			parent: true
		}
	},
	callback:{
		beforeRemove:zTreeBeforeRemove,
		beforeDrop:modelBeforeDorp	
	}
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.id).unbind().remove();
};
function zTreeBeforeRemove(treeId, treeNode) {
	if(treeNode.pId==0&&treeNode.isParent&&!treeNode.getNextNode()&&!treeNode.getPreNode()){
		return false;
	}
}
function modelBeforeDorp(treeId, treeNodes, targetNode, moveType) {
	for(i=0; i<treeNodes.length; i++){
		if(treeNodes[i].isParent){return true;}
		else{
			return !(targetNode == null || (moveType != "inner" && !targetNode.parentTId ));
		}
	}
};
/*
* 指标集、指标数设置
*/
var setting = {
	edit: {
		enable: true,
		showRemoveBtn: false,
		showRenameBtn: false,
		drag:{
			isMove:false,
			prev: false,
			next: false,
			inner: false
		}
	},
	data: {
		simpleData: {
			enable: true
		}
	},view: {
		selectedMulti: false
	},
	callback: {
		beforeDrag: beforeDrag,
		beforeDrop: beforeDrop
	}
};
function beforeDrag(treeId, treeNodes) {
	for (var i=0,l=treeNodes.length; i<l; i++) {
		if (treeNodes[i].drag === false) {
			return false;
		}
	}
	return true;
}
function beforeDrop(treeId, treeNodes, targetNode, moveType) {
	for(i=0; i<treeNodes.length; i++){
		if(treeNodes[i].isParent){return targetNode ? targetNode.drop !== false : true;}
		else{
			return (targetNode ? targetNode.drop !== false : true)&&!(targetNode == null || (moveType != "inner" && !targetNode.parentTId ));
		}
	}
}	
var zNodes;
$(document).ready(function(){
	/*
	* 指标集、指标数
	*/
	function dataFromAjax() {
    	$.ajax({
			type : "post",
			url : "framework/engine/info/zTreeSetGroup.do",
			dataType : "json",
			data : {
			},
			async : false,
			cache : false,
			success : function(data) {
				zNodes = data;
			},
			error : function() {
				alert("Ajax请求数据失败!");
			}
     	});
    	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
  	}
	
   	dataFromAjax();
	$.fn.zTree.init($("#templateItemTree"), templateItemTree,templateItemTreeNodes);
	$.fn.zTree.getZTreeObj("templateItemTree").getNodeByParam("id", 1, null).zAsync = true;
	

	
});
//提交模板指标按钮
function submitTemplateItemFrom(){
	var zSetTreeObj=$.fn.zTree.getZTreeObj("templateItemTree");
	var array=zSetTreeObj.transformToArray(zSetTreeObj.getNodes());
	var ztreeJson=new Array();
	//数组中元素的指定格式为id@pId,后台处理时应按照此格式解析
	for(var i=0;i<array.length;i++){
		var element="{\"id\":\""+array[i].id+"\",\"order\":"+i+",\"pId\":\""+array[i].pId+"\",\"name\":\""+array[i].name+"\",\"isParent\":"+array[i].isParent+"}";	
		ztreeJson.push(element);
	}
	var form = "<input type='hidden' name='ztreeJsonString' value='"+ztreeJson+"'/>";
	$("#templateItemTable").append(form);
	return true;
};
