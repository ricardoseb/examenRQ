/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.EmpleVentana;
import sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Empleado;


public class Registro {
    public static boolean nube;
    public static boolean agregarEmpleado(Empleado empleado) {
            try {
            Connection conexion = Conexion.getConexion(nube);
            String query = "INSERT INTO USUARIO01.RQEMPLEADO(codigo,rut,nombre,apellido,celular,email,sueldo_bruto,est_civil,nom_depto) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = conexion.prepareStatement(query);
            ins.setInt(1, empleado.getCodigo());
            ins.setString(2, empleado.getRut());
            ins.setString(3, empleado.getNombre());
            ins.setString(4, empleado.getApellido());
            ins.setInt(5, empleado.getCelular());
            ins.setString(6, empleado.getEmail());
            ins.setInt(7, empleado.getSueldo());
            ins.setString(8, empleado.getEstadoc());
            ins.setString(9, empleado.getDpto());
            if(ins.executeUpdate()>0){
                return true;
            }
            conexion.close(); 
            } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;
    }
    

    public boolean eliminarEmpleado (int codigo) {
        try {
            Connection conexion = Conexion.getConexion(nube);
            String query = "DELETE FROM USUARIO01.RQEMPLEADO WHERE codigo=?";
            PreparedStatement eli = conexion.prepareStatement(query);
            eli.setString (1, "" +codigo);
            if (eli.executeUpdate() > 0) {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    }
    
   /* public boolean deletePelicula () {
        try {
            Connection conexion = Conexion.getConexion(nube);
            String query = "DELETE FROM USUARIO08.FGPELICULA WHERE precio>2000";
            PreparedStatement eli = conexion.prepareStatement(query);
   //         eli.setString (1, "" +precio);
            if (eli.executeUpdate() > 0) {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    } */
    
    public static boolean modificarEmpleado(Empleado empleado) {
        try {
            Connection conexion = Conexion.getConexion(nube);
            String query = "UPDATE USUARIO01.RQEMPLEADO SET rut=?,nombre=?,apellido=?,"+ " celular=?,email=?,sueldo_bruto=?,"+ " est_civil=?,nom_depto=?"+ " WHERE codigo=?";
            PreparedStatement mod = conexion.prepareStatement(query);
            mod.setString(1, empleado.getRut());
            mod.setString(2, empleado.getNombre());
            mod.setString(3, empleado.getApellido());
            mod.setInt(4, empleado.getCelular());
            mod.setString(5, empleado.getEmail());
            mod.setInt(6, empleado.getSueldo());
            mod.setString(7, empleado.getEstadoc());
            mod.setString(8, empleado.getDpto());
            mod.setInt(9, empleado.getCodigo());
            if (mod.executeUpdate() > 0) {
                return true;
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar " + e.getMessage());
        }
        return false;
    }

    public Empleado buscarPorCodigo(int codigo) {
        
                Empleado empleado = null;
        try {
            Connection conexion = Conexion.getConexion(nube);
            String query = "SELECT * FROM USUARIO01.RQEMPLEADO WHERE codigo=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, codigo);
            //OJO todo SELECT REQUIERE UN LLAMADO executeQuery
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                empleado = new Empleado();
                empleado.setCodigo(rs.getInt("codigo"));
                empleado.setRut(rs.getString("rut"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setCelular(rs.getInt("celular"));
                empleado.setEmail(rs.getString("email"));
                empleado.setSueldo(rs.getInt("sueldo_bruto"));
                empleado.setEstadoc(rs.getString("est_civil"));
                empleado.setDpto(rs.getString("nom_depto"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al buscar por código " + e.getMessage());
        }
        return empleado;
    }
}
