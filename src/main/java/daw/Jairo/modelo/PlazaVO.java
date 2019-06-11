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
        return num_Plaza + "," + tarifa + "," + estado_Plaza + "," + tipo_Plazas;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.num_Plaza;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.tarifa) ^ (Double.doubleToLongBits(this.tarifa) >>> 32));
        hash = 79 * hash + this.estado_Plaza;
        hash = 79 * hash + this.tipo_Plazas;
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
        final PlazaVO other = (PlazaVO) obj;
        if (this.num_Plaza != other.num_Plaza) {
            return false;
        }
        if (Double.doubleToLongBits(this.tarifa) != Double.doubleToLongBits(other.tarifa)) {
            return false;
        }
        if (this.estado_Plaza != other.estado_Plaza) {
            return false;
        }
        if (this.tipo_Plazas != other.tipo_Plazas) {
            return false;
        }
        return true;
    }

}
