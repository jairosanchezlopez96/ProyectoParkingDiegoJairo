/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

/**
 *
 * @author jairo
 */
public class PlazaVO {
    // num plaza pl , estado_Plaza(1-4 
    // 1 -- libre , 2-- ocupada , 3-- abono libre , 4-- abono ocupada
    // tipo_Plazas 1- turismo 2- motocicletas 3- caravanas
    private int num_Plaza;
    private double tarifa;
    private int estado_Plaza;
    private int tipo_Plazas;

    public PlazaVO() {
    }

    @Override
    public String toString() {
        return "PlazaVO{" + "num_Plaza=" + num_Plaza + " tarifa=" + tarifa + " estado_Plaza=" + estado_Plaza + " tipo_Plaza=" + tipo_Plazas + '}';
    }

    public PlazaVO(int num_Plaza, double tarifa, int estado_Plaza, int tipo_Plaza) {
        this.num_Plaza = num_Plaza;
        this.tarifa = tarifa;
        this.estado_Plaza = estado_Plaza;
        this.tipo_Plazas = tipo_Plaza;
    }

    public int getNum_Plaza() {
        return num_Plaza;
    }

    public void setNum_Plaza(int num_Plaza) {
        this.num_Plaza = num_Plaza;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getEstado_Plaza() {
        return estado_Plaza;
    }

    public void setEstado_Plaza(int estado_Plaza) {
        this.estado_Plaza = estado_Plaza;
    }

    public int getTipo_Plazas() {
        return tipo_Plazas;
    }

    public void setTipo_Plazas(int tipo_Plaza) {
        this.tipo_Plazas = tipo_Plaza;
    }
   
    
    
}
