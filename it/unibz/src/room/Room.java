package it.unibz.src.room;

import it.unibz.src.room.optional.RoomOptional;
import it.unibz.src.room.quantity.Quantity;
import it.unibz.src.room.roomtype.RoomType;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class Room implements Serializable {

     /**
     * unique identifier for the Room
     */
    private int id;
    private RoomType roomType = getRoomType();
    private Quantity quantity = getQuantity();

    public Room(int id) {
        this.id = id;
    }

    public Room() {
    }

    public abstract RoomType getAssociatedRoomType();
    public abstract Quantity getAssociatedQuantity();

    public String getRoomName() {
        return String.format("%s %s Room", this.roomType.getName(), this.quantity.getName());
    }

    public double getCostPerDay() {
        return this.roomType.getDailyCostPerPerson() * this.quantity.getQuantity();
    }

    public List<RoomOptional> getRoomOptionals() {
        return this.roomType.getDefaultRoomOptionals();
    }

    public String getRoomDetails() {

        StringBuilder builder = new StringBuilder();

        builder.append("Room: " + this.getRoomName() + "\n");
        builder.append("Person: " + this.quantity.getQuantity() + "\n");
        builder.append("Price per day: " + this.getCostPerDay() + "\n");

        builder.append("\n");
        this.getRoomOptionals().stream().forEach(optional -> builder.append(optional.getName() + " at " +
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

    /** getters */
    public int getId() {
        return id;
    }

    public RoomType getRoomType() {
       return this.roomType != null ? this.roomType : getAssociatedRoomType();
    }

    public Quantity getQuantity() {
        return this.quantity != null ? this.quantity : getAssociatedQuantity();
    }

    /**
     * compare room instances according to only the id parameter
     * @param o
     * @return
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
