
	function setContent(url,param){
		var req = $.ajax({
            url: url,
            type: "GET",
            dataType: "html"
          });
        req.done(function( data ) {
        	$("#main_content").html(data);
        	$('.sharkform').on('submit', function(e) {
                e.preventDefault();
                    $.ajax({
                        url: $(this).attr('action'),
                        type: $(this).attr('method'),
                        dataType: "JSON",
                        data: new FormData(this),
                        processData: false,
                        contentType: false,
                        success: function(result) {
                            if(result[0]==1){
                            	document.getElementById('div_succes').hidden=false;
                            	$('#succes').html(result.substr(1));
                            }
                            if(result[0]==0){
                            	document.getElementById('div_error').hidden=false;
                            	$('#error').html(result.substr(1));
                            }
                        },
                        error: function (xhr, desc, err) {
                            var result=xhr.responseText;
                            if(result[0]==1){
                            	document.getElementById('div_succes').hidden=false;
                            	$('#succes').html(result.substr(1));
                            }
                            if(result[0]==0){
                            	document.getElementById('div_error').hidden=false;
                            	$('#error').html(result.substr(1));
                            }
                           }
                        });
                   });
          });
	}
	
	
	$('.loginform').on('submit', function(e) {
        e.preventDefault();
            $.ajax({
                url: $(this).attr('action'),
                type: $(this).attr('method'),
                dataType: "JSON",
                data: new FormData(this),
                processData: false,
                contentType: false,
                success: function(result) {
                	if(result!=""){
                		alert(result);
                		window.location='index.html';
                	}else{
                		window.location='login.html';
                	}
                },
                error: function (xhr, desc, err) {
                    var result=xhr.responseText;
                    if(result!=""){
                    	alert(result);
                    	window.location='index.html';
                	}else{
                		window.location='login.html';
                	}
                   }
                });
           });
	
	function openModal(url){
		var req = $.ajax({
            url: url,
            type: "GET",
            dataType: "html"
          });
        req.done(function( data ) {
        	$('#md-content').html(data);
        	$('#open-modal').click();
        });
	}