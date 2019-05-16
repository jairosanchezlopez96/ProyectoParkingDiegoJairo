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
                p.setCodvehiculo(res.getInt("codvechiculo"));
                p.setDescripcion("descrp");
                p.setMatricula("matricula");
                p.setTipo_Vehiculo(res.getInt("tipo_Vehiculo"));

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public VehiculoVO findByCodVehiculo(int codcli) throws SQLException {

        ResultSet res = null;
        VehiculoVO vehiculo = new VehiculoVO();

        String sql = "select * from Vehiculos where codcli=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, codcli);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe ese codcli
            if (res.first()) {
                // Recogemos los datos del vehiculo, guardamos en un objeto
                vehiculo.setCodvehiculo(res.getInt("codvechiculo"));
                vehiculo.setMatricula("matricula");
                vehiculo.setTipo_Vehiculo(res.getInt("tipo_Vehiculo"));
                vehiculo.setDescripcion("descrp");
                return vehiculo;
            }

            return null;
        }
    }

    @Override
    public int insertVehiculo(VehiculoVO vehiculo) throws SQLException {

        int numFilas = 0;
        String sql = "insert into Vehiculos values (?,?,?,?,?)";

        if (findByCodVehiculo(vehiculo.getCodvehiculo()) != null) {
            // Existe un registro con ese codcli
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, vehiculo.getCodvehiculo());
                prest.setString(2, vehiculo.getMatricula());
                prest.setInt(3, vehiculo.getTipo_Vehiculo());
                prest.setString(4, vehiculo.getDescripcion());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

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
    public int deleteVehiculo() throws SQLException {

        String sql = "delete from Vehiculos";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deleteVehiculo(VehiculoVO vehiculo) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Vehiculos where codcli = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, vehiculo.getCodvehiculo());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updateVehiculo(int codcli, VehiculoVO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update Vehiculos set  codvehiculo = ?, matricula = ?, tipo_Vehiculo= ?, descripcion= ? where codcli=? ";
        

        if (findByCodVehiculo(codcli) == null) {
            // El vehiculo a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevosDatos.getCodvehiculo());
                prest.setString(2, nuevosDatos.getMatricula());
                prest.setInt(3, nuevosDatos.getTipo_Vehiculo());
                prest.setString(4, nuevosDatos.getDescripcion());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    public int cambiarMatricula(String newMatricula, String oldMatricula) throws SQLException {

        int res = 0;
        // Dos ?, uno para newName y otro para oldName

        String sql = "{call cambiar_nombres (?,?,?)}";

        // Preparamos la llamada al procedimiento almacenado
        try (CallableStatement call = con.prepareCall(sql)) {
            // Establecemos parámetros a pasar al procedimiento
            call.setString(1, newMatricula);
            call.setString(2, oldMatricula);
            // Ejecutamos el procedimiento
            res = call.executeUpdate();

        }
        return res;
    }

}
