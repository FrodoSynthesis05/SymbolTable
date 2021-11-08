/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symboltableconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import symboltableconverter.*;

/**
 *
 * @author Julian
 */
public class SymbolTableConverter {

    public static SymbolTable s = new SymbolTable();
    public static String[] words;
    public static String[] copy = words;
    public static String result = ""; // Si lees esto funciono bblin
    //Nos vemos el viernes bblin
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String text = readString("LoremIpsum.txt");
        //System.out.println(text);
        words = passToArray(result);
        for (int i = 0; i < words.length; i = i + 1) {
            //System.out.println(words[i]);
        }
        //counter(s, copy);

        ST();
    }
    /*
    * Reads input string and scans for punctuation signs and replaces them with a blank space
    * Returns error message if it doesnt find a string to scan
    *
    */
    public static String readString(String file) {
        String text = "";

        try {
            Scanner s = new Scanner(new File(file));
            while (s.hasNextLine()) {
                text = text + s.nextLine().toLowerCase();
            }
            result = text.replaceAll("\\p{Punct}", "");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de entrada no encontrado.");
        }

        return result;
    }

    public static String[] passToArray(String resultArray) {

        String[] arreglo = resultArray.split(" ");

        return arreglo;

    }

    public static void ST() {

        for (int i = 0; i < words.length; i++) {
            s.put(Math.random(), words[i]);
        }

        System.out.println(s.size());
    }

    /**
     * Metodo que cuenta la cantidad de veces que sale cada palabra en el texto
     *
     * @param input Recibe Tabla de simbolos que contiene todas las palabras del
     * texto con un key al azar
     */
    public static int freq(SymbolTable input, String txt) {

        int counter = 0;
        for (int i = 0; i < input.size(); i++) {
            /* checking if string given as parameter is
                  present in the given SymbolTable. If present,
                  increase counter*/
            if (txt.equals(input)) {
                counter++;
            }
        }
        System.out.println(counter);
        return counter;

    }

    static void counter(SymbolTable arr, String[] q) {

        for (String palabra : words) {
            //System.out.print(freq(arr, q[i]) + " ");

            if (s.contains(palabra)) {
                s.put(palabra, s.get(palabra));

            } else {
                s.put(palabra, 1);
            }

        }


    }

} //end of class