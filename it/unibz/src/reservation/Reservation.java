package it.unibz.src.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.unibz.src.customer.Customer;
import it.unibz.src.extra.Extra;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reservation {

    private final int reservationID;
    private final int roomID;
    private final List<Customer> customers;
    private List<Extra> extras;
    private boolean closed = false;

    public Reservation(@JsonProperty("reservationID") int reservationID, @JsonProperty("roomID") int roomID,
                       @JsonProperty("customers") List<Customer> customers, @JsonProperty("extras") List<Extra> extras) {
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

    public List<Extra> getExtras() {
        return this.extras;
    }

    public void addExtra(Extra newExtra) {
        if(isClosed())
            throw new RuntimeException("Reservation already closed");

        if(this.extras == null) {
            this.extras = new ArrayList<>();
        }
        if(newExtra == null)
            throw new RuntimeException("Invalid Extra");
        else
            this.extras.add(newExtra);
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() {
        this.closed = true;
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
