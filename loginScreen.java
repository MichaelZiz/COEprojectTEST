/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.Scanner;
import java.util.ArrayList;


public class loginScreen {

    static private int k = 0, p = 0;
    private static ArrayList<customer> userspointer;
    private static ArrayList<String> titles;
    static private movies[] movieArr;

    public static manager Managersetup(manager one) {
        String password, name;
        int x = 0, x1 = 0, z1 = 0, qw = 0, b = 0;

        System.out.println("Security: Manager Setup: please enter/re Enter a password of 5 characters length, user automatically set as admin (admin,admin)");
        while (x == 0) {
            Scanner v = new Scanner(System.in);
            password = v.nextLine();
            if (password.length() <= 5) {

                if (password.equals(one.getAdminPassword()) == true) {

                    System.out.println("Password Accepted");
                    System.out.println("enter Username");

                    while (z1 == 0) {
                        if (v.hasNextLine() == true) {
                            name = v.nextLine();
                            if (name.equals(one.getUserName())) {
                                System.out.println("Username Accepted");
                                x = 1;
                                z1 = 1;
                            } else {
                                System.out.println("wrong Username or exceeds length 5 char");
                            }

                        } else {
                            System.out.println("enter a valid string");
                        }
                    }
                } else {
                    System.out.println("wrong password");
                }
            } else {
                System.out.println("enter a password of 5 characters length");
            }
        }

        System.out.println("As a manager you must create Movies");

        do {

            System.out.println(" \n Press 1 to create Movie \n Press 2 To LogOut of Manager");

            while (qw == 0) {
                Scanner q = new Scanner(System.in);
                if (q.hasNextInt() == true) {
                    b = q.nextInt();
                    if (b == 1 || b == 2) {
                        break;
                    } else {
                        System.out.println("enter 1 or 2");
                    }
                } else {
                    System.out.println("enter valid integer");
                }
            }

            if (b == 1 || b == 2) {//if statements corresponding to user input

                if (b == 1) {
                    String movieName;
                    double price;
                    int seatNum, y9 = 0, y8 = 0;
                    System.out.println("Type in movie title to create"); // movie title cannot occur twice 
                    Scanner v = new Scanner(System.in);
                    movieName = v.nextLine();

                    while (y9 == 0) {
                        Scanner yo = new Scanner(System.in);
                        System.out.println("enter ticket price, ticket price lies from 5 to 25 dollars");
                        if (yo.hasNextDouble() == true) {
                            price = yo.nextDouble();
                            if (price > 5 && price < 25.0) {

                                while (y8 == 0) {
                                    Scanner yo1 = new Scanner(System.in);
                                    System.out.println("enter # of available seats for the movie between 20 and 30 seats");
                                    if (yo1.hasNextInt() == true) {
                                        seatNum = yo1.nextInt();
                                        if (seatNum > 19 && seatNum < 31) {
                                            if (k > -1 && k < 8) {

                                                one.addMovie(movieName, seatNum, price, k);
                                                y8 = 1;
                                                y9 = 1;
                                                k++;
                                                System.out.println("movie created");

                                            } else {
                                                System.out.println("reached maximum amount of movies to create for the day");
                                                y8 = 1;
                                                y9 = 1;

                                            }
                                        } else {
                                            System.out.println("movie theater capacity lies from 19 to 31 seats ");
                                        }
                                    } else {
                                        System.out.println("Enter a valid decimal number");
                                    }
                                }

                            }
                        } else {
                            System.out.println("ticket prices can only be between 5 and 25 dollars");
                        }
                    }

                }

                if (b == 2) {//Exit Manager
                    System.out.println("exiting manager");
                    x1 = 1;
                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x1 == 0);

        return one;
    }

    public static void CustomerAccess(int i, ArrayList<customer> userspointer1, ArrayList<String> titles1, movies movies1[]) {
        // customer should be able to purchase a ticket, refund a ticker
        //and check the information on their seats, need to pass the customer array
        // that customer array needs to have a pointer to the customers specific seat

        int y = 0, x = 0, x1 = 0;
        int b = 0;
        do {

            System.out.println(" \n Press 1 Purchase Ticket\n Press 2 to View Info on Booking\n "
                    + "Press 3 Refund Tickets\n Press 4 Exits \n press 5 for titles playing");

            while (x1 == 0) {
                Scanner v = new Scanner(System.in);
                if (v.hasNextInt() == true) {
                    b = v.nextInt();
                    x1 = 1;
                } else {
                    System.out.println("enter an integer");
                }
            }

            if (b == 1 || b == 2 || b == 3 || b == 4 || b == 5) {//if statements corresponding to user input

                if (b == 1) {//Purchase Tickets
                    int age = 0, y1 = 0;
                    //Enter age
                    while (y1 == 0) {
                        Scanner v1 = new Scanner(System.in);
                        if (v1.hasNextInt() == true) {
                            age = v1.nextInt();
                            if (age > 0) {

                                age = v1.nextInt();
                                y1 = 1;
                            } else {
                                System.out.println("enter value above 0 for age");
                            }
                        } else {
                            System.out.println("enter a valid integer for age");
                        }
                    }

                    //enter seats and need to check the seat availability, need to pass through movies seats
                    //
                    System.out.println("Available movies");
                    String q = "\n";
                    for (int k = 0; k < titles1.size() - 1; k++) { // check the movies with a for loop that loops through and macthes the name hence also matching the number of seast along with it
                        if (titles.get(k) == null) {
                        } else {
                            q = "\n" + q + titles.get(k);
                            System.out.println(q);
                        }

                    }

                    int lp = 0;
                    String titlerequest;
                    do {
                        // ask user to input a string of movie title they like to attend 
                        // title doesnt exist then loop and ask them to  do it again 
                        System.out.println("enter a movie title");
                        Scanner moviet = new Scanner(System.in);
                        titlerequest = moviet.nextLine();

                        if (titles.contains(titlerequest)) {
                            //check available seats for that title
                            // if avaiable ask user to input value for seats
                            //check if user entered a valid int and that their is a number of seats avaiable
                            for (int j = 0; j < movies1.length; j++) {//enhanced loop
                                if (titlerequest.equals(movies1[j].getMovie())) {
                                    if (movies1[j].SeatsAvailable() > 0) {

                                        System.out.println("Available seats");
                                        System.out.println(movies1[j].SeatsAvailable());
                                        System.out.println("enter Number of seats you would like to purchase(limited to 4 per person)");
                                        int p1 = 0, seatholder;
                                        while (p1 == 0) {
                                            Scanner seatsnum = new Scanner(System.in);
                                            if (seatsnum.hasNextInt() == true) {
                                                seatholder = seatsnum.nextInt();

                                                if (seatholder > 0 && seatholder <= movies1[j].SeatsAvailable()) {
                                                    if (seatholder < 5 && seatholder > 0) {
                                                        userspointer1.get(i).purchaseTicket(age, seatholder, titlerequest, movies1[j]);
                                                        // should have a away to decrement the seats in movie and from customer point to movie so user can later access info
                                                        p1 = 1;
                                                        lp = 1;
                                                    } else {
                                                        System.out.println(" enter any seat number from 1-4");
                                                    }

                                                } else {
                                                    System.out.println("seat number should be less than or equal to the available seats");
                                                }

                                            } else {
                                                System.out.println("enter an integer");
                                            }

                                        }
                                    } else {
                                        System.out.println("No seats available for this movie");
                                    }
                                }
                            }

                        } else {
                            System.out.println("enter a valid movie title from the selection" + q);

                        }

                    } while (lp == 0);

                    //prompt user for input of age cant be negative,seats limit is 1 to 4, moviename must match one of those available
                    //  userspointer1.get(i).purchaseTicket(b, b, movieName);
                }

                if (b == 2) {//View Info on customers account his/her purchases, #of seats, movie title, 

                    userspointer1.get(i).SetinformationONticket();

                }
                if (b == 3) {//Refund tickets
                    int lp1 = 0;

                    do {

                        if (userspointer1.get(i).getTitle() == null) {
                            System.out.println("You haven't purchased any tickets, no tickets to refund");
                            lp1 = 1;
                        } else {
                            System.out.println("will be refunding this booking" + userspointer1.get(i).SetinformationONticket());

                            userspointer1.get(i).refundTicket(userspointer1.get(i).getMovie1(), userspointer1.get(i).getSeatnum());
                            lp1 = 1;

                        }

                    } while (lp1 == 0);

                }

                if (b == 4) {//exit
                    x = 1;
                }

                if (b == 5) {// view movies playing
                    //best to implement this through a method in manager class
                    System.out.println("Available movies");
                    String q = "\n";
                    for (int k = 0; k < titles1.size() - 1; k++) { // check the movies with a for loop that loops through and macthes the name hence also matching the number of seast along with it
                        if (titles.get(k) == null) {
                        } else {
                            q = "\n" + q + titles.get(k);
                            System.out.println(q);
                        }

                    }

                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
        } while (x == 0);

    }

    public static void main(String[] args) {

        manager one = new manager();
        System.out.println("Manager unique number is 0");

        one = Managersetup(one);
        //exit manager

        System.out.println("Accesssing Main directory");

        String name, password;
        int x = 0, x1 = 0, accnum = 0;//set it zero here no account will have 0 for users
        while (x == 0) {
            int access;
            System.out.println("Press 1 to enter to Login As customer\n Press 2 to Register as a user\n 3 To exit");
            Scanner q = new Scanner(System.in);
            if (q.hasNextInt() == true) {
                access = q.nextInt();

                if (access == 1) {

                    System.out.println("Login: enter Username ");
                    Scanner h = new Scanner(System.in);
                    name = h.nextLine();
                    System.out.println("Login: enter password");
                    password = h.nextLine();
                    System.out.println("enter password account number");

                    while (x1 == 0) {
                        Scanner pop = new Scanner(System.in);
                        if (pop.hasNextInt() == true) {
                            accnum = pop.nextInt();
                            x1 = 1;
                        } else {
                            System.out.println("enter an integer");

                        }

                    }
                    // useful info needed for purchase ticket
                    userspointer = one.getList();
                    titles = one.getMovieTitles();
                    movieArr = one.getMovies();
                    int counter1 = 0;
                    try {
                        //System.out.println(accNum);
                        if (password.equals(one.getAdminPassword()) && name.equals(one.getUserName()) && accnum == one.getAccountNum()) {//check manager login

                            Managersetup(one);
                        } else // System.out.println("in here");
                         if (userspointer.size() >= 1) {
                                for (int i = 0; i <= userspointer.size() - 1; i++) {
                                    //System.out.println("in here");
                                    if (password.equals(userspointer.get(i).getPassword()) && name.equals(userspointer.get(i).getUsername()) && accnum == userspointer.get(i).getAccnum()) {
                                        System.out.println("Logged into Account: " + name);
                                        CustomerAccess(i, userspointer, titles, movieArr);// customer access account here, customer will have access to customer profile arraylist
                                        System.out.println("logged out");
                                        counter1++;
                                    } else {

                                    }
                                }
                                //System.out.println(counter);
                                if (counter1 > 0) {
                                    //System.out.println("account doesnt exist");//add counter here}
                                } else {
                                    System.out.println("account doesnt exist");
                                }

                            } else {
                                System.out.println("account doesnt exist");
                            }
                    } catch (IndexOutOfBoundsException a) {
                        System.out.println("account doesnt exist");
                    }

                }
                if (access == 2) {// register as a user only a Username and Password is required account number is given to user 

                    String name1, password1;
                    System.out.println("Login: enter Username ");
                    Scanner h = new Scanner(System.in);
                    name1 = h.nextLine();
                    System.out.println("Login: enter password");
                    password1 = h.nextLine();
                    int x3 = 0;
                    while (x3 == 0) {
                        int dido = 0;
                        Scanner v = new Scanner(System.in);
                        name = v.nextLine();

                        for (int i = 0; i < userspointer.size() - 1; i++) {

                            if (name1.equals(userspointer.get(i).getUsername())) {// change this up to actual user name no tthe names array
                                dido++;
                            }
                        }
                        if (dido > 1) {
                            System.out.println("Username already exists, choose another name, Enter another Username");
                        } else {
                            one.createAccount(name1, password1, p++);
                            System.out.println("Unique Account Number is: " + p);
                            x3 = 1;
                        }

                    }

                }
                if (access == 3) {
                    x = 1;

                }

            }

        }

    }

}
