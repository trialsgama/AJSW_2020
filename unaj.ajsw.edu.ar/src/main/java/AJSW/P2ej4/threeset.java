package AJSW.P2ej4;
import java.util.Iterator;
import java.util.TreeSet;

public class threeset {
    public static void main(String[] args){
        TreeSet docus = new TreeSet();

        docus.add("36664298");
        docus.add("14773806");
        docus.add("38930683");
        docus.add("12345678");
        docus.add("4000000");

        Iterator n = docus.iterator();

        while(n.hasNext()){
            System.out.println(n.next());
        }
    }
}