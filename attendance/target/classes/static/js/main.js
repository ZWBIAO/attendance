	$(function(){
	 console.log("1111111");
	$("[data-btn]").click(function(e) {
        var url = $(this).parents("form").attr("action");
		console.log(url);
		var data = $(this).parents("form").serialize();//序列化
		console.log(data);
		
		$.post(url,data,function(result){
			var json = $.parseJSON(result);//解析json
			console.log(json);
			$.each(json,function(idx,obj){
				var name = "[data-error='"+obj.field+"']";
				$(name).html(obj.message);			
		     });		
			});
 	 	  });	 
		 });
