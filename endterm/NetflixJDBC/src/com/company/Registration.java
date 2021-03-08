package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registration {
    public void CreateUser(String name,String surname,String username1,int user_password,String email){
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
            connection= DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name, username, password);
            //st = connection.prepareStatement(qry);
            pt=connection.prepareStatement("insert into Registration(client_name,surname,username,user_password,email) values (?,?,?,?,?)");
            pt.setString(1,name);
            pt.setString(2,surname);
            pt.setString(3,username1);
            pt.setInt(4,user_password);
            pt.setString(5,email);
            pt.execute();
            System.out.println("Registered successfully\n");
            connection.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}