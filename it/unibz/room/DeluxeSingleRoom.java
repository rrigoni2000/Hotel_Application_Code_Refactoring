package it.unibz.room;

import it.unibz.room.quantity.Quantity;
import it.unibz.room.quantity.Single;
import it.unibz.room.roomtype.Deluxe;
import it.unibz.room.roomtype.RoomType;

public class DeluxeSingleRoom extends Room {

    public DeluxeSingleRoom(int id) {
        super(id);
    }

    public DeluxeSingleRoom() {
    }

    @Override
    public RoomType getAssociatedRoomType() {
        return new Deluxe();
    }

    @Override
    public Quantity getAssociatedQuantity() {
        return new Single();
    }

}