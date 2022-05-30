package it.unibz.src.room;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class RoomRepository {

    private static List<Room> rooms;

    public static void init(List<Room> inputRooms) {
        rooms = inputRooms;
    }

    public static List<String> getRoomNames() {
        isRepoInitialized();

        return rooms.stream().map(Room::getRoomName).distinct().collect(Collectors.toList());
    }

    public static String getRoomDetails(Class<? extends Room> roomClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        isRepoInitialized();

        return roomClass.getConstructor().newInstance().getRoomDetails();
    }

    public static String getRoomDetails(String roomName) {
        isRepoInitialized();

        Room match = rooms.stream().filter(room -> room.getRoomName().equals(roomName)).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("No matching room names");
        else
            return match.getRoomDetails();
    }

    public static List<Class<? extends Room>> getAvailableRoomClasses() {
        isRepoInitialized();

        return rooms.stream().map(Room::getClass).distinct().collect(Collectors.toList());
    }

    public static Room getRoomByID(int roomID) {
        isRepoInitialized();

        Room match = rooms.stream().filter(room -> room.getId() == roomID).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("No given room with the provided id");
        else
            return match;
    }

    public static List<Room> getRooms() {
        return rooms;
    }

    private static void isRepoInitialized() {
        if(rooms == null || rooms.isEmpty())
            throw new RuntimeException("Initialize the Repository first");
    }
}
