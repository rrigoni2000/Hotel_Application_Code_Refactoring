package it.unibz.room;

import it.unibz.room.optional.RoomOptional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class Room implements Serializable {

    private static int counter = 0;
    private static synchronized int getNextCounter() { return counter++; }

    /**
     * unique identifier for the Room
     */
    private int id;

    public Room() {
        this.id = getNextCounter();
    }

    public Room(int id) {
        this.id = id;
    }

    /**
     * implements this method to customize the number of person that could be in the room
     * @return
     */
    public abstract int getRoomCapacity();

    public abstract String getRoomName();

    public abstract double getCostPerDay();

    public abstract List<RoomOptional> getRoomOptionals();

    public String getRoomDetails() {

        StringBuilder builder = new StringBuilder();

        builder.append("Room: " + this.getRoomName() + "\n");
        builder.append("Person: " + this.getRoomCapacity() + "\n");
        builder.append("Price per day: " + this.getCostPerDay() + "\n");

        builder.append("\n");
        this.getRoomOptionals().stream().forEach(optional -> builder.append(optional.getOptionalName() + " at " +
                optional.getAdditionalCost() + " euro per day"));

        return builder.toString();
    }

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
