package it.unibz.test;

import it.unibz.src.customer.Customer;
import it.unibz.src.customer.Gender;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.reservation.ReservationFactory;
import it.unibz.src.room.LuxuryDoubleRoom;
import it.unibz.src.room.Room;
import it.unibz.src.util.ReservationSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationSerializerTest {


    @BeforeEach
    public void setup() {

    }

    /**
     * continue from here with serialization
     * then deserialization from file loading the classes with intermediate mapper
     */

    @Test
    public void simpleTest() throws IOException {
        Room room = new LuxuryDoubleRoom(101);
        List<Reservation> reservations = new ArrayList<>();
        Customer customer = new Customer("Riccardo", "r.r@gmail.com", Gender.Male);

        Reservation _1 = new ReservationFactory().setRoom(room).addCustomer(customer).get();
        reservations.add(_1);
        ReservationSerializer.serialize(reservations, "testSerialization.json");
    }
}
