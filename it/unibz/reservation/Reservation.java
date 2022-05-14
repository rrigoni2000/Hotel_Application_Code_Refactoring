package it.unibz.reservation;

import it.unibz.customer.Customer;
import it.unibz.room.Room;

import java.util.List;

public class Reservation {
    private Room room;
    private List<Customer> customers;

    public Room getRoom() {
        return room;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
