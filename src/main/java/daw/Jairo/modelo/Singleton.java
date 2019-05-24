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
    public static void EscribirPlaza(ArrayList<PlazaVO> lista, String idFichero) {

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

    public static void EscribirVehiculos(ArrayList<VehiculoVO> lista, String idFichero) {

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

    public static void EscribirPines(ArrayList<PinesVO> lista, String idFichero) {

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

    public static void EscribirClientes(ArrayList<ClienteVO> lista, String idFichero) {

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

    public static void EscribirReservas(ArrayList<ReservaVO> lista, String idFichero) {

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
    
    // leer copias de seguridad
    public static ArrayList<PlazaVO> leerPlazas( String idFichero){
          ArrayList<PlazaVO> lemp = new ArrayList<>();
        int contador = 1;

        // Instanciación de BufferedReader a partir de un objeto InputStreamReader
        // InputStreamReader permite indicar el tipo de codificación del archivo
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(idFichero), "ISO-8859-1"))) {
            String[] tokens;
            String linea;

            while ((linea = br.readLine()) != null) {
                // utilizamos un contador hasta la linea 9 ya que esta es la primera que contiene info 

                
                    // hacemos variables que utilizaremos 
                   
                    // spliteamos los tokens y le quitamos los espacios
                    tokens = linea.split(",");
                    tokens[0] = tokens[0].trim();
                    tokens[1] = tokens[1].trim();
                    tokens[2] = tokens[2].trim();
                    tokens[3] = tokens[3].trim();
                  
                 
                    //int num_Plaza, double tarifa, int estado_Plaza, int tipo_Plaza
                    PlazaVO p = new PlazaVO(Integer.valueOf(tokens[0]),Double.valueOf(tokens[1]),
                            Integer.valueOf(tokens[2]),Integer.valueOf(tokens[3]));
                   lemp.add(p);

                
            }

            // el catch para  las excepciones
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lemp;
        
        
        
    }
    }


