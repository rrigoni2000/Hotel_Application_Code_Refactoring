package it.unibz.src.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.unibz.src.customer.Customer;
import it.unibz.src.extra.ExtraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reservation {

    private final int reservationID;
    private final int roomID;
    private final List<Customer> customers;
    private List<Integer> extras;
    private boolean closed = false;

    public Reservation(@JsonProperty("reservationID") int reservationID, @JsonProperty("roomID") int roomID,
                       @JsonProperty("customers") List<Customer> customers, @JsonProperty("extras") List<Integer> extras) {
        this.reservationID = reservationID;
        this.roomID = roomID;
        this.customers = customers;
        this.extras = extras;
    }

    public int getReservationID() {
        return this.reservationID;
    }

    public int getRoomID() {
        return this.roomID;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Integer> getExtras() {
        return this.extras;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void addExtra(int newExtra) {
        if(isClosed())
            throw new RuntimeException("Reservation already closed");

        if(this.extras == null) {
            this.extras = new ArrayList<>();
        }
        else
            this.extras.add(newExtra);
    }

    public void close() {
        if (this.closed)
            throw new RuntimeException("Reservation already closed");
        else
            this.closed = true;
    }

    public String getReservationDetails() {
        StringBuilder builder = new StringBuilder();

        builder.append("Reservation ID: ").append(this.reservationID).append("\n");
        builder.append("Room ID: ").append(this.roomID).append("\n");

        builder.append("Customer Details: \n" );
        for (Customer customer : this.customers) {
            builder.append("Customer: ").append(customer.getCustomerDetails()).append("\n");
        }

        builder.append("Extras: \n" );
        for (Integer extra : this.extras) {
            builder.append("Extra: ").append(ExtraRepository.getExtraDetails(extra)).append("\n");
        }

        // the string is composed with the information included in the class.
        // it is fine to use the Repository to get the needed information
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getReservationID() == that.getReservationID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservationID());
    }
}
