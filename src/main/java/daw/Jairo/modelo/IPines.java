/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public interface IPines {

    public List<PinesVO> getAllPines() throws SQLException;

    public int insertPin(PinesVO pin) throws SQLException;
    // Insertar lista de plazas

    int insertPines(List<PinesVO> pines) throws SQLException;

    public int deletePines(PinesVO pines) throws SQLException;
    // la pk es el num_Plaza

    public int updatePin(int pk1, int pk2, LocalDate pk3, LocalTime pk4, PinesVO pin) throws SQLException;

    public int deletePines() throws SQLException;

}
