/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
   public static void EscribirPlaza ( ArrayList<PlazaVO> lista , String idFichero){
   
       
        // escribimos un nuevo archivo y lo separamos con una \n
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // recoremos la lista y segun si es true or false evaluador y 
            // coordinador ponemos si o no
            for (int i = 0; i < lista.size(); i++) {
               
                flujo.write(
                        lista.get(i).toString()
                );
                flujo.newLine();

            }
            // cuando termine de recorer la lista lo guardamos con flush

            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
   
   }
     public static void EscribirVehiculos ( ArrayList<VehiculoVO> lista , String idFichero){
   
       
        // escribimos un nuevo archivo y lo separamos con una \n
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // recoremos la lista y segun si es true or false evaluador y 
            // coordinador ponemos si o no
            for (int i = 0; i < lista.size(); i++) {
               
                flujo.write(
                        lista.get(i).toString()
                );
                flujo.newLine();

            }
            // cuando termine de recorer la lista lo guardamos con flush

            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
   
   }
       public static void EscribirPines ( ArrayList<PinesVO> lista , String idFichero){
   
       
        // escribimos un nuevo archivo y lo separamos con una \n
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // recoremos la lista y segun si es true or false evaluador y 
            // coordinador ponemos si o no
            for (int i = 0; i < lista.size(); i++) {
               
                flujo.write(
                        lista.get(i).toString()
                );
                flujo.newLine();

            }
            // cuando termine de recorer la lista lo guardamos con flush

            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
   
   }
         public static void EscribirClientes ( ArrayList<ClienteVO> lista , String idFichero){
   
       
        // escribimos un nuevo archivo y lo separamos con una \n
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // recoremos la lista y segun si es true or false evaluador y 
            // coordinador ponemos si o no
            for (int i = 0; i < lista.size(); i++) {
               
                flujo.write(
                        lista.get(i).toString()
                );
                flujo.newLine();

            }
            // cuando termine de recorer la lista lo guardamos con flush

            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
   
   }
           public static void EscribirReservas( ArrayList<ReservaVO> lista , String idFichero){
   
       
        // escribimos un nuevo archivo y lo separamos con una \n
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // recoremos la lista y segun si es true or false evaluador y 
            // coordinador ponemos si o no
            for (int i = 0; i < lista.size(); i++) {
               
                flujo.write(
                        lista.get(i).toString()
                );
                flujo.newLine();

            }
            // cuando termine de recorer la lista lo guardamos con flush

            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
   
   }
   
       
   
   
             
}