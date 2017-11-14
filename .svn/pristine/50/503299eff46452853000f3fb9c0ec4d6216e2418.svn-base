/**
 * 将validate框架进行包装，以方便调用
 * @param {Object} formId 表单的id或class
 * @param {Object} validateRules 要验证的字段及验证的规则
 * @param {Object} errorPlace 错误存放位置（父元素） 可选，默认值为'li'
 */
function validate(formId,validateRules,errorPlace)
{
	// 如果没有传递该参数，则提供默认值
	if(errorPlace == undefined)
	{
		errorPlace = 'li';
	}
	/**
	 * 使用validation框架进行验证
	 */
	$(formId).validate({
		rules: validateRules,	// 验证规则

		errorElement: 'span',						// 放置错误信息的元素，可以是其他的。
		errorPlacement: function(error,element)		// 将错误提示信息放在什么地方(error包含错误信息的标签，默认有一个class为'error'属性）
		{
			error.appendTo(element.parent(errorPlace));
		},
		// 验证成功执行
		success: function(label)
		{
			label.text(" ")						// 将错误内容清空，一定要是" "有空格，否则IE有问题。
				.addClass("success");
		}
	});
}

/**
 * 将validate框架进行包装，以方便调用，适用于将验证直接写到class中
 * @param {Object} formId 表单的id或class
 * @param {Object} errorPlace 错误存放位置（父元素） 可选，默认值为'li'
 */
function validateTagClass(formId,errorPlace)
{
	// 如果没有传递该参数，则提供默认值
	if(errorPlace == undefined)
	{
		errorPlace = 'li';
	}
	/**
	 * 使用validation框架进行验证
	 */
	$(formId).validate({
		meta: "validate",
		errorElement: 'span',						// 放置错误信息的元素，可以是其他的。
		errorPlacement: function(error,element)		// 将错误提示信息放在什么地方(error包含错误信息的标签，默认有一个class为'error'属性）
		{
			error.appendTo(element.parent(errorPlace));
		},
		// 验证成功执行
		success: function(label)
		{
			label.text(" ")						// 将错误内容清空，一定要是" "有空格，否则IE有问题。
				.addClass("success");
		}
	});
}

/**
 * 自定义验证规则——增加对菜单管理或者名单管理中显示顺序所填整数的范围验证
 */
$.validator.addMethod(
		"orderIsRight",
		function(value, element, param){
			return this.optional(element) || ( value >= param[0] && value <= param[1] );
		},
		$.validator.format("显示顺序必须介于{0}和{1}之间")
);

/**
 * 自定义验证规则——增加对重新输入的旧密码是否正确的验证
 */
$.validator.addMethod(
		"oldPwdIsRight",
		function(value, element, param){
			return this.optional(element) || ( value == param);
		},
		"旧密码不正确，请重试！"
);

/**
 * 自定义验证规则——增加对select的验证
 */
$.validator.addMethod(
		"selectNone", 						// name验证方法名
		function(value, element, param)    // 验证规则
		{
			if (value == "none" || value=="" || value=="-1"){ 	// select默认值需要设置为"none"或-1(当然可以自定义其他值）
				return false;
			} else {
				return true;
			}
		},
		"必须选择一项" 	// 默认验证消息（自定义规则信息的国际化是否不起作用？）
);

/**
 * 自定义验证规则——对手机号码进行验证
 */
$.validator.addMethod(
		"isMsisdn",
		function(value, element)
		{
			var msisdnReg = /(^0?[1][358][0-9]{9}$)/; 				//号码段的验证正则表达式
			return this.optional(element) || (msisdnReg.test(value));
		},
		"格式错误"
);

/**
 * 自定义验证规则——对电话号码进行验证
 */
$.validator.addMethod(
		"isPhone",
		function(value, element)
		{
			var tel = /^((0\d{2,3})(-?))?(\d{7,8})(-(\d{3,}))?$/;
			return this.optional(element) || (tel.test(value));
		}
		, "格式错误"
);

/**
 * 自定义验证规则——对风险评估表可能性输入验证
 */
$.validator.addMethod(
		"riskEvalPoss",
		function(value, element)
		{
			var reg = /[A-E]/; 				//风险评估表可能性输入正则表达式
			return this.optional(element) || (reg.test(value) && value.length == 1);
		},
		"请输入A-E之间的一个字符"
);

/**
 * 自定义验证规则——对日期时间进行验证：YYYY-MM-DD hh:mm:ss或者YYYY-MM-DD格式
 */
$.validator.addMethod(
		"isDateTime",
		function(value, element)
		{
			var tel = /^[1-9][0-9]{3}-(0?[1-9]|1[0|1|2])-(0?[1-9]|[1|2][0-9]|3[0|1])(\s(0?[0-9]|1[0-9]|2[0-3]):(0?[0-9]|[1|2|3|4|5][0-9]):(0?[0-9]|[1|2|3|4|5][0-9]))?$/;
			return this.optional(element) || (tel.test(value));
		}
		, "格式错误"
);

/**
 * 自定义验证规则——与系统当前时间比较
 */
$.validator.addMethod(
		"isCompareCurrentTime",
		function(value, element)
		{
			var d = new Date();
			var vYear = d.getFullYear();
			var vMon = d.getMonth() + 1;
			var vDay = d.getDate();
			var h = d.getHours();
			var m = d.getMinutes();
			var se = d.getSeconds();
			var timestr=vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay)+" "+(h<10 ? "0"+ h : h)+":"+(m<10 ? "0" + m : m)+":"+(se<10 ? "0" +se : se);
			if(value<=timestr){
				return false;
			}
			else{
				return true;
			}
		}
		, "所选时间必须大于当前系统时间"
);

/**
 * 在所有必填项后面加上红色星号（*）
 * @param {Object} $
 */
jQuery(function($){
	$(".required").append("<span style='color:red;'>*</span>").show();
});