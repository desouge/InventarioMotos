
package BASEDATOS;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ModifDatos {
    private Conexion conectar;
    private Datos modelo;
    private Connection con;

    public ModifDatos(){
        conectar = new Conexion();
        modelo = new Datos();
    }
    
    public void insertar(String marca, String patente, int anio, String color, int kms, int precio){
        PreparedStatement ps;
        String sql;
        modelo.setMarca(marca);
        modelo.setPatente(patente);
        modelo.setAnio(anio);
        modelo.setColor(color);
        modelo.setKms(kms);
        modelo.setPrecio(precio);
        try{
            con = conectar.getConexion();
            sql = "insert into motos(marca, patente, anio, color, kms, precio) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getMarca());
            ps.setString(2, modelo.getPatente());
            ps.setInt(3, modelo.getAnio());
            ps.setString(4, modelo.getColor());
            ps.setInt(5, modelo.getKms());
            ps.setInt(6, modelo.getPrecio());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha agregado la moto.");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }  
}

