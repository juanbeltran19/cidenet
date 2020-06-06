/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.util;

/**
 * Clase utilidad que se encarga de manejo valores constantes del servicio de
 * usuarios
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
public class ConstanteServicioUsuarios {

	public static final String CONSTANTE_NULL = null;
	public static final String CONSTANTE_OK = "OK";
	public static final String CONSTANTE_ERROR = "ERROR";
	public static final String CONS_MSG_USR = "El usuario no existe registrado en el sistema";
	public static final String CONS_URL_USR_EMPLEADO = "http://localhost:8081/cidenetapp/pg/pricing/";
	public static final String CONS_URL_USR_VENDEDOR = "http://localhost:8081/clientes.html";
	
	private ConstanteServicioUsuarios() {
		throw new IllegalStateException("Utilidad ConstanteServicioUsuarios class");
	}
}