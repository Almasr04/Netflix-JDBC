# Netflix-JDBC
This is our EndTerm project for the Java object orientated programming course. Here we created JDBC of Netflix. 
Database consists of 3 Tables and we have 6 javaclasses in IDE.
First of all we created tables for registration bank account information and movie.
Registration consists of first name ,last name ,password , email and one primary key username which is connnected to the bank table.
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


Bank table stores cradit card information of users. It consists of username Foreign key ,bank account ,card number and CVV.
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


Movie table is created to store info about movies that we have in assortment.
we divided them into two types premium movies and just general which are accesable for all userswith subscription.
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


Now lets explain our java classes.
Registration is class wor inserting and checking values in tables so if you are new to our service it will register you.
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

After the registration is completed you can move on and fullfill the information about your bank account and sign in the value that you want to spend on subscription and chose what type of subscription do you want.We have three types of subscriptions they are: ordinary  ,standart and premium.Ordinary will cost 9$ standart about 11$ and premium one will cost 14$.
package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    Connection connection = null;
    Statement st = null;
    ResultSet rs;
    ConnectDB connectDB = new ConnectDB();
        public void StartFunc() {
            while (true) {
                System.out.println();
                System.out.println("©pavKTL");
                System.out.println();
                System.out.println();
                System.out.println("*✲*´*。.❄️¯*✲。❄️。*¨`*✲´*。❄️¨`*✲。❄️。*`*\n" +
                        "*╔════════════ ༺❀༻❤️༺❀༻ ════════════╗*\n" +
                        "*♥️*❄️¯*✲❄️♫♪♩░N░E░T░F░L░I░X░ ♫♫♪❄️¯*✲❄️\n" +
                        "*╚════════════ ༺❀༻❤️༺❀༻ ════════════╝*\n" +
                        "*✲*´*。.❄️¯*✲。❄️。*¨`*✲´*。❄️¨`*✲。❄️。*`*");
                System.out.println("Login:");
                Registration registration = new Registration();
                System.out.println("Please enter your name:");
                String name = scanner.next();
                if(name == null){
                    System.out.println("You didn't fill in your name, please fill in your name:");
                    name=scanner.next();
                    System.out.println("Please enter your surname:");
                    String surname = scanner.next();
                    System.out.println(name+" "+surname+",please enter your username:");
                    String username = scanner.next();
                    System.out.println(name+" "+surname+",please enter your password:(only number consist of 4 numbers)");
                    int password = scanner.nextInt();
                    System.out.println(name+" "+surname+",please enter your email");
                    String email = scanner.next();
                    registration.CreateUser(name,surname,username,password,email);
                }
                else {
                    System.out.println("Please enter your surname:");
                    String surname = scanner.next();
                    System.out.println(name + " " + surname + ",please enter your username:");
                    String username = scanner.next();
                    System.out.println(name + " " + surname + ",please enter your password (password<4):");
                    int password = scanner.nextInt();
                    System.out.println(name + " " + surname + ",please enter your email");
                    String email = scanner.next();
                    registration.CreateUser(name, surname, username, password, email);
                }
                System.out.println("Choose a subscription type:(Write the type of the subscription)");
                System.out.println("BASIC - 9$  || STANDARD - 11$  || PREMIUM - 15$");
                String type =scanner.next();
                if (type.matches("BASIC")){
                    Bank bank =new Bank();
                    System.out.println("Please enter your username:");
                    String username2 = scanner.next();
                    System.out.println("Please enter your bank account ($):");
                    int bank_acc = scanner.nextInt();
                    bank_acc=bank_acc-9;
                    System.out.println("PLease enter your number of card");
                    int number_card = scanner.nextInt();
                    System.out.println("Please enter your CVV");
                    int CVV=scanner.nextInt();

                }
                else if(type.matches("STANDARD")){
                    Bank bank =new Bank();
                    System.out.println("Please enter your username:");
                    String username2 = scanner.next();
                    System.out.println("Please enter your bank account ($):");
                    int bank_acc = scanner.nextInt();
                    bank_acc=bank_acc-11;
                    System.out.println("PLease enter your number of card");
                    int number_card = scanner.nextInt();
                    System.out.println("Please enter your CVV");
                    int CVV=scanner.nextInt();
                    }
                else{
                    Bank bank =new Bank();
                    System.out.println("Please enter your username:");
                    String username2 = scanner.next();
                    System.out.println("Please enter your bank account ($):");
                    int bank_acc = scanner.nextInt();
                    bank_acc=bank_acc-15;
                    System.out.println("PLease enter your number of card");
                    int number_card = scanner.nextInt();
                    System.out.println("Please enter your CVV");
                    int CVV=scanner.nextInt();

                }
                   System.out.println("Menu:");
                System.out.println("__________________________________________");
               System.out.println("Select option:");
                System.out.println("1-See all movies");
                System.out.println("2-Find movie");
                System.out.println("3-Find type movie");
                System.out.println("4-Sorting rating");
                System.out.println("5-See favorites");
                System.out.println("6-Find");
//                System.out.println("9-Exit");
//                System.out.println();
                try {
                    System.out.println("Enter option (1-5): ");
                    int option = scanner.nextInt();
                    if (option == 1) {
                    Movies movies = new Movies();
                    movies.showMovies();
                        System.out.println("Choose a movie (write its name)\n");
                        String movie_name = scanner.next();
                        movies.SelectMovie(movie_name);
                        System.out.println("Start watching ?");

                    break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("***********************************");

            }

        }

}
So what about work splitted between us.
We worked on one computer and we will show our work also on one so all the coding in java and inserts to tables creting tables all done on Almas`s notebook and on his sql server.However we were working together Registration Menu and Bank Classes were created by Almas. Most of the sql part and class of movies was done by Aldiyar. Report we are writing together using screen share and discussing what to write.
