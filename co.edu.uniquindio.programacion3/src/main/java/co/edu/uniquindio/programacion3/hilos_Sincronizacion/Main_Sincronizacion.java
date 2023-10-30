package co.edu.uniquindio.programacion3.hilos_Sincronizacion;

import java.util.concurrent.Semaphore;

public class Main_Sincronizacion {
    public static void main(String[] args) {
        int arreglo[]={1,2,3,4,5,6,7,8,9,10};
        MiHilo mh1 = MiHilo.creaEInicia("#1",arreglo);
        MiHilo mh2 = MiHilo.creaEInicia("#2",arreglo);
        try {
        	System.out.println("Esperando que los hilos terminen la ejecuci�n");
            mh1.hilo.join();
            mh2.hilo.join();
            System.out.println("Se continua con el flujo principal");
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
    }
}
