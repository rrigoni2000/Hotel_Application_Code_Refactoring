package it.unibz.test.repository;

import it.unibz.src.reservation.Reservation;
import it.unibz.src.reservation.ReservationRepository;
import it.unibz.src.util.Deserializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationRepositoryTest {

    @BeforeEach
    public void setup() throws IOException {
        ReservationRepository.init(Deserializer.readReservations(new File("it/unibz/sample/sampleReservations.json")));
    }

    @Test
    public void getOpenReservations() {
        List<Reservation> openReservations = ReservationRepository.getOpenReservations();
        assertEquals(openReservations.size(),2);
    }
}
