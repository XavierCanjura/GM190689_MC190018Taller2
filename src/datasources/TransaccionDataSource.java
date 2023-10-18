/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasources;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Transaccion;

/**
 *
 * @author Xavier Canjura
 */
public class TransaccionDataSource {
    private final String SQL_INSERT = "INSERT INTO transacciones(monto, saldo_anterior, saldo_despues, descripcion, id_cuenta) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_GET_TRANSACCIONES = "SELECT id_transaccion, monto, descripcion, saldo_anterior, saldo_despues FROM transacciones WHERE id_cuenta = ?";
    
    public int insert(Transaccion transaccion){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            
            stmt.setDouble(index++, transaccion.getMonto());
            stmt.setDouble(index++, transaccion.getSaldo_anterior());
            stmt.setDouble(index++, transaccion.getSaldo_despues());
            stmt.setString(index++, transaccion.getDescripcion());
            stmt.setInt(index, transaccion.getId_cuenta());
            
            rows = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public DefaultTableModel getTransacciones(int id_cuenta){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_GET_TRANSACCIONES);
            int index = 1;
            
            stmt.setInt(index, id_cuenta);
            
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnsNumber = meta.getColumnCount();
            
            for(int i = 1; i <= columnsNumber; i++){
                dtm.addColumn(meta.getColumnLabel(i));
            }
            
            while(rs.next()){
                Object[] fila = new Object[columnsNumber];
                for(int i = 0; i < columnsNumber; i++){
                    fila[i] = rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return dtm;
    }
}
