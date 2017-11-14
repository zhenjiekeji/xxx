// JavaScript Document
// BY Jasmine AT 2012/03/01

//tabbar
$(document).ready(function(){
	if($(".tabbar").length!=0){
		$(".tabbar").find(".content").hide();
		$(".tabbar .tblHead a").click(function(){
			$(this).parents(".tblHead").find("a.sel").removeClass("sel");
			$(this).addClass("sel");
			$(this).parents(".tabbar").find(".content:visible").hide();
			var conId="#"+$(this).attr("forId");
			$(this).parents(".tabbar").find(conId).show();
		});
		$(".sel").trigger("click");
	}
	//对查询表格中class=clearBtn的【重置】按钮绑定单击事件，清空所在表格中input的value和选中状态
	$(".clearBtn").live("click",function(){
		$(this).parents(".queryPanel").find(".queryPanelBody :input:visible:not(:submit,:button,:reset)").val("").removeAttr("checked");
		return false;
	});
});

//创建一个FrameDialog
function openFrameDialog(url,title,w,h,buttons){
	var $dialog = jQuery.FrameDialog
		//create will make an iframe based on the url, other options are
		//    passed to jQueryUI's dialog command.
		.create({
			'url': url,
			'title': title?title:"请选择",
			'height': h?h:400,
			'width': w?w:600,
			autoOpen: true,
			overlay: {
				backgroundColor: '#fff',
				opacity: 0.8
			},
			'buttons':buttons?buttons:{
				"选择":function(event){
					if(typeof FrameDialogSubmit != 'undefined' && FrameDialogSubmit instanceof Function)
					{FrameDialogSubmit(this);}
					//var value =$(this).find('iframe').contents().find(":radio[name='org']:checked").val();
					//$("#orgname").val(value);
					$(this).dialog("close");
				}
			}
		})
		.dialog('open');
}

//获取url传递的参数值
function request(paras){
	var url = location.href;
	var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");
	var paraObj = {}
	for (i=0; j=paraString[i]; i++){
		paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);
	}
	var returnValue = paraObj[paras.toLowerCase()];
	if(typeof(returnValue)=="undefined"){
		return "";
	}else{
		return returnValue;
	}
}