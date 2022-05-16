package it.unibz.room;

import it.unibz.room.quantity.Double;
import it.unibz.room.quantity.Quantity;
import it.unibz.room.roomtype.Luxury;
import it.unibz.room.roomtype.RoomType;

public class LuxuryDoubleRoom extends Room {

    public LuxuryDoubleRoom(int id) {
        super(id);
    }

    public LuxuryDoubleRoom() {
    }

    @Override
    public RoomType getAssociatedRoomType() {
        return new Luxury();
    }

    @Override
    public Quantity getAssociatedQuantity() {
        return new Double();
    }


}