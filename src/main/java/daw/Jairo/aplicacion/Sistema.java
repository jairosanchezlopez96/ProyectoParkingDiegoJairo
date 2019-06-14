/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.ClienteDAO;
import daw.Jairo.modelo.ClienteVO;
import daw.Jairo.modelo.PinesDAO;
import daw.Jairo.modelo.PinesVO;
import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.ReservaVO;
import daw.Jairo.modelo.Singleton;
import daw.Jairo.modelo.VehiculoDAO;
import daw.Jairo.modelo.VehiculoVO;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author whizrxt
 */
public class Sistema {

    //LISTA DE CLIENTES
    private static ArrayList<ClienteVO> listaCliente;

    //LISTA DE PINES
    private static ArrayList<PinesVO> listaPines;

    //LISTA DE PLAZAS
    private static ArrayList<PlazaVO> listaPlaza;

    //LISTA DE RESERVAS
    private static ArrayList<ReservaVO> listaReserva;

    //LISTA DE VEHICULOS
    private static ArrayList<VehiculoVO> listaVehiculo;

    public static ArrayList<ClienteVO> getListaCliente() {
        return listaCliente;
    }

    public static void setListaCliente(ArrayList<ClienteVO> listaCliente) {
        Sistema.listaCliente = listaCliente;
    }

    public static ArrayList<PinesVO> getListaPines() {
        return listaPines;
    }

    public static void setListaPines(ArrayList<PinesVO> listaPines) {
        Sistema.listaPines = listaPines;
    }

    public static ArrayList<PlazaVO> getListaPlaza() {
        return listaPlaza;
    }

    public static void setListaPlaza(ArrayList<PlazaVO> listaPlaza) {
        Sistema.listaPlaza = listaPlaza;
    }

    public static ArrayList<ReservaVO> getListaReserva() {
        return listaReserva;
    }

    public static void setListaReserva(ArrayList<ReservaVO> listaReserva) {
        Sistema.listaReserva = listaReserva;
    }

    public static ArrayList<VehiculoVO> getListaVehiculo() {
        return listaVehiculo;
    }

    public static void setListaVehiculo(ArrayList<VehiculoVO> listaVehiculo) {
        Sistema.listaVehiculo = listaVehiculo;
    }

    @Override
    public String toString() {
        return "Sistema{" + "listaCliente=" + listaCliente + ", listaPines=" + listaPines + ", listaPlaza=" + listaPlaza + ", listaReserva=" + listaReserva + ", listaVehiculo=" + listaVehiculo + '}';
    }

    //Metodo para elegir la zona
    public static void elegirZona() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;
        PlazaDAO p = new PlazaDAO();
        ClienteDAO c = new ClienteDAO();
        PinesDAO pi = new PinesDAO();
        VehiculoDAO v = new VehiculoDAO();
        ArrayList<PlazaVO> listapla = (ArrayList<PlazaVO>) p.getAll();
        Sistema.setListaPlaza(listapla);
        ArrayList<PinesVO> listapin = (ArrayList<PinesVO>) pi.getAllPines();
        Sistema.setListaPines(listapin);
        ArrayList<ClienteVO> listacli = (ArrayList<ClienteVO>) c.getAllClientes();
        Sistema.setListaCliente(listacli);
        ArrayList<VehiculoVO> listavehiculo = (ArrayList<VehiculoVO>) v.getAll();
        Sistema.setListaVehiculo(listavehiculo);

        System.out.println("Bienvenido al parking, selecciona segun la zona a la que quieras acceder"
                + "\n1. Zona Cliente \n2. Zona Administrador");

        try {

            eleccion = tec.nextInt();
            System.out.println("");

            while (eleccion != 1 && eleccion != 2 && eleccion != 3) {

                System.out.println("Por favor seleccione una opcion correcta");
                eleccion = tec.nextInt();
                tec.nextLine();

            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros");
            tec.nextLine();
        }

        do {

            switch (eleccion) {
                case 1:
                    zonaCliente();
                    break;
                case 2:
                    zonaAdmin();
                    break;
            }

            System.out.println("");
            System.out.println("Bienvenido de nuevo al parking, selecciona segun la zona a la que quieras acceder"
                    + "\n1. Zona Cliente \n2. Zona Administrador \n3. Salir ");
            try {
                eleccion = tec.nextInt();
                tec.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten numeros");
                tec.nextLine();
                break;

            }
        } while (eleccion != 3);
    }

    public static void zonaCliente() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("");
        System.out.println("Bienvenido a la Zona de Cliente. Escoja la accion que desea realizar"
                + "\n1. Depositar vehiculo \n2. Retirar vehiculo \n3. Depositar abonados \n4. Retirar abonados");

        try {
            eleccion = tec.nextInt();
            System.out.println("");

            while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
                System.out.println("");
                tec.nextLine();
            }

            switch (eleccion) {
                case 1:
                    depositarVehiculo();
                    break;
                case 2:
                    retirarVehiculo();
                    break;
                case 3:
                    depositarAbonado();
                    break;
                case 4:
                    retirarAbonado();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros, reinicia el sistema e intentelo de nuevo");
        }
    }

    public static void zonaAdmin() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("");
        System.out.println("Bienvenido a la Zona de Administrador. Escoja la accion que desea realizar"
                + "\n1. Controlar estado del parking \n2. Facturacion"
                + " \n3. Abonos \n4. Caducidad de abonos \n5. Copia de Seguridad");

        try {
            eleccion = tec.nextInt();
            System.out.println("");

            while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
                System.out.println("");
                tec.nextLine();
            }

            switch (eleccion) {
                case 1:
                    controlarParking();
                    break;
                case 2:
                    facturacion();
                    break;
                case 3:
                    abonos();
                    break;
                case 4:
                    caducidadAbonos();
                    break;
                case 5:
                    copiaSeguridad();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros, reinicia el sistema e intentelo de nuevo");
        }
    }

    public static void depositarVehiculo() throws SQLException {
        // EL SISTEMA INFORMA EN TODO MOMENTO DEL NUMERO DE PLAZAS LIBRES
        PlazaDAO objeto = new PlazaDAO();
        ArrayList lista = objeto.plazasLibres();
        VehiculoDAO daop = new VehiculoDAO();
        PinesDAO daov = new PinesDAO();
        System.out.println("Lista de plazas libres");
        enseñarPlazas(lista);
        Scanner teclado = new Scanner(System.in);

        // limpiamos buffer
        teclado.nextLine();
        System.out.println("Introduzca los datos del vehiculo:");
        System.out.println("Codigo Vehiculo");
        int cod = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Matricula");
        String matri = teclado.nextLine();
        System.out.println(" Tipo vehiculo: 1- turismo 2- motocicletas 3- caravanas");
        int tipo = teclado.nextInt();
        System.out.println("Elige numero de plaza");
        int num_Plaza = teclado.nextInt();
        for (int i = 0 ; i< Sistema.getListaPlaza().size();i++) {
            if (Sistema.getListaPlaza().get(i).getNum_Plaza() == num_Plaza) {
                Sistema.getListaPlaza().get(i).setEstado_Plaza(2);
                System.out.println("La plaza numero :" + num_Plaza + " sera ocupada");
              objeto.updatePlaza(num_Plaza, Sistema.getListaPlaza().get(i));
                
            }

        }
        // insertamos el vehiculo en la bbdd y en la lista del sistema
        VehiculoVO v = new VehiculoVO(cod, matri, tipo);
        Sistema.listaVehiculo.add(v);
        daop.insertVehiculo(v);
        // int cod_Vehiculo, int num_Plaza, String pen_Desech
        //able, double coste, LocalDate fec_Fin_Pin_Dia, LocalTime fec_Fin_Pin_Hora, LocalDate fec_In_Pin_Dia, LocalTime fec_In_Pin_Hora
        String contraseña = generarContra();
        // los now son porque ahora pilla la plaza y el max lo cambiamos cuando saque el coche 
        PinesVO pinCoche = new PinesVO(cod, num_Plaza, contraseña, 0, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
        listaPines.add(pinCoche);
        daov.insertPin(pinCoche);

        System.out.println("Matricula: " + v.getMatricula() + " Identificador Plaza: " + num_Plaza + " Pin: " + contraseña);

    }

    public static String generarContra() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("06d", number);
    }

    public static void retirarVehiculo() throws SQLException {
        Scanner tec = new Scanner(System.in);
        System.out.println("Dime el codigo de vehiculo que quieres retirar");
        int numRetiro = tec.nextInt();
        System.out.println("Dime el identificador de plaza");
        int ident = tec.nextInt();
        System.out.println("Dime el pin");
        String contra = tec.nextLine();

        for (PinesVO p : listaPines) {
            if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && p.getPen_Desechable().equalsIgnoreCase(contra)) {
                p.setFec_Fin_Pin_Hora(LocalTime.now());
                p.setFec_Fin_Pin_Dia(LocalDate.now());

            } else {
                System.out.println("El coche ya ha sido retirado");
            }
            // falta caluclo del precio 
            int dias = p.getFec_Fin_Pin_Dia().getDayOfYear() - p.getFec_In_Pin_Dia().getDayOfYear();

            System.out.println("El precio de la reserva es: ");

        }

        VehiculoDAO c = new VehiculoDAO();

        for (VehiculoVO v : Sistema.listaVehiculo) {

            if (v.getCod_Vehiculo() == numRetiro) {
                c.deleteVehiculo(v);

            } else {
                System.out.println("El coche ya ha sido retirado o no existe");
            }
        }

    }

    public static void depositarAbonado() {

    }

    public static void retirarAbonado() throws SQLException {
    }

    //Metodo completo
    public static void controlarParking() {
        try {
            PlazaDAO control = new PlazaDAO();
            ArrayList lista = control.numeroPlazas();
            enseñarPlazas(lista);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void facturacion() {
        System.out.println("Dime dia ");
    }

    public static void abonos() throws SQLException {

        Scanner tec = new Scanner(System.in);
        System.out.println("Que quieres hacer : 1-alta 2-modificar 3-borrar");
        int resp = tec.nextInt();
        tec.nextLine();
        if (resp == 3) {
            System.out.println("Dime el codigo de cliente que desea retirar el abono");
            int numRetiro = tec.nextInt();
            ClienteDAO c = new ClienteDAO();

            for (ClienteVO v : Sistema.listaCliente) {

                if (v.getCod_Cliente() == numRetiro) {
                    if (v.getFec_in_abono() == LocalDate.MIN) {
                        System.out.println("El cliente nunca estuvo abonado");
                    } else {
                        v.setFec_in_abono(LocalDate.MIN);
                        v.setFec_fin_abono(LocalDate.MIN);
                    }
                    c.deleteCliente();

                    System.out.println("Abono retirado correctamente");

                } else {
                    System.out.println("El cliente ya ha sido borrado o no existe");
                }
            }
        }
        if (resp == 1) {
            System.out.println("Dime los datos del cliente");
            // int cod_Cliente, LocalDate fec_in_abono, LocalDate fec_fin_abono, String nombre, String tarjeta, int tipo_Abono, String email
            System.out.println("Dni sin letra");
            int dni = tec.nextInt();
            LocalDate ini = LocalDate.now();
            System.out.println("Tipo de abono : 1.");

        }

    }

    public static void caducidadAbonos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" 1.Consultar los abonos segun mes de caducidad 2.Consultar en la caducidad de los proximos 10 dias");
        int elegir = teclado.nextInt();
        if (elegir == 1) {
            System.out.println("Dime mes");
            int mes = teclado.nextInt();
            for (ClienteVO c : Sistema.getListaCliente()) {
                if (c.getFec_fin_abono().getMonthValue() == mes) {
                    System.out.println("El cliente de dni:" + c.getCod_Cliente() + " tendra su abono caducado este mes");
                }
            }

        } else {
            for (ClienteVO c : Sistema.getListaCliente()) {
                if (c.getFec_fin_abono().getDayOfYear() <= LocalDate.now().getDayOfYear() + 10) {
                    System.out.println("El cliente de dni:" + c.getCod_Cliente() + " tendra su abono caducado en 10 dias");
                }
            }

        }

    }

    public static void copiaSeguridad() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("");
        System.out.println("Elige la opcion que desea ejecutar"
                + " \n1. Crear copia de seguridad \n2. Restaurar copia de seguridad");

        try {
            eleccion = tec.nextInt();
            System.out.println("");

            while (eleccion != 1 && eleccion != 2) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
                System.out.println("");
                tec.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros, reinicia el sistema e intentelo de nuevo");
        }

        switch (eleccion) {
            case 1:
                System.out.println("Has elegido crear una copia de seguridad. En breves se completará la accion");
                crearCopiaSeguridad();
                break;
            case 2:
                System.out.println("Has elegido restaurar. En breves se restaurará por completo");
                restaurarCopiaSeguridad();
                break;
        }
    }

    public static void crearCopiaSeguridad() throws SQLException {
        Singleton.crearBackup();
    }

    public static void restaurarCopiaSeguridad() throws SQLException {
        Singleton.Restaurar();
        System.out.println("La restauración se completó satisfactoriamente.");
    }

    public static void enseñarPlazas(ArrayList<PlazaVO> x) {
        System.out.println("Estado de plazas \n1. Libre \n2. Ocupada \n3. Abono Libre \n4. Abono Ocupada");
        for (int i = 0; i < x.size(); i++) {

            switch (x.get(i).getEstado_Plaza()) {
                case 1:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Libre");
                    switch (x.get(i).getTipo_Plazas()) {
                        case 1:
                            System.out.println("Para turismos");
                            break;
                        case 2:
                            System.out.println("Para motocicletas");
                            break;
                        case 3:
                            System.out.println("Para caravanas");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Ocupada");
                    switch (x.get(i).getTipo_Plazas()) {
                        case 1:
                            System.out.println("Para turismos");
                            break;
                        case 2:
                            System.out.println("Para motocicletas");
                            break;
                        case 3:
                            System.out.println("Para caravanas");
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Abono Libre");
                    switch (x.get(i).getTipo_Plazas()) {
                        case 1:
                            System.out.println("Para turismos");
                            break;
                        case 2:
                            System.out.println("Para motocicletas");
                            break;
                        case 3:
                            System.out.println("Para caravanas");
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Abono Ocupada");
                    switch (x.get(i).getTipo_Plazas()) {
                        case 1:
                            System.out.println("Para turismos");
                            break;
                        case 2:
                            System.out.println("Para motocicletas");
                            break;
                        case 3:
                            System.out.println("Para caravanas");
                            break;
                        default:
                            break;
                    }
                    break;

            }
        }
    }
}
