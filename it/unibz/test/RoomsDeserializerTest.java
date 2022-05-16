package it.unibz.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.room.Room;
import it.unibz.src.util.Deserializer;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomsDeserializerTest {


    private String sampleMap = "{\"it.unibz.src.room.DeluxeDoubleRoom\":[2],\"it.unibz.src.room.LuxuryDoubleRoom\":[1]}";

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
    public void deserializeFromFile() throws IOException {
        List<Room> rooms = Deserializer.readRooms(sampleMap);

        assertEquals(2, rooms.size());
    }
}
