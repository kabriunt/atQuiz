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
			$("#users").html(html);
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

function newUser(){
	//Nos traemos los datos del formulario
	var username = $("#username").val();
	var password = $("#password").val();
	var role = $("#role").val();	
	var name = $("#name").val();
	var surname = $("#surname").val();
    var email = $("#email").val();	
	var dni = $("#dni").val();
	var nonExpiredAccount = $("#nonExpiredAccount").is(":checked");
	var nonLocked = $("#nonLocked").is(":checked");
	var nonExpiredCredentials = $("#nonExpiredCredentials").is(":checked");
	var enabled = $("#enabled").is(":checked");
	$.ajax( {
		type:"POST",
		url:"http://localhost:8081/api/user/admin",
		contentType:"application/json",
		dataType:"text",
		//creamos el json que recibe el servicio web
		data:JSON.stringify( {"username": username,"password": password,
			"role": role,"name":name, "surname": surname,
			"email": email,"dni": dni, "nonExpiredAccount":nonExpiredAccount,
	      "nonLocked": nonLocked, "nonExpiredCredentials": nonExpiredCredentials, "enabled": enabled}),
	    success:function(data){
	    	var html="Usuario registrado con éxito";
	    	$('#responseForCreation').html(html);
	    },
	    error:function(res){
	    	alert("ERROR "+ res.statusText); }
	});
}

function deleteUser(){
	var id = $('#idDelete').val();
	id = id.replace(/\s+/g, '');
	$.ajax({
		type:"DELETE",
		url:"http://localhost:8081/api/user/admin/"+id,
		contentType:"text",
		success:function(data){
			var html = "Se ha borrado el usuario";
			$('#responseForDelete').html(html);
		},
		error:function(res){
		alert("Error "+res.statusText);}
	});
}


function hideUsers() {
    var x = document.getElementById("userTable");
	var y = document.getElementById("hiddableUsers");
    if (x.style.display === "none") {
		y.firstChild.data="-";
        x.style.display = "block";
    } else {
        x.style.display = "none";
		y.firstChild.data="+";
    }
}

function hideUser() {
    var x = document.getElementById("userGet");
	var y = document.getElementById("hiddableUser");
    if (x.style.display === "none") {
		y.firstChild.data="-";
        x.style.display = "block";
    } else {
        x.style.display = "none";
		y.firstChild.data="+";
    }
}

function hidePost() {
    var x = document.getElementById("userPost");
	var y = document.getElementById("hiddablePost");
    if (x.style.display === "none") {
		y.firstChild.data="-";
        x.style.display = "block";
    } else {
        x.style.display = "none";
		y.firstChild.data="+";
    }
}

function hideDelete() {
    var x = document.getElementById("userDelete");
	var y = document.getElementById("hiddableDelete");
    if (x.style.display === "none") {
		y.firstChild.data="-";
        x.style.display = "block";
    } else {
        x.style.display = "none";
		y.firstChild.data="+";
    }
}
