package database;

import services.HashPasswordService;

import java.sql.*;

public class ClientQuery {
    private final String url = "jdbc:postgresql://localhost:5432/mishabrsv";

    public void insert(String username, String password, String first_name,
                             String second_name) {
        Statement statement;
        String query = "insert into client(username, password, first_name, second_name) values " +
                "('" + username + "', '" + HashPasswordService.hashPass(password) + "','" + first_name + "','"+ second_name + "')";
        try (Connection con = DriverManager.getConnection(url)) {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    //public String getId(String username) {}

    //public String getPassword(String username) {}

    //public String getPassword(Integer id) {}

    //public String getName(Integer id) {}

    //public void updatePassword(Integer id) {}

    //public void updateFirstName(Integer id) {}

    //public void updateSecondName(Integer id) {}

    //public void updateUsername(Integer id) {}
}
