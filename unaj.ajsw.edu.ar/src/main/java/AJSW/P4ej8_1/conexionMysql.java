package AJSW.P4ej8_1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class conexionMysql {
    public static void main(String args[]){
        try

    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "username", "password");
        Statement stmt = con.createStatement();
        //int rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('777-777-777-77','Planta Rara')");
        /*int rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('777-778-888-88','Planta Rara 4')");
        rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('777-123-123-99','Planta Rara 3')");
        rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('777-727-727-77','Planta Rara 2')");
        rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)"+ "VALUES('12345678','Juan','Perez','Fake123')");
        rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)"+ "VALUES('12345222','Pablo','Perez','NotFake123')");
        rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)"+ "VALUES('19234566','Fabricio','Bustos','Bochini 120')");
        rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)"+ "VALUES('12345666','Pepe','Argento','HijoNuestro')");
        rs = stmt.executeUpdate("INSERT INTO prestamo(persona,libro)"+ "VALUES('12345666','777-123-123-99')");
        rs = stmt.executeUpdate("INSERT INTO prestamo(persona,libro)"+ "VALUES('19234566','777-778-888-88')");*/
        ResultSet resultat= stmt.executeQuery("SELECT * from prestamo");
        List<String> resultados=new ArrayList<String>();

        while (resultat.next()){
            resultados.add(resultat.getString("id"));
            resultados.add(resultat.getString("persona"));
            resultados.add(resultat.getString("libro"));

        }
        System.out.println(resultados);
        con.close();


    } catch(
    Exception e)

    {
        System.out.println(e);
    }
}


}
