package AJSW.P2ej3;

import java.util.Scanner;
import java.io.*;

public class Flujo_IO {

    public static void main(String[] args) throws IOException {
        try {
            String texto;

            Scanner consola = new Scanner(System.in);

            System.out.println("Ingrese su nombre: \t");
            texto = consola.next();

            System.err.println("Le erraste papu");

            System.out.println("Su pinche nombre es: \t" + texto);

            String ruta = "/home/trialsgama/prueba.txt";
            File arquivo = new File(ruta);

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo);


            while(!texto.equals("\\"))

            {
                texto = consola.next();
                fw.write(texto);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Aca termina el programa");
        }


    }

}

