/*
 *https://github.com/rociopalma/ht7AED.git
 */
package com.mycompany.ht7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author Rocío
 */
public class Main {

    Scanner leer = new Scanner(System.in);
    Node nodoEspanol;
    Node nodoIngles;
    Node nodoFrances;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        (new Main()).Inicializar();
    }

    public int getAscii(String dato) {
        int Ascii = 0;
        for (int i = 0; i < dato.length(); i++) {
            Ascii += (int) dato.charAt(i);

        }
        return Ascii;

    }
    
    /*public void menu(){
        int opcion = 1;
        while (opcion != 3) {
            System.out.println("**********Bienvenido*************");
            System.out.println("1. Traducir palabra");
            System.out.println("2. Imprimir in order");
            System.out.println("3) ---SALIR---");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Inicializar();

                    break;
                case 2:
                    nodoEspanol.inOrder();

                    break;

                

                default:
                    System.out.println("Hasta pronto");
                    break;
            }//fin case
            
        }//fin while
    }*/

    public void Inicializar() {
        String ingles = "house", espanol = "casa", frances = "loger";
        int key = getAscii(espanol.toUpperCase());

        nodoEspanol = new Node(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles = new Node(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);
        //System.out.println(nodoEspanol.toString());

        ingles = "dog";
        espanol = "perro";
        frances = "chien";
        key = getAscii(espanol.toUpperCase());
        nodoEspanol.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);

        ingles = "woman";
        espanol = "mujer";
        frances = "femme";
        key = getAscii(espanol.toUpperCase());
        nodoEspanol.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);

        ingles = "homework";
        espanol = "tarea";
        frances = "devoirs";
        key = getAscii(espanol.toUpperCase());
        nodoEspanol.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);

        ingles = "town";
        espanol = "pueblo";
        frances = "ville";
        key = getAscii(espanol.toUpperCase());
        nodoEspanol.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);

        ingles = "yes";
        espanol = "si";
        frances = "Oui";
        key = getAscii(espanol.toUpperCase());
        nodoEspanol.add(key, espanol, ingles, frances);
        key = getAscii(ingles.toUpperCase());
        nodoIngles.add(key, espanol, ingles, frances);
        key = getAscii(frances.toUpperCase());
        nodoFrances = new Node(key, espanol, ingles, frances);
        buscar();
        nodoEspanol.inOrder();
    }

    public void buscar() {
        String resultado = "";
        System.out.println("Ingrese la parabra que quiere traducir");
        String palabra = leer.nextLine();
        System.out.println("Ingrese el idioma origen de esta parabra ");
        String idiomaOrigen = leer.nextLine();
        System.out.println("Ingrese el idioma destino");
        String idiomaDestino = leer.nextLine();
        /*String palabra = "Woman";
        String idiomaOrigen = "Ingles";
        String idiomaDestino = "Espanol";*/
        Optional<Node> result;
        int key = getAscii(palabra.toUpperCase());
        switch (idiomaOrigen.toUpperCase()) {
            case "ESPANOL":
                result = nodoEspanol.find(key);
                if (result.isPresent()) {
                    if (idiomaDestino.toUpperCase().equals("FRANCES")) {
                        //System.out.println(result.get().getFrances());
                        resultado = result.get().getFrances();
                    } else if (idiomaDestino.toUpperCase().equals("INGLES")) {
                        //System.out.println(result.get().getIngles());
                        resultado = result.get().getIngles();
                    }

                } else {
                    System.out.println("*" + palabra + "*");
                }
                break;
            case "INGLES":
                result = nodoIngles.find(key);
                if (result.isPresent()) {
                    if (idiomaDestino.toUpperCase().equals("FRANCES")) {
                        //System.out.println(result.get().getFrances());
                        resultado = result.get().getFrances();
                    } else if (idiomaDestino.toUpperCase().equals("ESPANOL")) {
                        //System.out.println(result.get().getEspanol());
                        resultado = result.get().getEspanol();
                    }

                } else {
                    //System.out.println("*" + palabra + "*");
                    resultado = "*" + palabra + "*";
                }
                break;
            case "FRANCES":
                //result = nodoEspanol.find(key);
                result = nodoFrances.find(key);
                if (result.isPresent()) {
                    if (idiomaDestino.toUpperCase().equals("FRANCES")) {
                        //System.out.println(result.get().getFrances());
                        resultado = result.get().getFrances();
                    } else if (idiomaDestino.toUpperCase().equals("ESPANOL")) {
                        //System.out.println(result.get().getEspanol());
                        resultado = result.get().getEspanol();
                    }

                } else {
                    //System.out.println("*" + palabra + "*");
                    resultado = "*" + palabra + "*";
                }
                break;
            default:
                System.out.println("Idioma no permitido. Usar: Ingles, Espanol o Ingles");
        }
        escribirArchivo(resultado);

        /*Optional<Node> result = nodoEspanol.find(key);
        if (result.isPresent()) {
            System.out.println(result.get().getFrances());
        } else {
            System.out.println("*"+palabra+"*");
        }*/
    }

    public void escribirArchivo(String cadena) {
        System.out.println("Escribiendo el archivo... " + cadena);
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("Traduccion.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(cadena);
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
