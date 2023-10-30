package co.edu.uniquindio.programacion3.productorConsumidor.fabricaTornillos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	Fabrica fabrica = new Fabrica();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecabrica = new JLabel("F\u00E1brica");
		lblFecabrica.setBounds(159, 29, 46, 14);
		contentPane.add(lblFecabrica);
		
		JButton btnIniciarEnsamble = new JButton("Iniciar ensamble");
		btnIniciarEnsamble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread thread = new Thread(fabrica);
				fabrica.ensamblar(true);
				thread.start();
				
				
			}
		});
		btnIniciarEnsamble.setBounds(135, 84, 119, 34);
		contentPane.add(btnIniciarEnsamble);
		
		JButton btnFinalizarEnsamble = new JButton("Finalizar ensamble");
		btnFinalizarEnsamble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fabrica.finalizarEnsamble();
			}
		});
		btnFinalizarEnsamble.setBounds(135, 129, 119, 34);
		contentPane.add(btnFinalizarEnsamble);
	}
}
