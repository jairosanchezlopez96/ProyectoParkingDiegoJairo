/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jairo
 */
public class ClienteDAO implements ICliente {
private Connection con = null;

    public ClienteDAO() {
        con = Conexion.getInstance();
    }
    @Override
    public List<ClienteVO> getAllClientes() throws SQLException {
          List<ClienteVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Reserva");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                ClienteVO c = new ClienteVO();
                // Recogemos los datos de la persona, guardamos en un objeto
              c.setCod_Cliente(res.getInt("cod_Cliente"));
                c.setEmail(res.getString("email"));
                c.setNombre(res.getString("nombre"));
               
                c.setFec_in_abono(res.getTimestamp("fec_Ini_Abono").toLocalDateTime());
                c.setFec_fin_abono(res.getTimestamp("fec_Fin_Abono").toLocalDateTime());
                 c.setTarjeta(res.getString("tarjeta"));
                c.setTipo_Abono(res.getInt("tipo_Abono"));                 
             
                //Añadimos el objeto a la lista
                lista.add(c);
            }
        }

        return lista;
    }

    @Override
    public int insertCliente(ClienteVO cliente) throws SQLException {
         int numFilas= 0;
        String sql = "insert into Cliente values (?,?,?,?,?,?,?)";

            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, cliente.getCod_Cliente());
                prest.setString(2, cliente.getNombre());
                prest.setString(3, cliente.getEmail());
                prest.setString(4,cliente.getTarjeta());
                 prest.setInt(5, cliente.getTipo_Abono());
                 prest.setTimestamp(6, Timestamp.valueOf(cliente.getFec_fin_abono()));
                  prest.setTimestamp(7, Timestamp.valueOf(cliente.getFec_in_abono()));

                numFilas = prest.executeUpdate();
            }
            return numFilas;
    }

    @Override
    public int insertCliente(List<ClienteVO> cliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCliente(ClienteVO cliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateCliente(int pk, ClienteVO nuevoCliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCliente() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
