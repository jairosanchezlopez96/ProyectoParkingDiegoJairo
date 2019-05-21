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
 * @author jairo
 */
public interface ICliente {
    public List<ClienteVO> getAllClientes() throws SQLException;
   
  public  int insertCliente (ClienteVO cliente) throws SQLException;
  // Insertar lista de plazas
   int insertCliente (List<ClienteVO> cliente) throws SQLException;
    
  public  int deleteCliente (ClienteVO cliente) throws SQLException;
   // la pk es el num_Plaza
    public int updateCliente (int pk, ClienteVO cliente) throws SQLException;
    public int deleteCliente() throws SQLException;
}
