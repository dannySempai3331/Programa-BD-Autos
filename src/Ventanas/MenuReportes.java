package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuReportes {
    private JPanel PanelMenuR;
    private JLabel labelTitulo;
    private JButton buttonR1;
    private JButton buttonR2;
    private JButton ButtonR3;
    private JButton buttonR4;
    private JButton buttonRegresar;
    public JFrame frameMR;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    public MenuReportes() {
        prepararFrame();

        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMR.dispose();
            }
        });

        buttonR2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reporte2 r2 = new Reporte2();
            }
        });
        buttonR1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reporte1 r1 = new Reporte1();
            }
        });
        ButtonR3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reporte3 r3 = new Reporte3();
            }
        });
        buttonR4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reporte4 r4 = new Reporte4();
            }
        });
    }

    private void prepararFrame(){
        frameMR=new JFrame("Reportes");
        frameMR.setLocation(dim.width/3,dim.height/3);
        frameMR.setSize(dim.width/3,dim.height/3);
        frameMR.setIconImage(imagen.getImage());
        frameMR.add(PanelMenuR);
        frameMR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMR.setResizable(false);
        frameMR.setVisible(true);
    }
}
