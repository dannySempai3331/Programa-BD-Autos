package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reporte1 {
    private JPanel panelR1;
    private JLabel labelTitulo;
    private JTable tableR1;
    private JButton buttonRegresar;
    private JLabel labelTitulo1;

    public JFrame frameR1;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    public Reporte1() {
         crearTabla();
         prepararFrame();
        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR1.dispose();
            }
        });
    }

    private void prepararFrame(){
        frameR1=new JFrame("Primer Reporte");
        frameR1.setLocation(dim.width/3,dim.height/3);
        frameR1.setSize(dim.width/2,dim.height/2);
        frameR1.setIconImage(imagen.getImage());
        frameR1.add(panelR1);
        frameR1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameR1.setResizable(false);
        frameR1.setVisible(true);
    }

    private void crearTabla(){
        try {
            DefaultTableModel modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column==1){
                        return false;
                    }
                    else {
                        return false;
                    }
                }
            };
            tableR1.setModel(modelo);

            Connection c;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexiones conn = new Conexiones();
            Connection cn = conn.conectar();

            ps=cn.prepareStatement("SELECT cliente.nombre, accidente.fecha, auto.marca, auto.modelo, auto.color FROM cliente " +
                    "NATURAL INNER JOIN accidente NATURAL INNER JOIN auto WHERE cliente.CVE_CLIENTE = accidente.CVE_CLIENTE ORDER BY accidente.FECHA");
            rs=ps.executeQuery();

            ResultSetMetaData rsm =rs.getMetaData();
            int cantidadColumnas=rsm.getColumnCount();

            modelo.addColumn("Nombre Cliente");
            modelo.addColumn("Fecha de Reparacion");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Color");

            while (rs.next()){
                Object[] filas=new Object[cantidadColumnas];
                for(int i=0;i<cantidadColumnas;i++){

                    filas[i]=rs.getObject(i+1);

                }
                modelo.addRow(filas);
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Error",0);
            throw new RuntimeException(e);
        }
    }
}

