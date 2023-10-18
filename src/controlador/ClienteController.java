/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import datasources.ClienteDataSource;
import modelo.Cliente;

/**
 *
 * @author Xavier Canjura
 */
public class ClienteController {
    
    ClienteDataSource clientDS = new ClienteDataSource();
    
    public boolean login(String dui, String pin, Cliente cliente){
        
        return clientDS.checkUserAuth(dui, pin, cliente);
    }
    
    public boolean register(Cliente cliente){
        
        int rows = clientDS.insert(cliente);
        
        if(rows == 0) return false;
        
        return true;
        
    }
}
