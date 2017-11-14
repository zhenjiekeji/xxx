jQuery(function($){
	
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

/*		
			$(".input1 input").attr("disabled",true);
			$(".input_date  input").attr("disabled",true);
			$(".input_num   input").attr("disabled",true);
			$(".input_text  input").attr("disabled",true);
			$(".text_area  input").attr("disabled",true);
			$(".Item_Image  input").attr("disabled",true);
			$(".Item_Link  input").attr("disabled",true);
			$(".Item_Div  input").attr("disabled",true);
			
			$(".source_alter  input").attr("disabled",true);
			$(".source_system  input").attr("disabled",true);
			$(".source_write input").attr("disabled",true);
			
 
 // 输入类型
		 $("#itemType").change(function(){
			 var selected=  $(this).val();
			 itemType(selected);
			  });

		// 数据来源类型
		 $("#sourceType").change(function(){
			 var selected=  $(this).val();
			 sourceType(selected);
			  });

		  //输入框类型
		 $("#inputItemType").change(function(){
			 var selected=  $(this).val();
			 inputItemType(selected);
			  });*/
		 
	function itemType(selected) {
		 if(selected==1){
			    $(".input1").show();
				$(".input1 input").attr("disabled",false);
				$(".text_area").hide();
				$(".text_area  input").attr("disabled",true);
				
				$(".Item_Image").hide();
				$(".Item_Link").hide();
				$(".Item_Div").hide();
				$(".Item_Image  input").attr("disabled",true);
				$(".Item_Link  input").attr("disabled",true);
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
			 else  if(selected==5){
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
			 else if(selected==6){
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
			 else  if(selected==7){
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
			  
			 else if (selected==-1){
				$(".text_area").hide();
				$(".text_area  input").attr("disabled",false);
				$(".input1").hide();
				$(".input1 input").attr("disabled",false);
				$(".Item_Image").hide();
				$(".Item_Link").hide();
			  }
	}
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
			 else  if(selected==2){
				$(".source_system").show();
				$(".source_system  input").attr("disabled",false);
			    $(".source_write").hide();
				$(".source_write input").attr("disabled",true);
				$(".source_alter").hide();
				$(".source_alter  input").attr("disabled",true);
			  }
			 else  if(selected==3){
				$(".source_alter").show();
				$(".source_alter  input").attr("disabled",false);
				$(".source_system").hide();
				$(".source_system  input").attr("disabled",true);
			    $(".source_write").hide();
				$(".source_write input").attr("disabled",true);
			  }
			 else 	 if(selected==4||selected==-1){
				$(".source_alter").hide();
				$(".source_alter  input").attr("disabled",true);
				$(".source_system").hide();
				$(".source_system  input").attr("disabled",true);
			    $(".source_write").hide();
				$(".source_write input").attr("disabled",true);
			  }
	 }
	 function inputItemType(selected) {
			if(selected==1){
			    $(".input_num").show();
				$(".input_num input").attr("disabled",false);
				$(".input_text").hide();
				$(".input_text  input").attr("disabled",true);
				$(".input_date").hide();
				$(".input_date  input").attr("disabled",true);
			  }
			 else  if(selected==2){
				$(".input_text").show();
				$(".input_text  input").attr("disabled",false);
				$(".input_num").hide();
				$(".input_num   input").attr("disabled",true);
				$(".input_date").hide();
				$(".input_date  input").attr("disabled",true);
			  }
			 else if(selected==3){
				$(".input_date").show();
				$(".input_date  input").attr("disabled",false);
				$(".input_text").hide();
				$(".input_text  input").attr("disabled",true);
				$(".input_num").hide();
				$(".input_num   input").attr("disabled",true);
			  }
			 else if(selected==-1){
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
	});