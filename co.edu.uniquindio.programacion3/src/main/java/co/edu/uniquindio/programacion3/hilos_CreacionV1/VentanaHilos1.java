package co.edu.uniquindio.programacion3.hilos_CreacionV1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHilos1 {

    ManejadorHilo manejadorHilo;
    JPanel rootPanel;
    private JButton main1Button;
    private JButton main2Button;
    private JButton startButtonHS1;
    private JButton stopButtonHS1;
    private JButton startButtonHS2;
    private JButton stopButtonHS2;
    private JButton startButtonHS3;
    private JButton stopButtonHS3;

    public VentanaHilos1() {
        this.manejadorHilo = new ManejadorHilo();
        actionStartHS1();
        actionStartHS2();
        actionStartHS3();
        actionStopHS1();
        actionStopHS2();
        actionStopH3();
    }

    private void actionStartHS1() {
        startButtonHS1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.starHiloServicio1();
            }
        });
    }

    private void actionStopHS1() {
        stopButtonHS1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.detenerHiloServicio1();

            }
        });
    }

    private void actionStartHS2() {
        startButtonHS2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.starHiloServicio2();
            }
        });
    }

    private void actionStopHS2() {
        stopButtonHS2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.detenerHiloServicio2();
            }
        });
    }

    private void actionStartHS3() {
        startButtonHS3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.starHiloServicio3();
            }
        });
    }

    private void actionStopH3() {
        stopButtonHS3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.detenerHiloServicio3();
            }
        });
    }


}
