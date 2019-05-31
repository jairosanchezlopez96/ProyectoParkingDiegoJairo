/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.ClienteVO;
import daw.Jairo.modelo.PinesVO;
import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.ReservaVO;
import daw.Jairo.modelo.Singleton;
import daw.Jairo.modelo.VehiculoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author whizrxt
 */
public class Sistema {

    //LISTA DE CLIENTES
    private ArrayList<ClienteVO> listaCliente;

    //LISTA DE PINES
    private ArrayList<PinesVO> listaPines;

    //LISTA DE PLAZAS
    private ArrayList<PlazaVO> listaPlaza;

    //LISTA DE RESERVAS
    private ArrayList<ReservaVO> listaReserva;

    //LISTA DE VEHICULOS
    private ArrayList<VehiculoVO> listaVehiculo;

    public Sistema(ArrayList<ClienteVO> listaCliente, ArrayList<PinesVO> listaPines, ArrayList<PlazaVO> listaPlaza, ArrayList<ReservaVO> listaReserva, ArrayList<VehiculoVO> listaVehiculo) {
        this.listaCliente = listaCliente;
        this.listaPines = listaPines;
        this.listaPlaza = listaPlaza;
        this.listaReserva = listaReserva;
        this.listaVehiculo = listaVehiculo;
    }

    public ArrayList<ClienteVO> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<ClienteVO> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<PinesVO> getListaPines() {
        return listaPines;
    }

    public void setListaPines(ArrayList<PinesVO> listaPines) {
        this.listaPines = listaPines;
    }

    public ArrayList<PlazaVO> getListaPlaza() {
        return listaPlaza;
    }

    public void setListaPlaza(ArrayList<PlazaVO> listaPlaza) {
        this.listaPlaza = listaPlaza;
    }

    public ArrayList<ReservaVO> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(ArrayList<ReservaVO> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public ArrayList<VehiculoVO> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ArrayList<VehiculoVO> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    @Override
    public String toString() {
        return "Sistema{" + "listaCliente=" + listaCliente + ", listaPines=" + listaPines + ", listaPlaza=" + listaPlaza + ", listaReserva=" + listaReserva + ", listaVehiculo=" + listaVehiculo + '}';
    }

    //Metodo para elegir la zona
    public static void elegirZona() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("Bienvenido al parking, seleccion segun la zona a la que quieras acceder"
                + "\n1. Zona Cliente \n2. Zona Administrador");

        try {

            eleccion = tec.nextInt();

            while (eleccion != 1 && eleccion != 2) {

                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
                tec.nextLine();

            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros, reinicia el sistema e intentelo de nuevo");
        }

        switch (eleccion) {
            case 1:
                zonaCliente();
                break;
            case 2:
                zonaAdmin();
                break;
        }
    }

    public static void zonaCliente() {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("");
        System.out.println("Bienvenido a la Zona de Cliente. Escoja la accion que desea realizar"
                + "\n1. Depositar vehiculo \n2. Retirar vehiculo \n3. Depositar abonados \n4. Retirar abonados");

        try {
            eleccion = tec.nextInt();

            while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
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

            while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
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

    public static void depositarVehiculo() {
        PlazaDAO plazas = new PlazaDAO();
        System.out.println("Numero de plazas disponible: ");
    }

    public static void retirarVehiculo() {

    }

    public static void depositarAbonado() {

    }

    public static void retirarAbonado() {

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

    }

    public static void abonos() {

    }

    public static void caducidadAbonos() {

    }

    public static void copiaSeguridad() throws SQLException {
        Scanner tec = new Scanner(System.in);
        int eleccion = 0;

        System.out.println("");
        System.out.println("Elige la opcion que desea ejecutar"
                + " \n1. Crear copia de seguridad \n2. Restaurar copia de seguridad");

        try {
            eleccion = tec.nextInt();

            while (eleccion != 1 && eleccion != 2) {
                System.out.println("Porfavor eleccione una opcion correcta");
                eleccion = tec.nextInt();
                tec.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se permiten numeros, reinicia el sistema e intentelo de nuevo");
        }
        
        switch (eleccion){
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
    
    public static void crearCopiaSeguridad() throws SQLException{
        Singleton.crearBackup();
    }

    public static void restaurarCopiaSeguridad() throws SQLException{
        Singleton.Restaurar();
    }
    public static void enseñarPlazas(ArrayList<PlazaVO> x) {
        System.out.println("Estado de plazas \n1. Libre \n2. Ocupada \n3. Abono Libre \n4. Abono Ocupada");
        for (int i = 0; i < x.size(); i++) {
            
            switch(x.get(i).getEstado_Plaza()){
                case 1:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Libre");
                    break;
                case 2:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Ocupada");
                    break;
                case 3:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Abono Libre");
                        break;
                case 4:
                    System.out.println("Numero de Plaza: " + x.get(i).getNum_Plaza() + ". Estado de Plaza: Abono Ocupada");
                    break;
                        
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        elegirZona();
    }
}