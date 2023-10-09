package co.edu.uniquindio.programacion3.hilos_CreacionV0;

public class MiHilo2 extends Thread{

	//Construye un nuevo hilo.
	MiHilo2(String nombre){
    //super se usa para llamar a la versi�n del constructor de Thread
        super(nombre);
    }

	//Punto de entrada del hilo
	public void run(){
		System.out.println(getName()+" iniciando.");

		//Como ExtendThread extiende de Thread, puede llamar directamente
		//a todos los m�todos de Thread, incluido el m�todo getName().
		try {
			for (int cont=0;cont<10;cont++){
				Thread.sleep(400);
				System.out.println("En "+getName()+ ", el recuento es "+cont);
			}
		}catch (InterruptedException exc){
			System.out.println(getName()+ "interrumpido.");
		}
		System.out.println(getName()+ "finalizando.");
	}
}