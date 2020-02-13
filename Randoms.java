/*
 * Librerias a utilizar
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Randoms {
	public Randoms() {
		
	/*
     * Archivos a crear
     */
    File creador = new File("random.txt"); // Nombre de archivo
    FileWriter fw = null;
    /*
     * La cantidad de numeros que se crearan en el archivo
     */
    int cantidadN = 3000; 
    /*
     * UN try para la creacion
     */
    try {
        /*
         * Instancia del escritor de archivo
         */
        fw = new FileWriter(creador);
        /*
         * Instancia del BufferedWriter para el escritor
         */
        BufferedWriter writer = new BufferedWriter(fw);
        int line;
        Random random = new Random();
        while (cantidadN > 0) {
            /*
             * Creacion de los numeros aleatorios 
             */
            line = random.nextInt(10000);
            /*
             * La escritura
             */
            writer.write(line + "\n");
            cantidadN--;
        }
        /*
         * El cierre de escritura
         */
       writer.close();
       /*
        * La excepcion de la programación defenisva
        */
    	} catch (IOException e) {
        e.printStackTrace();
        System.exit(0);
    	}
	}
}
