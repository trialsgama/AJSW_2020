package AJSW.P2ej3;
import java.util.Scanner;

public class Hilo extends Thread {
    public void run(){
        String nombre;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: \n");
        nombre= sc.next();
        System.out.println("Este su nombre: " + nombre + " implementando hilos");
    }
    public static void main(String[] args){
        Hilo t1 = new Hilo();
        t1.start();
    }
}