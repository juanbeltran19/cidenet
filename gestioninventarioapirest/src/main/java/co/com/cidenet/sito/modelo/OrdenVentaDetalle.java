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

import lombok.Data;

/**
 * Clase modelo que se encarga de persistir la información de las ventas
 * 
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 04/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Table(name="orden_venta_detalle")
public class OrdenVentaDetalle {

	@Id
	int ordenId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "Codigo", referencedColumnName = "Codigo") })
	Productos productos;
	
	@Column
	double valorUnitario;

	@Column
	int cantidad;
	
	@Column
	String idproducto;
	
	
	public OrdenVentaDetalle(int ordenId, String idproducto, double valorUnitario, int cantidad) {
		this.ordenId = ordenId;
		this.idproducto = idproducto;
		this.valorUnitario = valorUnitario;
		this.cantidad = cantidad;
	}
	

	public int getOrdenId() {
		return ordenId;
	}


	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}


	public Productos getProductos() {
		return productos;
	}


	public void setProductos(Productos productos) {
		this.productos = productos;
	}


	public double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}	
}
