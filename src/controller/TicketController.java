package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.time.temporal.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;  
import java.util.Calendar;

import classes.*;
import classes.Enum;
import initialiser.Initialise;
import serialiser.SerializeMovieDB;
import serialiser.WriteMovieDB;
import ui.*;

public class TicketController {

    static ArrayList<Cineplex> cineplexes = Initialise.cineplexes;
    static ArrayList<PublicHoliday> holidays = Initialise.holidays;
    static Customer current; 
    // private static double basePrice;

    static Scanner sc = new Scanner(System.in);

    public static void addToCart(Screening screeningChosen, Movie movieChosen, Cineplex cineplexChosen, double actualTicketPrice){
        Seat seatChosen;
        do {
            seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
        }while (seatChosen == null);
        seatChosen.setIsReserved(true);
        TicketController.addCartTicket(current.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice);
        seatChosen = null;
        }

    public static void createBooking(ArrayList<Cineplex> cineplexes, Customer customer) throws Exception {

        int i, childTicketNo, adultTicketNo, seniorTicketNo = 0;
        int cineplexChoice, movieChoice, screeningChoice;
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
        screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        if (screeningChoice == -1){
            return;
        }
        Screening screeningChosen = Initialise.screenings.get(screeningChoice);
        
        System.out.println("Number of Child Tickets: ");
        childTicketNo = sc.nextInt();
        System.out.println("Number of Adult Tickets: ");
        adultTicketNo = sc.nextInt();
        System.out.println("Number of Senior Citizen Tickets: ");
        seniorTicketNo = sc.nextInt();
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < childTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Child Seat (" + (j + 1) +"/"+childTicketNo+ ") : ");
                actualTicketPrice = TicketController.TicketPrice(1, 0, 0, cineplexChosen, movieChosen, screeningChosen);
                TicketController.addToCart(screeningChosen, movieChosen, cineplexChosen, actualTicketPrice);
            }
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < adultTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Adult Seat (" + (j + 1)+"/"+adultTicketNo + ") : ");
                actualTicketPrice = TicketController.TicketPrice(0, 1, 0, cineplexChosen, movieChosen, screeningChosen);
                TicketController.addToCart(screeningChosen, movieChosen, cineplexChosen, actualTicketPrice);
            }
            LayoutPrinterOrdinary.printLayout(screeningChosen);
            for (int j = 0; j < seniorTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Senior Seat (" + (j + 1)+"/"+seniorTicketNo + ") : ");
                actualTicketPrice = TicketController.TicketPrice(0, 0, 1, cineplexChosen, movieChosen, screeningChosen);
                TicketController.addToCart(screeningChosen, movieChosen, cineplexChosen, actualTicketPrice);
            }
            PaymentUI.initiatePaymentUI(customer);
            return;
        }



        public static double TicketPrice(int student, int adult, int senior, Cineplex cineplexChosen, Movie movieChosen, Screening screeningChosen) throws ParseException {
            // FOR CREATEBOOKING    

            //PH ARRAYLIST TO INITIALISE
            //PUBLIC HOLIDAYS OF SG (YYYYMMDD) - NEW YEARS DAY (20220101), CHINESE NEW YEAR(20220201, 20220202), GOOD FRIDAY (20220415), LABOUR DAY (20220501), HARI RAYA PUASA (20220503),
            //VESAK DAY (20220515), HARI RAYA HAJI (20220710), NATIONAL DAY (20220809), DEEPAVALI (20221024), CHRISTMAS (20221225)
           
            double ticketPrice = 0;

            //FIRST CHECK IF WEEKEND OR PUBLIC HOLIDAY
            // for (int i=0; i<holidays.size(); i++){
                Date actualDate = DateTime.stringToDate(screeningChosen.getShowDate());
                if ((TicketController.isWeekend(actualDate)) || (screeningChosen.getShowDate()).equals((holidays.get(0).getPublicHolidayDate()))){
                    if (movieChosen.getIs3D() == true){
                        ticketPrice = Enum.DayOfWeek.SATURDAY.getTicketPrice() + 5;
                    }
                    else{
                        ticketPrice = Enum.DayOfWeek.SATURDAY.getTicketPrice();
                    }
                    ticketPrice = Enum.DayOfWeek.SATURDAY.getTicketPrice();
                }// screeningchoice.showDate
                else{
                    //RETURN STUDENT PRICE
                    if (student == 1){
                        // TODO: NEED TO CHECK CINEMATYPE (and showtype!!)
                        //cineplex cinema cinematype
                        ticketPrice = Enum.TicketType.STUDENT.getTicketPrice() + screeningChosen.getCinema().getCinemaType().getTicketPrice();
                    }

                    //RETURN ADULT PRICE
                    else if (adult == 1){
                        ticketPrice = Enum.TicketType.ADULT.getTicketPrice() + screeningChosen.getCinema().getCinemaType().getTicketPrice();
                    }

                    //RETURN SENIOR PRICE
                    else if (senior == 1){
                        ticketPrice = Enum.TicketType.SENIORCITIZEN.getTicketPrice() + screeningChosen.getCinema().getCinemaType().getTicketPrice();
                    }

                // }

            }
            return ticketPrice;
        }

        public static Boolean isWeekend(Date date){
            Calendar calendar = new GregorianCalendar();
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if ((dayOfWeek == 7) || (dayOfWeek == 1)){
                return true;
            }
            else{
                return false;
            }
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
                for (Enum.CinemaType groupType: Enum.CinemaType.values()) {
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
                      Enum.CinemaType.PLATINUMMOVIESUITES.setTicketPrice(newpmstp);
  
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
                      Enum.CinemaType.ORDINARY.setTicketPrice(newordtp);
  
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

        }

        public static void addCartTicket(ArrayList<Ticket> cartTickets, Movie movieChosen, Cineplex cineplexChosen, Screening screeningChosen, Seat seatChosen, double actualTicketPrice){
            // FOR CREATEBOOKING

            int i;
            int cineplexChoice, movieChoice, screeningChoice;

            Ticket ticket = new Ticket(movieChosen, cineplexChosen, screeningChosen.getCinema(), screeningChosen.getShowDate(), screeningChosen.getShowTime(), seatChosen, actualTicketPrice);
            cartTickets.add(ticket);
        }

        public static void printTicket(Ticket ticket){
            //FOR PRINTRECEIPT

            System.out.println("Movie: " + ticket.getMovie().getMovieTitle());
            System.out.println("Cineplex: " + ticket.getCineplex().getCineplexName());
            System.out.println("Cinema: " + ticket.getCinema().getCinemaName());
            System.out.println("Show Date: " + ticket.getShowDate());
            System.out.println("Show Time: " + ticket.getShowTime());
            System.out.println("Seat: " + ticket.getSeat().getSeatId());
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

