/*
 * Clase para mapear los datos de la tabla Vehiculo
 */
package daw.Jairo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class VehiculoVO  {
    
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
        return  cod_Vehiculo + "," + matricula + "," + tipo_Vehiculo;
    }

    

}
