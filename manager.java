/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class manager {

    private String userName = "admin";
    private String adminPassword = "admin";
    static private int accountNumber = 0;
    static private movies[] movieArr;
    static private ArrayList<String> MovieTitles = new ArrayList<String>();
    static private ArrayList<customer> activeusers = new ArrayList<customer>();

    public manager() {

    }

    public void addMovie(String movieName, int numSeats, double ticketPrice, int movieNumber) {
        movieArr[movieNumber] = new movies(movieName, numSeats, ticketPrice);
        MovieTitles.add(movieName);

    }

    public static ArrayList<String> getMovieTitles() {
        return MovieTitles;
    }

    public void createAccount(String username, String password, int accnum) {

        activeusers.add(new customer(username, password, accnum));

    }

    public String getUserName() {
        return userName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public movies[] getMovies() {
        return movieArr;
    }

    public static ArrayList<customer> getList() {

        return activeusers;

    }

}
