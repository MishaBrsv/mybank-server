package database;

import services.HashPasswordService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountNumberQuery {
    private final String url = "jdbc:postgresql://localhost:5432/mishabrsv";

    public void insert(Integer client_id, String type, Double
                                     count) {
        Statement statement;
        String query = "insert into account_number(client_id, type, count) values " +
                "(" + client_id + ", '" + type + "'," + count + ")";
        try (Connection con = DriverManager.getConnection(url)) {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    //public void updateCount(Integer number, Double count) {}

    //public String getType(Integer number) {}

    //public Integer getClientId(Integer number) {}
}
