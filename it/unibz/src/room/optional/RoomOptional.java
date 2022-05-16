package it.unibz.src.room.optional;


public abstract class RoomOptional {
    public abstract String getName();
    public abstract double getAdditionalCost();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomOptional)) return false;
        RoomOptional roomOptional = (RoomOptional) o;
        return getName().equals(roomOptional.getName());
    }
}
