package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Movies {
    public void showMovies() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "Netflix";
        String username = "postgres";
        String password = "2009";
        Statement st = null;
        ResultSet rs = null;
        ConnectDB connectDB = new ConnectDB();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);
            //st = connection.prepareStatement(qry);
            st = connection.createStatement();
            String querySelect = "SELECT*FROM Movies;";
            rs = st.executeQuery(querySelect);
            while (rs.next()) {
                String movie_name = rs.getString(1);
                String genres = rs.getString(2);
                int rating = rs.getInt(3);
                String director = rs.getString(4);

                System.out.println(" | " +  movie_name + " | " + genres + " | " + rating + " | " + director);
            }
            System.out.println("Successful Records Done");
            rs.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void SelectMovie(String movie_name1) {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "Netflix";
        String username = "postgres";
        String password = "2009";
        Statement st = null;
        ResultSet rs = null;
        ConnectDB connectDB = new ConnectDB();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);
            //st = connection.prepareStatement(qry);
            st = connection.createStatement();
            String querySelect = "SELECT*FROM movies WHERE movie_name='"+movie_name1+"';";
            rs = st.executeQuery(querySelect);
            while (rs.next()) {
                String movie_name = rs.getString(1);
                String genres = rs.getString(2);
                int rating = rs.getInt(3);
                String director = rs.getString(4);

                System.out.println(" | " +  movie_name + " | " + genres + " | " + rating + " | " + director);

            }

            rs.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}