/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ht7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author Rocío
 */
public class Main {

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
    }

    public void buscar() {
        String resultado = "";
        //preguntarle al usuario lo que necesita buscar
        String palabra = "Yes";
        String idiomaOrigen = "Ingles";
        String idiomaDestino = "Frances";
        Optional<Node> result;
        int key = getAscii(palabra.toUpperCase());
        switch (idiomaOrigen) {
            case "Espanol":
                result = nodoEspanol.find(key);
                if (result.isPresent()) {
                    if(idiomaDestino.equals("Frances")){
                        System.out.println(result.get().getFrances());
                    }else if (idiomaDestino.equals("Ingles")){
                        System.out.println(result.get().getIngles());
                    }
                    
                } else {
                    System.out.println("*" + palabra + "*");
                }
                break;
            case "Ingles":
                result = nodoIngles.find(key);
                if (result.isPresent()) {
                    if(idiomaDestino.equals("Frances")){
                        //System.out.println(result.get().getFrances());
                        resultado = result.get().getFrances();
                    }else if (idiomaDestino.equals("Espanol")){
                        //System.out.println(result.get().getEspanol());
                        resultado = result.get().getEspanol();
                    }
                    
                } else {
                    //System.out.println("*" + palabra + "*");
                    resultado = "*" + palabra + "*";
                }
                break;
            case "Frances":
                //result = nodoEspanol.find(key);
                result = nodoFrances.find(key);
                if (result.isPresent()) {
                    if(idiomaDestino.equals("Frances")){
                        //System.out.println(result.get().getFrances());
                        resultado = result.get().getFrances();
                    }else if (idiomaDestino.equals("Espanol")){
                        //System.out.println(result.get().getEspanol());
                        resultado = result.get().getEspanol();
                    }
                    
                } else {
                    //System.out.println("*" + palabra + "*");
                    resultado = "*" + palabra + "*";
                }
                break;
                
        }
        escribirArchivo(resultado);

        /* Optional<Node> result = nodoEspanol.find(key);
        if (result.isPresent()) {
            System.out.println(result.get().getFrances());
        } else {
            System.out.println("*"+palabra+"*");
        }*/
    }
    
    public void escribirArchivo(String cadena){
        System.out.println("Escribiendo el archivo "+cadena);
    }

}
