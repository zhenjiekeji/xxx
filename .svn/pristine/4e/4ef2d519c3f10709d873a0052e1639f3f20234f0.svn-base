var rangeMenuOrder=new Array();			//定义菜单顺序的范围,把最小值与最大值放到数组中,便于后边进行validate验证
rangeMenuOrder[0]=1;



function OrderValidation()
{
	//验证规则函数
	var secInfoItemValidate = {
			"itemName":{
		required: true,
		maxlength: 1000
	},
	"s_setIdTree":{
		required: true
	},
	"itemType":{
		required: false,
		maxlength: 4
	},
	"sourceType":{
		required: false,
		maxlength: 4
	},
	"itemCode":{
		required: false,
		maxlength: 50
	},
	"itemStyle":{
		required: false,
		maxlength: 1000
	},
	"itemNote":{
		required: false,
		maxlength: 1000
	},
	"itemSort":{
		required: true,
		digits: true,
		orderIsRight:rangeMenuOrder  
	},
	// input项验证
	"secInfoItemInput.width":{
		required: false,
		number: true,
		maxlength: 50
	},
	"secInfoItemInput.height":{
		required: false,
		number: true,
		maxlength: 50
	},
	"secInfoItemInput.itemDatalength":{
		required: false,
		number: true,
		maxlength: 10
	},
	"secInfoItemInput.itemDatatype":{
		required: false,
		maxlength: 4
	},
	// input_num项验证
	"secInfoItemInput.secInfoItemInputNumber.min":{
		required: false,
		number: true,
		maxlength: 10
	},
	"secInfoItemInput.secInfoItemInputNumber.max":{
		required: false,
		number: true,
		maxlength: 10
	},
	"secInfoItemInput.secInfoItemInputNumber.numberType":{
		required: false,
		maxlength: 4
	},
	// input_text
	// input_date
	
	// textarea
	"secInfoItemTextarea.rownums":{
		required: false,
		number: true,
		maxlength: 4
	},
	"secInfoItemTextarea.colnums":{
		required: false,
		number: true,
		maxlength: 4
	},
	"secInfoItemTextarea.itemDatalength":{
		required: false,
		number: true,
		maxlength: 10
	},
	//Item_Image
	"secInfoItemImage.itemText":{
		required: false,
		maxlength: 1000
	},
	"secInfoItemImage.width":{
		required: false,
		number: true,
		maxlength: 50
	},
	"secInfoItemImage.height":{
		required: false,
		number: true,
		maxlength: 50
	},
	
	//Item_Link
	
	"secInfoItemLink.itemLinktext":{
		required: false,
		maxlength: 1000
	},
	"secInfoItemLink.itemLinksrc":{
		required: false,
		maxlength: 100
	},
	
	//ItemDiv
	"secInfoItemDiv.itemSrc":{
		required: false,
		maxlength: 1000
	},
	
	"secInfoItemDiv.width":{
		required: false,
		number: true,
		maxlength: 50
	},
	"secInfoItemDiv.height":{
		required: false,
		number: true,
		maxlength: 50
	},
	
	// source source_write
	"secInfoDataSource.secInfoDataSourceWrite.sourceValue":{
		required: false,
		maxlength: 3000
	},
	// source source_system
	// source source_alter
	"secInfoDataSource.secInfoDataSourceAltertabl.sourceAlterviewfield":{
		required: false,
		maxlength: 100
	},
	"secInfoDataSource.secInfoDataSourceAltertabl.sourceAlterkeyfield":{
		required: false,
		maxlength: 100
	},
	"secInfoDataSource.secInfoDataSourceAltertabl.sourceAlterorderfield":{
		required: false,
		maxlength: 100
	},
	"secInfoDataSource.secInfoDataSourceAltertabl.sourceAltercondition":{
		required: false,
		maxlength: 100
	},
	"secInfoDataSource.secInfoDataSourceAltertabl.sourceAlterorder":{
		required: false,
		maxlength: 100
	}
	};
	validate("#secInfoItemValidate",secInfoItemValidate,"td");				// 不传递errorPlace，则使用默认的
}

jQuery(function($){
	
	OrderValidation();
	
});

