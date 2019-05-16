/*
 * Clase para mapear los datos de la tabla Vehiculo
 */
package daw.Jairo.modelo;

import java.time.LocalDate;

public class VehiculoVO {
    private int codvehiculo;
    private String matricula;
    private int tipo_Vehiculo;
    private String descripcion;

    public VehiculoVO(int codvehiculo, String matricula, int tipo_Vehiculo, String descripcion) {
        this.codvehiculo = codvehiculo;
        this.matricula = matricula;
        this.tipo_Vehiculo = tipo_Vehiculo;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "VehiculoVO{" + "codvehiculo=" + codvehiculo + ", matricula=" + matricula + ", tipo_vehiculo=" + tipo_Vehiculo + ", descripcion=" + descripcion + '}';
    }

    

}
