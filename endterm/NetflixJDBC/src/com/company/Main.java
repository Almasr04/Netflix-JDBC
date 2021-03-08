package com.company;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_connection();
Menu menu =new Menu();
menu.StartFunc();
        try {
            //CREATE TABLE Registration(User_ID INTEGER,client_name varchar(200),surname VARCHAR(200),username VARCHAR(200) PRIMARY KEY,user_password INTEGER,email varchar);
            //String queryCreate = "CREATE TABLE Bank(username varchar(200),bank_account int,number_card int,CVV int, FOREIGN KEY (username) references Registration(username))";
            //String queryCreate = "CREATE TABLE movies(movie_name varchar(200),genres varchar(200),rating int(10),director varchar(100))";
            //String queryCreate = "CREATE TABLE movies_premium(movie_name varchar(200),genres varchar(200),rating int(10),director varchar(100))";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Joker','Thriller Drama',7,'Todd Philips')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Matrix','Fantasy Action',9,'Vachovsky Sisters')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Focus','Comedy Drama Melodrama',8,'Glen Phikarra')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('The Proposal','Melodrama Comedy Drama',8,'Enn Fletcher')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Fantastic Beasts: The Crimes of Grindelwald','Fantasy Adventure Family',9,'Davis Yeiets')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Prince of Persia: The Sands of Time','Fantasy Action',7,'Mike Newell')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Gifted','Drama',9,'Marl Webb')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Kingsman: The Golden Circle','Action Caomedy Adventure',9,'Mattew Von')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Forrest Gump','Drama',9,'Robert Zemekis')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('The Edge','Triller Drama Action',10,'Lee Tamahori')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('After Earth','Fantasy Adventure Action',8,'Mattew Nite')";
            //String queryInsert = "INSERT INTO movies(movie_name, genres ,rating ,director) values ('Pixels','Fantasy Action',8,'Chris Kolambus')";
            //String queryInsert = "INSERT INTO movies_premium(movie_name, genres ,rating ,director) values ('The Shawshank Redemption','Drama',10,'Frank Darabont')";
            //String queryInsert = "INSERT INTO movies_premium(movie_name, genres ,rating ,director) values ('Deadpool','Action Fantasy Comedy',7,'Tim Miller')";
            //String queryInsert = "INSERT INTO movies_premium(movie_name, genres ,rating ,director) values ('Ford vs Ferrari','Sport Drama Biography',10,'James Manglod')";
            //String queryInsert = "INSERT INTO movies_premium(movie_name, genres ,rating ,director) values ('The Intern','Comedy Melodrama',9,'Nansy Mayers')";
            //String queryInsert = "INSERT INTO movies_premium(movie_name, genres ,rating ,director) values ('The Martian','Fantasy Adventure',8,'Ridly Scott')";
            st = connection.createStatement();

            System.out.println("Done");

            st.close();
            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

