package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reporte4 {
    private JPanel panelR4;
    private JLabel labelTitulo;
    private JTable tableR4;
    private JButton buttonRegresar;
    public JFrame frameR4;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    public Reporte4() {
        crearTabla();
        preparaFrame();

        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR4.dispose();
            }
        });
    }
    private void preparaFrame(){
        frameR4=new JFrame("Cuarto Reporte");
        frameR4.setLocation(dim.width/3,dim.height/3);
        frameR4.setSize(dim.width/2,dim.height/2);
        frameR4.setIconImage(imagen.getImage());
        frameR4.add(panelR4);
        frameR4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameR4.setResizable(false);
        frameR4.setVisible(true);
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
            tableR4.setModel(modelo);

            Connection c;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexiones conn = new Conexiones();
            Connection cn = conn.conectar();

            ps=cn.prepareStatement("SELECT auto.cve_auto, auto.placa FROM auto NATURAL INNER JOIN accidente WHERE " +
                    "accidente.FECHA < '2022-01-01' AND accidente.cve_auto = auto.cve_auto");
            rs=ps.executeQuery();

            ResultSetMetaData rsm =rs.getMetaData();
            int cantidadColumnas=rsm.getColumnCount();

            modelo.addColumn("Clave Auto");
            modelo.addColumn("Placa del Auto");

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
