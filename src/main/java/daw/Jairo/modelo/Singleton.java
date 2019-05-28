/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Jairo.modelo;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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
    // leemos reservas 
     public static ArrayList<ReservaVO> leerReservas( String idFichero){
          ArrayList<ReservaVO> lemp = new ArrayList<>();
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
                    tokens[4] = tokens[4].trim();
                  
                 
                    //int num_Plaza, int cod_Vehiculo, int cod_Cliente, int pin_fijo, double coste
                    ReservaVO p = new ReservaVO(Integer.valueOf(tokens[0]),Integer.valueOf(tokens[1]),
                    Integer.valueOf(tokens[2]),Integer.valueOf(tokens[3]),Double.valueOf(tokens[4]));
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
     public static ArrayList<VehiculoVO> leerVehiculos( String idFichero){
          ArrayList<VehiculoVO> lemp = new ArrayList<>();
       
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
               
                  
                 
                    //int codvehiculo, String matricula, int tipo_Vehiculo
                    VehiculoVO p = new VehiculoVO(Integer.valueOf(tokens[0]),tokens[1],
                    Integer.valueOf(tokens[2]));
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
    
      public static ArrayList<ClienteVO> leerClientes( String idFichero){
          ArrayList<ClienteVO> lemp = new ArrayList<>();
       
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
                     tokens[4] = tokens[4].trim();
                    tokens[5] = tokens[5].trim();
                    tokens[6] = tokens[6].trim();
               
                  
                 
                    //int cod_Cliente, LocalDate fec_in_abono, LocalDate fec_fin_abono, String nombre, String tarjeta, int tipo_Abono, String email
                    ClienteVO p = new ClienteVO(Integer.valueOf(tokens[0]),LocalDate.parse(tokens[1]),
                    LocalDate.parse(tokens[2]), tokens[3],tokens[4],Integer.valueOf(tokens[5]),tokens[6]);
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
        public static ArrayList<PinesVO> leerPines( String idFichero){
          ArrayList<PinesVO> lemp = new ArrayList<>();
       
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
                     tokens[4] = tokens[4].trim();
                    tokens[5] = tokens[5].trim();
                    tokens[6] = tokens[6].trim();
                    tokens[7] = tokens[7].trim();
               
                  
                 
    //int cod_Vehiculo, int num_Plaza, String pen_Desechable, double coste, LocalDate fec_Fin_Pin_Dia, LocalTime fec_Fin_Pin_Hora, LocalDate fec_In_Pin_Dia, LocalTime fec_In_Pin_Hora
                    PinesVO p = new PinesVO(Integer.valueOf(tokens[0]),Integer.valueOf(tokens[1]),
                   tokens[2], Double.valueOf(tokens[3]),LocalDate.parse(tokens[4]),LocalTime.parse(tokens[5]),LocalDate.parse(tokens[6]),LocalTime.parse(tokens[7]));
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
        
        public void crearBackup () throws SQLException{
            LocalDate hoy = LocalDate.now();
             DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(hoy);  
            File directorio = new File(strDate);
            PinesDAO p = new PinesDAO();
            List<PinesVO> listapines =  p.getAllPines();
            EscribirPines((ArrayList<PinesVO>) listapines,strDate+"/"+"pines");
             VehiculoDAO v = new VehiculoDAO();
            List<VehiculoVO> listavehiculos =  v.getAll();
            EscribirVehiculos((ArrayList<VehiculoVO>) listavehiculos,strDate+"/"+"vehiculos");
             PlazaDAO pl = new PlazaDAO();
            List<PlazaVO> listaplaza =  pl.getAll();
            EscribirPlaza((ArrayList<PlazaVO>) listaplaza,strDate+"/"+"plazas");
             ReservaDAO reser = new ReservaDAO();
            List<ReservaVO> reservas =  reser.getAll();
            EscribirReservas((ArrayList<ReservaVO>) reservas,strDate+"/"+"reservas");
             ClienteDAO c = new ClienteDAO();
            List<ClienteVO> listacliente =  c.getAllClientes();
            EscribirClientes((ArrayList<ClienteVO>) listacliente,strDate+"/"+"pines");
            
            
        
        
        }
     
    }


