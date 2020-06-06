/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * Clase modelo que se encarga de persistir la información de los vendedores
 * 
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 03/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Data
public class Vendedor {

	@Id
	String idvendedor;

	@Column
	String contrasenya;

	@Column
	String nombre;

	@Column
	String apellido;

	@Column
	String direccion;

	@Column
	String telefono;
}
