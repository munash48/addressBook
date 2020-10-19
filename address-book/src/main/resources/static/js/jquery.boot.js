/**
 * 
 */

$(function(){
	$("#userList").click(function(){
		
		
		fetchList("user");
	});
	
	$("#addressList").on('click', function(){
		
		fetchList("address");
		
	});	
	
});

function addForm(type){
	modifyData("/addressbook/"+type+"/form");
	
}

function editForm(type, id){	
	modifyData("/addressbook/"+type+"/edit/"+id);
	
}

function modifyData(url){
	$.ajax({
		type: "GET",
		url: url,
    	success: function(data){
    	
    	$(".inner-jsp").html(data);
    }
	
	});
	
} 


function fetchList(type){
	modifyData("/addressbook/"+type+"/list");
	
}

function deleteData(type,id){
	
	toastr.warning("<div>Are you sure you want to delete this? </div>"+
			"<div class='btn-goup pull-right'>"+
			"<button type='button' id='confirmationYes' class='btn btn-xs btn-primary'><i class='glyphicon glyphicon-ok'></i> Yes</button>" +
			"<button type='button' class='btn btn-xs btn-default clear'> <i class='glyphicon glyphicon-remove'></i>No</button>" +
			"</div>", "DeleteConfirmation", {
		
		allowHTML: true,
		closeButton:true,
		progressBar: true,
		timeOut: 10000,
		positionClass:"toast-top-center",
		onShown: function(){
			$("#confirmationYes").click(function(){
				
				$.ajax({
					type: "GET",
					url: "/addressbook/"+type+"/delete/"+id,
			    	success: function(data){
			    	
			    		fetchList(type)
			    	
			    		toastr.success(data.message, "Delete Confirmation",{
			    			closeButton: true,
			    			progressBar: true,
							positionClass:"toast-top-center"
			    			
			    		});
			    	}
			});
			});
			
			
			
		
		
	}
	

		
		});
		
	
	
	
}


