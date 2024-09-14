package airline_reservation_system;
import java.util.*;

public class FlightSearch {
    private List<Flight> flights;

    // Constructor to initialize the list of flights
    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    // Method to search for flights based on origin and destination
    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> results = new ArrayList<>();

        // Iterate through the flights and find matching ones
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) && 
                flight.getDestination().equalsIgnoreCase(destination)) {
                results.add(flight);  // Add matching flight to the results
            }
        }

        return results;
    }

    // New method to search for flights by region
    public List<Flight> searchFlightsByRegion(String region) {
        List<Flight> results = new ArrayList<>();

        // Iterate through flights and find those from the selected region
        for (Flight flight : flights) {
            if (flight.getRegion().equalsIgnoreCase(region)) {
                results.add(flight);
            }
        }

        return results;
    }
}
