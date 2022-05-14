package it.unibz.stay;

import it.unibz.extra.Extra;
import it.unibz.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Stay {
    private Reservation reservation;
    private List<Extra> extras;

    public Stay(Reservation reservation) {
        this.reservation = reservation;
        this.extras = new ArrayList<>();
    }

    public void addExtra(Extra newExtra) {
        this.extras.add(newExtra);
    }
}
