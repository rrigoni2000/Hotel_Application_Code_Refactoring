package it.unibz.room.roomtype;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;

import java.util.ArrayList;
import java.util.List;

public class Luxury implements RoomType{
    @Override
    public String getName() {
        return "Luxury";
    }

    @Override
    public double getDailyCostProPerson() {
        return 90.0;
    }

    @Override
    public List<RoomOptional> getDefaultRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        return optionals;
    }
}
