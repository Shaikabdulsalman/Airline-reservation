package airline_reservation_system;


import java.util.*;

public class AirlineReservationSystem {
    private static List<Flight> flights = new ArrayList<>();
    private static UserService userService = new UserService();
    private static User loggedInUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeFlights();

        // User Authentication Loop
        while (loggedInUser == null) {
            System.out.println("\nWelcome to the Airline Reservation System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loggedInUser = loginUser();
                    break;
                case 3:
                    System.out.println("Exiting system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        // Main loop after login
        while (true) {
            System.out.println("\nWelcome " + loggedInUser.getUsername() + "!");
            System.out.println("1. Search Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Logout");
            System.out.println("4. Search Flights by Region");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchFlights();
                    break;
                case 2:
                    bookFlight();
                    break;
                case 3:
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    main(args);
                    break;
                case 4:
                    searchFlightsByRegion();
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        userService.registerUser(username, password);
    }

    private static User loginUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        return userService.loginUser(username, password);
    }

    private static void initializeFlights() {
        flights.add(new Flight("AI101", "New York", "London", "North America", new Date(), 150, 500));
        flights.add(new Flight("AI102", "Los Angeles", "Tokyo", "North America", new Date(), 100, 750));
        flights.add(new Flight("AI103", "New York", "Paris", "North America", new Date(), 200, 450));
        flights.add(new Flight("AI104", "Sydney", "Dubai", "Australia", new Date(), 180, 650));
        flights.add(new Flight("AI105", "Mumbai", "Singapore", "Asia", new Date(), 220, 400));
        flights.add(new Flight("AI106", "Toronto", "Frankfurt", "North America", new Date(), 130, 550));
        flights.add(new Flight("AI107", "Beijing", "Seoul", "Asia", new Date(), 150, 300));
        flights.add(new Flight("AI108", "San Francisco", "Melbourne", "North America", new Date(), 100, 850));
        flights.add(new Flight("AI109", "Cape Town", "Johannesburg", "Africa", new Date(), 250, 200));
        flights.add(new Flight("AI110", "Rio de Janeiro", "Buenos Aires", "South America", new Date(), 190, 350));
        flights.add(new Flight("AI111", "Chicago", "Mexico City", "North America", new Date(), 170, 450));
        flights.add(new Flight("AI112", "Bangkok", "Kuala Lumpur", "Asia", new Date(), 150, 250));
        flights.add(new Flight("AI113", "Dubai", "Istanbul", "Asia", new Date(), 120, 600));
        flights.add(new Flight("AI114", "London", "Rome", "Europe", new Date(), 140, 400));
        flights.add(new Flight("AI115", "Amsterdam", "Berlin", "Europe", new Date(), 180, 350));
        flights.add(new Flight("AI116", "Hong Kong", "Manila", "Asia", new Date(), 200, 320));
        flights.add(new Flight("AI117", "Tokyo", "Sydney", "Asia", new Date(), 110, 950));
        flights.add(new Flight("AI118", "Moscow", "Athens", "Europe", new Date(), 160, 700));
        flights.add(new Flight("AI119", "Seoul", "Bangkok", "Asia", new Date(), 200, 500));
        flights.add(new Flight("AI120", "Madrid", "Lisbon", "Europe", new Date(), 210, 350));
        flights.add(new Flight("AI121", "Delhi", "Kathmandu", "Asia", new Date(), 220, 280));
        flights.add(new Flight("AI122", "San Francisco", "New York", "North America", new Date(), 190, 300));
        flights.add(new Flight("AI123", "Chicago", "Los Angeles", "North America", new Date(), 160, 350));
        flights.add(new Flight("AI124", "Mumbai", "Dubai", "Asia", new Date(), 140, 600));
        flights.add(new Flight("AI125", "Paris", "Barcelona", "Europe", new Date(), 120, 450));
    }

    private static void searchFlights() {
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        FlightSearch flightSearch = new FlightSearch(flights);
        List<Flight> results = flightSearch.searchFlights(origin, destination);

        if (results.isEmpty()) {
            System.out.println("No flights found for the given origin and destination.");
        } else {
            for (Flight flight : results) {
                System.out.println("Flight No: " + flight.getFlightNumber() +
                                   ", From: " + flight.getOrigin() +
                                   ", To: " + flight.getDestination() +
                                   ", Seats Available: " + flight.getAvailableSeats() +
                                   ", Fare: $" + flight.getFare());
            }
        }
    }

    private static void searchFlightsByRegion() {
        System.out.println("Select a region:");
        System.out.println("1. North America");
        System.out.println("2. Europe");
        System.out.println("3. Asia");
        System.out.println("4. South America");
        System.out.println("5. Africa");
        System.out.println("6. Australia");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String region = null;

        switch (choice) {
            case 1:
                region = "North America";
                break;
            case 2:
                region = "Europe";
                break;
            case 3:
                region = "Asia";
                break;
            case 4:
                region = "South America";
                break;
            case 5:
                region = "Africa";
                break;
            case 6:
                region = "Australia";
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                return;
        }

        FlightSearch flightSearch = new FlightSearch(flights);
        List<Flight> results = flightSearch.searchFlightsByRegion(region);

        if (results.isEmpty()) {
            System.out.println("No flights found for the selected region.");
        } else {
            for (Flight flight : results) {
                System.out.println("Flight No: " + flight.getFlightNumber() +
                                   ", From: " + flight.getOrigin() +
                                   ", To: " + flight.getDestination() +
                                   ", Seats Available: " + flight.getAvailableSeats() +
                                   ", Fare: $" + flight.getFare());
            }
        }
    }

    private static void bookFlight() {
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        Flight selectedFlight = null;

        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null || selectedFlight.getAvailableSeats() == 0) {
            System.out.println("Flight not available or fully booked!");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        String passportNumber = scanner.nextLine();

        Passenger passenger = new Passenger(name, age, passportNumber);
        Booking booking = new Booking(selectedFlight, passenger);

        Payment payment = new Payment();
        boolean paymentStatus = payment.processPayment(selectedFlight.getFare());

        if (paymentStatus) {
            booking.confirmBooking();
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}
