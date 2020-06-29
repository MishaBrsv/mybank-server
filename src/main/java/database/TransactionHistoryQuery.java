package database;

import services.HashPasswordService;

import java.sql.*;

public class TransactionHistoryQuery {
    private final String url = "jdbc:postgresql://localhost:5432/mishabrsv";

    public void insert(Integer sender_id, Integer receiver_id,
                                         Double count, Timestamp date) {
        Statement statement;
        String query = "insert into transaction_history(sender_id, receiver_id, count, date) values " +
                "(" + sender_id + ", " + receiver_id + "," + count + ",'"+ date + "')";
        try (Connection con = DriverManager.getConnection(url)) {
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    //public String getSendInformation(Integer sender_id) {}

    //public String getGettingInformation(Integer receiver_id) {}
}
