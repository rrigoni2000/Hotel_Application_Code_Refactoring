package it.unibz.room;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;

import java.util.ArrayList;
import java.util.List;

public class LuxurySingleRoom extends Room {

    public LuxurySingleRoom() {
        super();
    }

    @Override
    public int getRoomCapacity() {
        return 1;
    }

    @Override
    public String getRoomName() {
        return "Luxury Single";
    }

    @Override
    public double getCostPerDay() {
        return 50.0;
    }

    @Override
    public List<RoomOptional> getRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        return optionals;
    }
}