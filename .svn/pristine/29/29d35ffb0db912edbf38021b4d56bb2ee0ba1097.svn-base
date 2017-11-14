jQuery(function($){
	$(".input1 input").attr("disabled",true);
//		$(".input_date  input").attr("disabled",true);
//		$(".input_num   input").attr("disabled",true);
//		$(".input_text  input").attr("disabled",true);
		
	$(".text_area  input").attr("disabled",true);
	$(".Item_Image  input").attr("disabled",true);
	$(".Item_Link  input").attr("disabled",true);
	$(".Item_Div  input").attr("disabled",true);

		$(".source_alter  input").attr("disabled",true);
		$(".source_system  input").attr("disabled",true);
		$(".source_write input").attr("disabled",true);

	// 进入edit页面 初始化 
	var itemTypeVar=  $("#itemType").val();
	if(itemTypeVar!=null)
	{
		itemType(itemTypeVar);
	}
	var sourceTypeVar=  $("#sourceType").val();
	if(sourceTypeVar!=null)
	{
		sourceType(sourceTypeVar);
	}
	var inputItemTypeVar=  $("#inputItemType").val();
	if(inputItemTypeVar!=null)
	{
		inputItemType(inputItemTypeVar);
	}
	
// 输入类型
 $("#itemType").change(function(){
	 var selected=  $(this).val();
	 itemType(selected);
	  });
	function itemType(selected) {
		 if(selected==1){
			 selectItemTypeAjax(selected);
		    $(".input1").show();
			$(".input1 input").attr("disabled",false);
			
			$(".text_area").hide();
			$(".text_area  input").attr("disabled",true);
			
			$(".Item_Image").hide();
			$(".Item_Image  input").attr("disabled",true);
			
			$(".Item_Link").hide();
			$(".Item_Link  input").attr("disabled",true);
			
			$(".Item_Div").hide();
			$(".Item_Div  input").attr("disabled",true)
		  }
		 else if(selected==2){
			$(".text_area").show();
			$(".text_area  input").attr("disabled",false);
			$(".input1").hide();
			$(".input1 input").attr("disabled",true);
			
			$(".Item_Image").hide();
			$(".Item_Link").hide();
			$(".Item_Div").hide();
			$(".Item_Image  input").attr("disabled",true);
			$(".Item_Link  input").attr("disabled",true);
			$(".Item_Div  input").attr("disabled",true)
		  }
		 else if(selected==3){
			$(".Item_Image").hide();
			$(".Item_Image  input").attr("disabled",false);
			$(".Item_Link").hide();
			$(".Item_Div").hide();
			$(".Item_Link  input").attr("disabled",true);
			$(".Item_Div  input").attr("disabled",true)
			$(".text_area").hide();
			$(".text_area  input").attr("disabled",true);
			$(".input1").hide();
			$(".input1 input").attr("disabled",true);
		  }
		 else if(selected==4){
			 $(".Item_Image").hide();
			 $(".Item_Image  input").attr("disabled",false);
			 $(".Item_Link").hide();
			 $(".Item_Div").hide();
			 $(".Item_Link  input").attr("disabled",true);
			 $(".Item_Div  input").attr("disabled",true)
			 $(".text_area").hide();
			 $(".text_area  input").attr("disabled",true);
			 $(".input1").hide();
			 $(".input1 input").attr("disabled",true);
		 }
		 else if(selected==5){
			 $(".Item_Image").show();
			 $(".Item_Image  input").attr("disabled",false);
			 $(".Item_Link").hide();
			 $(".Item_Div").hide();
			 $(".Item_Link  input").attr("disabled",true);
			 $(".Item_Div  input").attr("disabled",true)
			 $(".text_area").hide();
			 $(".text_area  input").attr("disabled",true);
			 $(".input1").hide();
			 $(".input1 input").attr("disabled",true);
		 }
		 // 链接类型
		 else if(selected==6){
			 selectItemTypeAjax(selected);
				$(".Item_Link").show();
			$(".Item_Link  input").attr("disabled",false);
				$(".Item_Image").hide();
				$(".Item_Div").hide();
			$(".Item_Image  input").attr("disabled",true);
			$(".Item_Div  input").attr("disabled",true)
			$(".text_area").hide();
			$(".text_area  input").attr("disabled",true);
			$(".input1").hide();
			$(".input1 input").attr("disabled",true);
		  }
		 else if(selected==7){
				$(".Item_Div").show();
				$(".Item_Div  input").attr("disabled",false)
				$(".Item_Image").hide();
				$(".Item_Link").hide();
			 $(".Item_Image  input").attr("disabled",true);
				$(".Item_Link  input").attr("disabled",true);
			$(".text_area").hide();
			$(".text_area  input").attr("disabled",true);
			$(".input1").hide();
			$(".input1 input").attr("disabled",true);
		  }
		  
		 else if(selected==-1){
			$(".text_area").hide();
			$(".text_area  input").attr("disabled",false);
			$(".input1").hide();
			$(".input1 input").attr("disabled",false);
			$(".Item_Image").hide();
			$(".Item_Link").hide();
		  }
	}
 // 指标项  数据类型
 function selectItemTypeAjax(item_Type)
 {
	 $.ajax({
		 type : "post",
		 url : "framework/engine/info/itemTypeSelectGroupJson.do",
		 dataType : "json",
		 data : {
		 item_Type :item_Type
	 },
	 error : function() {
		 alert("Ajax请求数据失败!");
	 },
	 success:function(data)
	 {
		 if(item_Type==1)
		 {
			 var ss=$("#itemDatatype_h").val();
			 var option="<option value='-1'>请选择</option>";
			 $.each(data,function(i,value){
				 if(ss==value.itemId)
				 {
					 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
				 }
				 else
				 {
					 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
				 }
				 option+=$opt;
			 });
			 //级联 input_num 子项
			 inputItemType(ss);
			 $("#inputItemType").html(option);
		 }
		 else if(item_Type==6)
		 {
			 var temp0=$("#itemLinktype_h").val();
			 var optionType="<option value='-1'>请选择</option>";
			 $.each(data[0].linkType,function(i,value){
				 if(temp0==value.itemId)
				 {
					 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
				 }
				 else
				 {
					 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
				 }
				 optionType+=$opt;
			 });
			 $("#itemLinktype").html(optionType);
			 
			 var temp1=$("#itemLinktarget_h").val();
			 var optionTarget="<option value='-1'>请选择</option>";
			 $.each(data[0].linkTarget,function(i,value){
				 if(temp1==value.itemId)
				 {
					 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
				 }
				 else
				 {
					 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
				 }
				 optionTarget+=$opt;
			 });
			 $("#itemLinktarget").html(optionTarget);
		 }
	 }
  });	
 }
// 数据来源类型
 $("#sourceType").change(function(){
	 var selected=  $(this).val();
	 sourceType(selected);
	  });
 function sourceType(selected)
 {
	 if(selected==1){
		    $(".source_write").show();
			$(".source_write input").attr("disabled",false);
			$(".source_system").hide();
			$(".source_system  input").attr("disabled",true);
			$(".source_alter").hide();
			$(".source_alter  input").attr("disabled",true);
		  }
		 if(selected==2){
			$(".source_system").show();
			$(".source_system  input").attr("disabled",false);
		    $(".source_write").hide();
			$(".source_write input").attr("disabled",true);
			$(".source_alter").hide();
			$(".source_alter  input").attr("disabled",true);
		  }
		 if(selected==3){
			$(".source_alter").show();
			$(".source_alter  input").attr("disabled",false);
			$(".source_system").hide();
			$(".source_system  input").attr("disabled",true);
		    $(".source_write").hide();
			$(".source_write input").attr("disabled",true);
			
		  }
		 if(selected==4||selected==-1){
			$(".source_alter").hide();
			$(".source_alter  input").attr("disabled",true);
			$(".source_system").hide();
			$(".source_system  input").attr("disabled",true);
		    $(".source_write").hide();
			$(".source_write input").attr("disabled",true);
		  }
 }
 selectAjax();
 $("#sourceAltertable").change(function(){
	 var selected=  $(this).val();
	 selectAjax();
 });
 //数据来源中级联
 function selectAjax()
 {
	 	 $.ajax({
		 type : "post",
		 url : "framework/engine/info/getSelectGroupJson.do",
		 dataType : "json",
		 data : {
		 group_dic_Id : $("#sourceAltertable").val()
	 },
	 error : function() {
		 alert("Ajax请求数据失败!");
	 },
	 success:function(data)
	 {
		 var option_v="<option value='-1'>请选择</option>";
		 var temp_v=$("#itemDatatype_h").val();
		 
		 var option_k="<option value='-1'>请选择</option>";
		 var temp_k=$("#itemDatatype_h").val();
		 
		 var option_o="<option value='-1'>请选择</option>";
		 var temp_o=$("#itemDatatype_h").val();
		 
		 $.each(data,function(i,value){
			 if(temp_v==value.itemId)
			 {
				 var $opt_v="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
			 }
			 else
			 {
				 var $opt_v="<option value='"+value.itemId+"'>"+value.name+"</option>";	
			 }
			 if(temp_k==value.itemId)
			 {
				 var $opt_k="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
			 }
			 else
			 {
				 var $opt_k="<option value='"+value.itemId+"'>"+value.name+"</option>";	
			 }
			 if(temp_o==value.itemId)
			 {
				 var $opt_o="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
			 }
			 else
			 {
				 var $opt_o="<option value='"+value.itemId+"'>"+value.name+"</option>";	
			 }
			 option_v+=$opt_v;
			 option_k+=$opt_k;
			 option_o+=$opt_o;
		 });
		 
		 $("#sourceAlterviewfield").html(option_v);
		 $("#sourceAlterkeyfield").html(option_k);
		 $("#sourceAlterorderfield").html(option_o);
		 
	 }
	 });	
 }
  //input指标 数据类型 改变
 $("#inputItemType").change(function(){
	 var selected=  $(this).val();
	 inputItemType(selected);
	  });
 function inputItemType(selected) {
	 if(selected==1){
		 inputItemTypeSelectAjax(selected);
	    $(".input_num").show();
		$(".input_num input").attr("disabled",false);
		$(".input_text").hide();
		$(".input_text  input").attr("disabled",true);
		$(".input_date").hide();
		$(".input_date  input").attr("disabled",true);
	  }
	 if(selected==2){
		$(".input_text").show();
		$(".input_text  input").attr("disabled",false);
		$(".input_num").hide();
		$(".input_num   input").attr("disabled",true);
		$(".input_date").hide();
		$(".input_date  input").attr("disabled",true);
	  }
	 if(selected==3){
		 inputItemTypeSelectAjax(selected);
		$(".input_date").show();
		$(".input_date  input").attr("disabled",false);
		$(".input_text").hide();
		$(".input_text  input").attr("disabled",true);
		$(".input_num").hide();
		$(".input_num   input").attr("disabled",true);
	  }
	 if(selected==-1){
		$(".input_text").hide();
		$(".input_text  input").attr("disabled",true);
		$(".input_num").hide();
		$(".input_num   input").attr("disabled",true);
		$(".input_date").hide();
		$(".input_date  input").attr("disabled",true);
		$(".Item_Image  input").attr("disabled",true);
		$(".Item_Link  input").attr("disabled",true);
		$(".Item_Div  input").attr("disabled",true);
	  }
 }
	 //
	 function inputItemTypeSelectAjax(input_item_Type)
	 {
		 $.ajax({
			 type : "post",
			 url : "framework/engine/info/inputItemTypeSelectJson.do",
			 dataType : "json",
			 data : {
			 input_item_Type :input_item_Type
		 },
		 error : function() {
			 alert("Ajax请求数据失败!");
		 },
		 success:function(data)
		 {
			 if(input_item_Type==1)
			 {
				 var optionFormat="";
				 var temp0=$("#inputDataFormat_h").val();
				 $.each(data[0].inputDataFormat,function(i,value){
					 if(temp0==value.itemId)
					 {
						 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
					 }
					 else
					 {
						 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
					 }
					 optionFormat+=$opt;
				 });
				 $("#inputDataFormat").html(optionFormat);
				 
				 var optionType="";
				 var temp1=$("#inputDataType_h").val();
				 $.each(data[0].inputDataType,function(i,value){
					 if(temp1==value.itemId)
					 {
						 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
					 }
					 else
					 {
						 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
					 }
					 optionType+=$opt;
				 });
				 $("#inputDataType").html(optionType);
			 }
			 else if(input_item_Type==3)
			 {
				 var option="";
				 var temp=$("#itemDateDataType_h").val();
				 $.each(data,function(i,value){
					 if(temp==value.itemId)
					 {
						 var $opt="<option value='"+value.itemId+"'selected='selected' >"+value.name+"</option>";	
					 }
					 else
					 {
						 var $opt="<option value='"+value.itemId+"'>"+value.name+"</option>";	
					 }
					 option+=$opt;
				 });
				 
				 $("#itemDateDataType").html(option);
			 }
		 }
	  });	
	 }


	});