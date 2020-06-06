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
import javax.persistence.Table;

/**
 * Clase modelo que se encarga de persistir la información de las ventas
 * 
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Table(name="orden_venta_encabezado")
public class OrdenVentaEncabezado {

	@Id
	int ordenId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "idempleado", referencedColumnName = "idempleado") })
	Empleados empleados;
	
	@Column
	String company;
	
	@Column
	String fechaorden;
	
	@Column
	String empleado;
	
	public OrdenVentaEncabezado(int ordenId, String empleado, String company, String fechaorden) {
		this.ordenId = ordenId;
		this.empleado = empleado;
		this.company = company;
		this.fechaorden = fechaorden;
	}
	
	public int getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}

	public Empleados getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFechaorden() {
		return fechaorden;
	}

	public void setFechaorden(String fechaorden) {
		this.fechaorden = fechaorden;
	}

	public String getIdempleado() {
		return empleado;
	}

	public void setIdempleado(String empleado) {
		this.empleado = empleado;
	}	
}
