package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reporte2 {
    private JPanel panelR2;
    private JLabel labelTitulo;
    private JTable tableR2;
    private JScrollPane scrollPane;
    private JButton buttonRegresar;
    private JLabel labelTitulo2;

    public JFrame frameR2;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    public Reporte2() {
        crearTabla();
        preparaFrame();

        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR2.dispose();
            }
        });
    }
    private void preparaFrame(){
        frameR2=new JFrame("Segundo Reporte");
        frameR2.setLocation(dim.width/3,dim.height/3);
        frameR2.setSize(dim.width/2,dim.height/2);
        frameR2.setIconImage(imagen.getImage());
        frameR2.add(panelR2);
        frameR2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameR2.setResizable(true);
        frameR2.setVisible(true);
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
            tableR2.setModel(modelo);

            Connection c;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexiones conn = new Conexiones();
            Connection cn = conn.conectar();

            ps=cn.prepareStatement("SELECT TRABAJOS.ID,MECANICO.NOMBRE,TRABAJOS.FECHA_REP " +
                    "FROM TRABAJOS NATURAL INNER JOIN MECANICO ORDER BY FECHA_REP");
            rs=ps.executeQuery();

            ResultSetMetaData rsm =rs.getMetaData();
            int cantidadColumnas=rsm.getColumnCount();

            modelo.addColumn("ID Trabajo");
            modelo.addColumn("Nombre Mecanico");
            modelo.addColumn("Fecha de Reparacion");

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
