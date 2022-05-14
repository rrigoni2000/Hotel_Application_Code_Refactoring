package it.unibz.hotel;

import it.unibz.room.DoubleRoom;
import it.unibz.room.Room;
import it.unibz.room.SingleRoom;

import java.io.Serializable;

public class Rooms implements Serializable {
    public DoubleRoom[] luxury_doublerrom = new DoubleRoom[10]; //Luxury
    public DoubleRoom[] deluxe_doublerrom =new DoubleRoom[20]; //Deluxe
    public SingleRoom[] luxury_singleerrom =new SingleRoom[10]; //Luxury
    public SingleRoom[] deluxe_singleerrom =new SingleRoom[20]; //Deluxe
}