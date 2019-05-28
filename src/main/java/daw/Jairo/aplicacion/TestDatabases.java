/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.Singleton;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class TestDatabases {
    public static void main(String[] args) throws SQLException {
    
        Singleton.crearBackup();
           Singleton.Restaurar("28 5 2019");
        
    }
}
