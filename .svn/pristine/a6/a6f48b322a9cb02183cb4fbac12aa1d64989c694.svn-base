// JavaScript Document

//城市赋值
$(document).ready(function(){
	$(".uk_area").each(function () {
		var val = $(this).attr("var");
		//alert(val);
		if (val != '' && val.length == 6) {
			var area = getArea(val);
			if (area != '' && area != null) {
				$(this).text(area);
			} else {
				//$(this).text(val);
			}
		}
	});
	$(".uk_area2").each(function () {
		var val = '';
		var val2 = '';
		var area = '';
		var area2 = '';
		val = $(this).attr("var");
		//alert(val);
		if (val != '' && val.length == 6) {
			if (val.substring(2) != '0000') {
				val2 = val.substring(0, 2)+"0000";
			}
			area = getArea(val);
			area2 = getArea(val2);
			if (area != '' && area != null) {
				if (area2 != '' && area2 != null) {
					$("#uk_area"+val2+"").hide();
					$(this).text(area2+'：'+area);
				} else {
					$(this).text(area);
				}
			} else {
				//$(this).text(val);
			}
		}
	});
});
function getArea(area) {
	var __area=JSON.stringify(_area); 
	//注意g将全文匹配，不加将永远只返回第一个匹配。
	eval('var re = /"'+area+'","name":"(\\w*\\W*)"}/;'); 
	var arr = re.exec(__area);
	if (arr != null) {
		return arr[1];
	} else {
		return arr;
	}
}
//地区自动补全
function areapatch(){
	var scmap={};
	$("select[no!='']").each(function(){
		scmap[$(this).attr("no")]="true";
	});
	for(k in scmap){
		var $t=$("select[no="+k+"]");
		if($t.length<2){
			$("select[no="+k+"]:last").after("<select style='display:none' name='city'><option value=''></option></select>"); 			
		}
		if($t.length<3){
			$("select[no="+k+"]:last").after("<select style='display:none' name='area'><option value=''></option></select>"); 			
		}
	}
}