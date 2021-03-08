package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bank {
    public void BankCheck(String username1, int bank_account, int number_card, int CVV) {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "Netflix";
        String username = "postgres";
        String password = "2009";
        PreparedStatement pt = null;
        ResultSet rs = null;
        ConnectDB connectDB = new ConnectDB();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);
            //st = connection.prepareStatement(qry);
            pt = connection.prepareStatement("insert into Bank(username,bank_account,number_card,cvv) values (?,?,?,?)");
            pt.setString(1, username1);
            pt.setInt(2, bank_account);
            pt.setInt(3, number_card);
            pt.setInt(4, CVV);
            pt.execute();
            System.out.println("Registered successfully\n");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}