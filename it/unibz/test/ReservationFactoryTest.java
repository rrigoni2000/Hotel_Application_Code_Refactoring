package it.unibz.test;

import it.unibz.src.customer.Customer;
import it.unibz.src.customer.Gender;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.reservation.ReservationFactory;
import it.unibz.src.room.DeluxeSingleRoom;
import it.unibz.src.room.Room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ReservationFactoryTest {
    private ReservationFactory factory = new ReservationFactory();

    @BeforeEach
    public void setup(){
        this.factory = new ReservationFactory();
    }

    @Test
    public void createCorrectReservation(){
        Room room = new DeluxeSingleRoom(101);
        Customer customer = new Customer("Riccardo", "simple@email.com", Gender.Male);
        factory.setRoom(room);
        factory.addCustomer(customer);

        Reservation reservation = factory.get();
        assertEquals(101, reservation.getRoomID());
        assertEquals(0, reservation.getExtras().size());
        assertEquals(1, reservation.getCustomers().size());
    }

    @Test
    public void exceptionReservationWithoutRoom(){
        factory.addCustomer(new Customer("Riccardo", "aa@gmail.com", Gender.Male));
        assertThrows(RuntimeException.class, () -> factory.get());
    }

    @Test
    public void addDuplicateCustomerTest(){
        Room room = new DeluxeSingleRoom();
        factory.setRoom(room);
        factory.addCustomer(new Customer("Riccardo", "aa@gmail.com", Gender.Male));
        factory.addCustomer(new Customer("Riccardo", "aa@gmail.com", Gender.Male));

        Reservation reservation = factory.get();
        assertEquals(1, reservation.getCustomers().size());
    }

    @Test
    public void exceptionTooManyCustomers(){
        Room room = new DeluxeSingleRoom(101);
        factory.setRoom(room);
        factory.addCustomer(new Customer("Riccardo", "aa@gmail.com", Gender.Male));
        factory.addCustomer(new Customer("Andrea", "aa@gmail.com", Gender.Female));
        assertThrows(RuntimeException.class, () -> factory.get());
    }

    @Test
    public void exceptionNoCustomers(){
        Room room = new DeluxeSingleRoom(101);
        factory.setRoom(room);
        assertThrows(RuntimeException.class, () -> factory.get());
    }
}
