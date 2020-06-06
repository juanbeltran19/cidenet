/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.bussines;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cidenet.sito.modelo.Vendedor;
import co.com.cidenet.sito.modelo.Empleados;
import co.com.cidenet.sito.integration.ServicioEmpleados;
import co.com.cidenet.sito.integration.ServicioVendedores;

import co.com.cidenet.sito.util.ConstanteServicioUsuarios;
import co.com.cidenet.sito.util.WebUtilUsuarios;
import co.com.cidenet.sito.util.ValidacionInformacionUsuario;

/**
 * Clase que se encarga de proveer el servicio rest
 * para procesar los datos de los usuarios
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ServicioUsuariosRest {
	
	@Autowired
	private ServicioEmpleados servicioEmpleados;	
	
	@Autowired
	private ServicioVendedores servicioVendedores;

	/**
	 * Metodo que se encarga de validar los datos de los usuarios
	 * retorna un mensaje de éxito con url o error 
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param identificacionUsuario objeto de tipo String
	 * @param claveUsuario objeto de tipo String
	 * 
	 * @return CONSTANTE_OK, CONSTANTE_ERROR de tipo String
	 * 
	 */	
	@PostMapping("usuarios")
	@ResponseBody	
	public String validarUsuarios(@QueryParam("identificacionUsuario") String identificacionUsuario,
			@QueryParam("claveUsuario") String claveUsuario) {
		String idUsuario =  null;
		String contrasenya = null;
		try {
			//Se obtiene desde la vista datos de usuarios 
			idUsuario = WebUtilUsuarios.decodeBase64(identificacionUsuario);
			contrasenya = WebUtilUsuarios.decodeBase64(claveUsuario);
			//Se consulta los usuarios
			Empleados empleados = servicioEmpleados.consultarEmpleado(idUsuario);
			Optional<Vendedor> vendedor = servicioVendedores.consultarVendendorById(idUsuario);
			//Se valida los usuarios
			if(ValidacionInformacionUsuario.esInformacionUsuarioIgual(idUsuario, empleados.getIdempleado()) 
					&& ValidacionInformacionUsuario.esInformacionUsuarioIgual(contrasenya, empleados.getContrasenya()) ) {
				return ConstanteServicioUsuarios.CONS_URL_USR_EMPLEADO;
			}else if(vendedor.isPresent())  {
				return ConstanteServicioUsuarios.CONS_URL_USR_VENDEDOR;
			}else {
				return ConstanteServicioUsuarios.CONS_MSG_USR;
			}
		}catch(Exception ex) {
			return ConstanteServicioUsuarios.CONSTANTE_ERROR;
		}
	}
}