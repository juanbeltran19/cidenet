/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */

 /**
 * javascript que se encarga de validar los usuarios de la app
 * 
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 05/06/2020
 * <br><b>Fecha de modificacion : </b> 00/00/0000
 */
var urlRoot = "http://localhost:8080/api/v1";
var urlData = "usuarios";

/**
 * Funcion que se encarga de validar las credenciales
 * de los usuarios 
 * 
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b>  00/00/0000
 */ 
function validarUsuario(){
	$("#tCorreo").click();
	if ($("#tCorreo").val() == '') {
		msgAdvertencia("Campo Correo es Requerido.");
		return;
    }    
    $("#tClave").click();
	if ($("#tClave").val() == '') {
		msgAdvertencia("Campo Clave es Requerido.");
		return;
	}        
    var url = urlRoot + "/" + urlData ;
    $.ajax({
        "url": url,
        "async": true,
        "type": "POST",
        "data": {
            "identificacionUsuario":  encode64($("#tCorreo").val()),
            "claveUsuario": encode64($("#tClave").val())         
        },
        "success": function(data) {
            if (data == 'ERROR') {
                msgError("Error al iniciar la sessi&oacuten.", xhr.responseText);
                return;
            } else if(data == 'El usuario no existe registrado en el sistema'){
                msgAdvertencia("El usuario no existe registrado en el sistema.");
            }else{
                localStorage.clear();
                localStorage.setItem("usuario", $("#tCorreo").val());
                location.href = data;
            }
        },
        "error": function(xhr, status, err) {
            msgError("Error al iniciar la sessi&oacuten.", xhr.responseText);
        }
    });    
}



function msgError(texto, data) {
	$("#divMensajeCont").remove();
	$("body").append("<div id='divMensajeCont' style='position: absolute;z-index: 10000;top: 0px;left: 0px;width: 100%;height: 100%;background: rgba(0, 0, 0, 0.5);text-align: center;'><div id='divMensaje' style='position:absolute; background: white;z-index: 10000;top: 50%;left: 5%;width: 90%;padding: 10px;box-sizing: border-box;text-align: center;'><img src='../../img/error.png'/><br/>" + texto + "<button>Aceptar</button></div></div>");
	$("#divMensaje").css("margin-top", "-" + $("#divMensaje").height() / 2 + "px");
	$("#divMensaje>button").bind('touchstart click',function(e) {
		e.preventDefault();
		$("#divMensajeCont").remove();
		$("#divLoading").hide();
	});
}

function msgAdvertencia(texto) {
	$("#divMensajeCont").remove();
	$("body").append("<div id='divMensajeCont' style='position: absolute;z-index: 10000;top: 0px;left: 0px;width: 100%;height: 100%;background: rgba(0, 0, 0, 0.5);text-align: center;'><div id='divMensaje' style='position:absolute; background: white;z-index: 10000;top: 50%;left: 5%;width: 90%;padding: 10px;box-sizing: border-box;text-align: center;'><img src='../../img/info.png'/><br/>" + texto + "<button>Aceptar</button></div></div>");
	$("#divMensaje").css("margin-top", "-" + $("#divMensaje").height() / 2 + "px");
	$("#divMensaje>button").bind('touchstart click',function(e) {
		e.preventDefault();
		$("#divMensajeCont").remove();
		$("#divLoading").hide();
	});
}

