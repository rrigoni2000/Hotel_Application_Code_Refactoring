package it.unibz.src.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.room.Room;

import java.io.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deserializer {

    // read file content, then pass as the string
    public static List<Room> readRooms(File inputFile) throws IOException {

        String content = readFileContent(inputFile);

        return readRooms(content);
    }

    public static List<Room> readRooms(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<Integer>> map = objectMapper.readValue(content, Map.class);

        return readRooms(map);
    }

    public static List<Room> readRooms(Map<String, List<Integer>> map) {
        List<Room> rooms = new ArrayList<>();

        map.forEach((className, roomIDs) -> {
            try {
                Class<?> c = Class.forName(className);
                for (int roomID: roomIDs) {
                    Room newRoom = (Room) c.getConstructor(int.class).newInstance(roomID);
                    rooms.add(newRoom);
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return rooms;
    }

    public static List<Reservation> readReservations(String content) throws IOException {
        return new ObjectMapper().readValue(content, new TypeReference<List<Reservation>>(){});
    }

    public static List<Reservation> readReservations(File inputFile) throws IOException {
        String content = readFileContent(inputFile);

        return readReservations(content);
    }

    private static String readFileContent(File inputFile) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        StringBuilder builder = new StringBuilder();
        reader.lines().forEachOrdered(builder::append);

        return builder.toString();
    }
}
