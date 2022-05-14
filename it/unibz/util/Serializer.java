package it.unibz.util;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer implements Runnable {
    RoomsManager hotel_ob;
    public Serializer(RoomsManager hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try{
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }

    }

}
