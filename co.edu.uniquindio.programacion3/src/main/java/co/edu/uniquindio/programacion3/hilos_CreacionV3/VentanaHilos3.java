package co.edu.uniquindio.programacion3.hilos_CreacionV3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHilos3 {
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
    private JTextField textField1;
    private JButton startButtonHS4;
    private JButton stopButtonHS4;
    private JButton startButtonHS5;
    private JButton stopButtonHS5;

    public VentanaHilos3() {
        this.manejadorHilo = new ManejadorHilo();
        actionStartHS1();
        actionStartHS2();
        actionStartHS3();
        actionStartHS4();
        actionStartHS5();
        actionStopHS1();
        actionStopHS2();
        actionStopH3();
        actionStopHS4();
        actionStopHS5();
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

    private void actionStartHS4() {
        startButtonHS4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.starHiloServicio4(Integer.valueOf(textField1.getText()));
            }
        });
    }

    private void actionStopHS4() {
        stopButtonHS4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                manejadorHilo.detenerHiloServicio
            }
        });
    }

    private void actionStartHS5() {
        startButtonHS5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejadorHilo.starHiloServicio5();
            }
        });
    }

    private void actionStopHS5() {
        stopButtonHS5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                manejadorHilo.detenerHiloServicio1();
            }
        });
    }

}
