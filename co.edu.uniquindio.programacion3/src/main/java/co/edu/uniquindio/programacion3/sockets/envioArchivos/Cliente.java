package co.edu.uniquindio.programacion3.sockets.envioArchivos;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	File localFile;
	Socket socket;	
	
	DataInputStream input;
	
	BufferedInputStream entradaLocalArchivo;
	BufferedOutputStream flujoSalidaArchivo;
	
	DataOutputStream flujoSalidaDatos;
	
	int puerto = 0;
	int in;
	byte[] byteArray;
	
	//Ruta en el discon del Fichero a transferir
	String rutaArchivoLocal = "C:\\td\\archivos\\";
	String filename;

	public Cliente(int puerto, String filename) {
		this.puerto = puerto;
		this.filename = filename;
		rutaArchivoLocal = rutaArchivoLocal +"\\"+filename;
		localFile = new File( rutaArchivoLocal );
	}


	public void crearConexion() throws UnknownHostException, IOException
	{
		socket = new Socket("localhost", puerto);
	}

	public void enviarArchivo () throws IOException,Exception
	{
		
		entradaLocalArchivo = new BufferedInputStream(new FileInputStream(localFile));
		
		flujoSalidaArchivo = new BufferedOutputStream(socket.getOutputStream());
		
		flujoSalidaDatos=new DataOutputStream(socket.getOutputStream());
		
		
		flujoSalidaDatos.writeUTF(localFile.getName());
		
		//Enviamos el fichero
		byteArray = new byte[8192];
		while ((in = entradaLocalArchivo.read(byteArray)) != -1)
		{
			flujoSalidaArchivo.write(byteArray,0,in);
		}

		entradaLocalArchivo.close();
		flujoSalidaArchivo.close();
		flujoSalidaDatos.close();
	}

}
