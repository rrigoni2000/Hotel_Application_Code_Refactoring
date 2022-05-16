package it.unibz.src.reservation;

import java.util.List;

public class ReservationService {

    public static Reservation getReservationByID(int reservationID, List<Reservation> reservations) {
        Reservation reservation = reservations.stream()
                .filter(res -> res.getReservationID() == reservationID)
                .findFirst().orElse(null);

        if(reservation == null)
            throw new RuntimeException("No reservation found");
        else
            return reservation;
    }
}
