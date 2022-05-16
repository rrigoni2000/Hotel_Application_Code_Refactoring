package it.unibz.src.room.quantity;

public class Single implements Quantity{
    @Override
    public int getQuantity() {
        return 1;
    }

    @Override
    public String getName() {
        return "Single";
    }

}
