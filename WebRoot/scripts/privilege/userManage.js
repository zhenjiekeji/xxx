//文档加载完毕
window.onload=function(){
	//单位树样式设置
	var settingDept = {
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
			onCheck : deptInfoAssignment
		}
	};		
	//ajax获取部门树
	function getDeptTreeAjax() {
		var zTreeDeptObj;
		var zNodesDept;
		$.ajax({
			type : "post",
			url : $("#contentPath").val()+"/bns/business/UkGroupInfo/zTreeDeptOrder.do",
			dataType : "json",
			data : {
				deptIds : $("#groupId").val()
			},
			async : false,
			cache : false,
			success : function(data) {
				zNodesDept = data;
			},
			error : function() {
				alert("Ajax请求数据失败!");
			}
		});
		//console.info("result-------"+zNodesDept);
		zTreeDeptObj = $.fn.zTree.init($("#zTreeDeptOrder"), settingDept,zNodesDept);
	}
    //展开部门树当前选中节点及其所有上级节点
	function expandNodesDept() {
		var zTreeDeptObj = $.fn.zTree.getZTreeObj("zTreeDeptOrder");
		var selectNodesArray = zTreeDeptObj.getCheckedNodes(true);
		var selectNodesLength = selectNodesArray.length;
		for ( var i = 0; i < selectNodesLength; i++) {
			var selectNode = selectNodesArray[i];
			zTreeDeptObj.expandNode(selectNode, true, true, true);
			zTreeDeptObj.selectNode(selectNode);
		}
	}			
	//部门输入框以及隐藏域赋值
	function deptInfoAssignment() {  
		var zTreeDeptObj = $.fn.zTree.getZTreeObj("zTreeDeptOrder");
		var selectNodesArray = zTreeDeptObj.getCheckedNodes(true);
		var selectNodesLength = selectNodesArray.length;
	
		var selectedItems = ""; //参数值的指定格式为id@@@id@@@id,后台处理时应按照此格式解析
		var selectedItemsNameDept = "";
		for ( var i = 0; i < selectNodesLength; i++) {
			selectedItems += selectNodesArray[i].id;
			selectedItemsNameDept += selectNodesArray[i].name;
			if (i != selectNodesLength - 1) {
				selectedItems += "@@@";
				selectedItemsNameDept += ",";
			}
		}
		$("#groupId").val(selectedItems);
		$("#userDeptTree").val(selectedItemsNameDept);
	}	
	//ztree初始化
	getDeptTreeAjax(); 
	//ztree展开当前选中节点及其所有上级节点
	expandNodesDept();	
	//初始化赋值
	deptInfoAssignment(); 
};
jQuery(function($){
	//编辑用户的全局验证规则函数
	var editUserValidateRules = {
		"loginName":{
			required: true,
			maxlength: 50,
			remote: {
				url:$("#contentPath").val()+'/framework/privilege/ajaxValidLoginName.do',		//后台处理程序
				type:'post',									  	//数据发送方式
				data:{
					'editLoginName':$("#loginName").val()
				},
				dataType:'json' 								 	//接受数据格式
			}
		},
		"passwd":{
			maxlength: 255
		},
		"repasswd":{
			equalTo: '#passwd'
		},
		"userName":{
			required: true,
			maxlength: 100
		},
		"userPhone":{
			isPhone: true
		},
		"userMobilephone":{
			isMsisdn: true
		},
		"userEmail":{
			email: true,
			maxlength: 50
		}
	};
	validate("#editUserForm",editUserValidateRules,"td");				// 不传递errorPlace，则使用默认的

	//添加用户的全局验证规则函数
	var addUserValidateRules = {
		"loginName":{
			required: true,
			maxlength: 50,
			remote: {
				url:$("#contentPath").val()+'/framework/privilege/ajaxValidLoginName.do',		//后台处理程序
				type:'post',									  	//数据发送方式
				dataType:'json' 								 	//接受数据格式
			}
		},
		"passwd":{
			required: true,
			maxlength: 255
		},
		"repasswd":{
			required: true,
			equalTo: '#passwd'
		},
		"userName":{
			required: true,
			maxlength: 100
		},
		"userPhone":{
			isPhone: true
		},
		"userMobilephone":{
			isMsisdn: true
		},
		"userEmail":{
			email: true,
			maxlength: 50
		}
	};
	validate("#addUserForm",addUserValidateRules,"td");					// 不传递errorPlace，则使用默认的
});



