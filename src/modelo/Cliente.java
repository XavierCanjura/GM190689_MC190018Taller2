/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Xavier Canjura
 */
public class Cliente {
    int id_cliente;
    String nombres;
    String apellidos;
    String dui;
    String pin;
    
    public Cliente(){}
    
    public Cliente(
        int id_cliente,
        String nombres,
        String apellidos,
        String dui,
        String pin
    ){
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.pin = pin;
    }
    
    public Cliente(
        String nombres,
        String apellidos,
        String dui,
        String pin
    ){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.pin = pin;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
            
}
