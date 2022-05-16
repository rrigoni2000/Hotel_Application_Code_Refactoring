package it.unibz.room.roomtype;

import it.unibz.room.optional.RoomOptional;

import java.util.ArrayList;
import java.util.List;

public class Standard implements RoomType{
    @Override
    public String getName() {
        return "Standard";
    }

    @Override
    public double getDailyCostProPerson() {
        return 60.0;
    }

    @Override
    public List<RoomOptional> getDefaultRoomOptionals() {
        return new ArrayList<>();
    }
}
