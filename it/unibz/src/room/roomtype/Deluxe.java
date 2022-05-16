package it.unibz.src.room.roomtype;

import it.unibz.src.room.optional.AirConditioner;
import it.unibz.src.room.optional.RoomOptional;
import it.unibz.src.room.optional.RoomService;

import java.util.ArrayList;
import java.util.List;

public class Deluxe implements RoomType {
    @Override
    public String getName() {
        return "Deluxe";
    }

    @Override
    public double getDailyCostPerPerson() {
        return 120.0;
    }

    @Override
    public List<RoomOptional> getDefaultRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        return optionals;
    }
}
