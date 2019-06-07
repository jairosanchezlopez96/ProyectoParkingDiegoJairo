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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairo
 */
public class PlazaDAO implements IPlaza {

    private Connection con = null;

    public PlazaDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<PlazaVO> getAll() throws SQLException {
        List<PlazaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Plazas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                PlazaVO p = new PlazaVO();
                // Recogemos los datos de la plaza, guardamos en un objeto
                p.setNum_Plaza(res.getInt("num_Plaza"));
                p.setTarifa(res.getDouble("tarifa"));
                p.setTipo_Plazas(res.getInt("tipo_Plazas"));
                p.setEstado_Plaza(res.getInt("estado_Plaza"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public int insertPlaza(PlazaVO plaza) throws SQLException {
        int numFilas = 0;
        String sql = "insert into Plazas values (?,?,?,?)";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(4, plaza.getTipo_Plazas());
            prest.setInt(1, plaza.getNum_Plaza());
            prest.setInt(3, plaza.getEstado_Plaza());
            prest.setDouble(2, plaza.getTarifa());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int deletePlaza(PlazaVO plaza) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Plazas where num_Plaza = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, plaza.getNum_Plaza());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;

    }

    @Override
    public int updatePlaza(int num_Plaza, PlazaVO nuevaPlaza) throws SQLException {
        int numFilas = 0;
        String sql = "update Plazas set tipo_Plazas = ?, estado_Plaza = ?, tarifa = ? where num_Plaza=?";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, nuevaPlaza.getTipo_Plazas());
            prest.setInt(2, nuevaPlaza.getEstado_Plaza());
            prest.setDouble(3, nuevaPlaza.getTarifa());
            prest.setInt(4, num_Plaza);

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int insertPlaza(List<PlazaVO> lista) throws SQLException {
        int numFilas = 0;

        for (PlazaVO tmp : lista) {
            numFilas += insertPlaza(tmp);
        }

        return numFilas;
    }

    @Override
    public int deletePlaza() throws SQLException {
        String sql = "delete from Plazas";
        int nfilas = 0;

        try (Statement st = con.createStatement()) {

            nfilas = st.executeUpdate(sql);
        }
        return nfilas;
    }

    @Override
    public ArrayList<PlazaVO> numeroPlazas() throws SQLException {
        ArrayList<PlazaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select num_Plaza, estado_Plaza from Plazas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                PlazaVO p = new PlazaVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setNum_Plaza(res.getInt("num_Plaza"));
                p.setEstado_Plaza(res.getInt("estado_Plaza"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }
    
    //Metodo para consultar el numero de plazas libres
    public ArrayList<PlazaVO> plazasLibres() throws SQLException {
        ArrayList<PlazaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Plazas where estado_Plaza=1");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                PlazaVO p = new PlazaVO();
                // Recogemos los datos de la plaza, guardamos en un objeto
                p.setNum_Plaza(res.getInt("num_Plaza"));
                p.setTarifa(res.getDouble("tarifa"));
                p.setTipo_Plazas(res.getInt("tipo_Plazas"));
                p.setEstado_Plaza(res.getInt("estado_Plaza"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }
}
