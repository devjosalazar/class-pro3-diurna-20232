package co.edu.uniquindio.programacion3.sockets.envioArchivos;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor 
{
	ServerSocket server;
	Socket socket;
	int puerto = 0;

	DataOutputStream output;
	DataInputStream flujoEntradaDatos;
	
	BufferedInputStream flujoEntradaArchivo;
	BufferedOutputStream salidaLocalArchivo;
	
	byte[] receivedData;
	int in;
	//Ruta en el disco donde se almacenaran los archivos recibidos
	String rutaRecibidos = "C:\\td\\archivos\\recibidos_servidor\\";
	String nombreArchivo;

	public Servidor(int puerto)
	{
		this.puerto = puerto;
	}


	public void runServer() throws IOException 
	{
		server = new ServerSocket(puerto);

		while ( true ) {
			//Aceptar conexiones
			socket = server.accept();
			
			//Buffer de 1024 bytes
			receivedData = new byte[1024];
			
			flujoEntradaArchivo = new BufferedInputStream(socket.getInputStream());
			flujoEntradaDatos   =new DataInputStream(socket.getInputStream());
			
			//Recibimos el nombre del fichero
			nombreArchivo = flujoEntradaDatos.readUTF();
			nombreArchivo = nombreArchivo.substring(nombreArchivo.indexOf('\\')+1,nombreArchivo.length());
			
			rutaRecibidos = rutaRecibidos +"\\"+nombreArchivo;
			
			//Para guardar fichero recibido
			salidaLocalArchivo = new BufferedOutputStream(new FileOutputStream(rutaRecibidos));
			
			while ((in = flujoEntradaArchivo.read(receivedData)) != -1)
			{
				salidaLocalArchivo.write(receivedData,0,in);
			}
			
			salidaLocalArchivo.close();
			flujoEntradaDatos.close();
		}

	}
}
