package it.unibz.test.repository;

import it.unibz.src.extra.ExtraRepository;
import it.unibz.src.reservation.ReservationRepository;
import it.unibz.src.room.Room;
import it.unibz.src.room.RoomRepository;
import it.unibz.src.util.Deserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomRepositoryTest {

    @BeforeEach
    public void setup() throws IOException {
        RoomRepository.init(Deserializer.readRooms(new File("it/unibz/sample/sampleRooms.json")));
        ReservationRepository.init(Deserializer.readReservations(new File("it/unibz/sample/sampleReservations.json")));
        ExtraRepository.init(Deserializer.readExtras(new File("it/unibz/sample/sampleExtras.json")));
    }

    @Test
    public void getRoomNamesTest() {
        List<String> roomNames = RoomRepository.getRoomNames();
        assertEquals(roomNames.size(),4);
    }

    @Test
    public void getRoomDetails() {
        List<String> roomNames = RoomRepository.getRoomNames();
        String roomDetails = RoomRepository.getRoomDetails(roomNames.get(0));
        assertTrue(roomDetails.contains("Luxury Single Room"));
        assertTrue(roomDetails.contains("Price per day: 90.0"));
    }

    @Test
    public void getRoomByIDTest() {
        assertThrows(RuntimeException.class, () -> RoomRepository.getRoomByID(-1));
        assertEquals(RoomRepository.getRoomByID(1).getRoomName(), "Luxury Single Room");
    }

    @Test
    public void getAvailableRoomClassesTest() {
        assertEquals(RoomRepository.getAvailableRoomClasses().size(), 4);
    }
}
