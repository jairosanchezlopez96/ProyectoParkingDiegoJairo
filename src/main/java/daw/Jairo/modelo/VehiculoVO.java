/*
 * Clase para mapear los datos de la tabla Vehiculo
 */
package daw.Jairo.modelo;

import java.time.LocalDate;

public class VehiculoVO {
    private int codvehiculo;
    private String matricula;
    private String tipo_vehiculo;
    private String descripcion;

    public VehiculoVO(int codvehiculo, String matricula, String tipo_vehiculo, String descripcion) {
        this.codvehiculo = codvehiculo;
        this.matricula = matricula;
        this.tipo_vehiculo = tipo_vehiculo;
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

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "VehiculoVO{" + "codvehiculo=" + codvehiculo + ", matricula=" + matricula + ", tipo_vehiculo=" + tipo_vehiculo + ", descripcion=" + descripcion + '}';
    }

    

}
