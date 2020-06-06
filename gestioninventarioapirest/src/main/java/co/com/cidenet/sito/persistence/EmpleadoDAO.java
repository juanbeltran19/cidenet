/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cidenet.sito.modelo.Empleados;
/**
 * interface contrato que implementa 
 * el registro de la información de los empleados
 * 
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 04/06/2020
 * <br><b>Fecha de modificacion : </b> 00/00/0000
 */
@SuppressWarnings("rawtypes")
@Repository
public interface EmpleadoDAO extends JpaRepository<Empleados, String> {
}

