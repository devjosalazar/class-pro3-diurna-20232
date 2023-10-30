package co.edu.uniquindio.programacion3.sockets.gui.enviarMensaje.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;


public class Cliente {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	private JTextField campo1;
	
	private JButton miboton;
	
	public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("CLIENTE");
		
		add(texto);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		EnviaTexto miEvento = new EnviaTexto();
		miboton.addActionListener(miEvento);
		
		add(miboton);	
		
	}
	
	
	private class EnviaTexto implements ActionListener
	{
		Socket miSocket;
		DataOutputStream flujoSalida;

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(campo1.getText());
			
			try {
				//la direccion o ubicacion del servidor y el peurto por el cual se va aenviar la infromaci�n
				miSocket =  new Socket("localhost", 8081);//Conexi�n (depende del servidor)
				
				
				//Enviar informaci�n por el socket
				flujoSalida = new DataOutputStream(miSocket.getOutputStream());
				
				flujoSalida.writeUTF(campo1.getText());//hola   1011
				flujoSalida.close();
				
				campo1.setText("");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
		

	
}