package it.unibz.src.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.reservation.Reservation;

import java.io.*;
import java.util.List;

public class ReservationSerializer {

    public static void serialize(List<Reservation> reservations, String outputFilePath) throws IOException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new BufferedWriter(new FileWriter(outputFilePath)), reservations);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
