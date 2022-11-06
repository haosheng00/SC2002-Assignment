package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;
import Classes.Enum;
import Initialiser.Initialise;
import ui.*;

public class TicketController {

    static ArrayList<Cineplex> cineplexes = Initialise.cineplexes;
    static ArrayList<PublicHoliday> holidays = Initialise.holidays;
    static ArrayList<Ticket> cartTickets = Initialise.cartTickets;

    private static double basePrice;

    static Scanner sc = new Scanner(System.in);

    public static void createBooking(ArrayList<Cineplex> cineplexes, Customer customer) {

        int i, childTicketNo, adultTicketNo, seniorTicketNo = 0;
        int cineplexChoice, movieChoice, screeningChoice;
        char rowChoice;
        int columnChoice;
        String seatIdChoice;
        boolean validSeatId = false;

        cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice - 1).getMovies());
        //TODO: Each movie should have a screening ArrayList
        screeningChoice = DropDownMenu.initiateScreeningChoice(cineplexes.get(cineplexChoice - 1).getMovies().get(movieChoice - 1).getScreenings());
        Screening screeningChosen = cineplexes.get(cineplexChoice - 1).getMovies().get(movieChoice - 1).getScreenings().get(screeningChoice - 1);
        System.out.println("Number of Child Tickets: ");
        childTicketNo = sc.nextInt();
        System.out.println("Number of Adult Tickets: ");
        adultTicketNo = sc.nextInt();
        System.out.println("Number of Senior Citizen Tickets: ");
        seniorTicketNo = sc.nextInt();

        for (i = 0; i < childTicketNo; i++) {
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < childTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Child Seat (" + i + 1 + ") : ");
                do {
                    validSeatId = SeatFormatter.checkIfValidSeat(screeningChosen);
                    if (validSeatId){
                        //Add to cart tickets Make it a function... since we are going to make it over again
                        //Add to cart
                        //change the seats to reserve
                        //System.out.println("Ticket added to cart successfully!");
                        //customer.getCartTickets().add(new Ticket(?????));
                        }
                } while (!validSeatId);
            }
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < adultTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Adult Seat (" + i + 1 + ") : ");
                do {
                    validSeatId = SeatFormatter.checkIfValidSeat(screeningChosen);
                    if (validSeatId) {
                        //Add to cart tickets Make it a function... since we are going to make it over again
                        //Add to cart
                        //change the seats to reserve
                        //System.out.println("Ticket added to cart successfully!");
                        //customer.getCartTickets().add(new Ticket(?????));
                    }
                } while (!validSeatId);
            }
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < seniorTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Senior Seat (" + i + 1 + ") : ");
                do {
                    validSeatId = SeatFormatter.checkIfValidSeat(screeningChosen);
                    if (validSeatId) {
                        //Add to cart tickets Make it a function... since we are going to make it over again
                        //Add to cart
                        //change the seats to reserve
                        //System.out.println("Ticket added to cart successfully!");
                        //customer.getCartTickets().add(new Ticket(?????));
                    }
                } while (!validSeatId);
            }
            PaymentUI.initiatePaymentUI(customer);
        }
    }



        public static double TicketPrice() {
            // FOR CREATEBOOKING    

            //PH ARRAYLIST IN INITIALISE
            //PUBLIC HOLIDAYS OF SG (YYYYMMDD) - NEW YEARS DAY (20220101), CHINESE NEW YEAR(20220201, 20220202), GOOD FRIDAY (20220415), LABOUR DAY (20220501), HARI RAYA PUASA (20220503),
            //VESAK DAY (20220515), HARI RAYA HAJI (20220710), NATIONAL DAY (20220809), DEEPAVALI (20221024), CHRISTMAS (20221225)
           
            double ticketPrice = 0;

            for 




            //CHECK IF HOLIDAY OR PUBLIC HOLIDAY

            return ticketPrice;
        }




        public static void updateTicketPriceByAge(){
            //FOR ADMIN
            
            //LIST AGE GROUP
            int i = 0, option;
            do {
                System.out.println("========================================");
                System.out.println("Select Age Group: ");
                for (Enum.TicketType groupType: Enum.TicketType.values()) {
                    System.out.println("(" + i + 1 + ")" + groupType);
                    i++;
                }
                option = sc.nextInt();
                if (option <= 0 || option > i) {
                    System.out.println("Invalid Input! Try again!");
                }
            } while (option <= 0 || option > i);


            switch(option){

                case 1:
                double newstudtp;
                do{
                    System.out.println("Input new ticket price: ");
                    newstudtp = sc.nextInt();
                    Enum.TicketType.STUDENT.setTicketPrice(newstudtp);

                    if (newstudtp <0){
                        System.out.println("Invalid Input! Try again!");
                    }
                } while (newstudtp <0);

                System.out.println("Ticket Price (Student) has been updated successfully!");

                break;

                case 2:
                double newadutp;
                do{
                    System.out.println("Input new ticket price: ");
                    newadutp = sc.nextInt();
                    Enum.TicketType.STUDENT.setTicketPrice(newadutp);

                    if (newadutp <0){
                        System.out.println("Invalid Input! Try again!");
                    }
                } while (newadutp <0);

                System.out.println("Ticket Price (Adult) has been updated successfully!");

                break;

                case 3:
                double newsnrtp;
                do{
                    System.out.println("Input new ticket price: ");
                    newsnrtp = sc.nextInt();
                    Enum.TicketType.STUDENT.setTicketPrice(newsnrtp);

                    if (newsnrtp <0){
                        System.out.println("Invalid Input! Try again!");
                    }
                } while (newsnrtp <0);

                System.out.println("Ticket Price (Senior Citizen) has been updated successfully!");

                break;

                default:
                System.out.println("Invalid Input!");

            }
        }


        public static void updateTicketPriceByCinemaType(){
            //FOR ADMIN
            
            //LIST CINEMA TYPE
            int i = 0, option;
            do {
                System.out.println("========================================");
                System.out.println("Select Cinema Type: ");
                for (CinemaType groupType: CinemaType.values()) {
                      System.out.println("(" + i + 1 + ")" + groupType);
                      i++;
                }
                option = sc.nextInt();
                if (option <= 0 || option > i) {
                    System.out.println("Invalid Input! Try again!");
                }
              } while (option <= 0 || option > i);
  
  
            switch(option){
  
                  case 1:
                  double newpmstp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newpmstp = sc.nextInt();
                      CinemaType.PLATINUMMOVIESUITES.setTicketPrice(newpmstp);
  
                      if (newpmstp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newpmstp <0);
  
                  System.out.println("Ticket Price (Platinum Movie Suites) has been updated successfully!");
  
                  break;
  
                  case 2:
                  double newordtp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newordtp = sc.nextInt();
                      CinemaType.ORDINARY.setTicketPrice(newordtp);
  
                      if (newordtp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newordtp <0);
  
                  System.out.println("Ticket Price (Ordinary) has been updated successfully!");
  
                  break;
  
                  default:
                  System.out.println("Invalid Input!");
  
              }
        }


        public static void updateTicketPriceByDayOfWeek(){
            //FOR ADMIN
            
            //CHOOSE DAY OF WEEK
            int option;
            do {
                System.out.println("========================================");
                System.out.println("Select Day of Week: ");
                System.out.println("(1) Weekdays (Monday to Friday)");
                System.out.println("(2) Weekends (Saturday and Sunday)");

                option = sc.nextInt();
                if (option <= 0 || option > 2) {
                    System.out.println("Invalid Input! Try again!");
                }
              } while (option <= 0 || option > 2);
  
  
            switch(option){
  
                  case 1:
                  double newdaytp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newdaytp = sc.nextInt();
                      Enum.DayOfWeek.MONDAY.setTicketPrice(newdaytp);
                      Enum.DayOfWeek.TUESDAY.setTicketPrice(newdaytp);
                      Enum.DayOfWeek.WEDNESDAY.setTicketPrice(newdaytp);
                      Enum.DayOfWeek.THURSDAY.setTicketPrice(newdaytp);
                      Enum.DayOfWeek.FRIDAY.setTicketPrice(newdaytp);
  
                      if (newdaytp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newdaytp <0);
  
                  System.out.println("Ticket Price (Weekdays) has been updated successfully!");
  
                  break;
  
                  case 2:
                  double newendtp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newendtp = sc.nextInt();
                      Enum.DayOfWeek.SATURDAY.setTicketPrice(newendtp);
                      Enum.DayOfWeek.SUNDAY.setTicketPrice(newendtp);
  
                      if (newendtp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newendtp <0);
  
                  System.out.println("Ticket Price (Weekends) has been updated successfully!");
  
                  break;
  
                  default:
                  System.out.println("Invalid Input!");
  
              }
        }


        public static void addHolidays(ArrayList<PublicHoliday> holidays){
            //FOR ADMIN

            System.out.println("Enter Name of Public Holiday: ");
            String name = sc.next();
            System.out.println("Enter Date of Public Holiday: ");
            LocalDate date = sc.next(); //ADD STRING TO DATE

            PublicHoliday publicholiday = new PublicHoliday(name, date);

            System.out.println("New Public Holiday has been added!");

        }

        public static void addCartTicket(ArrayList<Ticket> cartTickets){
            // FOR CREATEBOOKING

            int i;
            int cineplexChoice, movieChoice, screeningChoice;

            Ticket ticket = new Ticket(); //INSERT PARAMETERS

        }

        public static void printTicket(Ticket ticket){
            //FOR PRINTRECEIPT

            System.out.println("Movie: " + ticket.getMovie());
            System.out.println("Cineplex: " + ticket.getCineplex());
            System.out.println("Cinema: " + ticket.getCinema());
            System.out.println("Show Date and Time: " + ticket.getShowDateTime());
            System.out.println("Seat: " + ticket.getSeat());
            System.out.println("Price: " + ticket.getTicketPrice());

        }



        // public Boolean searchTicket(ArrayList<Ticket> tickets) {
        //     for (int i = 0; i < tickets.size(); i++) {
        //         if (tickets.contains(tickets.get(i).getTicket())) {
        //             return true;
        //         }
        //     }
        //     return false;
        // }

        // public static void cancelBooking() {

        // }

    }

