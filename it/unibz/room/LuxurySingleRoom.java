package it.unibz.room;

import it.unibz.room.quantity.Quantity;
import it.unibz.room.quantity.Single;
import it.unibz.room.roomtype.Luxury;
import it.unibz.room.roomtype.RoomType;

public class LuxurySingleRoom extends Room {

    public LuxurySingleRoom(int id) {
        super(id);
    }

    public LuxurySingleRoom() {
    }

    @Override
    public RoomType getAssociatedRoomType() {
        return new Luxury();
    }

    @Override
    public Quantity getAssociatedQuantity() {
        return new Single();
    }
}