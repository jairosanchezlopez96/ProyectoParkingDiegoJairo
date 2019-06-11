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
    private int cod_Cliente;
    private int pin_fijo;
    private double coste;

    public ReservaVO() {
    }

    public ReservaVO(int num_Plaza, int cod_Vehiculo, int cod_Cliente, int pin_fijo, double coste) {
        this.num_Plaza = num_Plaza;
        this.cod_Vehiculo = cod_Vehiculo;
        this.cod_Cliente = cod_Cliente;
        this.pin_fijo = pin_fijo;
        this.coste = coste;
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

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public int getPin_fijo() {
        return pin_fijo;
    }

    public void setPin_fijo(int pin_fijo) {
        this.pin_fijo = pin_fijo;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return num_Plaza + "," + cod_Vehiculo + "," + cod_Cliente + "," + pin_fijo + "," + coste;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.num_Plaza;
        hash = 47 * hash + this.cod_Vehiculo;
        hash = 47 * hash + this.cod_Cliente;
        hash = 47 * hash + this.pin_fijo;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.coste) ^ (Double.doubleToLongBits(this.coste) >>> 32));
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
        final ReservaVO other = (ReservaVO) obj;
        if (this.num_Plaza != other.num_Plaza) {
            return false;
        }
        if (this.cod_Vehiculo != other.cod_Vehiculo) {
            return false;
        }
        if (this.cod_Cliente != other.cod_Cliente) {
            return false;
        }
        if (this.pin_fijo != other.pin_fijo) {
            return false;
        }
        if (Double.doubleToLongBits(this.coste) != Double.doubleToLongBits(other.coste)) {
            return false;
        }
        return true;
    }

}
