/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.bussines;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cidenet.sito.integration.ServicioProductos;
import co.com.cidenet.sito.modelo.Productos;
import co.com.cidenet.sito.util.ConstanteServicioProductos;

/**
 * Clase que se encarga de proveer el servicio rest
 * para procesar los datos de los productos
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ServicioProductosRest {
	
	@Autowired
	private ServicioProductos servicioProductos;	

	/**
	 * Metodo que se encarga de listar los datos de los productos
	 * retorna la lista de clientes o null 
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return List<Clientes> , CONSTANTE_NULL de tipo List
	 */	
	@PostMapping("/productos/lista")
	@ResponseBody
	public  List<Productos> listarProductos(){
		try {
			return servicioProductos.obtenerListaProductos();
		}catch (Exception e) {
			return ConstanteServicioProductos.CONSTANTE_NULL;
		}
	}
	
	/**
	 * Metodo que se encarga de almacenar los datos de los productos
	 * retorna un mensaje de exito o error de guardado en base de datos
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param cliente objeto de tipo Clientes
	 * 
	 * @return CONSTANTE_OK, CONSTANTE_ERROR de tipo String
	 * 
	 */	
	@PostMapping("productos")
	@ResponseBody	
	public String guardarProductos(@QueryParam("codigoProducto") String codigoProducto,
			@QueryParam("nombreProducto") String nombreProducto,
			@QueryParam("precioProducto") String precioProducto,
			@QueryParam("stockProducto") String stockProducto) {
		try {
			Productos producto = new Productos();
			producto.setCodigoProducto(codigoProducto);
			producto.setNombreProducto(nombreProducto);
			producto.setPrecioProducto(precioProducto);
			producto.setStockProducto(stockProducto);
			servicioProductos.guardarProducto(producto);
		}catch(Exception ex) {
			return ConstanteServicioProductos.CONSTANTE_ERROR;
		}
		return ConstanteServicioProductos.CONSTANTE_OK;		
	}
}
