package AJSW.P2ej4;

import java.util.ArrayList;
import java.util.Iterator;


public class Biblioteca {
    public static void main(String[] args){
        ArrayList<Libros> libros = new ArrayList<Libros>();
        libros.add(new Libros("988-123-456-123","Prueba de libro"));
        libros.add(new Libros("133-123-123-123","Otro libro"));
        libros.add(new Libros("234-234-345-456","Another thing coming"));

        Iterator n = libros.iterator();
        while (n.hasNext()){
            Libros l = (Libros) n.next();
            System.out.println(l.getNombre());
        }
    }
}

class Libros{
    String isbn,nombre;

    public Libros(String id,String n){
        isbn=id;
        nombre=n;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }
}
