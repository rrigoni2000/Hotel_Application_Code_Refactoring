package it.unibz.room;

import it.unibz.room.quantity.Double;
import it.unibz.room.quantity.Quantity;
import it.unibz.room.roomtype.Deluxe;
import it.unibz.room.roomtype.RoomType;

public class DeluxeDoubleRoom extends Room {

    public DeluxeDoubleRoom(int id) {
        super(id);
    }

    public DeluxeDoubleRoom() {
    }

    @Override
    public RoomType getAssociatedRoomType() {
        return new Deluxe();
    }

    @Override
    public Quantity getAssociatedQuantity() {
        return new Double();
    }

}