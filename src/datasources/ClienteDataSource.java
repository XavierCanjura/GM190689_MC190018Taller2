/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasources;

import java.sql.*;
import modelo.Cliente;
import modelo.Conexion;

/**
 *
 * @author Xavier Canjura
 */
public class ClienteDataSource {
    
    private final String SQL_INSERT = "INSERT INTO clientes(nombres, apellidos, dui, pin) VALUES (?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE clientes SET nombres=?, apellidos=?, dui=?, pin=? WHERE id_cliente=?";
    
    private final String SQL_GET_USER_BY_DUI = "SELECT id_cliente, nombres, apellidos, pin FROM clientes WHERE dui=?";
    
    public int insert(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            
            stmt.setString(index++, cliente.getNombres());
            stmt.setString(index++, cliente.getApellidos());
            stmt.setString(index++, cliente.getDui());
            stmt.setString(index++, cliente.getPin());
            
            rows = stmt.executeUpdate();
        
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public boolean checkUserAuth(String dui, String pin, Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_BY_DUI);
            int index = 1;
            
            stmt.setString(index++, dui);
            rs = stmt.executeQuery();
            
            ResultSetMetaData meta = rs.getMetaData();
            int columnsNumber = meta.getColumnCount();
            if(!rs.next()) return false;
            
            int id_cliente = (int) rs.getObject(1);
            String nombres = (String) rs.getObject(2);
            String apellidos = (String) rs.getObject(3);
            String pinDB = (String) rs.getObject(4);

            if(!pinDB.equals(pin)) return false;

            cliente.setId_cliente(id_cliente);
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setPin(pin);
            cliente.setDui(dui);
            return true;
            
                    
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return false;
    }
}
