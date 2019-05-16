/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;


import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
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
        listaPlaza.add(new PlazaVO(42,42.5,1,1));
        listaPlaza.add(new PlazaVO(43,30.2,2,3));
        PlazaVO p1 = new PlazaVO(32,0.1,2, 2);
         PlazaVO p10 = new PlazaVO (4,30,2,1);
             
        
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
            

//            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
//            nuevaLista.forEach(System.out::println);
//            System.out.println("-----------------------------------------");
//            System.out.println("Modificación de la persona con pk 5");
//            System.out.println("Nº Personas modificadas " + 
//                    daoPersona.updatePersona(5, new PersonaVO(7,"NuevoNombre", LocalDate.of(2019, 6, 5))));
//            System.out.println("-----------------------------------------");
//            nuevaLista = daoPersona.getAll();
//            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
//            nuevaLista.forEach(System.out::println);
//            System.out.println("-----------------------------------------");
//            System.out.println("Ejecución del procedimiento almacenado");
//            System.out.println("Se cambia María Weston por Felipe Román");
//            System.out.println("Nombres cambiados " + daoPersona.cambiarNombres("María Weston", "Felipe Román"));
//            System.out.println("-----------------------------------------");
//            nuevaLista = daoPersona.getAll();
//            System.out.println("-------- Lista con datos recogidos desde la B.D despues de ejecutar proced. -------------");
//            nuevaLista.forEach(System.out::println);
//            System.out.println("-----------------------------------------");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        

    }

}
