package it.unibz.test.serializer;

import it.unibz.src.reservation.Reservation;
import it.unibz.src.room.Room;
import it.unibz.src.util.Deserializer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomsDeserializerTest {


    @Test
    public void deserializeSingleRoom() {
        Map<String, List<Integer>> roomMap = new HashMap<>();
        List<Integer> roomIDs = new ArrayList<>();
        roomIDs.add(2);
        roomMap.put("it.unibz.src.room.DeluxeDoubleRoom", roomIDs);

        List<Room> rooms = Deserializer.readRooms(roomMap);

        assertEquals(2, rooms.get(0).getId());
        assertEquals(2, rooms.get(0).getQuantity().getQuantity());
    }

    @Test
    public void deserializeFromString() throws IOException {
        String sampleMapStr = "{\"it.unibz.src.room.DeluxeDoubleRoom\":[2],\"it.unibz.src.room.LuxuryDoubleRoom\":[1]}";
        List<Room> rooms = Deserializer.readRooms(sampleMapStr);

        assertEquals(2, rooms.size());
    }

    @Test
    public void deserializeFromSampleFile() throws IOException {
        List<Reservation> reservations = Deserializer.readReservations(new File("it/unibz/sample/sampleReservations.json"));
        List<Room> rooms = Deserializer.readRooms(new File("it/unibz/sample/sampleRooms.json"));
        assertEquals(0, reservations.get(0).getReservationID());
        assertEquals(1, reservations.size());
        assertEquals(40, rooms.size());
    }
}
