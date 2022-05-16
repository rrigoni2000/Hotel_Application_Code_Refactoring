package it.unibz.src.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.reservation.Reservation;

import java.io.*;
import java.util.List;

/**
 * gets as input the list of reservations
 */
public class ReservationSerializer implements Runnable {

    List<Reservation> reservations;

    public ReservationSerializer(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public void run() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new BufferedWriter(new FileWriter("reservationsBackup.json")), this.reservations);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
