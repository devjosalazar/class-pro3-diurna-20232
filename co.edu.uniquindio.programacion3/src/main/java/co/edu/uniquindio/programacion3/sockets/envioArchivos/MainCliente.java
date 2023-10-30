package co.edu.uniquindio.programacion3.sockets.envioArchivos;

import java.io.IOException;

public class MainCliente {

	public static void main(String[] args) {


		Cliente miCliente = new Cliente(8081,"Libro1.xlsx");
		
		try {
			miCliente.crearConexion();
			miCliente.enviarArchivo();
			
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
