package it.unibz.room;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;
import it.unibz.room.optional.RoomServiceOptional;

import java.util.ArrayList;
import java.util.List;

public class DeluxeDoubleRoom extends Room {

    public DeluxeDoubleRoom() {
        super();
    }

    @Override
    public int getRoomCapacity() {
        return 2;
    }

    @Override
    public String getRoomName() {
        return "Deluxe Double";
    }

    @Override
    public double getCostPerDay() {
        return 160.0;
    }

    @Override
    public List<RoomOptional> getRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        optionals.add(new RoomServiceOptional());
        return optionals;
    }
}