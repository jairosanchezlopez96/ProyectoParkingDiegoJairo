/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.aplicacion;

import daw.Jairo.modelo.PlazaVO;
import daw.Jairo.modelo.Singleton;
import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class TestDatabases {
    public static void main(String[] args) {
        ArrayList<PlazaVO> lista = new ArrayList<>();
        lista.add(new PlazaVO(2,41.2, 3, 1));
        lista.add(new PlazaVO(3,41.2, 2, 2));
        lista.add(new PlazaVO(4,41.2, 2, 3));
        lista.add(new PlazaVO(5,41.2, 1, 1));
        
        
        Singleton.EscribirPlaza(lista,"ficheroPlaza");
    }
}
