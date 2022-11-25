package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarDireccionCliente {
    private JPanel panelMDC;
    private JLabel labelClave;
    private JTextField textFieldClave;
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelDireccion;
    private JLabel labelEstado;
    private JTextField textFieldEstado;
    private JLabel labelMunicipio;
    private JLabel labelColonia;
    private JTextField textFieldMunicipio;
    private JTextField textFieldColonia;
    private JTextField textFieldCalle;
    private JLabel labelCalle;
    private JLabel labelNo;
    private JTextField textFieldNo;
    private JButton buttonBuscar;
    private JButton buttonActualizar;
    private JButton cancelarButton;

    private JFrame frameDcliente;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    Conexiones c =new Conexiones();

    public ModificarDireccionCliente() {
        prepararFrame();
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameDcliente.dispose();
            }
        });
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldEstado.setText("");
                textFieldMunicipio.setText("");
                textFieldColonia.setText("");
                textFieldCalle.setText("");
                textFieldNo.setText("");
               textFieldNombre.setText(c.ObtenerNombreCliente(Integer.parseInt(textFieldClave.getText())));
               textFieldNombre.setEditable(false);
            }
        });
        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.AcualizarDireccionCliente(textFieldEstado.getText(),textFieldMunicipio.getText(),textFieldColonia.getText(),
                        textFieldCalle.getText(),Integer.parseInt(textFieldNo.getText()),Integer.parseInt(textFieldClave.getText()));

            }
        });
    }

    private void prepararFrame(){
        frameDcliente=new JFrame("Actualizar direccion");
        frameDcliente.setLocation(dim.width/3,dim.height/3);
        frameDcliente.setSize(dim.width/2,dim.height/2);
        frameDcliente.setIconImage(imagen.getImage());
        frameDcliente.add(panelMDC);
        frameDcliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameDcliente.setResizable(false);
        frameDcliente.setVisible(true);
    }
}
