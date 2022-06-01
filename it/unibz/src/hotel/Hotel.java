package it.unibz.src.hotel;

import it.unibz.src.customer.Customer;
import it.unibz.src.extra.Extra;
import it.unibz.src.extra.ExtraRepository;
import it.unibz.src.reservation.Reservation;
import it.unibz.src.reservation.ReservationFactory;
import it.unibz.src.reservation.ReservationRepository;
import it.unibz.src.room.*;
import it.unibz.src.util.Deserializer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Hotel {

    public static void initialize(String roomsJsonFile, String reservationsJsonFile, String extrasJsonFile) throws IOException {
        RoomRepository.init(Deserializer.readRooms(new File(roomsJsonFile)));
        ReservationRepository.init(Deserializer.readReservations(new File(reservationsJsonFile)));
        ExtraRepository.init(Deserializer.readExtras(new File(extrasJsonFile)));
    }

    public static void makeReservation(int roomID, List<Customer> customers) {
        Room room = RoomRepository.getRoomByID(roomID);
        if(!isRoomAvailable(room.getId()))
            throw new RuntimeException("Room is not available");
        else {
            ReservationFactory factory = new ReservationFactory(ReservationRepository.getNextReservationID());

            factory.setRoom(room);
            customers.forEach(factory::addCustomer);

            ReservationRepository.addReservation(factory.get());
        }
    }

    private static boolean isRoomAvailable(int roomID) {
        /* if the ID is not valid, an exception is thrown */
        List<Reservation> reservations = ReservationRepository.getReservationsForRoom(roomID);

        return reservations.stream()
                .filter(res -> !res.isClosed()).findAny().orElse(null) == null;
    }

    public static List<Room> getAvailableRooms() {
        List<Integer> notAvailableRooms = ReservationRepository.getOpenReservations().stream()
                .map(Reservation::getRoomID)
                .collect(Collectors.toList());
        return RoomRepository.getRooms().stream()
                .filter(room -> !notAvailableRooms.contains(room.getId()))
                .collect(Collectors.toList());
    }

    public static List<String> getRoomTypes() {
        return RoomRepository.getRoomNames();
    }

    public static List<Class<? extends Room>> getAvailableRoomClasses() {
        return RoomRepository.getAvailableRoomClasses();
    }

    public static String getRoomDetails(String roomName) {
        return RoomRepository.getRoomDetails(roomName);
    }

    public static String getRoomDetails(Class<? extends Room> roomClass) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return RoomRepository.getRoomDetails(roomClass);
    }

    public static double getReservationCost(int reservationID) {
        Reservation reservation = ReservationRepository.getReservationByID(reservationID);

        AtomicReference<Double> tmp = new AtomicReference<>(0.0);

        Room room = RoomRepository.getRoomByID(reservation.getRoomID());
        tmp.updateAndGet(v -> v + room.getCostPerDay() * room.getQuantity().getQuantity());

        reservation.getExtras().forEach(extraID -> tmp.updateAndGet(v -> v + ExtraRepository.getPriceFromExtraID(extraID)));

        return tmp.get();
    }

    public static void closeReservation(int reservationID) {
        Reservation reservation = ReservationRepository.getReservationByID(reservationID);
        reservation.close();
    }

    public static void addExtraToReservation(int reservationID, int newExtra) {
        Reservation reservation = ReservationRepository.getReservationByID(reservationID);
        if(reservation.isClosed())
            throw new RuntimeException("Cannot add extra to closed reservation");
        else
            reservation.addExtra(newExtra);
    }
}
