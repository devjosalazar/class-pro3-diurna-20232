package co.edu.uniquindio.programacion3.hilos_CreacionV0;

public class MainEjemploRunnable {

	public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto MiHilo.
        MiHiloRunnable mh=new MiHiloRunnable("#1");
        
        //Luego, construye un hilo de ese objeto.
        Thread nuevoh=new Thread(mh);
        //Finalmente, comienza la ejecuci�n del hilo.
        nuevoh.start();
        
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
