package it.unibz.room.roomtype;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;
import it.unibz.room.optional.RoomServiceOptional;

import java.util.ArrayList;
import java.util.List;

public class Deluxe implements RoomType {
    @Override
    public String getName() {
        return "Deluxe";
    }

    @Override
    public double getDailyCostProPerson() {
        return 120.0;
    }

    @Override
    public List<RoomOptional> getDefaultRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        optionals.add(new RoomServiceOptional());
        return optionals;
    }
}
