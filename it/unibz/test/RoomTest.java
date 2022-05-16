package it.unibz.test;

import it.unibz.src.room.*;
import it.unibz.src.room.optional.AirConditioner;
import it.unibz.src.room.optional.RoomService;
import it.unibz.src.room.quantity.Double;
import it.unibz.src.room.quantity.Single;
import it.unibz.src.room.roomtype.Deluxe;
import it.unibz.src.room.roomtype.Luxury;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    Room deluxeSingleRoom;
    Room deluxeDoubleRoom;
    Room luxurySingleRoom;
    Room luxuryDoubleRoom;

    @BeforeEach
    public void setup(){
        this.deluxeSingleRoom = new DeluxeSingleRoom();
        this.deluxeDoubleRoom = new DeluxeDoubleRoom();
        this.luxurySingleRoom = new LuxurySingleRoom();
        this.luxuryDoubleRoom = new LuxuryDoubleRoom();
    }
    @Test
    public void roomNameTest() {
        assertEquals("Deluxe Single Room", deluxeSingleRoom.getRoomName());
        assertEquals("Deluxe Double Room", deluxeDoubleRoom.getRoomName());
        assertEquals("Luxury Single Room", luxurySingleRoom.getRoomName());
        assertEquals("Luxury Double Room", luxuryDoubleRoom.getRoomName());
    }

    @Test
    public void costPerDayTest() {
        assertEquals(new Deluxe().getDailyCostPerPerson() * new Single().getQuantity(), deluxeSingleRoom.getCostPerDay());
        assertEquals(new Deluxe().getDailyCostPerPerson() * new Double().getQuantity(), deluxeDoubleRoom.getCostPerDay());
        assertEquals(new Luxury().getDailyCostPerPerson() * new Single().getQuantity(), luxurySingleRoom.getCostPerDay());
        assertEquals(new Luxury().getDailyCostPerPerson() * new Double().getQuantity(), luxuryDoubleRoom.getCostPerDay());
    }

    @Test
    public void roomOptionalsTest() {
        assertEquals(2, deluxeDoubleRoom.getRoomOptionals().size());
        assertEquals(1, luxuryDoubleRoom.getRoomOptionals().size());

        assertTrue(deluxeSingleRoom.getRoomOptionals().contains(new AirConditioner()));
        assertFalse(luxuryDoubleRoom.getRoomOptionals().contains(new RoomService()));
    }
}
