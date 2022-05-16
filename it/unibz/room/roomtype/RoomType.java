package it.unibz.room.roomtype;

import it.unibz.room.optional.RoomOptional;

import java.util.List;

public interface RoomType {
    String getName();

    double getDailyCostProPerson();

    List<RoomOptional> getDefaultRoomOptionals();
}
