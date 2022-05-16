package it.unibz.room.quantity;

public class Empty implements Quantity{
    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public String getName() {
        return "Empty";
    }
}
