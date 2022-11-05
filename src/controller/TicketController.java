package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;
import Initialiser.Initialise;
import ui.*;

public class TicketController {

    private static ArrayList<Ticket> tickets;
    private static ArrayList<Screening> screenings;
    private static ArrayList<DateTime> holidays;

    static Scanner sc = new Scanner(System.in);

    public TicketController(ArrayList<Ticket> tickets, ArrayList<Screening> screenings, ArrayList<DateTime> holidays) {
        TicketController.tickets = tickets;
        TicketController.screenings = screenings;
        TicketController.holidays = holidays;
    }


    public static void createBooking(ArrayList<Cineplex> cineplexes) {

        int i, childTicketNo, adultTicketNo, seniorTicketNo = 0;
        int cineplexChoice, cinemaChoice, screeningChoice;
        char rowChoice;
        int columnChoice;
        String seatIdChoice;
        boolean validSeatId = false;

        do {
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.size(); i++) {
                System.out.println((i + 1) + ": " + cineplexes.get(i).getCineplexName());
            }
            cineplexChoice = sc.nextInt();
            if (cineplexChoice < 0 || cineplexChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cineplexChoice < 0 || cineplexChoice > i);

        do {
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.get(cineplexChoice - 1).getCinemas().size(); i++) {
                System.out.println((i + 1) + ": " + cineplexes.get(cineplexChoice - 1).getCinemas().get(i).getCinemaName());
            }
            cinemaChoice = sc.nextInt();
            if (cinemaChoice < 0 || cinemaChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cinemaChoice < 0 || cinemaChoice > i);

        do {
            System.out.println("========================================");
            System.out.println("Select Show Date & Time: ");
            for (i = 0; i < cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().size(); i++) {
                System.out.println((i + 1) + ": " + cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(i).getShowDateTime());
            }
            screeningChoice = sc.nextInt();
            if (screeningChoice < 0 || screeningChoice > i) {
                System.out.println("Invalid Input! Try Again!");
            }
        } while (screeningChoice < 0 || screeningChoice > i);

        System.out.println("Number of Child Tickets: ");
        childTicketNo = sc.nextInt();
        System.out.println("Number of Adult Tickets: ");
        adultTicketNo = sc.nextInt();
        System.out.println("Number of Senior Citizen Tickets: ");
        seniorTicketNo = sc.nextInt();

        for (i = 0; i < childTicketNo; i++) {
            LayoutPrinterOrdinary.printLayout(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1));
            for (int j = 0; j < childTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Child Seat (" + i + 1 + ") : ");
                do {
                    System.out.println("Enter Row Letter:");
                    rowChoice = Character.toUpperCase(sc.next().charAt(0));
                    System.out.println("Enter Column Number:");
                    columnChoice = sc.nextInt();
                    //TODO: Can make this a method in Seats
                    if (columnChoice < 10) {
                        seatIdChoice = rowChoice + String.format("%02d", columnChoice);
                    } else {
                        seatIdChoice = rowChoice + String.valueOf(columnChoice);
                    }
                    //TODO: Can make another method for this so that it can break out of the loop
                    validSeatId = false;
                    if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getCinemaType() == CinemaType.ORDINARY) {
                        for (i = 0; i < Initialise.Ordinary_Capacity; i++) {
                            if (seatIdChoice == cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getSeatId()) {
                                if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getIsBooked() == false) {
                                    validSeatId = true;
                                    //TODO: They will change the isBooked at payment?
                                    cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).setIsBooked(true);
                                    System.out.println("Ticket added to cart successfully!");
                                    //TODO: We add this ticket to cartTickets or what?
                                    Ticket ticket = new Ticket(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getMovie(),
                                            cineplexes.get(cineplexChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getShowDateTime(),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i),
                                            //TODO: Change when TicketPrice change
                                            10
                                    );
                                }
                            }
                        }
                    }
                } while (validSeatId == false);
            }
            LayoutPrinterOrdinary.printLayout(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1));
            for (int j = 0; j < adultTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Adult Seat (" + i + 1 + ") : ");
                do {
                    System.out.println("Enter Row Letter:");
                    rowChoice = Character.toUpperCase(sc.next().charAt(0));
                    System.out.println("Enter Column Number:");
                    columnChoice = sc.nextInt();
                    //TODO: Can make this a method in Seats
                    if (columnChoice < 10) {
                        seatIdChoice = rowChoice + String.format("%02d", columnChoice);
                    } else {
                        seatIdChoice = rowChoice + String.valueOf(columnChoice);
                    }
                    //TODO: Can make another method for this so that it can break out of the loop
                    validSeatId = false;
                    if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getCinemaType() == CinemaType.ORDINARY) {
                        for (i = 0; i < Initialise.Ordinary_Capacity; i++) {
                            if (seatIdChoice == cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getSeatId()) {
                                if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getIsBooked() == false) {
                                    validSeatId = true;
                                    //TODO: They will change the isBooked at payment?
                                    cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).setIsBooked(true);
                                    System.out.println("Ticket added to cart successfully!");
                                    //TODO: We add this ticket to cartTickets or what?
                                    Ticket ticket = new Ticket(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getMovie(),
                                            cineplexes.get(cineplexChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getShowDateTime(),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i),
                                            //TODO: Change when TicketPrice change
                                            10
                                    );
                                }
                            }
                        }
                    }
                } while (validSeatId == false);
            }
            LayoutPrinterOrdinary.printLayout(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1));
            for (int j = 0; j < seniorTicketNo; j++) {
                System.out.println("========================================");
                System.out.println("Select Senior Seat (" + i + 1 + ") : ");
                do {
                    System.out.println("Enter Row Letter:");
                    rowChoice = Character.toUpperCase(sc.next().charAt(0));
                    System.out.println("Enter Column Number:");
                    columnChoice = sc.nextInt();
                    //TODO: Can make this a method in Seats
                    if (columnChoice < 10) {
                        seatIdChoice = rowChoice + String.format("%02d", columnChoice);
                    } else {
                        seatIdChoice = rowChoice + String.valueOf(columnChoice);
                    }
                    //TODO: Can make another method for this so that it can break out of the loop
                    validSeatId = false;
                    if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getCinemaType() == CinemaType.ORDINARY) {
                        for (i = 0; i < Initialise.Ordinary_Capacity; i++) {
                            if (seatIdChoice == cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getSeatId()) {
                                if (cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).getIsBooked() == false) {
                                    validSeatId = true;
                                    //TODO: They will change the isBooked at payment?
                                    cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i).setIsBooked(true);
                                    System.out.println("Ticket added to cart successfully!");
                                    //TODO: We add this ticket to cartTickets or what?
                                    Ticket ticket = new Ticket(cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getMovie(),
                                            cineplexes.get(cineplexChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getShowDateTime(),
                                            cineplexes.get(cineplexChoice - 1).getCinemas().get(cinemaChoice - 1).getScreenings().get(screeningChoice - 1).getSeat(i),
                                            //TODO: Change when TicketPrice change
                                            10
                                    );
                                }
                            }
                        }
                    }
                } while (validSeatId == false);
            }

            PaymentUI.initiatePaymentUI();

        }
    }


        public static double ticketPrice() {

            //PUBLIC HOLIDAYS FOR SG (YYYYMMDD) - NEW YEARS DAY (20220101), CHINESE NEW YEAR(20220201, 20220202), GOOD FRIDAY (20220415), LABOUR DAY (20220501), HARI RAYA PUASA (20220503),
            //VESAK DAY (20220515), HARI RAYA HAJI (20220710), NATIONAL DAY (20220809), DEEPAVALI (20221024), CHRISTMAS (20221225)

            String[] holidays = new String[]{};

            // if (screenings.get(i).getShowTime())

            //CHECK IF HOLIDAY OR PUBLIC HOLIDAY


        }

        public Boolean searchTicket(ArrayList < Ticket > tickets) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.contains(tickets.get(i).getTicket())) {
                    return true;
                }
            }
            return false;
        }


        public static void updateTicketPrice () {
            //FOR ADMIN

            System.out.println();
        }

        public void printTicket(Ticket ticket){

            System.out.println("Your ticket details are as follows: ");
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

