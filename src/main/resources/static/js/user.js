$(document).ready(function(data){
	var userId= 1;
	
//	function getName(){
//		 var firstName= '<%= session.getAttribute("id")%>';
//		 alert(firstName);
//		}
	
	function mapRecurrence(recurrence){
		switch(recurrence){
		case 1: return '9:00';
		case 2: return '1:00';
		case 3: return '7:00';
		}
	}
	$.ajax({
    	url: '/users/'+userId+'/today',
    	dataType: 'json',
    	success: function(data){
    	
    		$.each(data, function(i, d) {
 			   var dt = new Date();
			   var time = dt.getHours() + ":" + dt.getMinutes();
			   var strike ="";
 			   if(time.localeCompare(mapRecurrence(data[i].arecurrence)) ){
				   console.log(time);
				   strike="completed_item";
			   }
 			   var row='<li class="list-group-item" id="'+data[i].apillId+'" value="'+data[i].apillId+'">';
			   row+=data[i].apillName+' at <label>'+mapRecurrence(data[i].arecurrence)+'</label><span class="pull-right bigger blue2 glyphicon glyphicon-question-sign"></span> </li>'; 			   	
			   
			   $('#alarmsToday').append(row);
    			   
    			});	
			
    	},
    	error: function(data) {
    		alert('Oops! Error');
    	}
	});
	

	
});

$(document).on('click', '.glyphicon', function(){

	if ($(this).hasClass("glyphicon-question-sign")) {
		var icon = $(this);
		var pillId = $(this).parent().val();
		var alternatives="No alternatives found";
		$.ajax({
	    	url: '/pills/'+pillId+'/alternatives',
	    	dataType: 'json',
	    	success: function(data){
	    		alternatives="";
	    		$.each(data, function(i, d) {
	    			   alternatives+= data[i].pillName+",";
	    			   console.log(data[i].pillName);
	    			   icon.popover({title: "Alternative Pills", content: " "+alternatives,});
	    			});	
				
	    	},
	    	error: function(data) {
	    		alert('Oops! Error');
	    	}
		});
		console.log(alternatives);
	  }
});

$(document).on('click', '.logout', function(){
	console.log("hello");
//	$.post('logout', {}).success(function() {
//		console.log(self.authenticated);
//		self.authenticated = false;
//		location.reload();
//		console.log("logout success");
//	}).error(function(data) {
//		console.log("Logout failed");
//		self.authenticated = false;
//	});
	$.ajax({
		url: '/logout',
	    type: 'POST',
	    	success: function() {
		    	console.log('success');
		    	
		    	//location.reload();
		    }, 
		    error: function (xhr) {
		        var jsonResponse = JSON.parse(xhr.responseText);
		        $(".alert").html(jsonResponse.message);
		      }
	});
	
});


$(document).on('click','#admin', function() {
	window.location.href = '/home';
});

$(document).on('click', '#user' , function() {
	window.location.href = '/userHome';
});