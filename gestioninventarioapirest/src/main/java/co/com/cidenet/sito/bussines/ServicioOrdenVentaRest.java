/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.bussines;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cidenet.sito.modelo.OrdenVentaEncabezado;
import co.com.cidenet.sito.modelo.OrdenVentaDetalle;
import co.com.cidenet.sito.modelo.Empleados;
import co.com.cidenet.sito.modelo.Productos;

import co.com.cidenet.sito.util.ConstanteServicioProductos;
import co.com.cidenet.sito.util.WebUtilUsuarios;
import co.com.cidenet.sito.integration.ServicioOrdenVenta;
import co.com.cidenet.sito.integration.ServicioEmpleados;

/**
 * Clase que se encarga de proveer el servicio rest
 * para procesar los datos de las ventas
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ServicioOrdenVentaRest {
	
	@Autowired
	private ServicioOrdenVenta servicioOrdenVenta;	
	@Autowired
	private ServicioEmpleados servicioEmpleados;

	/**
	 * Metodo que se encarga de listar los datos de ventas
	 * retorna la lista de ventas o null 
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return List<OrdenVentaEncabezado> , CONSTANTE_NULL de tipo List
	 */	
	@PostMapping("/ventas/lista")
	@ResponseBody
	public  List<OrdenVentaEncabezado> listarVentas(){
		try {
			return servicioOrdenVenta.obtenerVentasEncabezado();
		}catch (Exception e) {
			return ConstanteServicioProductos.CONS_VENTA_ENC_NULL;
		}
	}
	
	/**
	 * Metodo que se encarga de listar los datos detalle ventas
	 * retorna la lista de ventas o null 
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return List<OrdenVentaDetalle> , CONSTANTE_NULL de tipo List
	 */	
	@PostMapping("/ventasdetalle/lista")
	@ResponseBody
	public  List<OrdenVentaDetalle> listarVentasDetalle(){
		try {
			return servicioOrdenVenta.obtenerVentasDetalle();
		}catch (Exception e) {
			return ConstanteServicioProductos.CONS_VENTA_DET_NULL;
		}
	}	
	
	/**
	 * Metodo que se encarga de almacenar los datos de ventas
	 * retorna un mensaje de exito o error de guardado en base de datos
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param cliente objeto de tipo Clientes
	 * 
	 * @return CONSTANTE_OK, CONSTANTE_ERROR de tipo String
	 * 
	 */	
	@PostMapping("ventas")
	@ResponseBody	
	public String guardarVentas(@QueryParam("codigoProducto") String codigoProducto,
			@QueryParam("precioProducto") double precioProducto,
			@QueryParam("cantidadProducto") int cantidadProducto,
			@QueryParam("identificacionUsuario") String identificacionUsuario) {
		try {		
 			int ordenId = ((int)(Math.random()*100));//.substring(0, 3) );
			Empleados empleado = new Empleados();
			empleado.setIdempleado(identificacionUsuario);
			//Se genera la venta
			OrdenVentaEncabezado ordenVentaEncabezado = new OrdenVentaEncabezado(ordenId,
					identificacionUsuario,
					"Cidenet",
					LocalDate.now().toString());
			
			Productos productos = new Productos();
			productos.setCodigoProducto( codigoProducto );
			OrdenVentaDetalle ordenVentaDetalle = new OrdenVentaDetalle(ordenId,
					codigoProducto,
					precioProducto,
					cantidadProducto);
			
			servicioOrdenVenta.guardarVentas(ordenVentaEncabezado, ordenVentaDetalle);
		}catch(Exception ex) {
			return ConstanteServicioProductos.CONSTANTE_ERROR;
		}
		return ConstanteServicioProductos.CONSTANTE_OK;		
	}
}

