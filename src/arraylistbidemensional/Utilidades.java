/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistbidemensional;

/**
 *
 * @author alumno
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class Utilidades {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FMR
 */

    
public static void clrscr(int n) {
    for (int i = 0; i < n; i ++) System.out.println();
}
public static void clrscr() {clrscr(25);}
 
 public static void verArray(int[] arr){
        for (int i=0;i<arr.length; i++){
            System.out.print(arr[i] + "-");
        }
        System.out.println("---");
    }  
 
 public static void verArrayConForEach(int[] arr){
     for(int a : arr){
        System.out.print(a + "-");
     }
 }
 public static void verArray(String[] arr){
        for (int i=0;i<arr.length; i++){
            System.out.print(arr[i] + "-");
        }
        System.out.println("---");
    }  
 
 public static String leerString(){return leerString("Introducir dato: ");};
 public static String leerString(String msg){
    System.out.print("\n"+msg);
    Scanner leerTeclado = new Scanner(System.in);
    String frase = leerTeclado.next();
    return frase;
}
 public static char leerChar(String msg){
    char letra= ' ';
    Scanner sc = new Scanner(System.in);
    System.out.println(msg);
    try {
        letra = (char)System.in.read();
    } catch (Exception e2){
        e2.printStackTrace();
    }
    return letra;   
    }

public static int leerNumero(){return leerNumero(-36000,+36000, "");}
public static int leerNumero(int min,int max){return leerNumero(min,max, "");} 
public static int leerNumero(int min, int max, String msg){
        Scanner leerTeclado = new Scanner(System.in);
        int numero=0;
        boolean puedeHaberError=true;
        while(puedeHaberError){
            
            System.out.println(msg); 
            try {
                numero = leerTeclado.nextInt();
                
                if (numero < min) { 
                    NumDemasiadoPequenioEx e1 = new NumDemasiadoPequenioEx("Error, numero demasiado pequeño.");
                    throw e1;
                }
                if (numero > max){
                    NumDemasiadoGrandeEx e2 = new NumDemasiadoGrandeEx("Error, numero demasiado grande.");
                    throw e2;
                }
                puedeHaberError=false;
            } catch (NumDemasiadoPequenioEx ex1){
                System.out.println("se ha producido un error ..." + ex1.getMessage());
            } catch (NumDemasiadoGrandeEx ex2){
                 System.out.println("se ha producido un error ..." + ex2.getMessage());
                
            } catch (Exception ex) {     
                    System.out.println("se ha producido un error..." + ex.getMessage());
            } finally {
                   
                    leerTeclado.nextLine();
            }
        }
       
       
        return(numero);
    }  
    public static int busquedaDicotomica(int[] t, int buscar){
        int   izq= 0;
        int   der= t.length-1;
        int   cen=(izq+der)/2 ;
         
        while( izq < der && t[cen] != buscar ) {	
            if( t[cen] < buscar ) {      		 
                izq = cen +1;      /*a la derecha*/
            } else { der = cen - 1;   /*a la izquierda*/
            }
            cen = (izq+der)/2;
        } 

        if (t[cen] != buscar){	
            cen = -1;
        }
        return cen;
    }
    
    public static void escribirFicheroTexto(ArrayList<String> cadenas, String nombreFichero){
        FileWriter ffichero = null;  // flujo de escritura de caracteres fichero
        PrintWriter fpw = null;      // flujo de escritura de caracteres
        try
        {
            ffichero = new FileWriter(nombreFichero);
            fpw = new PrintWriter(ffichero);

            for (int i = 0; i < cadenas.size(); i++)
                fpw.println(cadenas.get(i));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {  // aprovechamos el finally para asegurarnos que se cierra el fichero.
           if (null != ffichero)
              ffichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public static ArrayList<String> leerFicheroTexto(String nombrefichero) {
        
        ArrayList<String> cadenas= new ArrayList<String>();
        
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader (new File (nombrefichero));
         //   fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                cadenas.add(linea);
                System.out.println("Cargando :" + linea);
            }
        catch(Exception e){
            e.printStackTrace();
            }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return cadenas; 
    }// del programa
} // del fichero

