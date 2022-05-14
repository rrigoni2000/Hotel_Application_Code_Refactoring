package it.unibz.room;

import it.unibz.room.optional.AirConditioner;
import it.unibz.room.optional.RoomOptional;

import java.util.ArrayList;
import java.util.List;

public class LuxuryDoubleRoom extends Room {

    public LuxuryDoubleRoom() {
        super();
    }

    @Override
    public int getRoomCapacity() {
        return 2;
    }

    @Override
    public String getRoomName() {
        return "Luxury Double";
    }

    @Override
    public double getCostPerDay() {
        return 90.0;
    }

    @Override
    public List<RoomOptional> getRoomOptionals() {
        List<RoomOptional> optionals = new ArrayList<>();
        optionals.add(new AirConditioner());
        return optionals;
    }
}