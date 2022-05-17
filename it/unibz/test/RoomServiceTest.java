package it.unibz.test;

import it.unibz.src.room.Room;
import it.unibz.src.room.RoomService;
import it.unibz.src.util.Deserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomServiceTest {

    private List<Room> rooms;

    @BeforeEach
    public void setup() throws IOException {
        this.rooms = Deserializer.readRooms(new File("it/unibz/sample/sampleRooms.json"));
    }

    @Test
    public void getRoomNamesTest() {
        List<String> roomNames = RoomService.getRoomNames(this.rooms);
        assertEquals(roomNames.size(),4);
    }

    @Test
    public void getRoomDetails() {
        List<String> roomNames = RoomService.getRoomNames(this.rooms);
        String roomDetails = RoomService.getRoomDetails(roomNames.get(0), this.rooms);
        System.out.println(roomDetails);
    }
}
