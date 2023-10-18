package co.edu.uniquindio.programacion3.hilos_CreacionV0;

public class MiHilo3 implements Runnable{
	Thread hilo;

	//Construye un nuevo hilo.
	public MiHilo3(String nombre){
		hilo= new Thread(this,nombre);
	}

	//Un m�todo de f�brica que crea e inicia un hilo.
	public static MiHilo3 crearYComenzar (String nombre){
		MiHilo3 miHilo=new MiHilo3(nombre);
		miHilo.hilo.start(); //Inicia el hilo
		return miHilo;
	}

	//Punto de entrada de hilo.
	public void run(){
		System.out.println(hilo.getName()+" iniciando.");
		try {
			for (int count=0; count<10;count++){
				Thread.sleep(4000);
				System.out.println("En "+hilo.getName()+ ", el recuento es "+count);
			}
		}catch (InterruptedException exc){
			System.out.println(hilo.getName()+ " interrumpudo.");
		}
		System.out.println(hilo.getName()+" terminado.");
	}
}
