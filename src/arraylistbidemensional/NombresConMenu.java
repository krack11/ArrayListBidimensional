/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistbidemensional;

//Escribir una clase que permita crear y gestionar un arrayList de nombres a través de un menú.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class NombresConMenu {
    
    public static String menu(){
        Utilidades.clrscr();
        System.out.println("" +
            "\n             *** GESTION DE NOMBRES ***" +
            "\n =====================================================\n" +
            "A-ñadir elemento\n" +
            "B-uscar posición de elemento \n" +
            "R-ecuperar un elemento correspondiente a una posición.\n" +
            "M-odificar un elemento \n" +
            "I-nsertar un elemento en una posición\n" +
            "E-liminar el elemento que ocupa una posición\n" +
            "L-listar todos los elementos.\n" +
            "O-Ordenar elementos ascendentemente"+
            "V-Vaciar la lista"+
            "S-alir" +
            "\n =====================================================");
        String opc=Utilidades.leerString( "\n Selecciona opción...");
        return opc;
    }
    public static void main(String[] arg){
                //nO PONER---ArrayList<String>miLista=Utilidades.leerFicheroTexto("d:\\arrayListDeNombres.txt");
        
    // Cargamos una lista con valores iniciales para tener "ALGO"
        ArrayList<String>miLista = new ArrayList<>(
                Arrays.asList("Julio","Alberto","jose","Pedro"));
    
    // Creamos variables de trabajo
         char dummy;
         int posicion;
         String nombre;
         String opc="";
         
    // Gestionamos...
         while (!opc.equals("S")){
             opc=menu();
             switch (opc){
                case "A":       // añadir elemento
                     nombre=Utilidades.leerString("Introduce del elemento para añadir: ");
                     miLista.add(nombre);
                     break;
                case "B":       // buscar posicion elemento
                    nombre=Utilidades.leerString("Introduce el nombre a buscar: ");
                    posicion=miLista.indexOf(nombre);
                    System.out.print("\nOcupa la posición: " + posicion);
                     break;
                case "R":       // recuperar elemento de una posición
                    posicion= Utilidades.leerNumero(0,miLista.size()-1,"Introduce Posicion: ");
                    nombre=miLista.get(posicion);
                    System.out.print("\nCorresponde al nombre: "+ nombre);
                     break;
                case "M":       // modificar elemento de una posición
                    posicion= Utilidades.leerNumero(0,miLista.size()-1,"Introduce Posicion a modificar: ");
                    nombre=Utilidades.leerString("Introduce el nombre nuevo: ");
                    miLista.set(posicion, nombre);
                     break;
                case "I":       // insertar elemento en una posición 
                    posicion= Utilidades.leerNumero(0,miLista.size()-1,"Introduce Posicion a modificar: ");
                    nombre=Utilidades.leerString("Introduce el nombre nuevo: ");
                    miLista.add(posicion, nombre);
                     break;
                case "E":       // borrar elemento que ocupa una posición
                    posicion= Utilidades.leerNumero(0,miLista.size()-1,"Introduce Posicion del elemento a borrar : ");
                    miLista.remove(posicion);
                     break;
                case "L":       // listar todos los elementos
                    System.out.println("\n *** Listado ***");
                    /*for (posicion=0; posicion<miLista.size(); posicion++){
                        System.out.print("\nPosicion: " + posicion + "\tNombre: " + miLista.get(posicion));
                    }*/
                    Iterator<String> it= miLista.iterator();
                    while (it.hasNext()){
                            System.out.println("Nombre: " + it.next());
                    } 
                     break;
                case "O":
                    break;
                case "V":
                    break;
                case "S":       // salir
                    System.out.println("\n Has pulsado Salir");
                     break;
                default:
                    System.out.println("\n Error, opción no válida");
                    break;
             } // de swith
             dummy=Utilidades.leerChar("\nPulsa intro para continuar...");
         }// de while
         Utilidades.escribirFicheroTexto(miLista, "d:\\arrayListDeNombres.txt");
    }// de main
}
    
    
    
    
    

