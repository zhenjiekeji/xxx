function onClick(e, treeId, treeNode) {
	var zTree =  $.fn.zTree.getZTreeObj($(e.target).attr("id"));
	//var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, true, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree =  $.fn.zTree.getZTreeObj($(e.target).attr("id"));
	//var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getCheckedNodes(true),
	v = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	var cityObj = $(e.target).parents(".menuContent").siblings(".exSelect");
	//var cityObj = $("#citySel");
	cityObj.attr("value", v);
}

function showMenu(event) {
	var cityObj = $(event.target);
	var menuContent = cityObj.siblings(".menuContent")
	var cityOffset = cityObj.offset();
	//alert($(window).height()+"---"+$(document).height());
	menuContent.css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).show();
//	if(cityOffset.top + cityObj.outerHeight()+menuContent.outerHeight()>$(window).height()){
//		menuContent.css({left:cityOffset.left + "px", top:cityOffset.top - menuContent.outerHeight() + "px"}).show();
//	}
//	else{
//		menuContent.css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).show();
//	}

	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$(".menuContent").hide();
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	//alert($(event.target).siblings(".menuContent:visible").length>0);
	if (!(($(event.target).attr("class") == "exSelect" && $(event.target).siblings(".menuContent:visible").length>0)|| $(event.target).attr("class")  == "menuContent" || $(event.target).parents(".menuContent").length>0)) {
		hideMenu();
	}
}

$(document).ready(function(){
	$(".exSelect").click(function(event){showMenu(event);});
});