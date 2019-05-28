/*
 * Interface que usa el patrón DAO sobre la tabla Persona
 */

package daw.Jairo.modelo;

import java.sql.SQLException;
import java.util.List;


public interface IVehiculo{
    
    // Método para obtener todos los registros de la tabla
    List<VehiculoVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir del codcli
 
    
    // Método para insertar un registro
    int insertVehiculo (VehiculoVO vehiculo) throws SQLException;
    
    // Método para insertar varios registros
    int insertVehiculo (List<VehiculoVO> lista) throws SQLException;
    
    // Método para borrar un vehiculo
    int deleteVehiculo (VehiculoVO p) throws SQLException;
    int deleteVehiculo() throws SQLException;
    
    // Método para modificar una vehiculo. Se modifica a la vehiculo que tenga ese 'codcli'
    // con los nuevos datos que traiga la vehiculo 'nuevosDatos'
    int updateVehiculo (int codcli, VehiculoVO nuevosDatos) throws SQLException;
    
}
