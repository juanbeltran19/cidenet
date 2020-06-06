/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.integration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.cidenet.sito.modelo.Vendedor;
import co.com.cidenet.sito.persistence.VendedorDAO;
/**
 * Clase servicio que se encarga de 
 * gestionar la información de los vendedores
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Service
@Component
@Configuration
@ComponentScan(value = "co.com.cidenet")
public class ServicioVendedores {

	@Autowired
	private VendedorDAO vendedorDAO;
	
	/**
	 * Metodo que se encarga de buscar un vendedor
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Vendedor
	 */
	public Optional<Vendedor> consultarVendendorById(String id) {
		return vendedorDAO.findById(id);
	}		
}