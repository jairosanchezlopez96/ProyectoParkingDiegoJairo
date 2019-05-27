/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.ReservaDAO;
import daw.Jairo.modelo.ReservaVO;
import daw.Jairo.modelo.Singleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class ProgramaReserva {
    public static void main(String[] args) {
        ReservaDAO daoReserva = new ReservaDAO();
        List<ReservaVO> listaReserva = new ArrayList<>();
//        listaReserva.add(new ReservaVO(1, 10, 5, 1, 1.1));
//        listaReserva.add(new ReservaVO(2, 11, 6, 2, 2.2));
        ReservaVO p1 = new ReservaVO(3, 14, 8, 3, 3.3);
        ReservaVO p10 = new ReservaVO(5, 15, 12, 5, 5.5);
        ReservaVO p11 = new ReservaVO(6, 20, 13, 6, 6.6);
        ReservaVO p12 = new ReservaVO(8, 21, 8, 8, 8.8);
//        listaReserva.add(p1);
//        listaReserva.add(p12);
//        listaReserva.add(p11);
//        listaReserva.add(p10);

        try {

            System.out.println("Nº reservas insertadas " + daoReserva.insertReserva(listaReserva));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<ReservaVO> nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("Insertar una nueva Reserva");
            daoReserva.insertReserva(p12);
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoReserva.getAll();

            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("---Borramos una persona-----");
            daoReserva.deleteReserva(p1);
            nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista despues de Borrar-------------");
            nuevaLista.forEach(System.out::println);

            // FALTA EL UPDATE PLAZA
            System.out.println("Actualizar una reserva");

            daoReserva.updateReserva(10, 4, 15, p10);

            nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista despues actualizar -------------");
            nuevaLista.forEach(System.out::println);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
}
