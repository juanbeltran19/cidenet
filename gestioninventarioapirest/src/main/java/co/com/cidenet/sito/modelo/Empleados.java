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
 * Clase modelo que se encarga de persistir la información de los empleados
 * 
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 03/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@Entity
@Table(name="Empleados")
public class Empleados {

	@Id
	String idempleado;

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
	
	public String getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
}
