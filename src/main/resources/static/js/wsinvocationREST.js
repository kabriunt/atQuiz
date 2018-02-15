/**
 * Método que obtiene todos los estudiantes y los muestra
 */
function getAll(){
	$.ajax({
		type: "GET",
		//va a devolver el contenido en un Json
		dataType: "json",
		//url de nuestro servicio web
		url: "http://localhost:8081/api/user/admin",
		crossDomain : true ,
		//esto se hará en caso de que el servicio web funcione
		success: function(data){
			var html ='<table class="table"><thead class="thead-dark"><tr><th scope="col">Id</th><th scope="col">Username</th> <th scope="col">Password</th></thead><tbody>';
			//bucle que recorre todos los elementos del json 
			$.each(data, function(i,item){		
				html+='<tr>'
					+'<td>' + item.id + '</td>'
					+'<td>' + item.username + '</td>'
					+'<td>'+item.password+'</td>';
					html+='</tr>';
			});
			html+='</tbody></table>';
			//se pasa el contenido a la vista
			$("#content").html(html);
		},		
		//esto se hará en caso de que el servicio web falle
		error:function(res){
			alert("ERROR "+ res.statusText);
		}
	});
}

function getUser(){
	var id = $('#id').val();
	//Quitamos los espacios
	id = id.replace(/\s+/g, '');
	if(id!=""){
		$.ajax({
			type: "GET",
			url: "http://localhost:8081/api/user/admin/"+id,
			success: function(data){
				var html ='<ul class="list-group"><li class="list-group-item">'+data.id+'</li><li class="list-group-item">'+data.username
				+'</li><li class="list-group-item">'+data.password+'</li></ul>';
				$("#user").html(html); 
			},
			error:function(res){
				alert("ERROR "+ res.statusText);
			}
		});
	}
}

function hide() {
    var x = document.getElementById("userTable");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}