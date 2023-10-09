package co.edu.uniquindio.programacion3.hilos_CreacionV0;

public class MainEjemplo2_Herencia {

	public static void main(String[] args) {
		System.out.println("Iniciando hilo principal.");

		MiHilo2 mh=new MiHilo2("#1");
		mh.start();

		for (int i=0;i<50;i++){
			System.out.print(".");
			try {
				Thread.sleep(100);
			}catch (InterruptedException exc) {
				System.out.println("Hilo principal interrumpido");
			}
		}
		System.out.println("Hilo principal finalizado");
	}
}
