package it.unibz.room.quantity;

public class Double implements Quantity{
    @Override
    public int getQuantity() {
        return 2;
    }

    @Override
    public String getName() {
        return "Double";
    }

}
