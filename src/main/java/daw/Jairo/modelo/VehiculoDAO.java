/*
 * Clase que implementa la interface IVEHICULO
 */
package daw.Jairo.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO implements IVehiculo {

    private Connection con = null;

    public VehiculoDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<VehiculoVO> getAll() throws SQLException {
        List<VehiculoVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Vehiculos");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                VehiculoVO p = new VehiculoVO();
                // Recogemos los datos del vehiculo, guardamos en un objeto
                p.setCod_Vehiculo(res.getInt("cod_Vehiculo"));
                p.setMatricula("matricula");
                p.setTipo_Vehiculo(res.getInt("tipo_Vehiculo"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public int insertVehiculo(VehiculoVO vehiculo) throws SQLException {

        int numFilas = 0;
        String sql = "insert into Vehiculos values (?,?,?)";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, vehiculo.getCod_Vehiculo());
            prest.setString(2, vehiculo.getMatricula());
            prest.setInt(3, vehiculo.getTipo_Vehiculo());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int insertVehiculo(List<VehiculoVO> lista) throws SQLException {
        int numFilas = 0;

        for (VehiculoVO tmp : lista) {
            numFilas += insertVehiculo(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteVehiculo(VehiculoVO vehiculo) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Vehiculos where cod_Vehiculo = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, vehiculo.getCod_Vehiculo());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updateVehiculo(int codcli, VehiculoVO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update Vehiculos set matricula = ?, tipo_Vehiculo= ? where cod_Vehiculo=? ";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(3, nuevosDatos.getCod_Vehiculo());
            prest.setString(1, nuevosDatos.getMatricula());
            prest.setInt(2, nuevosDatos.getTipo_Vehiculo());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

}
