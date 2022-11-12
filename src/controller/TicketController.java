package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import java.text.ParseException; 
import java.util.Calendar;

import classes.*;
import classes.Enum;
import initialiser.Initialise;
import serialiser.WriteMovieDB;
import ui.*;


/**
 * Represents the controller that can configure ticket prices, create new bookings 
 * and match correct ticket price based on given conditions
 */
public class TicketController {
    /**
     * Represents all the public holidays 
     */
    static ArrayList<PublicHoliday> holidays = Initialise.holidays;
    /**
     * Represents the customer who is currently booking 
     */
    static Customer current; 

    static Scanner sc = new Scanner(System.in);


    /**
     * Creates booking for customer when customer selects choice of cineplex, movie, screening and seat
     * @param cineplexes arraylist of cineplexes
     * @param customer customer who is booking
     * @throws Exception
     */
    public static void createBooking(ArrayList<Cineplex> cineplexes, Customer customer) throws Exception {

        int childTicketNo, adultTicketNo, seniorTicketNo = 0;
        int cineplexChoice, movieChoice, screeningChoice;
        int ageno;
        double actualTicketPrice;
        Seat seatChosen = null;
        current = customer;

        cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        Cineplex cineplexChosen = Initialise.cineplexes.get(cineplexChoice);
        movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 0);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = cineplexChosen.getMovies().get(movieChoice);
        screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen, cineplexChosen);
        if (screeningChoice == -1){
            return;
        }
        Screening screeningChosen = Initialise.screenings.get(screeningChoice);
        
        System.out.println("Number of Child Tickets: ");
        do {
            try {
                childTicketNo = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        }while(true);
        System.out.println("Number of Adult Tickets: ");
        do {
            try {
                adultTicketNo = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        }while(true);
        System.out.println("Number of Senior Citizen Tickets: ");
        do {
            try {
                seniorTicketNo = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        }while(true);
            
            for (int j = 0; j < childTicketNo; j++) {
                SeatFormatter.seatDisplay(screeningChosen);
                System.out.println("========================================");
                System.out.println("Select Child Seat (" + (j + 1) +"/"+childTicketNo+ ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                if (seatChosen.getSeatType() == Enum.SeatType.COUPLE_SEAT){
                    j++;
                }
                ageno = 1;
                actualTicketPrice = TicketController.TicketPrice(ageno, cineplexChosen, movieChosen, screeningChosen, seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice, ageno);
            }

            for (int j = 0; j < adultTicketNo; j++) {
                SeatFormatter.seatDisplay(screeningChosen);
                System.out.println("========================================");
                System.out.println("Select Adult Seat (" + (j + 1)+"/"+adultTicketNo + ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                if (seatChosen.getSeatType() == Enum.SeatType.COUPLE_SEAT){
                    j++;
                }
                ageno = 2;
                actualTicketPrice = TicketController.TicketPrice(ageno, cineplexChosen, movieChosen, screeningChosen,seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice, ageno);
            }

            for (int j = 0; j < seniorTicketNo; j++) {
                SeatFormatter.seatDisplay(screeningChosen);
                System.out.println("========================================");
                System.out.println("Select Senior Seat (" + (j + 1)+"/"+seniorTicketNo + ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                if (seatChosen.getSeatType() == Enum.SeatType.COUPLE_SEAT){
                    j++;
                }
                ageno = 3;
                actualTicketPrice = TicketController.TicketPrice(ageno, cineplexChosen, movieChosen, screeningChosen, seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice, ageno);
            }

            PaymentUI.initiatePaymentUI(customer);
            return;
        }
    
        /**
         * Determines the ticket price based on certain conditions such as: <p>
         * Age Group (Base Price)             Student: 7.0, Adult: 8.5, Senior: 4.0<p>
         * Seat Type (Base Price)             Couple Seat: 17.0<p>
         * Movie Type (Add-on Price)          3D: 2.0<p>
         * Cinema Type (Add-on Price)         Platinum Movie Suites: 5.0<p>
         * Day of Week (Add-on Price)         Weekend: 3.0, Holiday: 5.0<p>
         * @param student checks if ticket bought is a student ticket
         * @param adult checks if ticket bought is a adult ticket
         * @param senior checks if ticket bought is a senior ticket
         * @param cineplexChosen cineplex selected by customer
         * @param movieChosen movie selected by customer
         * @param screeningChosen screening selected by customer
         * @param seatChosen seat selected by customer
         * @return final ticket price
         * @throws ParseException
         */
        public static double TicketPrice(int ageno, Cineplex cineplexChosen, Movie movieChosen, Screening screeningChosen, Seat seatChosen) throws ParseException {
            // FOR CREATEBOOKING    

            double ticketPrice = 0;

            //CHECK AGE
            if (seatChosen.getSeatType() == Enum.SeatType.COUPLE_SEAT){
                ticketPrice = Initialise.priceByAge.get(1) *2;
            }
            else{
                
                if (ageno == 1){
                    ticketPrice = Initialise.priceByAge.get(0);
                }
    
                if (ageno == 2){
                        ticketPrice = Initialise.priceByAge.get(1);
                    }   
                
                if (ageno == 3){
                    ticketPrice = Initialise.priceByAge.get(2);
                }
            }

            //CHECK MOVIE TYPE
            if (movieChosen.getIs3D() == true){
                ticketPrice += Initialise.priceByMovieType.get(1);
            }

            //CHECK CINEMA TYPE
            if (screeningChosen.getCinema().getCinemaType() == Enum.CinemaType.PLATINUMMOVIESUITES){
                ticketPrice += Initialise.priceByCinemaType.get(1);
            }

            //CHECK WEEKDAY/WEEKEND/PH
            Date actualDate = DateTime.stringToDate(screeningChosen.getShowDate());

            for (int i=0; i<holidays.size(); i++){
                if ((screeningChosen.getShowDate()).equals((holidays.get(i).getPublicHolidayDate()))){
                    ticketPrice += Initialise.priceByDay.get(2);
                    break;
                }
                else if(TicketController.isWeekend(actualDate)){
                    ticketPrice += Initialise.priceByDay.get(1);
                    break;
                }
            }

            return ticketPrice;
        }
    
        /**
         * Checks if the input date is a weekend
         * @param date date of screening
         * @return true if weekend, false if weekday
         */
        public static Boolean isWeekend(Date date){

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            // System.out.println(cal.getTime());

            return (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7);
        }

        /**
         * Allows user to update the base price of the ticket based on Age Group 
         * @throws Exception
         */
        public static void updateTicketPriceByAge() throws Exception{
            //FOR ADMIN
            
            //LIST AGE GROUP
            ArrayList <Double> priceByAge = Initialise.priceByAge;
            int i = 0, option, j = 0, k = 0;
            do {
                System.out.println("========================================");
                System.out.println("The current ticket base prices by age are:");
                for (Enum.TicketType ticketType: Enum.TicketType.values()) {
                    System.out.println("(" + (j+1) + ") " + ticketType.getTicketType(j) + " = $" + priceByAge.get(j));
                    j++;
                }
                j=0;
                System.out.println(" ");
                System.out.println("Select age group to update: ");
                for (Enum.TicketType ticketType: Enum.TicketType.values()) {
                    System.out.println("(" + (i+1) + ") " + ticketType.getTicketType(i));
                    i++;
                    k++;
                }
                k=0;
                do {
                    try {
                        option = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter an integer: ");
                        sc.next();
                    }
                }while(true);
                if (option <= 0 || option > i) {
                    System.out.println("Invalid Input! Please enter an integer: ");
                }
            } while (option <= 0 || option > i);


            switch(option){

                case 1:
                double newstudtp;
                do{
                    System.out.println("Input new ticket price: ");
                    do {
                        try {
                            newstudtp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                    Initialise.priceByAge.set(0,newstudtp);
                    WriteMovieDB.writeMovieDB();

                    if (newstudtp <0){
                        System.out.println("Invalid Input! Please enter an integer: ");
                    }
                } while (newstudtp <0);

                System.out.println("Ticket Price (Student) has been updated successfully!");

                break;

                case 2:
                double newadutp;
                do{
                    System.out.println("Input new ticket price: ");
                    do {
                        try {
                            newadutp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                    Initialise.priceByAge.set(1, newadutp);
                    WriteMovieDB.writeMovieDB(); 

                    if (newadutp <0){
                        System.out.println("Invalid Input! Please enter an integer: ");
                    }
                } while (newadutp <0);

                System.out.println("Ticket Price (Adult) has been updated successfully!");

                break;

                case 3:
                double newsnrtp;
                do{
                    System.out.println("Input new ticket price: ");
                    do {
                        try {
                            newsnrtp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                    Initialise.priceByAge.set(2, newsnrtp);
                    WriteMovieDB.writeMovieDB(); 

                    if (newsnrtp <0){
                        System.out.println("Invalid Input! Please enter an integer: ");
                    }
                } while (newsnrtp <0);

                System.out.println("Ticket Price (Senior Citizen) has been updated successfully!");

                break;

                default:
                System.out.println("Invalid Input!");

            }
        }

        /**
         * Allows user to update the add-on price of the ticket based on Cinema Type
         * @throws Exception
         */
        public static void updateTicketPriceByCinemaType() throws Exception{
            //FOR ADMIN
            
            //LIST CINEMA TYPE
            ArrayList <Double> priceByCinemaType = Initialise.priceByCinemaType;
            int i = 0, option, j = 0, k = 0;
            do {
                System.out.println("========================================");
                System.out.println("The current ticket add-on prices by cinema type are:");
                for (Enum.CinemaType cinemaType: Enum.CinemaType.values()) {
                    System.out.println("(" + (j+1) + ") " + cinemaType.getCinemaType(j) + " = $" + priceByCinemaType.get(j));
                    j++;
                }
                j=0;
                System.out.println(" ");
                System.out.println("Select Cinema Type to update: ");
                for (Enum.CinemaType cinemaType: Enum.CinemaType.values()) {
                      System.out.println("(" + (i+1) + ") " + cinemaType.getCinemaType(i));
                      i++;
                      k++;
                } 
                k=0;
                do {
                    try {
                        option = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter an integer: ");
                        sc.next();
                    }
                }while(true);
                if (option <= 0 || option > i) {
                    System.out.println("Invalid Input! Please enter an integer: ");
                }
              } while (option <= 0 || option > i);
  
  
            switch(option){
  
                  case 1:
                  double newordtp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newordtp = sc.nextInt();
                      do {
                        try {
                            newordtp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                      Initialise.priceByCinemaType.set(0, newordtp);
                      WriteMovieDB.writeMovieDB(); 
  
                      if (newordtp <0){
                          System.out.println("Invalid Input! Please enter an integer: ");
                      }
                  } while (newordtp <0);
  
                  System.out.println("Ticket Price (Ordinary) has been updated successfully!");
  
                  break;


                  case 2:
                  double newpmstp;
                  do{
                      System.out.println("Input new ticket price: ");
                      do {
                        try {
                            newpmstp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                      Initialise.priceByCinemaType.set(1, newpmstp);
                      WriteMovieDB.writeMovieDB(); 
  
                      if (newpmstp <0){
                          System.out.println("Invalid Input! Please enter an integer: ");
                      }
                  } while (newpmstp <0);
  
                  System.out.println("Ticket Price (Platinum Movie Suites) has been updated successfully!");
  
                  break;
  
                  default:
                  System.out.println("Invalid Input!");
  
            }
        }

        /**
         * Allows user to update the add-on price of the ticket based on Day of Week or Public Holiday
         * @throws Exception
         */
        public static void updateTicketPriceByDayOfWeek() throws Exception{
            //FOR ADMIN
            
            //CHOOSE DAY OF WEEK
            ArrayList <Double> priceByDay = Initialise.priceByDay;
            int option;
            do {
                System.out.println("========================================");
                System.out.println("The current ticket add-on prices by day of week are:");
                System.out.println("(1) Weekdays (Monday to Friday) = $" + priceByDay.get(0));
                System.out.println("(2) Weekdays (Saturday and Sunday) = $" + priceByDay.get(1));
                System.out.println("(3) Public Holiday = $" + priceByDay.get(2));
      
                System.out.println(" ");
                System.out.println("Select day of week to update: ");
                System.out.println("(1) Weekdays (Monday to Friday)");
                System.out.println("(2) Weekends (Saturday and Sunday)");
                System.out.println("(3) Public Holiday");

                do {
                    try {
                        option = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter an integer: ");
                        sc.next();
                    }
                }while(true);
  
                if (option < 0 ) {
                    System.out.println("Invalid Input! Please enter an integer: ");

                }

              } while (option <= 0 || option > 3);
  

            switch(option){
  
                  case 1:
                  double newdaytp;
                  do{
                      System.out.println("Input new ticket price: ");
                      do {
                        try {
                            newdaytp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                      Initialise.priceByDay.set(0, newdaytp);
                      WriteMovieDB.writeMovieDB(); 
  
                      if (newdaytp <0){
                          System.out.println("Invalid Input! Please enter an integer: ");
                      }
                  } while (newdaytp <0);
  
                  System.out.println("Ticket Price (Weekdays) has been updated successfully!");
  
                  break;
  
                  case 2:
                  double newendtp;
                  do{
                      System.out.println("Input new ticket price: ");

                      do {
                        try {
                            newendtp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                      Initialise.priceByDay.set(1, newendtp);
                      WriteMovieDB.writeMovieDB(); 
  
                      if (newendtp <0){
                          System.out.println("Invalid Input! Please enter an integer: ");
                      }
                  } while (newendtp <0);
  
                  System.out.println("Ticket Price (Weekends) has been updated successfully!");
  
                  break;

                  case 3:
                  double newholtp;
                  do{
                      System.out.println("Input new ticket price: ");
                      do {
                        try {
                            newholtp = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer: ");
                            sc.next();
                        }
                    }while(true);
                      Initialise.priceByDay.set(2, newholtp);
                      WriteMovieDB.writeMovieDB(); 

                      if (newholtp <0){
                          System.out.println("Invalid Input! Please enter an integer: ");
                      }
                  } while (newholtp <0);
  
                  System.out.println("Ticket Price (Public Holiday) has been updated successfully!");
  
                  break;
  
                  default:
                  System.out.println("Invalid Input! Please enter an integer: ");
  
            }
        }

        /**
         * Adds a new public holiday to the existing ArrayList of public holidays
         * @param holidays arraylist of public holidays
         * @throws Exception
         */
        public static void addHolidays(ArrayList<PublicHoliday> holidays) throws Exception{
            //FOR ADMIN

            System.out.println("Enter Name of Public Holiday: ");
            String name = sc.next();
            System.out.println("Enter Date of Public Holiday (Format: YYYYMMDD): ");
            String stringdate = sc.next(); 

            PublicHoliday publicHoliday = new PublicHoliday(name, stringdate);
            Initialise.holidays.add(publicHoliday);
            System.out.println("New Public Holiday has been added!");
            WriteMovieDB.writeMovieDB();

            TicketUI.initiateAdminTicketUI();

        }

        /**
         * Add tickets to the cart for the customer
         * @param cartTickets arraylist of cart tickets
         * @param movieChosen movie selected by customer
         * @param cineplexChosen cineplex selected by customer
         * @param screeningChosen screening selected by customer
         * @param seatChosen seat selected by customer
         * @param actualTicketPrice final ticket price
         */
        public static void addCartTicket(ArrayList<Ticket> cartTickets, Movie movieChosen, Cineplex cineplexChosen, Screening screeningChosen, Seat seatChosen, double actualTicketPrice, int ageno){
            // FOR CREATEBOOKING

            Ticket ticket = new Ticket(movieChosen, cineplexChosen, screeningChosen.getCinema(), screeningChosen.getShowDate(), screeningChosen.getShowTime(), seatChosen, actualTicketPrice, ageno);
            cartTickets.add(ticket);
        }

        /**
         * Prints the attributes of the ticket
         * @param ticket ticket of customer
         */
        public static void printTicket(Ticket ticket){
            //FOR PRINTRECEIPT
            System.out.println("Movie: " + ticket.getMovie().getMovieTitle());
            System.out.println("Cineplex: " + ticket.getCineplex().getCineplexName());
            System.out.println("Cinema: " + ticket.getCinema().getCinemaName());
            System.out.println("Show Date: " + ticket.getShowDate());
            System.out.println("Show Time: " + ticket.getShowTime());
            System.out.println("Seat: " + ticket.getSeat().getSeatId());
            System.out.println("Price " + ticket.ageGroup(ticket.getAgeNo()) + ": $" + ticket.getTicketPrice());
        }
    }

