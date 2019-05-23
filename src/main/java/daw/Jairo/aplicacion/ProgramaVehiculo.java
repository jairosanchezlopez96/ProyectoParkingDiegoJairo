/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.VehiculoDAO;
import daw.Jairo.modelo.VehiculoVO;
import daw.Jairo.modelo.Singleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class ProgramaVehiculo {
    public static void main(String[] args) {
        VehiculoDAO daoPlaza = new VehiculoDAO();
        List<VehiculoVO> listaVehiculo = new ArrayList<>();
        listaVehiculo.add(new VehiculoVO(10, "FRH653", 0));
        listaVehiculo.add(new VehiculoVO(11, "WHSG518", 2));
        VehiculoVO p1 = new VehiculoVO(12, "GEHS264", 1);
        VehiculoVO p10 = new VehiculoVO(13, "SFWF125", 1);

        try {

            System.out.println("Nº plazas insertadas " + daoPlaza.insertVehiculo(listaVehiculo));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<VehiculoVO> nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("Insertar una nueva Plaza");
            daoPlaza.insertVehiculo(p1);
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoPlaza.getAll();

            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("---Borramos una persona-----");
            daoPlaza.deleteVehiculo(p1);
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista despues de Borrar-------------");
            nuevaLista.forEach(System.out::println);

            // FALTA EL UPDATE PLAZA
            System.out.println("Actualizar una plaza");

            daoPlaza.updateVehiculo(4, p10);

            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista despues actualizar -------------");
            nuevaLista.forEach(System.out::println);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
}
