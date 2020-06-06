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

import co.com.cidenet.sito.modelo.Empleados;
import co.com.cidenet.sito.persistence.EmpleadoDAO;
/**
 * Clase servicio que se encarga de 
 * gestionar la información de los empleados
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Service
@Component
@Configuration
@ComponentScan(value = "co.com.cidenet")
public class ServicioEmpleados {

	@Autowired
	private EmpleadoDAO empleadoDAO;

	/**
	 * Metodo que se encarga de buscar un empleados
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Empleado
	 */
	public Empleados consultarEmpleado(String id) {
		return empleadoDAO.getOne(id);
	}
	
	/**
	 * Metodo que se encarga de buscar un empleado
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @return Empleado
	 */
	public Optional<Empleados> consultarEmpleadoById(String id) {
		return empleadoDAO.findById(id);
	}		
}