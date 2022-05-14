package it.unibz.reservation;

import it.unibz.customer.Customer;
import it.unibz.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ReservationFactory {
    private Reservation reservation;

    private Room room;
    private List<Customer> customers;

    public ReservationFactory() {
        this.reservation = new Reservation();
        this.customers = new ArrayList<>();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void addCustomer(Customer newCustomer) {
        if(newCustomer == null)
            throw new RuntimeException("Invalid Null Customer");
        if(this.customers.contains(newCustomer))
            ;
        else
            this.customers.add(newCustomer);
    }

    public Reservation get() {
        if (this.room == null)
            throw new RuntimeException("Incomplete Parameters: room missing");
        else if(this.customers.size() == 0)
            throw new RuntimeException("No Customers specified");
        else if(this.customers.size() > this.room.getRoomCapacity())
            throw new RuntimeException("Too many Customers");
        else
            return this.reservation;
    }
}