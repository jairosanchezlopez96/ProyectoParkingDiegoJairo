/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public interface IReserva {

    public List<ReservaVO> getAll() throws SQLException;

    public int insertReserva(ReservaVO reserva) throws SQLException;
    // Insertar lista de plazas

    int insertReserva(List<ReservaVO> lista) throws SQLException;

    public int deleteReserva(ReservaVO reserva) throws SQLException;
    // la pk es el num_Plaza

    public int updateReserva(int pk, ReservaVO nuevaReserva) throws SQLException;

    public int deleteReserva() throws SQLException;
}
