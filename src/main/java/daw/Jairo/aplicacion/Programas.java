/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.ClienteVO;
import daw.Jairo.modelo.PinesVO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.ReservaVO;
import daw.Jairo.modelo.VehiculoVO;
import java.util.ArrayList;

/**
 *
 * @author whizrxt
 */
public class Programas {
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

    public Programas(ArrayList<ClienteVO> listaCliente, ArrayList<PinesVO> listaPines, ArrayList<PlazaVO> listaPlaza, ArrayList<ReservaVO> listaReserva, ArrayList<VehiculoVO> listaVehiculo) {
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
        return "Programas{" + "listaCliente=" + listaCliente + ", listaPines=" + listaPines + ", listaPlaza=" + listaPlaza + ", listaReserva=" + listaReserva + ", listaVehiculo=" + listaVehiculo + '}';
    }
}
