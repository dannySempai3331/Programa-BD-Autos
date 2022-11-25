package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel panel1;
    private JLabel labelMensaje;
    private JButton registrarAutoButton;
    private JButton registrarClienteButton;
    private JButton modificarDireccionClienteButton;
    private JButton reportesButton;
    private JButton salirButton;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    JFrame frameMenu;

    private void prepararFrame(){
        frameMenu = new JFrame("Menu");
        frameMenu.setSize(dim.width/3,dim.height/3);
        frameMenu.setLocation(dim.width/3,dim.height/3);
        frameMenu.setIconImage(imagen.getImage());
        frameMenu.add(panel1);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setResizable(false);
        frameMenu.setVisible(true);
    }
    public Menu() {
        prepararFrame();

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
            }
        });
        registrarAutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroAuto ra=new RegistroAuto();
            }
        });
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarCliente rc=new RegistrarCliente();
            }
        });
        modificarDireccionClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarDireccionCliente mdc = new ModificarDireccionCliente();
            }
        });
        reportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReportes mr=new MenuReportes();
            }
        });
    }
}
