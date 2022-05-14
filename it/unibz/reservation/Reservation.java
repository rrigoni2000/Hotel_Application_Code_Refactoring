package it.unibz.reservation;

import it.unibz.customer.Customer;
import it.unibz.extra.Extra;
import it.unibz.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Room room;
    private List<Customer> customers;
    private List<Extra> extras;

    public Room getRoom() {
        return room;
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
