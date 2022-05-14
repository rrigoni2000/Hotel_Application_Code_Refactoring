package it.unibz.room;

public class SingleRoom extends Room {

    public SingleRoom() {
        super();
    }

    @Override
    public int getRoomCapacity() {
        return 1;
    }
}