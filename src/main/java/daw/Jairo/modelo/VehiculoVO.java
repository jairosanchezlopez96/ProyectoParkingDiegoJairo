/*
 * Clase para mapear los datos de la tabla Vehiculo
 */
package daw.Jairo.modelo;

import java.time.LocalDate;

public class VehiculoVO {
    private int codvehiculo;
    private String matricula;
    private int tipo_Vehiculo;

    public VehiculoVO(int codvehiculo, String matricula, int tipo_Vehiculo) {
        this.codvehiculo = codvehiculo;
        this.matricula = matricula;
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    public VehiculoVO() {

    }

    public int getCodvehiculo() {
        return codvehiculo;
    }

    public void setCodvehiculo(int codvehiculo) {
        this.codvehiculo = codvehiculo;
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
        return "VehiculoVO{" + "codvehiculo=" + codvehiculo + ", matricula=" + matricula + ", tipo_vehiculo=" + tipo_Vehiculo+ '}';
    }

    

}
