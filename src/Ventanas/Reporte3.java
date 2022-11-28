package Ventanas;

import BD.Conexiones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reporte3 {
    private JPanel panelR3;
    private JLabel labelTitulo;
    private JButton buttonRegresar;
    private JTable tableR3;

    public JFrame frameR3;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension dim = kit.getScreenSize();

    ImageIcon imagen = new ImageIcon("226777 (1).png");

    public Reporte3() {
        crearTabla();
        prepararFrame();

        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameR3.dispose();
            }
        });
    }

    private void prepararFrame(){
        frameR3=new JFrame("Tercer Reporte");
        frameR3.setLocation(dim.width/3,dim.height/3);
        frameR3.setSize(dim.width/2,dim.height/2);
        frameR3.setIconImage(imagen.getImage());
        frameR3.add(panelR3);
        frameR3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameR3.setResizable(false);
        frameR3.setVisible(true);
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
            tableR3.setModel(modelo);

            Connection c;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexiones conn = new Conexiones();
            Connection cn = conn.conectar();

            ps=cn.prepareStatement("SELECT taller.NOMBRE FROM taller NATURAL INNER JOIN accidente WHERE" +
                    " taller.CVE_TALLER = accidente.CVE_TALLER GROUP BY(taller.NOMBRE)");
            rs=ps.executeQuery();

            ResultSetMetaData rsm =rs.getMetaData();
            int cantidadColumnas=rsm.getColumnCount();

            modelo.addColumn("Nombre Taller");

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
