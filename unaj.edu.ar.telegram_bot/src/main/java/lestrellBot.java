import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class lestrellBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        //System.out.println(update.getMessage().getText());

        SendMessage message = new SendMessage();
        String command = update.getMessage().getText();
        if(command.equals("/responder")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }
        if(command.equals("/cargarbase")){
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "username", "password");
                Statement stmt = con.createStatement();
                int rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('555-777-777-77','Planta Rara')");
                rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('666-778-888-88','Planta Rara 4')");
                rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('88-123-123-99','Planta Rara 3')");
                rs = stmt.executeUpdate("INSERT INTO libros(isbn,name)" + "VALUES('72-727-727-77','Planta Rara 2')");
                rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)" + "VALUES('2345678','Juan','Perez','Fake123')");
                rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)" + "VALUES('345222','Pablo','Perez','NotFake123')");
                rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)" + "VALUES('1194566','Fabricio','Bustos','Bochini 120')");
                rs = stmt.executeUpdate("INSERT INTO persona(dni,nombre,apellido,direccion)" + "VALUES('135666','Pepe','Argento','HijoNuestro')");
                rs = stmt.executeUpdate("INSERT INTO prestamo(persona,libro)" + "VALUES('345222','555-777-777-77')");
                rs = stmt.executeUpdate("INSERT INTO prestamo(persona,libro)" + "VALUES('1194566','666-778-888-88')");
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(command.equals("/mostrar")){
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "username", "password");
                Statement stmt = con.createStatement();
                ResultSet resultat = stmt.executeQuery("SELECT * from prestamo");
                List<String> resultados = new ArrayList<String>();
                while (resultat.next()) {
                    resultados.add(resultat.getString("id"));
                    resultados.add(resultat.getString("persona"));
                    resultados.add(resultat.getString("libro"));

                }
                message.setText(String.valueOf(resultados));
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "lestrell_bot";
    }

    public String getBotToken() {
        return null;
    }
}

