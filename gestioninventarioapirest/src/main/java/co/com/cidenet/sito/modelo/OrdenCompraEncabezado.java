/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Clase modelo que se encarga de persistir la información de las compras
 * 
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Data
public class OrdenCompraEncabezado {

	@Id
	int ordenId;

	@Column
	String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor") })
	Vendedor vendedores;
	
	@Column
	String company;
	
	@Column
	String fechaorden;
}
