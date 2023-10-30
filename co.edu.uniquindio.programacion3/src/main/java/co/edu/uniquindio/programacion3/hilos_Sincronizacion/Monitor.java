package co.edu.uniquindio.programacion3.hilos_Sincronizacion;

public class Monitor{
    private int sum;

    //sumArray est� sincronizado
    synchronized int sumArray(int nums[]){
        sum=0;
        for (int i=0; i<nums.length;i++){
            sum+=nums[i];
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+sum);
        try {
            Thread.sleep(1000);//
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido");
        }
        }
        return sum;
    }
}
