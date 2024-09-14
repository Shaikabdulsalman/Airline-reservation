package airline_reservation_system;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String region;
    private Date departureDate;
    private int availableSeats;
    private double fare;

    public Flight(String flightNumber, String origin, String destination, String region, Date departureDate, int availableSeats, double fare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.region = region;
        this.departureDate = departureDate;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getRegion() {
        return region;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
}

