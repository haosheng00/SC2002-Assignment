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
import serialiser.WriteMovieDB;
import ui.*;


/**
 * Represents the controller that can configure ticket prices, create new bookings and match correct ticket price based on given conditions
 */
public class TicketController {

    static ArrayList<Cineplex> cineplexes = Initialise.cineplexes;
    static ArrayList<PublicHoliday> holidays = Initialise.holidays;
    static Customer current; 
    // private static double basePrice;

    static Scanner sc = new Scanner(System.in);

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
        screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen, cineplexChosen);
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
            for (int j = 0; j < childTicketNo; j++) {
                if (j == 0){
                    SeatFormatter.seatDisplay(screeningChosen);
                }
                System.out.println("========================================");
                System.out.println("Select Child Seat (" + (j + 1) +"/"+childTicketNo+ ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                actualTicketPrice = TicketController.TicketPrice(1, 0, 0, cineplexChosen, movieChosen, screeningChosen, seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice);
            }
            for (int j = 0; j < adultTicketNo; j++) {
                if (j == 0){
                    SeatFormatter.seatDisplay(screeningChosen);
                }
                System.out.println("========================================");
                System.out.println("Select Adult Seat (" + (j + 1)+"/"+adultTicketNo + ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                actualTicketPrice = TicketController.TicketPrice(0, 1, 0, cineplexChosen, movieChosen, screeningChosen,seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice);
            }
            for (int j = 0; j < seniorTicketNo; j++) {
                if (j == 0){
                    SeatFormatter.seatDisplay(screeningChosen);
                }
                System.out.println("========================================");
                System.out.println("Select Senior Seat (" + (j + 1)+"/"+seniorTicketNo + ") : ");
                seatChosen = SeatFormatter.checkIfValidSeat(screeningChosen);
                actualTicketPrice = TicketController.TicketPrice(0, 0, 1, cineplexChosen, movieChosen, screeningChosen, seatChosen);
                TicketController.addCartTicket(customer.getCartTickets(), movieChosen, cineplexChosen, screeningChosen, seatChosen, actualTicketPrice);
            }
            PaymentUI.initiatePaymentUI(customer);
            return;
        }
    

        public static double TicketPrice(int student, int adult, int senior, Cineplex cineplexChosen, Movie movieChosen, Screening screeningChosen, Seat seatChosen) throws ParseException {
            // FOR CREATEBOOKING    

            double ticketPrice = 0;

            //CHECK AGE
            if (student == 1){
                ticketPrice = Initialise.priceByAge.get(0);
            }

            if (adult == 1){
                if (seatChosen.getSeatType() == Enum.SeatType.COUPLE_SEAT){
                    ticketPrice = Initialise.priceByAge.get(1) *2;
                }
                else{
                    ticketPrice = Initialise.priceByAge.get(1);
                }   
            }
   

            if (senior == 1){
                ticketPrice = Initialise.priceByAge.get(2);
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
    
  
        public static Boolean isWeekend(Date date){

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            System.out.println(cal);

            return (cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7);
        }

        public static void updateTicketPriceByAge() throws Exception{
            //FOR ADMIN
            
            //LIST AGE GROUP
            int i = 0, option;
            do {
                System.out.println("========================================");
                System.out.println("Select Age Group: ");
                for (Enum.TicketType groupType: Enum.TicketType.values()) {
                    System.out.println("(" + (i+1) + ")" + groupType);
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
                    Initialise.priceByAge.set(0,newstudtp);
                    WriteMovieDB.writeMovieDB();

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
                    Initialise.priceByAge.set(1, newadutp);
                    WriteMovieDB.writeMovieDB(); 

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
                    Initialise.priceByAge.set(2, newsnrtp);
                    WriteMovieDB.writeMovieDB(); 

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


        public static void updateTicketPriceByCinemaType() throws Exception{
            //FOR ADMIN
            
            //LIST CINEMA TYPE
            int i = 0, option;
            do {
                System.out.println("========================================");
                System.out.println("Select Cinema Type: ");
                for (Enum.CinemaType groupType: Enum.CinemaType.values()) {
                      System.out.println("(" + (i+1) + ")" + groupType);
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
                      Initialise.priceByAge.set(1, newpmstp);
                      WriteMovieDB.writeMovieDB(); 
  
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
                      Initialise.priceByAge.set(0, newordtp);
                      WriteMovieDB.writeMovieDB(); 
  
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


        public static void updateTicketPriceByDayOfWeek() throws Exception{
            //FOR ADMIN
            
            //CHOOSE DAY OF WEEK
            int option;
            do {
                System.out.println("========================================");
                System.out.println("Select Day of Week: ");
                System.out.println("(1) Weekdays (Monday to Friday)");
                System.out.println("(2) Weekends (Saturday and Sunday)");
                System.out.println("(3) Public Holiday");

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
                      Initialise.priceByAge.set(0, newdaytp);
                      WriteMovieDB.writeMovieDB(); 
  
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
                      Initialise.priceByAge.set(1, newendtp);
                      WriteMovieDB.writeMovieDB(); 
  
                      if (newendtp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newendtp <0);
  
                  System.out.println("Ticket Price (Weekends) has been updated successfully!");
  
                  break;

                  case 3:
                  double newholtp;
                  do{
                      System.out.println("Input new ticket price: ");
                      newholtp = sc.nextInt();
                      Initialise.priceByAge.set(2, newholtp);
                      WriteMovieDB.writeMovieDB(); 

                      if (newholtp <0){
                          System.out.println("Invalid Input! Try again!");
                      }
                  } while (newholtp <0);
  
                  System.out.println("Ticket Price (Public Holiday) has been updated successfully!");
  
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
    }

