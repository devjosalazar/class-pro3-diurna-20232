package co.edu.uniquindio.programacion3.sockets.gui.enviarMensaje.base;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor mimarco=new MarcoServidor();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
}

class MarcoServidor extends JFrame implements Runnable{

	private	JTextArea areatexto;
	
	Thread hiloServicio_servidor;
	
	ServerSocket server;
	Socket socket;
	DataInputStream flujoEntrada;
	String mensaje;
	
	
	
	public MarcoServidor(){

		setBounds(1200,300,280,350);				

		JPanel milamina= new JPanel();

		milamina.setLayout(new BorderLayout());

		areatexto=new JTextArea();

		milamina.add(areatexto,BorderLayout.CENTER);

		add(milamina);

		setVisible(true);
		
		hiloServicio_servidor = new Thread(this);
		hiloServicio_servidor.start();

	}
	
	
	
	@Override
	public void run() {
		
		
		try {
			server = new ServerSocket(8081); //Esta a la escuha en el puerto 8081
			
			while(true){
				socket = server.accept(); //Aceptar las conexion que vengan desde el exterior 
				
				flujoEntrada = new DataInputStream(socket.getInputStream());//10101
				mensaje = flujoEntrada.readUTF();
				flujoEntrada.close();
				areatexto.append("\n"+"  "+mensaje);
				socket.close();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
