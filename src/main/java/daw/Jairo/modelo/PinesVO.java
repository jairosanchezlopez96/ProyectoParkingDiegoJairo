/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author whizrxt
 */
public class PinesVO implements Serializable {

    private static final long serialVersionUID = 1L;
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
        return cod_Vehiculo + "," + num_Plaza + "," + pen_Desechable + "," + coste + "," + fec_Fin_Pin_Dia + "," + fec_Fin_Pin_Hora + "," + fec_In_Pin_Dia + "," + fec_In_Pin_Hora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.cod_Vehiculo;
        hash = 67 * hash + this.num_Plaza;
        hash = 67 * hash + Objects.hashCode(this.pen_Desechable);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.coste) ^ (Double.doubleToLongBits(this.coste) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.fec_Fin_Pin_Dia);
        hash = 67 * hash + Objects.hashCode(this.fec_Fin_Pin_Hora);
        hash = 67 * hash + Objects.hashCode(this.fec_In_Pin_Dia);
        hash = 67 * hash + Objects.hashCode(this.fec_In_Pin_Hora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PinesVO other = (PinesVO) obj;
        if (this.cod_Vehiculo != other.cod_Vehiculo) {
            return false;
        }
        if (this.num_Plaza != other.num_Plaza) {
            return false;
        }
        if (Double.doubleToLongBits(this.coste) != Double.doubleToLongBits(other.coste)) {
            return false;
        }
        if (!Objects.equals(this.pen_Desechable, other.pen_Desechable)) {
            return false;
        }
        if (!Objects.equals(this.fec_Fin_Pin_Dia, other.fec_Fin_Pin_Dia)) {
            return false;
        }
        if (!Objects.equals(this.fec_Fin_Pin_Hora, other.fec_Fin_Pin_Hora)) {
            return false;
        }
        if (!Objects.equals(this.fec_In_Pin_Dia, other.fec_In_Pin_Dia)) {
            return false;
        }
        if (!Objects.equals(this.fec_In_Pin_Hora, other.fec_In_Pin_Hora)) {
            return false;
        }
        return true;
    }

}
