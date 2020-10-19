$(function(){
	

	$("#submitUserForm").submit(function(e){
		
		e.preventDefault();	
		var frm=$("#submitUserForm");
		var data={};
		$.each(this, function(i,v){
			var input =$(v);
			data[input.attr("name")]=input.val();
			delete data["undefined"];
					
		});
		saveRequestData(frm,data,"user");
		
	});
	
	
	$("#submitAddressForm").submit(function(e){
		e.preventDefault();
		
		var frm=$("#submitAddressForm");
		var data={};
		$.each(this, function(i,v){
			var input =$(v);
			data[input.attr("name")]=input.val();
			delete data["undefined"];
					
		});
		saveRequestData(frm,data,"address");
		
	});
		
});
function saveRequestData(frm,data,type){
	
	$.ajax({
		contentType:"application/json; charset=utf-8",
		type:frm.attr("method"),
		url:frm.attr("action"),
		dataType:'json', 
		data:JSON.stringify(data),
		
		success: function (data) {
			if(data.status=="success"){
				
				toastr.success(data.message, data.title, {
					closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
						
				});
				fetchList(type);
				
			} else{
				
				toastr.error(data.message, data.title,{
					closeButton: true,
					progressBar: true,
					allowHtml: true,
					positionClass:"toast-top-center"
				});
				
				
			}
			
			 
		    }
		
	}); 
	
	
}