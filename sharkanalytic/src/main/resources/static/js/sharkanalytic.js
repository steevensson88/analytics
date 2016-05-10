function loadMenu(){
		var req = $.ajax({
            url: '/menu',
            type: "GET",
            dataType: "html"
          });
        req.done(function( data ) {
        	$("#col-left").html(data)
          });
	}
	function loadHeader(){
		var req = $.ajax({
            url: '/header',
            type: "GET",
            dataType: "html"
          });
        req.done(function( data ) {
        	$("#header-navbar").html(data)
          });
	}
	
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
                    	document.getElementById('div_succes').hidden=true;
                    	$('#succes').html(result.substr(1));
                    }
                    if(result[0]==0){
                    	document.getElementById('div_error').hidden=true;
                    	$('#error').html(result.substr(1));
                    }
                },
                error: function (xhr, desc, err) {
                    var result=xhr.responseText;
                    if(result[0]==1){
                    	document.getElementById('div_succes').hidden=true;
                    	$('#succes').html(result.substr(1));
                    }
                    if(result[0]==0){
                    	document.getElementById('div_error').hidden=true;
                    	$('#error').html(result.substr(1));
                    }
                   }
                });
           });