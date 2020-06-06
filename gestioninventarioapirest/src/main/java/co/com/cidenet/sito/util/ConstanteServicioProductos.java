/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.util;

import java.util.List;

import co.com.cidenet.sito.modelo.Productos;
import co.com.cidenet.sito.modelo.OrdenVentaEncabezado;
import co.com.cidenet.sito.modelo.OrdenVentaDetalle;

/**
 * Clase utilidad que se encarga de manejo valores constantes del servicio de
 * productos
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
public class ConstanteServicioProductos {

	public static final String CONSTANTE_OK = "OK";
	public static final String CONSTANTE_ERROR = "ERROR";
	public static final List<Productos> CONSTANTE_NULL = null;
	public static final Productos CONSTANTE_VLR_NULL = null;
	public static final List<OrdenVentaEncabezado> CONS_VENTA_ENC_NULL = null;
	public static final List<OrdenVentaDetalle> CONS_VENTA_DET_NULL = null;
	
	public static final String CONSTANTE_BD = "testdb";
	public static final String CONSTANTE_USUARIO = "sa";
	public static final String CONSTANTE_PASSWORD = "";	

	private ConstanteServicioProductos() {
		throw new IllegalStateException("Utilidad ConstanteServicioProductos class");
	}
}