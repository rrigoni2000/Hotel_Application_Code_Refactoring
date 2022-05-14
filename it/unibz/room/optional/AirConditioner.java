package it.unibz.room.optional;

public class AirConditioner extends RoomOptional {
    @Override
    public String getOptionalName() {
        return "AC (Air Conditioner)";
    }

    @Override
    public double getAdditionalCost() {
        return 10.0;
    }
}
