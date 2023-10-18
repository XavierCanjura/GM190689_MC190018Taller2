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
public class Transaccion {
    int id_transaccion;
    double monto;
    double saldo_anterior;
    double saldo_despues;
    String descripcion;
    int id_cuenta;
    
    public Transaccion(){}
    
    public Transaccion(
        int id_transaccion,
        double monto,
        double saldo_anterior,
        double saldo_despues,
        String descripcion,
        int id_cuenta
    ){
        this.id_transaccion = id_transaccion;
        this.monto = monto;
        this.saldo_anterior = saldo_anterior;
        this.saldo_despues = saldo_despues;
        this.descripcion = descripcion;
        this.id_cuenta = id_cuenta;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public double getSaldo_despues() {
        return saldo_despues;
    }

    public void setSaldo_despues(double saldo_despues) {
        this.saldo_despues = saldo_despues;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
}
