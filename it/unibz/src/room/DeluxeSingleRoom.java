package it.unibz.src.room;

import it.unibz.src.room.quantity.Quantity;
import it.unibz.src.room.quantity.Single;
import it.unibz.src.room.roomtype.Deluxe;
import it.unibz.src.room.roomtype.RoomType;

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