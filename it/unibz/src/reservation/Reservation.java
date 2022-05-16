package it.unibz.src.reservation;

import it.unibz.src.customer.Customer;
import it.unibz.src.extra.Extra;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private int roomID;
    private List<Customer> customers;
    private List<Extra> extras;

    public Reservation(int roomID, List<Customer> customers, List<Extra> extras) {
        this.roomID = roomID;
        this.customers = customers;
        this.extras = extras;
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
        if(this.extras == null) {
            this.extras = new ArrayList<>();
        }
        if(newExtra == null)
            throw new RuntimeException("Invalid Extra");
        else
            this.extras.add(newExtra);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getRoomID() == that.getRoomID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomID());
    }
}
