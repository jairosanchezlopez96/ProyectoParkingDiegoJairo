/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public class ReservaDAO implements IReserva {
     private Connection con = null;

    public ReservaDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<ReservaVO> getAll() throws SQLException {
         List<ReservaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Reserva");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                ReservaVO p = new ReservaVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setNum_Plaza(res.getInt("num_Plaza"));
                p.setCod_Vehiculo(res.getInt("cod_Vehiculo"));
                p.setCod_Cliente(res.getInt("cod_Cliente"));
                p.setPin_fijo(res.getInt("pin_Fijo"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public int insertReserva(ReservaVO reserva) throws SQLException {
        int numFilas= 0;
        String sql = "insert into Reserva values (?,?,?,?)";

            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, reserva.getNum_Plaza());
                prest.setInt(2, reserva.getCod_Vehiculo());
                prest.setInt(3, reserva.getCod_Cliente());
                prest.setInt(4,reserva.getPin_fijo());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    @Override
    public int deleteReserva(ReservaVO reserva) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Reserva where num_Plaza = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, reserva.getNum_Plaza());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;

    }

    @Override
    public int updateReserva(int num_Plaza, ReservaVO nuevaReserva) throws SQLException {
        int numFilas = 0;
        String sql = "update Reserva set cod_Vehiculo = ?, cod_Cliente = ?, pin_fijo = ? where num_Plaza=?";

       
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevaReserva.getCod_Vehiculo());
                prest.setInt(2, nuevaReserva.getPin_fijo());
                prest.setDouble(3, nuevaReserva.getCod_Cliente());
                prest.setInt(4, num_Plaza);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    

    @Override
    public int insertReserva(List<ReservaVO> lista) throws SQLException {
          int numFilas = 0;

        for (ReservaVO tmp : lista) {
            numFilas += insertReserva(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteReserva() throws SQLException {
         String sql = "delete from Reserva";
        int nfilas = 0 ;
        
        
        try(Statement st = con.createStatement()){
        
        nfilas = st.executeUpdate(sql);
        }
        return nfilas;
    }
    
    }