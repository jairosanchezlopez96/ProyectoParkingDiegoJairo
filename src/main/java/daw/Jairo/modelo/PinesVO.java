/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author whizrxt
 */
public class PinesVO {
    private int cod_Vehiculo;
    private int num_Plaza;
    private String pen_Desechable;
    private double coste;
    private LocalDate fec_Fin_Pin_Dia;
    private LocalTime fec_Fin_Pin_Hora;
     private LocalDate fec_In_Pin_Dia;
    private LocalTime fec_In_Pin_Hora;

    public PinesVO(int cod_Vehiculo, int num_Plaza, String pen_Desechable, double coste, LocalDate fec_Fin_Pin_Dia, LocalTime fec_Fin_Pin_Hora, LocalDate fec_In_Pin_Dia, LocalTime fec_In_Pin_Hora) {
        this.cod_Vehiculo = cod_Vehiculo;
        this.num_Plaza = num_Plaza;
        this.pen_Desechable = pen_Desechable;
        this.coste = coste;
        this.fec_Fin_Pin_Dia = fec_Fin_Pin_Dia;
        this.fec_Fin_Pin_Hora = fec_Fin_Pin_Hora;
        this.fec_In_Pin_Dia = fec_In_Pin_Dia;
        this.fec_In_Pin_Hora = fec_In_Pin_Hora;
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

    public LocalDate getFec_Fin_Pin_Dia() {
        return fec_Fin_Pin_Dia;
    }

    public void setFec_Fin_Pin_Dia(LocalDate fec_Fin_Pin_Dia) {
        this.fec_Fin_Pin_Dia = fec_Fin_Pin_Dia;
    }

    public LocalTime getFec_Fin_Pin_Hora() {
        return fec_Fin_Pin_Hora;
    }

    public void setFec_Fin_Pin_Hora(LocalTime fec_Fin_Pin_Hora) {
        this.fec_Fin_Pin_Hora = fec_Fin_Pin_Hora;
    }

    public LocalDate getFec_In_Pin_Dia() {
        return fec_In_Pin_Dia;
    }

    public void setFec_In_Pin_Dia(LocalDate fec_In_Pin_Dia) {
        this.fec_In_Pin_Dia = fec_In_Pin_Dia;
    }

    public LocalTime getFec_In_Pin_Hora() {
        return fec_In_Pin_Hora;
    }

    public void setFec_In_Pin_Hora(LocalTime fec_In_Pin_Hora) {
        this.fec_In_Pin_Hora = fec_In_Pin_Hora;
    }

    @Override
    public String toString() {
        return "PinesVO{" + "cod_Vehiculo=" + cod_Vehiculo + ", num_Plaza=" + num_Plaza + ", pen_Desechable=" + pen_Desechable + ", coste=" + coste + ", fec_Fin_Pin_Dia=" + fec_Fin_Pin_Dia + ", fec_Fin_Pin_Hora=" + fec_Fin_Pin_Hora + ", fec_In_Pin_Dia=" + fec_In_Pin_Dia + ", fec_In_Pin_Hora=" + fec_In_Pin_Hora + '}';
    }
   
    
    
    
}
 