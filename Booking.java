package airline_reservation_system;

public class Booking {
    private Flight flight;
    private Passenger passenger;

    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public void confirmBooking() {
        flight.bookSeat();
        System.out.println("Booking confirmed for " + passenger);
    }
}

