/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datasources.CuentaDataSource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xavier Canjura
 */
public class CuentaController {
    
    public boolean createCuenta(int id_cliente){
        CuentaDataSource cuentaDS = new CuentaDataSource();
        
        int rows = cuentaDS.insert(id_cliente);
        
        if(rows == 0) return false;
        
        return true;
    }
    
    public DefaultTableModel getCuentas(int id_cliente){
        
        CuentaDataSource cuentaDS = new CuentaDataSource();
        
        return cuentaDS.getCuentas(id_cliente);
    }
    
    public Object[] getCuentaById(int id_cliente, int id_cuenta){
        
        CuentaDataSource cuentaDS = new CuentaDataSource();
        
        Object[] data = cuentaDS.getCuentaById(id_cliente, id_cuenta);
        
        return data;
    }
    
}
