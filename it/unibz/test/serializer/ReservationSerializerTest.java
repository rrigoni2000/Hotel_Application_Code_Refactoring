package it.unibz.test.serializer;

import it.unibz.src.customer.Customer;
import it.unibz.src.customer.Gender;
import it.unibz.src.extra.Extra;
import it.unibz.src.extra.ExtraRepository;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.reservation.ReservationFactory;
import it.unibz.src.room.LuxurySingleRoom;
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
        List<Extra> extras = new ArrayList<>();
        extras.add(new Extra(1,2.0, "Sample Extra"));
        ExtraRepository.init(extras);
    }

    /**
     * continue from here with serialization
     * then deserialization from file loading the classes with intermediate mapper
     */

    @Test
    public void simpleTest() throws IOException {

        Room room = new LuxurySingleRoom(1);
        List<Reservation> reservations = new ArrayList<>();
        Customer customer = new Customer("Riccardo", "r.r@gmail.com", Gender.Male);

        Reservation _1 = new ReservationFactory(0).setRoom(room).addCustomer(customer).get();
        _1.addExtra(1);
        reservations.add(_1);
        ReservationSerializer.serialize(reservations, "testSerialization.json");
    }
}
