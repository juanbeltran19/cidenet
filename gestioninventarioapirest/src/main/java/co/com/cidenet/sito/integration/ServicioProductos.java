/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.integration;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.cidenet.sito.modelo.Productos;
import co.com.cidenet.sito.persistence.RepositorioProductosDAO;
/**
 * Clase servicio que se encarga de 
 * gestionar la información de los productos
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
public class ServicioProductos {

	@Autowired
	private RepositorioProductosDAO repositorioProductosDAO;

	/**
	 * Metodo que se encarga de retornar una lista de productos
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return listaProductos lista registros de los productos
	 */
	public List<Productos> obtenerListaProductos() {
		List<Productos> listaProductos = new ArrayList<>();
		repositorioProductosDAO.findAll().forEach(producto -> listaProductos.add((Productos) producto));
		return listaProductos;
	}
	
	/**
	 * Metodo que se encarga de guardar registro del producto
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 02/06/2020 <br>
	 *         <b>Fecha de modificacion : </b>  00/00/0000
	 * 
	 * @param producto objeto de tipo Productos
	 */		
	public void guardarProducto(Productos producto) {
		repositorioProductosDAO.save(producto);
	}
}