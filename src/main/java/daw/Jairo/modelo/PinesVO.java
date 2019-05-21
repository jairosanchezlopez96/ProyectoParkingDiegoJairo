/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.time.LocalDateTime;

/**
 *
 * @author whizrxt
 */
public class PinesVO {
    private int cod_Vehiculo;
    private int num_Plaza;
    private String pen_Desechable;
    private double coste;
    private LocalDateTime fec_Fin_Pin;
    private LocalDateTime fec_In_Pin;

    public PinesVO(int cod_Vehiculo, int num_Plaza, String pen_Desechable, double coste, LocalDateTime fec_Fin_Pin, LocalDateTime fec_In_Pin) {
        this.cod_Vehiculo = cod_Vehiculo;
        this.num_Plaza = num_Plaza;
        this.pen_Desechable = pen_Desechable;
        this.coste = coste;
        this.fec_Fin_Pin = fec_Fin_Pin;
        this.fec_In_Pin = fec_In_Pin;
    }

    public PinesVO() {
    }

    public int getCod_Vehiculo() {
        return cod_Vehiculo;
    }

    public void setCod_Vehiculo(int cod_Vehiculo) {
        this.cod_Vehiculo = cod_Vehiculo;
    }

    public int getNum_Plaza() {
        return num_Plaza;
    }

    public void setNum_Plaza(int num_Plaza) {
        this.num_Plaza = num_Plaza;
    }

    public String getPen_Desechable() {
        return pen_Desechable;
    }

    public void setPen_Desechable(String pen_Desechable) {
        this.pen_Desechable = pen_Desechable;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public LocalDateTime getFec_Fin_Pin() {
        return fec_Fin_Pin;
    }

    public void setFec_Fin_Pin(LocalDateTime fec_Fin_Pin) {
        this.fec_Fin_Pin = fec_Fin_Pin;
    }

    public LocalDateTime getFec_In_Pin() {
        return fec_In_Pin;
    }

    public void setFec_In_Pin(LocalDateTime fec_In_Pin) {
        this.fec_In_Pin = fec_In_Pin;
    }

    @Override
    public String toString() {
        return "PinesVO{" + "cod_Vehiculo=" + cod_Vehiculo + ", num_Plaza=" + num_Plaza + ", pen_Desechable=" + pen_Desechable + ", coste=" + coste + ", fec_Fin_Pin=" + fec_Fin_Pin + ", fec_In_Pin=" + fec_In_Pin + '}';
    }
    
}
