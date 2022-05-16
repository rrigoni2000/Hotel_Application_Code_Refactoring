package it.unibz.src.room;

import it.unibz.src.room.quantity.Double;
import it.unibz.src.room.quantity.Quantity;
import it.unibz.src.room.roomtype.Luxury;
import it.unibz.src.room.roomtype.RoomType;

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