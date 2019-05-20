/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

/**
 *
 * @author whizrxt
 */
public class ReservaVO {
    private int num_Plaza;
    private int cod_Vehiculo;
    private int cod_cliente;
    private int pin_fijo;

    public ReservaVO() {
    }
    
    public ReservaVO(int num_Plaza, int cod_Vehiculo, int cod_cliente, int pin_fijo) {
        this.num_Plaza = num_Plaza;
        this.cod_Vehiculo = cod_Vehiculo;
        this.cod_cliente = cod_cliente;
        this.pin_fijo = pin_fijo;
    }
    
    public int getNum_Plaza() {
        return num_Plaza;
    }

    public void setNum_Plaza(int num_Plaza) {
        this.num_Plaza = num_Plaza;
    }

    public int getCod_Vehiculo() {
        return cod_Vehiculo;
    }

    public void setCod_Vehiculo(int cod_Vehiculo) {
        this.cod_Vehiculo = cod_Vehiculo;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getPin_fijo() {
        return pin_fijo;
    }

    public void setPin_fijo(int pin_fijo) {
        this.pin_fijo = pin_fijo;
    }

    @Override
    public String toString() {
        return "ReservaVO{" + "num_Plaza=" + num_Plaza + ", cod_Vehiculo=" + cod_Vehiculo + ", cod_cliente=" + cod_cliente + ", pin_fijo=" + pin_fijo + '}';
    }
    
    
}
