package it.unibz.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.src.customer.Customer;
import it.unibz.src.customer.Gender;
import it.unibz.src.extra.Extra;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.util.Deserializer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ReservationDeserializerTest {
    private static final String singleReservationExample = "{\"roomID\":101,\"customers\":[{\"name\":\"Riccardo\",\"contact\":\"r.r@gmail.com\",\"gender\":\"Male\"}],\"extras\":[{\"code\":1,\"unitaryPrice\":2.0}]}";
    private static final String singleReservationInListExample = String.format("[%s]", singleReservationExample);
    private static final String doubleReservationInListExample = String.format("[%s,%s]", singleReservationExample, singleReservationExample);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void deserializeSingleReservationTest() throws IOException {
        Reservation reservation = objectMapper.readValue(singleReservationExample, Reservation.class);
        assertEquals(101, reservation.getRoomID());
        assertTrue(reservation.getExtras().contains(new Extra(1, 0.0)));
        assertTrue(reservation.getCustomers().contains(new Customer("Riccardo", "..", Gender.Male)));
    }

    @Test
    public void deserializeListWithOneReservationTest() throws IOException {
        Reservation reservation = Deserializer.readReservations(ReservationDeserializerTest.singleReservationInListExample).get(0);

        assertEquals(101, reservation.getRoomID());
        assertTrue(reservation.getExtras().contains(new Extra(1, 0.0)));
        assertTrue(reservation.getCustomers().contains(new Customer("Riccardo", "..", Gender.Male)));
    }

    @Test
    public void deserializeListWithTwoReservationsTest() throws IOException {
        List<Reservation> reservations = Deserializer.readReservations(ReservationDeserializerTest.doubleReservationInListExample);

        Reservation _0 = reservations.get(0);
        Reservation _1 = reservations.get(1);
        assertEquals(101, _0.getRoomID());
        assertEquals(101, _1.getRoomID());
        assertTrue(_0.getExtras().contains(new Extra(1, 0.0)));
        assertTrue(_1.getExtras().contains(new Extra(1, 0.0)));
        assertTrue(_0.getCustomers().contains(new Customer("Riccardo", "..", Gender.Male)));
        assertTrue(_1.getCustomers().contains(new Customer("Riccardo", "..", Gender.Male)));
    }
}
