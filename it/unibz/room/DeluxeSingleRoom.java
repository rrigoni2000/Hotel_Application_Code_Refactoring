package it.unibz.room;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;
import it.unibz.room.optional.RoomServiceOptional;

import java.util.ArrayList;
import java.util.List;

public class DeluxeSingleRoom extends Room {

    public DeluxeSingleRoom() {
        super();
    }

    @Override
    public int getRoomCapacity() {
        return 1;
    }

    @Override
    public String getRoomName() {
        return "Deluxe Single";
    }

    @Override
    public double getCostPerDay() {
        return 90.0;
    }

    @Override
    public List<RoomOptional> getRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        optionals.add(new RoomServiceOptional());
        return optionals;
    }
}