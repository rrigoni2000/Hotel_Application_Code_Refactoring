package it.unibz.room;

import java.io.Serializable;

public abstract class Room implements Serializable {

    private static int counter = 0;
    private static synchronized int getNextCounter() { return counter++; }

    private int roomCapacity;
    private int id;

    //private List<Customer> customers;

    public Room() {
        this.id = getNextCounter();
        // override the method
        this.roomCapacity = this.getRoomCapacity();

        // this.customers = new ArrayList<>();
        // this.orderedFood = new ArrayList<>();
    }

    /**
     * implements this method to customize the number of person that could be in the room
     * @return
     */
    public abstract int getRoomCapacity();

    /*
    public void addCustomer(Customer newCustomer) {
        if(newCustomer == null) {
            throw new RuntimeException("Invalid Customer");
        }
        else if(this.customers.size() >= this.roomCapacity) {
            throw new RuntimeException("Room is full");
        }
        else if(this.customers.contains(newCustomer)) {
            throw new RuntimeException("Customer already there");
        }
        else
            this.customers.add(newCustomer);
    }

    public Customer removeCustomer(Customer customer) {
        if(customer == null)
            throw new RuntimeException("Customer cannot be null");
        else if(this.customers.contains(customer)) {
            this.customers.remove(customer);
            return customer;
        }
        else
            throw new RuntimeException("Customer " + customer.toString() + " not assigned for the room");
    }
     */


}
