package it.unibz.src.room;

import it.unibz.src.room.quantity.Double;
import it.unibz.src.room.quantity.Quantity;
import it.unibz.src.room.roomtype.Deluxe;
import it.unibz.src.room.roomtype.RoomType;

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