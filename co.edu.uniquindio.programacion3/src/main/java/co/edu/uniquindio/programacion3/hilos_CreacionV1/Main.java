package co.edu.uniquindio.programacion3.hilos_CreacionV1;

public class Main {

    static ManejadorHilo manejadorHilo;

    public static void main(String[] args) {
        manejadorHilo = new ManejadorHilo();
        initServicio1();
        stopServicio1();
        initServicio2();
        stopServicio2();
        initServicio3();
        stopServicio3();
    }



    private static void initServicio1() {
        manejadorHilo.starHiloServicio1();
    }

    private static void initServicio2() {
        manejadorHilo.starHiloServicio2();
    }

    private static void initServicio3() {
        manejadorHilo.starHiloServicio3();
    }

    private static void stopServicio1() {
        manejadorHilo.detenerHiloServicio1();
    }

    private static void stopServicio2() {
        manejadorHilo.detenerHiloServicio2();
    }

    private static void stopServicio3() {
        manejadorHilo.detenerHiloServicio3();
    }
}
