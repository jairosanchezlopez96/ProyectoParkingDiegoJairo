/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.time.LocalDate;

/**
 *
 * @author jairo
 */
public class ClienteVO {
    private int cod_Cliente;
    private LocalDate fec_in_abono;
     
    private LocalDate fec_fin_abono;
    private String nombre;
    private String tarjeta;
    private int tipo_Abono;
    private String email;

    public ClienteVO(int cod_Cliente, LocalDate fec_in_abono, LocalDate fec_fin_abono, String nombre, String tarjeta, int tipo_Abono, String email) {
        this.cod_Cliente = cod_Cliente;
        this.fec_in_abono = fec_in_abono;
        this.fec_fin_abono = fec_fin_abono;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.tipo_Abono = tipo_Abono;
        this.email = email;
    }

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public LocalDate getFec_in_abono() {
        return fec_in_abono;
    }

    public void setFec_in_abono(LocalDate fec_in_abono) {
        this.fec_in_abono = fec_in_abono;
    }

    public LocalDate getFec_fin_abono() {
        return fec_fin_abono;
    }

    public void setFec_fin_abono(LocalDate fec_fin_abono) {
        this.fec_fin_abono = fec_fin_abono;
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
        return "ClienteVO{" + "cod_Cliente=" + cod_Cliente + ", fec_in_abono=" + fec_in_abono + ", fec_fin_abono=" + fec_fin_abono + ", nombre=" + nombre + ", tarjeta=" + tarjeta + ", tipo_Abono=" + tipo_Abono + ", email=" + email + '}';
    }
    
    
}
