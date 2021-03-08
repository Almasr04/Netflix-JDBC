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
