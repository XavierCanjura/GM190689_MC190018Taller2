/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datasources.CuentaDataSource;
import datasources.TransaccionDataSource;
import javax.swing.table.DefaultTableModel;
import modelo.Cuenta;
import modelo.Transaccion;

/**
 *
 * @author Xavier Canjura
 */
public class TransaccionController {
    TransaccionDataSource transaccionDS = new TransaccionDataSource();
    CuentaDataSource cuentaDS = new CuentaDataSource();
    
    public int insertTransaccion(double monto, int id_cuenta, double saldo, String descripcion){
        Transaccion transaccion = new Transaccion();
        
        double newSaldo = saldo + monto;
        
        if(newSaldo < 0) return 1;
        
        transaccion.setDescripcion(descripcion);
        transaccion.setId_cuenta(id_cuenta);
        transaccion.setSaldo_anterior(saldo);
        transaccion.setSaldo_despues(newSaldo);
        transaccion.setMonto(monto);
        
        int rows = transaccionDS.insert(transaccion);
        
        if(rows == 0) return 2;
        
        Cuenta cuenta = new Cuenta(id_cuenta, 0, newSaldo);
        cuentaDS.updated(cuenta);
        
        return 0;
    }
    
    public DefaultTableModel getTransaccionesById(int id_cuenta){
     return transaccionDS.getTransacciones(id_cuenta);        
    }
}
