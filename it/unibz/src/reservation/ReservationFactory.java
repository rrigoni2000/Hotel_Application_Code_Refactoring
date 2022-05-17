package it.unibz.src.reservation;

import it.unibz.src.customer.Customer;
import it.unibz.src.room.Room;

import java.util.ArrayList;
import java.util.List;

public class ReservationFactory {
    private Reservation reservation;

    private Room room;
    private List<Customer> customers;

    private int reservationID;

    public ReservationFactory(int reservationID) {
        this.customers = new ArrayList<>();
        this.reservationID = reservationID;
    }

    public ReservationFactory setRoom(Room room) {
        this.room = room;
        return this;
    }

    public ReservationFactory addCustomer(Customer newCustomer) {
        if(newCustomer == null)
            throw new RuntimeException("Invalid Null Customer");
        if(this.customers.contains(newCustomer))
            ;
        else
            this.customers.add(newCustomer);
        return this;
    }

    public Reservation get() {
        if (this.room == null)
            throw new RuntimeException("Incomplete Parameters: room missing");
        else if(this.customers.size() == 0)
            throw new RuntimeException("No Customers specified");
        else if(this.customers.size() > this.room.getQuantity().getQuantity())
            throw new RuntimeException("Too many Customers");
        else {
            return new Reservation(this.reservationID, this.room.getId(), this.customers, new ArrayList<>());
        }
    }
}
