/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.util;

/**
 * Clase utilidad que se encarga de manejo validacion de usuarios
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
public class ValidacionInformacionUsuario {

	private ValidacionInformacionUsuario() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Metodo que se encarga de validar dos strings retorna un true si son
	 * iguales/false si son diferentes
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param cadenaCodificada objeto de tipo String
	 * 
	 * @return true o false de tipo boolean
	 */
	public static boolean esInformacionUsuarioIgual(String parametroUno, String parametroDos) {
		return parametroUno.equals(parametroDos);
	}

}
