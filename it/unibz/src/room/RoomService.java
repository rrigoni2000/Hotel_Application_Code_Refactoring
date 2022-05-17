package it.unibz.src.room;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class RoomService {

    public static List<String> getRoomNames(List<Room> rooms) {
        if(rooms == null)
            throw new RuntimeException("Invalid list of Rooms");
        return rooms.stream().map(Room::getRoomName).distinct().collect(Collectors.toList());
    }

    public static String getRoomDetails(Class<? extends Room> roomClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return roomClass.getConstructor().newInstance().getRoomDetails();
    }

    public static String getRoomDetails(String roomName, List<Room> rooms) {
        Room match = rooms.stream().filter(room -> room.getRoomName().equals(roomName)).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("No matching room names");
        else
            return match.getRoomDetails();
    }

    public static List<Class<? extends Room>> getAvailableRoomClasses(List<Room> rooms) {
        return rooms.stream().map(Room::getClass).distinct().collect(Collectors.toList());
    }

    public static Room getRoomByID(int roomID, List<Room> rooms) {
        Room match = rooms.stream().filter(room -> room.getId() == roomID).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("No given room with the provided id");
        else
            return match;
    }
}
