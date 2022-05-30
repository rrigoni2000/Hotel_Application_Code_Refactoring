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
    private final RoomType roomType = getRoomType();
    private final Quantity quantity = getQuantity();

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

        builder.append("Room: ").append(this.getRoomName()).append("\n");
        builder.append("Person: ").append(this.quantity.getQuantity()).append("\n");
        builder.append("Price per day: ").append(this.getCostPerDay()).append("\n");

        builder.append("\n");
        this.getRoomOptionals().forEach(optional -> builder.append(optional.getName()).append(" at ")
                .append(optional.getAdditionalCost()).append(" euro per day").append("\n"));

        return builder.toString();
    }

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
