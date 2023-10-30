package co.edu.uniquindio.programacion3.sockets.ejemploEnviaryRecibirPrimitivos;

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
	
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	BufferedReader entrada;
	
	String mensajeCliente;
	
	public AppServidor() {
		// TODO Auto-generated constructor stub
	}
	
	public void iniciarServidor() {
		
		try {
			server = new ServerSocket(puerto);
			while(true)
			{
				System.out.println("Esperando al cliente");
				socketComunicacion = server.accept();
				
				flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
				flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
				
				enviarDatosPrimitivos();
				
				
				System.out.println("Recibiendo datos del cliente");
				recibirDatosPrimitivos();
				
				
				flujoEntrada.close();
				flujoSalida.close();
				socketComunicacion.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	private void recibirDatosPrimitivos() throws IOException {
		
		mensajeCliente = flujoEntrada.readUTF();
		System.out.println(mensajeCliente);
	}
	
	
	private void enviarDatosPrimitivos() throws IOException {
		
		int entero = 2020;
		
		flujoSalida.writeInt(entero);
		System.out.println("Enviando entero:"+ entero);
		
		flujoSalida.writeUTF("Enviando hola");
		System.out.println("Se envio hola");
	}

	
	
	
	
	
	
	
	

}
