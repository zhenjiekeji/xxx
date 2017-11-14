function isTop(minOrder){
if($("#minOrder").val()==minOrder){
		alert("已移至顶部");
		return false;
	}else{
	return true;
	}
}

function isBottom(maxOrder){
	if($("#maxOrder").val()==maxOrder){
		alert("已移至底部");
		return false;
	}else{
	return true;
	}
}

function clearInput(){
	$("#itemName").val("");
}

/**
* 添加、修改字典项的验证规则
*/
jQuery(function($){
	var itemValidateRules = {
		"itemName":{
			required: true,
			maxlength: 50
		},
		"itemDescription":{
			maxlength: 1000
		}
	};
	validate("#itemForm",itemValidateRules,"td");
});

