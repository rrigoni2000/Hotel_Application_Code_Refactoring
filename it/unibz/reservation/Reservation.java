package it.unibz.reservation;

import it.unibz.customer.Customer;
import it.unibz.extra.Extra;
import java.util.ArrayList;
import java.util.List;

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
}
