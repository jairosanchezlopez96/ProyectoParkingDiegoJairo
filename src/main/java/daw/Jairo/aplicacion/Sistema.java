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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    public static void elegirZona() throws SQLException, FileNotFoundException {
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

    public static void zonaCliente() throws SQLException, FileNotFoundException {
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
        boolean repetido = false;
        VehiculoDAO daop = new VehiculoDAO();
        PinesDAO daov = new PinesDAO();

        Scanner teclado = new Scanner(System.in);

        // limpiamos buffer
        teclado.nextLine();
        System.out.println("Introduzca los datos del vehiculo:");
        System.out.println("Codigo vehiculo");
        int cod = teclado.nextInt();
        for (PinesVO pin : Sistema.getListaPines()) {
            if (pin.getCod_Vehiculo() == cod && pin.getCoste() == 0) {
                repetido = true;
            }

        }
        teclado.nextLine();
        int num_Plaza = 0;
        System.out.println("Matricula vehiculo");
        String matri = teclado.nextLine();
        System.out.println(" Tipo vehiculo: 1- turismo 2- motocicletas 3- caravanas");
        int tipo = teclado.nextInt();
        for (PlazaVO ps : Sistema.getListaPlaza()) {
            if (ps.getTipo_Plazas() == tipo && ps.getEstado_Plaza() == 1 && repetido == false) {
                num_Plaza = ps.getNum_Plaza();
                ps.setEstado_Plaza(2);
                System.out.println("La plaza numero :" + num_Plaza + " sera ocupada");
                objeto.updatePlaza(num_Plaza, ps);
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

                System.out.println("Matricula: " + v.getMatricula() + " Fecha: " + LocalDate.now() + " Identificador Plaza: " + num_Plaza + " Pin: " + contraseña);
                break;
            } else if (repetido == true) {
                System.out.println("El coche ya ha sido depositado");
                break;
            }

        }

        // insertamos el vehiculo en la bbdd y en la lista del sistema
    }

    public static String generarContra() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public static void retirarVehiculo() throws SQLException {
        Scanner tec = new Scanner(System.in);
        System.out.println("Dime el  codigo de vehiculo que quieras retirar");
        int numRetiro = tec.nextInt();
        System.out.println("Dime el identificador de plaza");
        int ident = tec.nextInt();
        tec.nextLine();
        System.out.println("Dime el pin");
        String contra = tec.nextLine();
        int minutos = 0;
        PinesDAO pdao = new PinesDAO();
        PlazaDAO pldao = new PlazaDAO();

        for (PinesVO p : Sistema.getListaPines()) {
            if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && p.getPen_Desechable().equalsIgnoreCase(contra)
                    && p.getCoste() == 0) {
                p.setFec_Fin_Pin_Hora(LocalTime.now());
                p.setFec_Fin_Pin_Dia(LocalDate.now());
                if (p.getFec_In_Pin_Dia() == p.getFec_Fin_Pin_Dia()) {
                    minutos = (p.getFec_Fin_Pin_Hora().getHour() * 60 + p.getFec_Fin_Pin_Hora().getMinute())
                            - (p.getFec_In_Pin_Hora().getHour() * 60 + p.getFec_In_Pin_Hora().getMinute());

                    for (PlazaVO ps : Sistema.getListaPlaza()) {
                        if (ps.getNum_Plaza() == ident) {
                            ps.setEstado_Plaza(1);
                            if (ps.getTipo_Plazas() == 1) {
                                System.out.println("El precio es : " + minutos * 0.12 + "euros");
                                double precio = minutos * 0.12;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 2) {
                                System.out.println("El precio es : " + minutos * 0.08 + "euros");
                                double precio = minutos * 0.08;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);
                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 3) {
                                System.out.println("El precio es : " + minutos * 0.45 + "euros");
                                double precio = minutos * 0.45;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);
                                pldao.updatePlaza(ident, ps);
                            }

                        }
                    }
                } else {

                    minutos = (int) ((1.440) * ((p.getFec_Fin_Pin_Dia().getDayOfYear() - p.getFec_In_Pin_Dia().getDayOfYear()) - 1) + (p.getFec_Fin_Pin_Hora().getHour() * 60 + p.getFec_Fin_Pin_Hora().getMinute())
                            + (1440 - (p.getFec_In_Pin_Hora().getHour() * 60 + p.getFec_In_Pin_Hora().getMinute())));

                    for (PlazaVO ps : Sistema.getListaPlaza()) {
                        if (ps.getNum_Plaza() == ident) {
                            ps.setEstado_Plaza(1);

                            if (ps.getTipo_Plazas() == 1) {
                                System.out.println("El precio es : " + minutos * 0.12 + "euros");
                                double precio = minutos * 0.12;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);
                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 2) {
                                System.out.println("El precio es : " + minutos * 0.08 + "euros");
                                double precio = minutos * 0.08;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);
                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 3) {
                                System.out.println("El precio es : " + minutos * 0.45 + "euros");
                                double precio = minutos * 0.45;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);
                                pldao.updatePlaza(ident, ps);
                            }

                        }
                    }

                }
            } else if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && !(p.getPen_Desechable().equalsIgnoreCase(contra))) {
                System.out.println(" Error al meter datos");
            } else if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && p.getPen_Desechable().equalsIgnoreCase(contra)
                    && p.getCoste() != 0) {
                System.out.println("El vehiculo ya ha sido retirado");

            }
        }

    }

    public static void depositarAbonado() throws SQLException, FileNotFoundException {
        // EL SISTEMA INFORMA EN TODO MOMENTO DEL NUMERO DE PLAZAS LIBRES
        PlazaDAO objeto = new PlazaDAO();
        boolean repetido = false;
        ArrayList lista = objeto.plazasLibres();
        VehiculoDAO daop = new VehiculoDAO();
        PinesDAO daov = new PinesDAO();

        Scanner teclado = new Scanner(System.in);

        // limpiamos buffer
        System.out.println("Introduzca los datos del cliente y :");
        System.out.println("Codigo vehiculo");
        int cod = teclado.nextInt();
        for (PinesVO pin : Sistema.getListaPines()) {
            if (pin.getCod_Vehiculo() == cod && pin.getCoste() == 0) {
                repetido = true;
            }

        }
        teclado.nextLine();
        int num_Plaza = 0;
        System.out.println("Matricula vehiculo");
        String matri = teclado.nextLine();

        System.out.println(" Tipo vehiculo: 1- turismo 2- motocicletas 3- caravanas");
        int tipo = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Dni ");
        String dni = teclado.nextLine();
        for (PlazaVO ps : Sistema.getListaPlaza()) {
            if (ps.getTipo_Plazas() == tipo && (ps.getEstado_Plaza() == 1 || ps.getEstado_Plaza() == 3 && repetido == false)) {
                num_Plaza = ps.getNum_Plaza();
                ps.setEstado_Plaza(4);

                objeto.updatePlaza(num_Plaza, ps);
                VehiculoVO v = new VehiculoVO(cod, matri, tipo);
                System.out.println("La plaza Reservada ha sido : " + num_Plaza);
                Sistema.listaVehiculo.add(v);
                daop.insertVehiculo(v);
                // int cod_Vehiculo, int num_Plaza, String pen_Desech
                //able, double coste, LocalDate fec_Fin_Pin_Dia, LocalTime fec_Fin_Pin_Hora, LocalDate fec_In_Pin_Dia, LocalTime fec_In_Pin_Hora
                String contraseña = generarContra();
                // los now son porque ahora pilla la plaza y el max lo cambiamos cuando saque el coche 

                File tmpDir = new File("clientes/" + dni);
                if (tmpDir.exists() == true) {
                    String contra = "";
                    try {
                        Scanner scan = new Scanner(tmpDir);
                        while (scan.hasNextLine()) {
                            contra = scan.nextLine();

                        }
                        scan.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    PinesVO pinCoche = new PinesVO(cod, num_Plaza, contra, 0, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
                    listaPines.add(pinCoche);
                    daov.insertPin(pinCoche);
                } else {
                    PinesVO pinCoche = new PinesVO(cod, num_Plaza, contraseña, 0, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now());
                    listaPines.add(pinCoche);
                    daov.insertPin(pinCoche);
                    try (BufferedWriter flujo = new BufferedWriter(new FileWriter("clientes/" + dni))) {
                        // recoremos la lista y segun si es true or false evaluador y 
                        // coordinador ponemos si o no

                        flujo.write(contraseña);

                        // cuando termine de recorer la lista lo guardamos con flush
                        flujo.flush();

                    } catch (IOException e) {
                        System.out.println(e.getMessage());

                    }
                }

                break;
            } else if (repetido == true) {
                System.out.println("El coche ya ha sido depositado");
                break;
            }
        }

        // insertamos el vehiculo en la bbdd y en la lista del sistema
    }

    public static void retirarAbonado() throws SQLException {
        Scanner tec = new Scanner(System.in);
        System.out.println("Dime el codigo de coche que quieres retirar");
        int numRetiro = tec.nextInt();
        System.out.println("Dime el identificador de plaza");
        int ident = tec.nextInt();
        tec.nextLine();
        System.out.println("Dime el pin");
        String contra = tec.nextLine();
        double minutos = 0;
        PinesDAO pdao = new PinesDAO();
        PlazaDAO pldao = new PlazaDAO();

        for (PinesVO p : Sistema.getListaPines()) {
            if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && p.getPen_Desechable().equalsIgnoreCase(contra)
                    && p.getCoste() == 0) {
                p.setFec_Fin_Pin_Hora(LocalTime.now());
                p.setFec_Fin_Pin_Dia(LocalDate.now());
                if (p.getFec_In_Pin_Dia() == p.getFec_Fin_Pin_Dia()) {
                    minutos = (p.getFec_Fin_Pin_Hora().getHour() * 60 + p.getFec_Fin_Pin_Hora().getMinute())
                            - (p.getFec_In_Pin_Hora().getHour() * 60 + p.getFec_In_Pin_Hora().getMinute());

                    for (PlazaVO ps : Sistema.getListaPlaza()) {
                        if (ps.getNum_Plaza() == ident) {
                            ps.setEstado_Plaza(3);
                            if (ps.getTipo_Plazas() == 1) {
                                System.out.println("El precio es : " + minutos * 0.12 + "euros");
                                p.setCoste(minutos * 0.12);
                                double precio = minutos * 0.12;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 2) {
                                System.out.println("El precio es : " + minutos * 0.08 + "euros");
                                p.setCoste(minutos * 0.08);
                                double precio = minutos * 0.08;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 3) {
                                System.out.println("El precio es : " + minutos * 0.45 + "euros");
                                p.setCoste(minutos * 0.45);
                                double precio = minutos * 0.12;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            }

                        }
                    }
                } else {

                    minutos = ((1.440) * ((p.getFec_Fin_Pin_Dia().getDayOfYear() - p.getFec_In_Pin_Dia().getDayOfYear()) - 1) + (p.getFec_Fin_Pin_Hora().getHour() * 60 + p.getFec_Fin_Pin_Hora().getMinute())
                            + (1440 - (p.getFec_In_Pin_Hora().getHour() * 60 + p.getFec_In_Pin_Hora().getMinute())));
                    for (PlazaVO ps : Sistema.getListaPlaza()) {
                        if (ps.getNum_Plaza() == ident) {
                            ps.setEstado_Plaza(3);
                            if (ps.getTipo_Plazas() == 1) {
                                System.out.println("El precio es : " + minutos * 0.12 + "euros");
                                p.setCoste(minutos * 0.12);
                                double precio = minutos * 0.12;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 2) {
                                System.out.println("El precio es : " + minutos * 0.08 + "euros");
                                p.setCoste(minutos * 0.08);
                                double precio = minutos * 0.08;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            } else if (ps.getTipo_Plazas() == 3) {
                                System.out.println("El precio es : " + minutos * 0.45 + "euros");
                                p.setCoste(minutos * 0.45);
                                double precio = minutos * 0.45;
                                int pre = (int) precio;
                                p.setCoste(pre);
                                pdao.updatePin(p.getNum_Plaza(), p.getCod_Vehiculo(), p.getFec_In_Pin_Dia(), p.getFec_In_Pin_Hora(), p);

                                pldao.updatePlaza(ident, ps);
                            }

                        }
                    }

                }
            } else if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && !(p.getPen_Desechable().equalsIgnoreCase(contra))) {
                System.out.println(" Error al meter la contraseña");
            } else if (p.getCod_Vehiculo() == numRetiro && p.getNum_Plaza() == ident && (p.getPen_Desechable().equalsIgnoreCase(contra)) && p.getCoste() != 0) {
                System.out.println("El vehiculo ya ha sido retirado");

            }

        }
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
        Scanner tec = new Scanner(System.in);
        System.out.println("1.Abonos 2.Segun fecha");
        int dinero = 0;
        if (tec.nextInt() == 1) {
            for (ClienteVO c : Sistema.getListaCliente()) {
                if (c.getTipo_Abono() == 1) {
                    dinero += 25;
                } else if (c.getTipo_Abono() == 2) {
                    dinero += 70;
                } else if (c.getTipo_Abono() == 3) {
                    dinero += 130;
                } else if (c.getTipo_Abono() == 4) {
                    dinero += 200;
                }
            }

            System.out.println("El dinero sacado por abonos es de :" + dinero);
        } else {
            System.out.println("Dime fecha de inicio (año mes dia) ");
            tec.nextLine();
            String fecha = tec.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fechaini = LocalDate.parse(fecha, formatter);
            System.out.println("Dime fecha de fin (año mes dia )");
            String fechafinal = tec.nextLine();

            LocalDate fechafin = LocalDate.parse(fechafinal, formatter);
            System.out.println("Hora de inicio ");
            int horaini = tec.nextInt();
            LocalTime horai = LocalTime.of(horaini, 0, 0);
            tec.nextLine();
            System.out.println("Hora de fin ");
            int horafin = tec.nextInt();
            LocalTime horaf = LocalTime.of(horafin, 0, 0);
            for (PinesVO p : Sistema.getListaPines()) {
                if (p.getFec_Fin_Pin_Dia().isAfter(fechaini) && p.getFec_Fin_Pin_Dia().isBefore(fechafin)) {
                    if (p.getFec_Fin_Pin_Hora().isAfter(horai) && p.getFec_Fin_Pin_Hora().isBefore(horaf)) {

                        dinero += p.getCoste();
                    }

                }

            }
            System.out.println("El precio sacado por las reservas entre las fechas indicadas es : " + dinero);
        }

    }

    public static void abonos() throws SQLException {

        Scanner tec = new Scanner(System.in);
        System.out.println("Que quieres hacer : 1-alta 2-modificar 3-borrar");
        int resp = tec.nextInt();
        tec.nextLine();
        ClienteDAO c = new ClienteDAO();
        if (resp == 3) {
            System.out.println("Dime el codigo de cliente  que desea retirar el abono");
            int numRetiro = tec.nextInt();

            for (ClienteVO v : Sistema.getListaCliente()) {

                if (v.getCod_Cliente() == numRetiro) {
                    if (v.getTipo_Abono() == 0) {
                        System.out.println("El cliente nunca estuvo abonado");
                    } else {
                        v.setFec_in_abono(LocalDate.now());
                        v.setFec_fin_abono(LocalDate.now());
                        v.setNombre("No abonado");
                        c.updateCliente(v.getCod_Cliente(), v);
                        System.out.println("Abono retirado correctamente");
                    }

                } else {
                    System.out.println("El cliente ya ha sido borrado o no existe");
                }
            }
        } else if (resp == 1) {
            System.out.println("Dime los datos del cliente");

            System.out.println("Dni cliente sin letra");
            int cod = tec.nextInt();
            tec.nextLine();
            LocalDate ini = LocalDate.now();
            System.out.println("Nombre");
            String nombre = tec.nextLine();
            System.out.println("Tarjeta");
            String tarjeta = tec.nextLine();
            System.out.println("Email");
            String email = tec.nextLine();

            System.out.println("Tipo de abono : 1.Mensual 2.trimestral 3.semestral 4.anual");
            int abono = tec.nextInt();
            if (abono == 1) {
                // int cod_Cliente, LocalDate fec_in_abono, LocalDate fec_fin_abono, String nombre, String tarjeta, int tipo_Abono, String email
                LocalDate fechafin = ini.plusMonths(3);
                ClienteVO cli = new ClienteVO(cod, ini, fechafin, nombre, tarjeta, 1, email);
                Sistema.getListaCliente().add(cli);
                c.insertCliente(cli);
                System.out.println("Se ha insertado correctamente el cliente");

            } else if (abono == 2) {
                LocalDate fechafin = ini.plusMonths(6);
                ClienteVO cli = new ClienteVO(cod, ini, fechafin, nombre, tarjeta, 2, email);
                Sistema.getListaCliente().add(cli);
                c.insertCliente(cli);
                System.out.println("Se ha insertado correctamente el cliente");

            } else if (abono == 3) {
                LocalDate fechafin = ini.plusMonths(9);
                ClienteVO cli = new ClienteVO(cod, ini, fechafin, nombre, tarjeta, 3, email);
                Sistema.getListaCliente().add(cli);
                c.insertCliente(cli);
                System.out.println("Se ha insertado correctamente el cliente");
            } else if (abono == 4) {
                LocalDate fechafin = ini.plusYears(1);
                ClienteVO cli = new ClienteVO(cod, ini, fechafin, nombre, tarjeta, 1, email);
                Sistema.getListaCliente().add(cli);
                c.insertCliente(cli);
                System.out.println("Se ha insertado correctamente el cliente");
            }

        } else if (resp == 2) {
            System.out.println("Dime dni del cliente que quieres cambiar");
            int codigocl = tec.nextInt();
            for (ClienteVO clientes : Sistema.getListaCliente()) {
                if (clientes.getCod_Cliente() == codigocl) {

                    System.out.println("El cliente tiene tipo de abono :" + clientes.getTipo_Abono());

                    System.out.println("A cual lo quieres cambiar :");
                    int abononuevo = tec.nextInt();
                    clientes.setTipo_Abono(abononuevo);
                    c.updateCliente(clientes.getCod_Cliente(), clientes);
                    System.out.println("Cliente actualizado");

                }

            }

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
