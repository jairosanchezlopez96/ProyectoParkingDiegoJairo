/*
 * Clase para mapear los datos de la tabla Vehiculo
 */
package daw.Jairo.modelo;

import java.util.Objects;

public class VehiculoVO {

    private int cod_Vehiculo;
    private String matricula;
    private int tipo_Vehiculo;

    public VehiculoVO(int codvehiculo, String matricula, int tipo_Vehiculo) {
        this.cod_Vehiculo = codvehiculo;
        this.matricula = matricula;
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    public VehiculoVO() {

    }

    public int getCod_Vehiculo() {
        return cod_Vehiculo;
    }

    public void setCod_Vehiculo(int cod_Vehiculo) {
        this.cod_Vehiculo = cod_Vehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTipo_Vehiculo() {
        return tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(int tipo_Vehiculo) {
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    @Override
    public String toString() {
        return cod_Vehiculo + "," + matricula + "," + tipo_Vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.cod_Vehiculo;
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + this.tipo_Vehiculo;
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
        final VehiculoVO other = (VehiculoVO) obj;
        if (this.cod_Vehiculo != other.cod_Vehiculo) {
            return false;
        }
        if (this.tipo_Vehiculo != other.tipo_Vehiculo) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

}
