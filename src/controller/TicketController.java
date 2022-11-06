package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;
import Initialiser.Initialise;
import ui.*;

public class TicketController {

    static ArrayList<Cineplex> cineplexes = Initialise.cineplexes;
    //initialise holidays;

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


        public static double ticketPrice() {

            double ticketPrice = 0;
            // cinemaType, SeatType

            //PUBLIC HOLIDAYS FOR SG (YYYYMMDD) - NEW YEARS DAY (20220101), CHINESE NEW YEAR(20220201, 20220202), GOOD FRIDAY (20220415), LABOUR DAY (20220501), HARI RAYA PUASA (20220503),
            //VESAK DAY (20220515), HARI RAYA HAJI (20220710), NATIONAL DAY (20220809), DEEPAVALI (20221024), CHRISTMAS (20221225)

            String[] holidays = new String[]{};

            // if (screenings.get(i).getShowTime())

            //CHECK IF HOLIDAY OR PUBLIC HOLIDAY

            return ticketPrice;
        }

        // public Boolean searchTicket(ArrayList<Ticket> tickets) {
        //     for (int i = 0; i < tickets.size(); i++) {
        //         if (tickets.contains(tickets.get(i).getTicket())) {
        //             return true;
        //         }
        //     }
        //     return false;
        // }


        public static void updateTicketPrice(){
            //FOR ADMIN
            //TODO
            // drop down type of ticket
            System.out.println();
        }

        public static void updateHolidays(Initialise.Holidays){
            //FOR ADMIN
            //TODO
            // put holiday array under initaliser
            System.out.println();

        }

        public static void printTicket(Ticket ticket){

            System.out.println("Movie: " + ticket.getMovie());
            System.out.println("Cineplex: " + ticket.getCineplex());
            System.out.println("Cinema: " + ticket.getCinema());
            System.out.println("Show Date and Time: " + ticket.getShowDateTime());
            System.out.println("Seat: " + ticket.getSeat());
            System.out.println("Price: " + ticket.getTicketPrice());

        }
        // public static void cancelBooking() {

        // }

    }

