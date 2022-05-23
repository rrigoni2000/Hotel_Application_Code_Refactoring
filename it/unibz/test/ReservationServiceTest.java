package it.unibz.test;

public class ReservationServiceTest {
	private List<Reservation> reservations;

    @BeforeEach
    public void setup() throws IOException {
        this.reservation = Deserializer.readReserrvations(new File("it/unibz/sample/sampleReservations.json"));
    }

    @Test
    public void getReservationDetails() {
        List<String> reservationNames = ReservationRepository.getReservationNames(this.reservations);
        String reservationDetails = ReservationRepository.getReservationDetails(reservationNames.get(0), this.reservations);
        System.out.println(reservationDetails);
    }
}
