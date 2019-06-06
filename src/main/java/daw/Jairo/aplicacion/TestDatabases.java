/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PinesDAO;
import daw.Jairo.modelo.PlazaDAO;
import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.Singleton;
import daw.Jairo.modelo.VehiculoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class TestDatabases {
    public static void main(String[] args) throws SQLException {
    
//        Singleton.crearBackup();
//           Singleton.Restaurar("28 5 2019");
           PlazaDAO plaza= new PlazaDAO();
          
        //Crear plazas turismo
        for (int i = 1; i <= 15; i++) {
            PlazaVO plazas= new PlazaVO(i, 0.0, 1, 1);
            plaza.insertPlaza(plazas);
        }
        
        //Crear plazas motocicletas
        for (int i = 16; i <= 30; i++) {
            PlazaVO plazas= new PlazaVO(i, 0.0, 1, 2);
            plaza.insertPlaza(plazas);
        }
        
        //Crear plazas caravanas
        for (int i = 31; i <=45; i++) {
            PlazaVO plazas= new PlazaVO(i, 0.0, 1, 3);
            plaza.insertPlaza(plazas);
        }
    }
}
