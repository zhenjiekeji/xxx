	var tplconnect=function(tpl,obj){
		if(obj == null) return '';
		var result='';
		result = tpl.replace(/\{([\w]+)\}/gi,function(word,key){
		    if(obj[key] != undefined){ //若obj含有这个属性，则返回obj的属性值
		        return obj[key];
		    }
		});
		return result;
	};