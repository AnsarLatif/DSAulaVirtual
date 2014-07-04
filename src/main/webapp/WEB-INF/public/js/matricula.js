$(window).load(function(){  
	
	$("select#cursoId").change(function(){
		$.getJSON("/DSAulaVirtual/admin/alumno/grupos/"+$(this).val(), function(j){
		  console.log("json: "+j[0].id+" "+j[0].nombre);	
	      var options = '';
	      for (var i = 0; i < j.length; i++) {
	        options += '<option value="' + j[i].id + '" ' ;
	        if(i==0){
	        	options += 'selected';
	        }
	        options += ' >' + j[i].nombre + '</option>';
	      }
	      console.log("options: "+options);
	      $("select#grupoId").html(options);
	    });
	});

});