package co.edu.uniquindio.programacion3.sockets.ejemploEnviaryRecibirPrimitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//import javax.xml.ws.handler.MessageContext.Scope;

public class AppCliente {
	
	
	String host;
	int puerto;
	Socket socketComunicacion;
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	int contador = 0;
	
	
	public AppCliente(String host, int puerto) {
		this.puerto = puerto;
		this.host = host;
	}

	
	
	public void iniciarCliente() {
		
		
		try {
			
			while(contador != 10)
			{
				crearConexion();
				
				flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
				flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
				
				recibirDatosPrimitivos();
				
				
				System.out.println("Enviando datos al servidor");
				enviarDatosPrimitivos();
				
				contador++;
				
				flujoEntrada.close();
				flujoSalida.close();
				socketComunicacion.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void enviarDatosPrimitivos() throws IOException {
		
		flujoSalida.writeUTF("Mensaje desde el cliente 2021 -1");
	}
	

	private void recibirDatosPrimitivos() throws IOException {
		
		System.out.println("Datos recibidos del servidor: "+flujoEntrada.readInt());
		System.out.println("Datos recibidos del servidor: "+flujoEntrada.readUTF());
	}



	private void crearConexion() throws IOException {
		socketComunicacion = new Socket(host, puerto);
	}



	
}
