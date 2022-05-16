package it.unibz.src.room;

import it.unibz.src.room.quantity.Quantity;
import it.unibz.src.room.quantity.Single;
import it.unibz.src.room.roomtype.Luxury;
import it.unibz.src.room.roomtype.RoomType;

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