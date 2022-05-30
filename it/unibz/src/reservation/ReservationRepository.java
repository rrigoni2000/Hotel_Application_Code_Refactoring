package it.unibz.src.reservation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationRepository {

    private static int lastReservationID = -1;

    private static List<Reservation> reservations;

    public static List<Reservation> getReservationsForRoom(int roomID) {
        return reservations.stream()
                .filter(res -> res.getRoomID() == roomID).collect(Collectors.toList());
    }

    public static List<Reservation> getOpenReservations() {
        return reservations.stream().filter(res -> !res.isClosed()).collect(Collectors.toList());
    }

    public static void init(List<Reservation> inputReservations) {
        reservations = inputReservations;
    }

    public static int getNextReservationID() {
        if (lastReservationID < 0) {
            lastReservationID = reservations.stream().map(Reservation::getReservationID).max(Integer::compareTo).orElse(-1);
        }

        return ++lastReservationID;
    }

    public static void addReservation(Reservation newReservation) {
        if(reservations.contains(newReservation))
            throw new RuntimeException("Invalid Operation: the reservation is already in the list");
        else
            reservations.add(newReservation);
    }

    /**
     * Get Reservation Details By ID
     */
    public static String getReservationDetails(int reservationID) {
        isRepoInitialized();

        return getReservationByID(reservationID).getReservationDetails();
    }

    public static Reservation getReservationByID(int reservationID) {
        isRepoInitialized();

        Reservation reservation = reservations.stream().filter(res -> res.getReservationID() == reservationID).findFirst().orElse(null);

        if(reservation == null)
            throw new RuntimeException("No reservation present with give ID");
        else
            return reservation;
    }

    private static void isRepoInitialized() {
        if(reservations == null || reservations.isEmpty())
            throw new RuntimeException("Initialize the Repository first");
    }
}
