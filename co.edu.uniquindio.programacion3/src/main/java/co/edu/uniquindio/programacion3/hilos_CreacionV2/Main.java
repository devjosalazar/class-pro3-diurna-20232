package co.edu.uniquindio.programacion3.hilos_CreacionV2;

import javax.swing.*;

public class Main {

    static ManejadorHilo manejadorHilo;

    public static void main(String[] args) {
        runUI();
    }

    private static void runUI() {
        JFrame frame = new JFrame("VentanaHilos2");
        frame.setContentPane(new VentanaHilos2().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
