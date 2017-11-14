<%@ page pageEncoding="UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		/**
		 * 左侧树加载
		 */
		$("#tree").tree({
			url : "BasicLinkowner/getRoadTreeByTreeByAsyn.do",
			onClick : function(node) {
				console.log(node.id);
				location.href = node.url + "?menuId=" + node.id;
				//$.cookie("selectId", node.id);
			},
			//加载成功后默认展开第一级
			onLoadSuccess : function(node, data) {
				//if(data[0].id == "5bbd27b5a20211e4afd700163e000117"){ //判断是否是根节点，如果是根节点才展开第一级
				/* var menuId = $("#menuId").val();
				if(menuId != "null" && menuId != null){
				    var rootNode = $("#tree").tree("find", menuId);
				    $("#tree").tree("expand",rootNode.target);
				} */
				var t = $(this);
				if (data) {
					$(data).each(function(index, d) {
						if (this.state == 'closed') {
							t.tree('expandAll');
						}
					});
				}
			}
		});
	});
</script>
<div class="menus">
	<ul id="tree" class="easyui-tree"></ul>
</div>