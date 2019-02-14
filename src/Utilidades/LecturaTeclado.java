/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class LecturaTeclado {
    
    //leerEntero
    public static int leerEntero(){
        int num=leerEntero("?", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return num;
    }
    
    public static int leerEntero(String texto){
        int num=leerEntero(texto, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return num;
    }
    
    public static int leerEntero(String texto, int min, int max){
        Scanner sc = new Scanner(System.in);
        int numero=0;
        boolean puedeHaberError=true;
        while(puedeHaberError){
        System.out.println(texto);
        try {
            numero = sc.nextInt();
            if (numero < min || numero > max) {
                throw new Exception ("El número está fuera del rango: "+min+ " "+max);
            }
            puedeHaberError=false;
        } catch (Exception ex) {
            System. out.println("se ha producido un error..." + ex.getMessage());
        } finally {
            //System.out.println("Limpiando el buffer");
            sc.nextLine();
        }
    }
        return(numero);
    }
    
    // Leer Carácter
    public static char leerCaracter(String texto){
        Scanner sc = new Scanner(System. in);
        char c=' ';
        boolean puedeHaberError=true;
        while(puedeHaberError){
            System. out.println(texto);
            try {
                c = sc.nextLine().charAt(0);
                puedeHaberError=false;
            } catch (Exception ex) {
                System. out.println("se ha producido un error..." + ex.getMessage());
              } finally {
                //System.out.println("Limpiando el buffer");
                //sc.nextLine();
                }
            }
        return(c);
    }
    // Leer Cadena
    public static String leerCadena(String texto){
        Scanner sc = new Scanner(System.in);
        String s="";
        boolean puedeHaberError=true;
        while(puedeHaberError){
            System.out.print(texto+"\t");
            try {
                s = sc.nextLine();
                puedeHaberError=false;
            } catch (Exception ex) {
                System. out.println("se ha producido un error..." + ex.getMessage());
              } finally {
                    //System.out.println("Limpiando el buffer");
                    //sc.nextLine();
                }
            }
        return(s);
    }
} /*
public static void main(String[] args ){
char c= leerCaracter("Pulsa una tecla...");
System.out.println("Tecla: "+c);
int num = leerEntero("Introduce un numero", 0, 10);
System.out.println("Numero: " + num);
}
}
*/
    
    
    


