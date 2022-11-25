package BD;

import javax.swing.*;
import java.sql.*;
public class Conexiones {

    Connection c;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Statement st=null;

    public Conexiones() {
    }

    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_practico1","root","Alphaomega31");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudo establecer " +
                    "la conexion a la base de datos");
            throw new RuntimeException(e);
        }
        return c;
    }

    public void desconectar(){
        try {
            c.close();
            //JOptionPane.showMessageDialog(null,"La base de datos se ha desconectado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void RegistrarAuto(String placa, String marca, String annio,
                              String modelo, String color ){
        if((!placa.isBlank())&&(!marca.isBlank()) &&(!annio.isBlank())&&(!modelo.isBlank()) &&(!color.isBlank())) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_practico1", "root", "Alphaomega31");

                int i = 0;
                ps = c.prepareStatement("SELECT CVE_AUTO FROM AUTO");
                rs = ps.executeQuery();

                while (rs.next()) {
                    i = rs.getInt("CVE_AUTO");
                }
                i = i + 1;

                ps = c.prepareStatement("INSERT INTO AUTO VALUES(?,?,?,?,?,?)");
                ps.setInt(1, i);
                ps.setString(2, placa);
                ps.setString(3, marca);
                ps.setString(4, annio);
                ps.setString(5, modelo);
                ps.setString(6, color);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Se han registrado los datos exitosamente!");
                desconectar();

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error!", "Error", 0);
                throw new RuntimeException(e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", 0);
        }
    }

    public void RegistrarCliente(String nombre, String estado,String municipio,
                                 String colonia,String calle, int numero){
        if((!nombre.isBlank())&&(!estado.isBlank())&&(!municipio.isBlank())&&(!colonia.isBlank())&&(!calle.isBlank())&&(numero==0)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_practico1", "root", "Alphaomega31");

                int i = 0;
                ps = c.prepareStatement("SELECT CVE_CLIENTE FROM CLIENTE");
                rs = ps.executeQuery();

                while (rs.next()) {
                    i = rs.getInt("CVE_CLIENTE");
                }
                i = i + 1;

                ps = c.prepareStatement("INSERT INTO CLIENTE VALUES(?,?,?,?,?,?,?)");
                ps.setInt(1, i);
                ps.setString(2, nombre);
                ps.setString(3, estado);
                ps.setString(4, municipio);
                ps.setString(5, colonia);
                ps.setString(6, calle);
                ps.setInt(7, numero);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se han registrado los datos exitosamente!");
                desconectar();

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error!", "Error", 0);
                throw new RuntimeException(e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vacio", "Error", 0);
        }
    }

   public String ObtenerNombreCliente(int clave_cliente){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c= DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_practico1","root","Alphaomega31");

           String nombre="";

           ps=c.prepareStatement("SELECT NOMBRE FROM cliente WHERE CVE_CLIENTE=?");
           ps.setInt(1,clave_cliente);
           rs=ps.executeQuery();

           while (rs.next()){
                nombre=rs.getString("NOMBRE");
           }
           desconectar();
           return nombre;

       } catch (ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Error",0);
           throw new RuntimeException(e);
       }
   }

   public void AcualizarDireccionCliente(String estado, String municipio, String colonia,
                                         String calle,int num, int cve_cliente){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c= DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_practico1","root","Alphaomega31");

               ps = c.prepareStatement("UPDATE cliente SET ESTADO=?,MUNICIPIO=?,COLONIA=?,CALLE=?,NUMERO=? WHERE CVE_CLIENTE=?");
               ps.setString(1, estado);
               ps.setString(2, municipio);
               ps.setString(3, colonia);
               ps.setString(4, calle);
               ps.setInt(5, num);
               ps.setInt(6, cve_cliente);
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null, "Se ha actualizado la dirección del cliente");
               desconectar();

       } catch (ClassNotFoundException | SQLException e) {
           JOptionPane.showMessageDialog(null,"Ha ocurrido un error!","Error",0);
           throw new RuntimeException(e);
       }
   }
}
