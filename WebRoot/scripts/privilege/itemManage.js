jQuery(function($){
	var zTreeSet;
	//普通的radio树 	
	var setting = {
			check : {
				enable : true,
				chkStyle : "radio",
				radioType : "all"
			},
			view : {
				dblClickExpand : false,
				showLine : false
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				onClick : onClick,
				onCheck : onCheckToMe
			}
		};
	   //指令树	
	   function itemSetAjax() {  
			$.ajax({
		        type:"post",
		        url: "framework/privilegeJson/zTreeSetOrder.do",
		        dataType:"json",
		        data : {setIds : $("#s_setId").val()},
		        async: false,
		        cache:false,
		        success: function (data) {
					zTreeSet=data;
				},
		        error: function () {
		        	alert("Ajax请求数据失败!");
		        }
			});
			$.fn.zTree.init($("#setTree"), setting, zTreeSet);
	   }
	   itemSetAjax();
	   //获得指令信息
		function getItemSet() {
			var zTreeProductObj = $.fn.zTree.getZTreeObj("setTree");
			var selectNodesArray3 = zTreeProductObj.getCheckedNodes(true);
			var selectNodesLength3 = selectNodesArray3.length;
			var selectedItems3 = ""; //参数值的指定格式为id@@@id@@@id,后台处理时应按照此格式解析
			var selectedUtemsName = "";
			for ( var i = 0; i < selectNodesLength3; i++) {
				selectedItems3 += selectNodesArray3[i].id;
				selectedUtemsName += selectNodesArray3[i].name;
				if (i != selectNodesLength3 - 1) {
					selectedItems3 += "@@@";
					selectedUtemsName += ",";
				}
			}
			$("#s_setIdTree").val(selectedUtemsName);
			$("#s_setId").val(selectedItems3);
		}
		getItemSet();
		function onCheckToMe(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj($(e.target).attr("id"));
			nodes = zTree.getCheckedNodes(true), v = "";
			for ( var i = 0, l = nodes.length; i < l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0)
				v = v.substring(0, v.length - 1);
			var cityObj = $(e.target).parents(".menuContent").siblings(".exSelect");
			cityObj.attr("value", v);

			getItemSet(); 
		}
});

