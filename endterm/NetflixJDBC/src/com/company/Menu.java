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
                System.out.println("*✲*´*。.❄¯*✲。❄。*¨`*✲´*。❄¨`*✲。❄。*`*\n" +
                        "*╔════════════ ༺❀༻❤༺❀༻ ════════════╗*\n" +
                        "*♥*❄¯*✲❄♫♪♩░N░E░T░F░L░I░X░ ♫♫♪❄¯*✲❄\n" +
                        "*╚════════════ ༺❀༻❤༺❀༻ ════════════╝*\n" +
                        "*✲*´*。.❄¯*✲。❄。*¨`*✲´*。❄¨`*✲。❄。*`*");
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
// 100%
//README - TECHNICAL PART
//FIND MOVIE
//FIND TYPE MOVIE
//SORTING RATING
//GIU(USER INTERFACE)->lOGIN (EXAMPLE EMAIL.PASSWORD)
//DEDLINE 00:00