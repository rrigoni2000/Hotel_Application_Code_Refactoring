package it.unibz.src.room.roomtype;

import it.unibz.src.room.optional.RoomOptional;

import java.util.List;

public interface RoomType {
    String getName();

    double getDailyCostPerPerson();

    List<RoomOptional> getDefaultRoomOptionals();
}
