/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.ClienteDAO;
import daw.Jairo.modelo.ClienteVO;
import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.Singleton;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class ProgramaCliente {
    public static void main(String[] args) {
         ClienteDAO daoCliente = new ClienteDAO();
        List<ClienteVO> listaCliente = new ArrayList<>();
        listaCliente.add(new ClienteVO());
        listaCliente.add(new ClienteVO());
        ClienteVO p1 = new ClienteVO(10, LocalDate.now(), null, "Diego", "3244DSF", 1, "dosofskfokfss@fidjvd.com");
        ClienteVO p10 = new ClienteVO(11, LocalDate.now(), null, "Jairo", "7543GDF", 0, "iqifkog@urugiog.es");

        try {
            
           System.out.println("Nº plazas insertadas " + daoCliente.insertCliente(listaCliente));
        System.out.println("-----------------------------------------");
        System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
        List<ClienteVO> nuevaLista = daoCliente.getAllClientes();
        System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
        nuevaLista.forEach(System.out::println);
        System.out.println("Insertar una nueva Plaza");
        daoCliente.insertCliente(p1);
        nuevaLista.forEach(System.out::println);
        nuevaLista = daoCliente.getAllClientes();

        System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
        nuevaLista.forEach(System.out::println);
        System.out.println("---Borramos una persona-----");
        daoCliente.deleteCliente(p1);
        nuevaLista = daoCliente.getAllClientes();
        System.out.println("-------- Lista despues de Borrar-------------");
        nuevaLista.forEach(System.out::println);

        // FALTA EL UPDATE PLAZA
        System.out.println("Actualizar una plaza");

        daoCliente.updateCliente(4, p10);

        nuevaLista = daoCliente.getAllClientes();
        System.out.println("-------- Lista despues actualizar -------------");
        nuevaLista.forEach(System.out::println);

    }
    catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
        System.out.println(sqle.getMessage());
    }
    }
    
    }