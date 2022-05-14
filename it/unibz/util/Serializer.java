package it.unibz.util;

import it.unibz.hotel.Rooms;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer implements Runnable {
    Rooms hotel_ob;
    public Serializer(Rooms hotel_ob) {
        this.hotel_ob=hotel_ob;
    }

    @Override
    public void run() {
        try{
            FileOutputStream fout=new FileOutputStream("backup");
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }

    }

}
