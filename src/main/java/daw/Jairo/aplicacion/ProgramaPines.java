/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PinesDAO;
import daw.Jairo.modelo.PinesVO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class ProgramaPines {

    public static void main(String[] args) {
        PinesDAO daoPines = new PinesDAO();
        List<PinesVO> listaPines = new ArrayList<>();
        listaPines.add(new PinesVO(10, 2, "SFSF", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now()));
        listaPines.add(new PinesVO(11, 2, "GDHB", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now()));
        PinesVO p1 = new PinesVO(14, 3, "EJCB", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
        PinesVO p10 = new PinesVO(15, 5, "IBGG", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
        PinesVO p11 = new PinesVO(20, 6, "FULW", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
        PinesVO p13 = new PinesVO(14, 3, "FDBF", 123.1, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
        listaPines.add(p11);
        listaPines.add(p10);

        try {

            System.out.println("---Borramos una persona-----");
            daoPines.deletePines(p13);
            System.out.println("Nº reservas insertadas " + daoPines.insertPines(listaPines));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PinesVO> nuevaLista = daoPines.getAllPines();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("Insertar una nueva Reserva");
            daoPines.insertPin(p13);
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoPines.getAllPines();

            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoPines.getAllPines();
            System.out.println("-------- Lista despues de Borrar-------------");
            nuevaLista.forEach(System.out::println);

            // FALTA EL UPDATE PLAZA
            System.out.println("Actualizar una reserva");

            daoPines.updatePin(20, 20, LocalDate.now(), LocalTime.now(), p13);

            nuevaLista = daoPines.getAllPines();
            System.out.println("-------- Lista despues actualizar -------------");
            nuevaLista.forEach(System.out::println);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
}
