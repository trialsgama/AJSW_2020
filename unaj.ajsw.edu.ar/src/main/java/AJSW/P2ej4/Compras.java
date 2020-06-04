package AJSW.P2ej4;
import java.util.ArrayList;
import java.util.Iterator;

public class Compras {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();

        lista.add("Huevos");
        lista.add("Queso");
        lista.add("Fideos");

        Iterator x = lista.iterator();

        while (x.hasNext()) {
            System.out.println(x.next());
        }


    }
}