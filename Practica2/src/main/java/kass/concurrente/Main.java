package kass.concurrente;

import kass.concurrente.constants.Constante;
import kass.concurrente.crypto.Cifrar;

/**
 * Clase Principal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Long inicio = System.nanoTime();

        //System.out.println(Cifrar.descifraC(Constante.LLAVE, Constante.CONTRASENNA));
        String contr = "";

        for (int i = 1; i <= 13; i++) {
            genera_palabras(Constante.ALFABETO, i, "");
        }
            

        Long fin = System.nanoTime();
        Long total = fin-inicio;
        System.out.println("TIEMPO TOTAL: " + nanoSegundoASegundo(total));
        System.out.println("Practica 2");
    }

    public static double nanoSegundoASegundo(Long tiempo){
        return tiempo *1.0 * Math.pow(10,-9);
    }

    public static void genera_palabras(String alfabeto, int longitudMaxima, String prefijo) {
        if (prefijo.length() <= longitudMaxima) {
            // Generar nuevas combinaciones añadiendo cada letra del alfabeto al prefijo actual
            for (int i = 0; i < alfabeto.length(); i++) {
                String nuevaCombinacion = prefijo + alfabeto.charAt(i);
                try{
                    if(Cifrar.descifraC(Constante.LLAVE, nuevaCombinacion)){
                        System.out.println(nuevaCombinacion);    
                        return;
                    }
                }catch(Exception e){}
                genera_palabras(alfabeto, longitudMaxima, nuevaCombinacion);
            }
        }
    }

}






/*
 * _  _  _  _
 * A 27 27 27
 */