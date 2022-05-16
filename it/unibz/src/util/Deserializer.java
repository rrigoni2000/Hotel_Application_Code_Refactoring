package it.unibz.src.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.room.Room;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Deserializer {

    public static List<Room> loadRoomsFromFile(String filePath) {
        return null;
    }

    public static List<Reservation> readReservations(String singleReservationExample) throws IOException {
        return new ObjectMapper().readValue(singleReservationExample, new TypeReference<List<Reservation>>(){});
    }

    public static List<Reservation> readReservations(File inputFile) {
        return null;
    }
}
