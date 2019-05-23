/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.Singleton;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Programa {

    public static void main(String[] args) {

        PlazaDAO daoPlaza = new PlazaDAO();
        List<PlazaVO> listaPlaza = new ArrayList<>();
        listaPlaza.add(new PlazaVO(42, 42.5, 1, 1));
        listaPlaza.add(new PlazaVO(43, 30.2, 2, 3));
        PlazaVO p1 = new PlazaVO(32, 0.1, 2, 2);
        PlazaVO p10 = new PlazaVO(4, 30, 2, 1);
        // test escribir
        Singleton.EscribirPlaza((ArrayList<PlazaVO>) listaPlaza, "prueba");

        try {

            System.out.println("Nº plazas insertadas " + daoPlaza.insertPlaza(listaPlaza));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<PlazaVO> nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("Insertar una nueva Plaza");
            daoPlaza.insertPlaza(p1);
            nuevaLista.forEach(System.out::println);
            nuevaLista = daoPlaza.getAll();

            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("---Borramos una persona-----");
            daoPlaza.deletePlaza(p1);
            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista despues de Borrar-------------");
            nuevaLista.forEach(System.out::println);

            // FALTA EL UPDATE PLAZA
            System.out.println("Actualizar una plaza");

            daoPlaza.updatePlaza(4, p10);

            nuevaLista = daoPlaza.getAll();
            System.out.println("-------- Lista despues actualizar -------------");
            nuevaLista.forEach(System.out::println);

        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }

}
