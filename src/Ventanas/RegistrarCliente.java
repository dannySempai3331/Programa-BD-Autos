package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCliente {
    private JPanel panelResgistroCliente;
    private JLabel labelNombreCliente;
    private JLabel labelDireccion;
    private JTextField textFieldNombre;
    private JLabel labelEstado;
    private JLabel labelMunicipio;
    private JLabel labelNo;
    private JTextField textFieldEstado;
    private JLabel labelColonia;
    private JLabel labelCalle;
    private JTextField textFieldMunicipio;
    private JTextField textFieldColonia;
    private JTextField textFieldCalle;
    private JTextField textFieldNo;
    private JButton registrarButton;
    private JButton Regresarbutton;

    private JFrame frameClienteReg;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");
    public Conexiones c =new Conexiones();
    int no=0;
    public RegistrarCliente() {

        prepararFrame();
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textFieldNo.getText().isBlank()) {
                     no = Integer.parseInt(textFieldNo.getText());
                }
                 else {
                     no=0;
                }
                   c.RegistrarCliente(textFieldNombre.getText(),textFieldEstado.getText(),
                           textFieldMunicipio.getText(),textFieldColonia.getText(),textFieldCalle.getText(),no);

                   textFieldNombre.setText("");
                   textFieldEstado.setText("");
                   textFieldMunicipio.setText("");
                   textFieldColonia.setText("");
                   textFieldCalle.setText("");
                   textFieldNo.setText("");
            }
        });
        Regresarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameClienteReg.dispose();
            }
        });
    }

    private void prepararFrame(){
        frameClienteReg=new JFrame("Registro Cliente");
        frameClienteReg.setSize(dim.width/3,dim.height/2);
        frameClienteReg.setLocation(dim.width/3,dim.height/3);
        frameClienteReg.setIconImage(imagen.getImage());
        frameClienteReg.add(panelResgistroCliente);
        frameClienteReg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameClienteReg.setResizable(false);
        frameClienteReg.setVisible(true);
    }
}
