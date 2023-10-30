package co.edu.uniquindio.programacion3.sockets.envioArchivos;

import java.io.IOException;

public class MainServidor {

	public static void main(String[] args) {
		
		
		Servidor miServidor = new Servidor(8081);
		
		try {
			miServidor.runServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
