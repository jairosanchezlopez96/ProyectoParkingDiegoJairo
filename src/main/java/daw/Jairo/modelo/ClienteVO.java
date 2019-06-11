/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author jairo
 */
public class ClienteVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int cod_Cliente;
    private LocalDate fec_In_Abono;

    private LocalDate fec_Fin_Abono;
    private String nombre;
    private String tarjeta;
    private int tipo_Abono;
    private String email;

    public ClienteVO(int cod_Cliente, LocalDate fec_in_abono, LocalDate fec_fin_abono, String nombre, String tarjeta, int tipo_Abono, String email) {
        this.cod_Cliente = cod_Cliente;
        this.fec_In_Abono = fec_in_abono;
        this.fec_Fin_Abono = fec_fin_abono;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.tipo_Abono = tipo_Abono;
        this.email = email;
    }

    public ClienteVO() {
    }

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public LocalDate getFec_in_abono() {
        return fec_In_Abono;
    }

    public void setFec_in_abono(LocalDate fec_in_abono) {
        this.fec_In_Abono = fec_in_abono;
    }

    public LocalDate getFec_fin_abono() {
        return fec_Fin_Abono;
    }

    public void setFec_fin_abono(LocalDate fec_fin_abono) {
        this.fec_Fin_Abono = fec_fin_abono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getTipo_Abono() {
        return tipo_Abono;
    }

    public void setTipo_Abono(int tipo_Abono) {
        this.tipo_Abono = tipo_Abono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return cod_Cliente + "," + fec_In_Abono + "," + fec_Fin_Abono + "," + nombre + "," + tarjeta + "," + tipo_Abono + "," + email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.cod_Cliente;
        hash = 29 * hash + Objects.hashCode(this.fec_In_Abono);
        hash = 29 * hash + Objects.hashCode(this.fec_Fin_Abono);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.tarjeta);
        hash = 29 * hash + this.tipo_Abono;
        hash = 29 * hash + Objects.hashCode(this.email);
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
        final ClienteVO other = (ClienteVO) obj;
        if (this.cod_Cliente != other.cod_Cliente) {
            return false;
        }
        if (this.tipo_Abono != other.tipo_Abono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.fec_In_Abono, other.fec_In_Abono)) {
            return false;
        }
        if (!Objects.equals(this.fec_Fin_Abono, other.fec_Fin_Abono)) {
            return false;
        }
        return true;
    }
    

}
