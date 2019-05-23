/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class ProgramaPlaza {
    public static void main(String[] args) {
        PlazaDAO daoReserva = new PlazaDAO();
        List<PlazaVO> listaPlaza = new ArrayList<>();
        listaPlaza.add(new PlazaVO(5, 202.3, 1, 1));
        listaPlaza.add(new PlazaVO(6, 234.24, 1, 1));
        PlazaVO p1 = new PlazaVO(7, 123.2, 0, 0);
        PlazaVO p10 = new PlazaVO(8, 123.24, 1, 2);

        try {

            System.out.println("Nº reservas insertadas " + daoReserva.insertPlaza(listaPlaza));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PlazaVO> nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("Insertar una nueva Reserva");
            daoReserva.insertPlaza(p10);
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoReserva.getAll();

            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("---Borramos una persona-----");
            daoReserva.deletePlaza(p1);
            nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista despues de Borrar-------------");
            nuevaLista.forEach(System.out::println);

            // FALTA EL UPDATE PLAZA
            System.out.println("Actualizar una reserva");

            daoReserva.updatePlaza(13, p10);

            nuevaLista = daoReserva.getAll();
            System.out.println("-------- Lista despues actualizar -------------");
            nuevaLista.forEach(System.out::println);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
}
