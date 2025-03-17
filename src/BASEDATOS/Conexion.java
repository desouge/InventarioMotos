
package BASEDATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

// CONECTAR

public class Conexion { // Conectarse a la base de datos
    
    String usuario = "root"; // usuario de la base de datos
    String password = ""; // contraseña de la base de datos
    String url = "jdbc:mysql://localhost:3306/roquebd"; // enlace de la base de datos
    String driver = "com.mysql.cj.jdbc.Driver";

    Connection con;
    Statement stmt;
    ResultSet rs;

    public Conexion(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password); // Cadena de conexion
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, password);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public void cerrarConexion(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   // TABLA DE MOTOS EN LA BASE DE DATOS
    
    public void llenarTablaMoto(DefaultTableModel model){ // Llenar la tabla con información de las motos

        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM motos";

            rs = stmt.executeQuery(query);

            while(rs.next()){
                String marca = rs.getString("marca");
                String patente = rs.getString("patente");
                String anio = rs.getString("anio");
                String color = rs.getString("color");
                String kms = rs.getString("kms");
                String precio = rs.getString("precio");

                model.addRow(new Object[]{marca, patente, anio, color, kms, precio});
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
    }
    
    // FILTRAR LA TABLA DE MOTOS
    
    public void filtrarMarca (DefaultTableModel model, String busqueda){ // Filtrar busqueda a traves de caracteres puestos en el cuadro de texto
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM motos WHERE marca LIKE '%"+busqueda+"%'";

            rs = stmt.executeQuery(query);

            while(rs.next()){
                String marca = rs.getString("marca");
                String patente = rs.getString("patente");
                String anio = rs.getString("anio");
                String color = rs.getString("color");
                String kms = rs.getString("kms");
                String precio = rs.getString("precio");

                model.addRow(new Object[]{marca, patente, anio, color, kms, precio});
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        
    }
    
    public void filtrarAnio (DefaultTableModel model, String busqueda){ // Filtrar busqueda a traves de caracteres puestos en el cuadro de texto
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM motos WHERE anio LIKE '%"+busqueda+"%'";

            rs = stmt.executeQuery(query);

            while(rs.next()){
                String marca = rs.getString("marca");
                String patente = rs.getString("patente");
                String anio = rs.getString("anio");
                String color = rs.getString("color");
                String kms = rs.getString("kms");
                String precio = rs.getString("precio");

                model.addRow(new Object[]{marca, patente, anio, color, kms, precio});
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        
    }
    
    public void filtrarPatente (DefaultTableModel model, String busqueda){ // Filtrar busqueda a traves de caracteres puestos en el cuadro de texto
        
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM motos WHERE patente LIKE '%"+busqueda+"%'";

            rs = stmt.executeQuery(query);

            while(rs.next()){
                String marca = rs.getString("marca");
                String patente = rs.getString("patente");
                String anio = rs.getString("anio");
                String color = rs.getString("color");
                String kms = rs.getString("kms");
                String precio = rs.getString("precio");

                model.addRow(new Object[]{marca, patente, anio, color, kms, precio});
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
        
    }

 
    
}

