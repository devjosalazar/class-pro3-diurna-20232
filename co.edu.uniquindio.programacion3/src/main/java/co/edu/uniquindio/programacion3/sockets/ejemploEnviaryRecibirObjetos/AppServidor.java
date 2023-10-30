package co.edu.uniquindio.programacion3.sockets.ejemploEnviaryRecibirObjetos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//import javax.xml.ws.handler.MessageContext.Scope;

public class AppServidor {
	
	
	String host = "localhost";
	int puerto = 8081;
	ServerSocket server;
	
	Socket socketComunicacion;
	ObjectOutputStream flujoSalidaObjeto;
	String mensajeCliente;
	
	public AppServidor() {
		// TODO Auto-generated constructor stub
	}
	
	public void iniciarServidor() {
		
		try {
			server = new ServerSocket(puerto);
			
			System.out.println("Esperando cliente");
			socketComunicacion = server.accept();
			
			flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream());
			
			enviarObjeto();
			
			flujoSalidaObjeto.close();
			socketComunicacion.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void enviarObjeto() throws IOException {
		
		Universidad universidad = new Universidad();
		universidad.inicializar();
		System.out.println("Sen envio el objeto universidad: "+universidad.getNombre());
		
		flujoSalidaObjeto.writeObject(universidad);
	}


	

}
