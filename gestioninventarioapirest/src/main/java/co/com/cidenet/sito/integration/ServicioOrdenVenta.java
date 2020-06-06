/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.integration;

import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.cidenet.sito.modelo.OrdenVentaEncabezado;
import co.com.cidenet.sito.modelo.Productos;
import co.com.cidenet.sito.modelo.OrdenVentaDetalle;

import co.com.cidenet.sito.persistence.OrdenVentaEncabezadoDAO;
import co.com.cidenet.sito.persistence.OrdenVentaDetalleDAO;
import co.com.cidenet.sito.persistence.ProductoDAO;

import co.com.cidenet.sito.util.ConectarBD;
import co.com.cidenet.sito.util.ConstanteServicioProductos;

/**
 * Clase servicio que se encarga de gestionar la información de los productos
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Service
@Component
@Configuration
@ComponentScan(value = "co.com.cidenet")
public class ServicioOrdenVenta {

	@Autowired
	private OrdenVentaEncabezadoDAO ordenVentaEncabezadoDAO;

	@Autowired
	private OrdenVentaDetalleDAO ordenVentaDetalleDAO;

	@Autowired
	private ProductoDAO productoDAO;

	/**
	 * Metodo que se encarga de guardar registro de venta
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 0/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param producto objeto de tipo Productos
	 */
	public void guardarVentas(OrdenVentaEncabezado ordenVentaEncabezado, OrdenVentaDetalle ordenVentaDetalle) {
		PreparedStatement pStatement = null;
		String salida = "";
		try {
			ConectarBD conectarBD = new ConectarBD(ConstanteServicioProductos.CONSTANTE_BD,
					ConstanteServicioProductos.CONSTANTE_USUARIO, ConstanteServicioProductos.CONSTANTE_PASSWORD);
			
			String query = "insert into orden_venta_encabezado(OrdenID, idempleado, Company, FechaOrden) VALUES (?, ?, ?, ?)";
			
			pStatement = conectarBD.getConexion().prepareStatement(query);
			pStatement.setInt(1, ordenVentaEncabezado.getOrdenId());
			pStatement.setString(2, ordenVentaEncabezado.getIdempleado());
			pStatement.setString(3, ordenVentaEncabezado.getCompany());
			pStatement.setString(4, ordenVentaEncabezado.getFechaorden());
			pStatement.executeUpdate();
			
			query = "insert into orden_venta_detalle(OrdenID, Codigo, ValorUnit, Cantidad) VALUES (?, ?, ?, ?)";
			
			pStatement = conectarBD.getConexion().prepareStatement(query);
			pStatement.setInt(1, ordenVentaDetalle.getOrdenId());
			pStatement.setString(2, ordenVentaDetalle.getIdproducto());
			pStatement.setDouble(3, ordenVentaDetalle.getValorUnitario());
			pStatement.setInt(4, ordenVentaDetalle.getCantidad());
			pStatement.executeUpdate();			
			
		}catch(Exception ex) {
			System.out.println("Exception:"+ex);
		}
	}

	/**
	 * Metodo que se encarga de retornar una lista de ventas
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return listaProductos lista registros de los productos
	 */
	public List<OrdenVentaEncabezado> obtenerVentasEncabezado() {
		List<OrdenVentaEncabezado> listaVentas = new ArrayList<>();
		ordenVentaEncabezadoDAO.findAll().forEach(venta -> listaVentas.add((OrdenVentaEncabezado) venta));
		return listaVentas;
	}

	/**
	 * Metodo que se encarga de retornar una lista detalle de ventas
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return listaProductos lista registros de los productos
	 */
	public List<OrdenVentaDetalle> obtenerVentasDetalle() {
		List<OrdenVentaDetalle> listaVentas = new ArrayList<>();
		ordenVentaDetalleDAO.findAll().forEach(venta -> listaVentas.add((OrdenVentaDetalle) venta));
		return listaVentas;
	}

	/**
	 * Metodo que se encarga de buscar un producto
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Producto registro del producto
	 */
	public Productos consultarProducto(String id) {
		return productoDAO.getOne(id);
	}

	/**
	 * Metodo que se encarga de buscar un producto
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Producto registro del producto
	 */
	public Optional<Productos> consultarProductoById(String id) {
		return productoDAO.findById(id);
	}

	/**
	 * Metodo que se encarga de buscar un producto
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Producto registro del producto
	 */
	public Productos actualizarProducto(String id) {
		return productoDAO.getOne(id);
	}
}
