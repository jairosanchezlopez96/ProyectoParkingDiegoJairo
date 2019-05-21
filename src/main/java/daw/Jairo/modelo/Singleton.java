/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Singleton {
    
    // empezamos con metodos para  hacer la copia de seguridad
    public static void EscribirPlaza( ArrayList<PlazaVO> lista , String idFichero){
    
            try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
                for(int i = 0 ; i < lista.size() ; i++){
                flujo.writeObject(lista.get(i));
                flujo.flush();
                }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }}
     public  static void EscribirVehiculo( ArrayList<VehiculoVO> lista , String idFichero){
    
            try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
                 for(int i = 0 ; i < lista.size() ; i++){
                flujo.writeObject(lista.get(i));
                flujo.flush();
                 }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }}
     public static void EscribirPines (ArrayList<PinesVO> lista, String idFichero){
         try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
                 for(int i = 0 ; i < lista.size() ; i++){
                flujo.writeObject(lista.get(i));
                flujo.flush();
                 }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
     
     
     }
      public static void EscribirClientes (ArrayList<ClienteVO> lista, String idFichero){
         try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
                 for(int i = 0 ; i < lista.size() ; i++){
                flujo.writeObject(lista.get(i));
                flujo.flush();
                 }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
     
     
     }
       public static void EscribirReservas (ArrayList<ReservaVO> lista, String idFichero){
         try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idFichero))) {
                 for(int i = 0 ; i < lista.size() ; i++){
                flujo.writeObject(lista.get(i));
                flujo.flush();
                 }
            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
     
     
     }
     // Añadir las dependencias de maven en el proyecto

//    public static ArrayList<PlazaVO> leerFicheroPlaza(String url) {
//        //creop una lista de App
//        ArrayList<PlazaVO> listaApp = new ArrayList<>();
//
//        // Archivo xml que hay que leer
//        File archivoXML = new File(url);
//
//        // Instancia un documento JDOM usando el SAX (Simple API for XML)
//        // El siguiente objeto permite la lectura del fichero XML y obtener su contenido
//        SAXBuilder constructorXML = new SAXBuilder();
//
//        try {
//            // Cargamos el árbol de nodos del fichero XML
//            Document arbolNodos = (Document) constructorXML.build(archivoXML);
//
//            // Obtenemos el nodo raíz del documento
//            Element nodoRaiz = arbolNodos.getRootElement();
//
//            // Se crea una lista de hijos tipo Element del nodo raíz
//            List<Element> lista = nodoRaiz.getChildren();
//
//            // Por cada hijo que hay en la lista
//            for (Element node : lista) {
//
//                // Guardo en un objeto Mueble la información
//                PlazaVO tmp = new PlazaVO();
//
//                //meto los set del objeto
//                
//                //lo añado a la lista
//                listaApp.add(tmp);
//
//            }
//
//        } catch (IOException | JDOMException io) {
//            System.out.println(io.getMessage());
//        }
//
//        //devuelvo la lista
//        return listaApp;
//    }
//    public static ArrayList<VehiculoVO> leerFicheroVehiculo(String url) {
//        //creop una lista de App
//        ArrayList<VehiculoVO> listaApp = new ArrayList<>();
//
//        // Archivo xml que hay que leer
//        File archivoXML = new File(url);
//
//        // Instancia un documento JDOM usando el SAX (Simple API for XML)
//        // El siguiente objeto permite la lectura del fichero XML y obtener su contenido
//        SAXBuilder constructorXML = new SAXBuilder();
//
//        try {
//            // Cargamos el árbol de nodos del fichero XML
//            Document arbolNodos = (Document) constructorXML.build(archivoXML);
//
//            // Obtenemos el nodo raíz del documento
//            Element nodoRaiz = arbolNodos.getRootElement();
//
//            // Se crea una lista de hijos tipo Element del nodo raíz
//            List<Element> lista = nodoRaiz.getChildren();
//
//            // Por cada hijo que hay en la lista
//            for (Element node : lista) {
//
//                // Guardo en un objeto Mueble la información
//                VehiculoVO tmp = new VehiculoVO();
//                //meto los set del objeto
//                
//                //lo añado a la lista
//                listaApp.add(tmp);
//
//            }
//
//        } catch (IOException | JDOMException io) {
//            System.out.println(io.getMessage());
//        }
//
//        //devuelvo la lista
//        return listaApp;
//    }
}