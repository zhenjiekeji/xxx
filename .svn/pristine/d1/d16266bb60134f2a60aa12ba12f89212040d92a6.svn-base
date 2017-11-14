function disableSubmit(finalResult,submitButtonId) {
	if(finalResult) {
		document.getElementById(submitButtonId).disabled = true;
		return finalResult;
	}else {
		return finalResult;
	}
}

function batchDelete(action,checkboxName,form){
    if (!hasOneChecked(checkboxName)){
            alert('请选择要操作的对象!');
            return;
    }
    if (confirm('确定执行[删除]操作?')){
        form.action = action;
        form.submit();
    }
}

function deleteConfirm(){
	return confirm('确定执行[删除]操作?');
}

function hasOneChecked(name){
    var items = document.getElementsByName(name);
    if (items.length > 0) {
        for (var i = 0; i < items.length; i++){
            if (items[i].checked == true){
                return true;
            }
        }
    } else {
        if (items.checked == true) {
            return true;
        }
    }
    return false;
}

function setAllCheckboxState(name,state) {
	var elms = document.getElementsByName(name);
	for(var i = 0; i < elms.length; i++) {
		elms[i].checked = state;
	}
}

function getReferenceForm(elm) {
	while(elm && elm.tagName != 'BODY') {
		if(elm.tagName == 'FORM') return elm;
		elm = elm.parentNode;
	}
	return null;
}
/*
*创建操作对象，根据传入的action与json对象
*/
var OperObject = {
	createNewObject:function(action,paraJson){
		var operObject={};
		operObject.action=action;
		operObject.paraJson=paraJson;
		return operObject;	
	}
}
/*
*操作函数
*/
function operationFunction(obj){
	var action = obj.action == undefined ? '' : obj.action;
	var paraJson = obj.paraJson == undefined ? null : obj.paraJson;
	if(action == ''){
		alert("请求地址不能为空！");
		return;
	}
	var form = "<form id='operationForm' method='post'>"
	if(paraJson != null){
		for(var key in paraJson){
    	   form+="<input type='hidden' name='"+key+"' value='"+paraJson[key]+"'/>"
		}  
	}
	form+="</form>";
	$("#operationForm").remove();
	$("body").append(form);
	$("#operationForm").get(0).action=action;
	$("#operationForm").submit();
}

/**
* 全选按钮点击第一次（奇数次）时是全选，点击第二次（偶数次）时是全不选
*/
jQuery(function($){
	$("#selectAllButton").toggle(
	    function(){
	        $(":checkbox").attr("checked","checked");
	        $(this).val("全不选");
	    },
	    function(){
	        $(":checkbox").removeAttr("checked");
	         $(this).val("全选");
	    }
	);
});

