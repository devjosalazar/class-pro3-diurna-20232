package co.edu.uniquindio.programacion3.hilos_Sincronizacion;

public class MiHilo implements Runnable{
    Thread hilo;
    static Monitor monitor = new Monitor();
    int arreglo[];
    int respuesta;

    //Construye un nuevo hilo.
    MiHilo(String nombre, int arreglo[]){
    	hilo= new Thread(this,nombre);
    	this.arreglo=arreglo;
    }

    //Un m�todo que crea e inicia un hilo
    public static MiHilo creaEInicia (String nombre,int nums[]){
        MiHilo miHilo=new MiHilo(nombre,nums);

        miHilo.hilo.start(); //Inicia el hilo
        return miHilo;
    }
    
    
    //Punto de entrada del hilo
    public void run(){
        int sum;
        System.out.println(hilo.getName()+ " iniciando.");

        respuesta=monitor.sumArray(arreglo);
        System.out.println("Suma para "+hilo.getName()+ " es "+respuesta);
        System.out.println(hilo.getName()+ " terminado.");
    }
}
