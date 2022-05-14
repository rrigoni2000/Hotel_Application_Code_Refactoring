package it.unibz.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoomService {

    public static Map<Integer,String> getRoomNames(List<Room> rooms) {

        AtomicInteger counter = new AtomicInteger(1);
        Set<String> roomNames = rooms.stream().map(Room::getRoomName).collect(Collectors.toSet());
        Map<Integer,String> numberedNames = new HashMap<>();

        roomNames.forEach(name -> numberedNames.put(counter.getAndIncrement(),name));
        return numberedNames;
    }

    public static String getRoomDetailsByRoomName(String roomName, List<Room> rooms) {
        Room match = rooms.stream().filter(room -> room.getRoomName().equals(roomName)).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("No matching room names");
        else
            return match.getRoomDetails();
    }
}
