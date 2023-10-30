package co.edu.uniquindio.programacion3.sockets.ejemploEnviaryRecibirObjetos;

import java.io.Serializable;

public class Facultad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String codigo;

	public Facultad() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
