package com.company;
import java.sql.Connection;//импортирую из пакета java.sql
import java.sql.DriverManager;
public class ConnectDB {
    public Connection get_connection() {
        Connection connection = null;//обявляю переменую типа connection только после connection можно использовать разные виды манипуляций
        String host = "localhost";
        String port = "5432";
        String db_name = "Netflix";
        String username = "postgres";
        String password = "2009";
        try {//нужно использовать try-catch потомо что driver manager может не подключится из за библотеки
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name, username, password);
            //DriverManager -  с помощью него мы можем зарегестрировать наш driver
            if(connection!=null) {
                System.out.println("Database opened successfully \n");

            } else {
                System.out.println("Database failed to open \n");
            }

        }catch(Exception e) {
            System.out.println(e);
        }
        return connection;

    }


}

