/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public interface IPlaza {
    
  public List<PlazaVO> getAll() throws SQLException;
   
  public  int insertPlaza (PlazaVO plaza) throws SQLException;
  // Insertar lista de plazas
   int insertPlaza (List<PlazaVO> lista) throws SQLException;
    
  public  int deletePlaza (PlazaVO plaza) throws SQLException;
   // la pk es el num_Plaza
    public int updatePlaza (int pk, PlazaVO nuevaPlaza) throws SQLException;
    public int deletePlaza() throws SQLException;
    
    public ArrayList<PlazaVO> numeroPlazas() throws SQLException;
}
