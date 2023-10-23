package co.edu.uniquindio.programacion3.hilos_CreacionV3;

import javax.swing.*;

public class Main {
    static ManejadorHilo manejadorHilo;

    public static void main(String[] args) {
        runUI();
    }

    private static void runUI() {
        JFrame frame = new JFrame("VentanaHilos3");
        frame.setContentPane(new VentanaHilos3().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
