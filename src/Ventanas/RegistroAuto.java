package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroAuto {
    private JPanel panelRegistroAuto;
    private JLabel labelMatricula;
    private JLabel labelMarca;
    private JLabel labelAnnio;
    private JLabel labelModelo;
    private JTextField textFieldPlaca;
    private JTextField textFieldMarca;
    private JTextField textFieldAnnio;
    private JTextField textFieldModelo;
    private JTextField textFieldColor;
    private JLabel labelColor;
    private JButton buttonRegistrar;
    private JButton buttonCerrar;
    private JLabel labelTitulo;
    public JFrame frameRegistro;
    public Conexiones c =new Conexiones();
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();
    ImageIcon imagen = new ImageIcon("226777 (1).png");
    public RegistroAuto() {
        prepararFrame();
        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String placa=textFieldPlaca.getText(),
                        marca=textFieldMarca.getText(),
                        annio=textFieldAnnio.getText(),
                        modelo=textFieldModelo.getText(),
                        color=textFieldColor.getText();

                c.RegistrarAuto(placa,marca,annio,modelo,color);

                textFieldPlaca.setText("");
                textFieldMarca.setText("");
                textFieldAnnio.setText("");
                textFieldModelo.setText("");
                textFieldColor.setText("");
            }
        });

        buttonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRegistro.dispose();
            }
        });
    }
    private void prepararFrame(){
        frameRegistro=new JFrame("Registro Informacion");
        frameRegistro.setSize(dim.width/2,dim.height/3);
        frameRegistro.setLocation(dim.width/3,dim.height/3);
        frameRegistro.setIconImage(imagen.getImage());
        frameRegistro.add(panelRegistroAuto);
        frameRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRegistro.setResizable(false);
        frameRegistro.setVisible(true);
    }
}
