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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whizrxt
 */
public class PinesDAO implements IPines {
private Connection con = null;

    public PinesDAO() {
        con = Conexion.getInstance();
    }
    @Override
    public List<PinesVO> getAllPines() throws SQLException {
          List<PinesVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Reserva");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                PinesVO p = new PinesVO();
                // Recogemos los datos de la persona, guardamos en un objeto
              p.setCod_Vehiculo(res.getInt("cod_Vehiculo"));
                p.setPen_Desechable(res.getString("pen_Desechable"));
                 p.setNum_Plaza(res.getInt("num_Vehiculo"));
               
              
                 p.setCoste(res.getDouble("coste"));
                        
             
                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public int insertPin(PinesVO pin) throws SQLException {
        int numFilas= 0;
        String sql = "insert into Pines values (?,?,?,?,?,?,?,?)";

            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, pin.getCod_Vehiculo());
                prest.setInt(2, pin.getNum_Plaza());
                prest.setString(3, pin.getPen_Desechable());
                prest.setDouble(4,pin.getCoste());
                prest.setDate(5, Date.valueOf(pin.getFec_Fin_Pin_Dia()));
                 prest.setTime(6, Time.valueOf(pin.getFec_Fin_Pin_Hora()));
                prest.setDate(7, Date.valueOf(pin.getFec_In_Pin_Dia()));
                 prest.setTime(8, Time.valueOf(pin.getFec_In_Pin_Hora()));
               
                
                
                 
                
                numFilas = prest.executeUpdate();
            }
            return numFilas;
    }

    @Override
    public int insertPines(List<PinesVO> pines) throws SQLException {
         int numFilas = 0;

        for (PinesVO tmp : pines) {
            numFilas += insertPin(tmp);
        }

        return numFilas;
    }

    @Override
    public int deletePines(PinesVO pines) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Pines where cod_Cliente = ? and num_Plaza = ? and fec_In_Pin_Hora = ? and fec_In_Pin_Dia = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, pines.getCod_Vehiculo());
             prest.setInt(2, pines.getNum_Plaza());
              // falta pasar de localDate a date de sql 
              // diego preguntale a vico si esto esta bn 
              prest.setTime(3,Time.valueOf(pines.getFec_In_Pin_Hora()));
              prest.setDate(4, Date.valueOf(pines.getFec_In_Pin_Dia()));
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updatePin(int pk, PinesVO pin) throws SQLException {
        
    }

    @Override
    public int deletePines() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
