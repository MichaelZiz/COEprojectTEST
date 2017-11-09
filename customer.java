/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;


public class customer implements info {

    private info info1;
    private String Username;
    private String password;
    private int accnum, seatnum;
    private String title, q;
    private double totalprice;
    private Booked booked;
    private movies movie1;

    public String getUsername() {
        return Username;
    }

    public movies getMovie1() {
        return movie1;
    }

    public void setMovie1(movies movie1) {
        this.movie1 = movie1;
    }

    public void setBooked(movies movies1, int j, int k) {
        booked = new Booked(movies1, j, k);
    }

    public String getPassword() {
        return password;
    }

    public int getAccnum() {
        return accnum;
    }

    public customer(String Username, String password, int accnum) {

        this.Username = Username;
        this.password = password;
        this.accnum = accnum;

    }

    public int getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(int seatnum) {
        this.seatnum = seatnum;
    }

    public String getTitle() {
        return title;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void purchaseTicket(int age, int seats, String movieName, movies movies1) {
        //customer should get discounts as applicable, based on age if they buy one ticket,number of seats purchased
        //need access to movies array here

        totalprice = movies1.getTicketPrice();
        title = movies1.getMovie();
        seatnum = seats;
        setSeatnum(seatnum);
        setMovie1(movie1);
        // need to decrement the amount of seats availble will make another class called booked that will access the seat booking
        // will be accessed via book.seatavailable()

        if (seats == 1) {//discount on age, 10% discount
            if (age < 12 || age > 64) {
                totalprice = totalprice * 0.9;
                System.out.println("Age discount");
                System.out.println("new ticket price " + totalprice);

            }

        }
        if (seats == 2)//discount 5%
        {
            totalprice = totalprice * 0.95;
            System.out.println("2 seat discount");
            System.out.println("new ticket price " + totalprice);
        }
        if (seats == 3)//discount 10%
        {
            totalprice = totalprice * 0.9;
            System.out.println("3 seat discount");
            System.out.println("new ticket price " + totalprice);
        }
        if (seats == 4)//discount 20%
        {
            System.out.println("4 seat discount");

            totalprice = totalprice * 0.8;
            System.out.println("new ticket price " + totalprice);
        }

        setBooked(movies1, 1, getSeatnum());

    }

    public void refundTicket(movies movies1, int seats) {

        setBooked(movies1, 0, getSeatnum()); //this should be the calling to booked from refund ticket

    }

    @Override
    public String SetinformationONticket() {
        //will use this method to possibly gather info from customer array in the main login screen

        return q = getTitle() + "\n Number of seats" + getSeatnum() + "\n Price: " + getTotalprice();

    }

}
