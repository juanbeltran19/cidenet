/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Clase modelo que se encarga de persistir 
 * la información de los productos
 * 
 * @version
 * @author juanpbeltran
 * <br><b>Fecha de desarrollo : </b> 02/06/2020
 * <br><b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Table(name="Productos")
public class Productos {

	@Id
	@Column(name="Codigo")
	private String codigoProducto;

	@Column(name="Nombre")
	private String nombreProducto;
	
	@Column(name="Precio")
	private String precioProducto;	
	
	@Column(name="Stock")
	private String stockProducto;		
	
	/**
	 * @return codigoProducto the String to get
	 */	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	/**
	 * @param codigoProducto the String to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	/**
	 * @return nombreProducto the String to get
	 */	
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the String to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return precioProducto the int to get
	 */	
	public String getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * @param precioProducto the int to set
	 */
	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}
	/**
	 * @return stockProducto the int to get
	 */	
	public String getStockProducto() {
		return stockProducto;
	}
	/**
	 * @param stockProducto the int to set
	 */
	public void setStockProducto(String stockProducto) {
		this.stockProducto = stockProducto;
	}	
}