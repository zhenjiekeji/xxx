$(document).ready(function(){
$("#ckall").click(function(){
var flag = $(this).attr("checked");
// alert(flag);
if(!flag)
$("[name = ck]:checkbox").attr("checked",false);
else
$("[name = ck]:checkbox").attr("checked",true);
});

//全选后，取消某个选中后，全选的checkbox取消选中状态
       $("[name=ck]:checkbox").click(function(){
         var flag = true;
         $("[name=ck]:checkbox").each(function(){
         if(!this.checked)
          {
             flag = false;
          }
         });
           $("#ckall").attr("checked",flag);
            });
});