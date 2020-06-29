package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TokenQuery {
    private final String url = "jdbc:postgresql://localhost:5432/mishabrsv";

    public void insert(String token, Integer client_id,
                           String type) {
        Statement statement;
        String query = "insert into token(token, client_id, type) values " +
                "('" + token + "'," + client_id + ",'" + type + "')";
        try (Connection con = DriverManager.getConnection(url)) {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    //public void getToken(Integer client_id, String type) {}

    //public void updateToken(String token, String newtoken) {}
}
