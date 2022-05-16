package it.unibz.src.hotel;

import it.unibz.src.reservation.Reservation;
import it.unibz.src.room.*;
import it.unibz.src.util.Deserializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    /**
     * rooms that are in the hotel. Defined at compilation time for the moment. Then use reflection.
     */
   public static List<Room> rooms;

    /**
     * reservations: interact with reservations to obtain information
     */
    public static List<Reservation> reservations;

    static Scanner sc = new Scanner(System.in);

    public static void initialize(String roomsJsonFile, String reservationsJsonFile) throws IOException {
        rooms = Deserializer.readRooms(new File(roomsJsonFile));
        reservations = Deserializer.readReservations(new File(reservationsJsonFile));
    }

    public static void makeReservation(Reservation newReservation) {
        // reservation not null, not already closed, not on a room taken, satisfies the requirements on list of customers
        if(newReservation == null)
            throw new RuntimeException("Invalid Reservation");


    }
    /*
    static void bookRoom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<roomsManager.luxury_doublerrom.length;j++)
                {
                    if(roomsManager.luxury_doublerrom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn--;
                    if(roomsManager.luxury_doublerrom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for(j=0;j<roomsManager.deluxe_doublerrom.length;j++)
                {
                    if(roomsManager.deluxe_doublerrom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-11;
                    if(roomsManager.deluxe_doublerrom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for(j=0;j<roomsManager.luxury_singleerrom.length;j++)
                {
                    if(roomsManager.luxury_singleerrom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-31;
                    if(roomsManager.luxury_singleerrom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for(j=0;j<roomsManager.deluxe_singleerrom.length;j++)
                {
                    if(roomsManager.deluxe_singleerrom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-41;
                    if(roomsManager.deluxe_singleerrom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }

    static void customerDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:roomsManager.luxury_doublerrom[rn] = new LuxuryDoubleRoom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:roomsManager.deluxe_doublerrom[rn] = new LuxuryDoubleRoom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:roomsManager.luxury_singleerrom[rn] = new LuxurySingleRoom(name,contact,gender);
                break;
            case 4:roomsManager.deluxe_singleerrom[rn] = new LuxurySingleRoom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }

     */

    /**
     * search the description via class name
     * @param roomType
     */
    /*
    static String getRoomFeatures(Class< ? extends Room> roomType) {

        Room match = rooms.stream().filter(room -> room.getClass().equals(roomType)).findFirst().orElse(null);

        if(match == null)
            throw new RuntimeException("Invalid class");
        else
            return match.getRoomDetails();
    }

    static void availability(int i)
    {
        int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(roomsManager.luxury_doublerrom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<roomsManager.deluxe_doublerrom.length;j++)
                {
                    if(roomsManager.deluxe_doublerrom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<roomsManager.luxury_singleerrom.length;j++)
                {
                    if(roomsManager.luxury_singleerrom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<roomsManager.deluxe_singleerrom.length;j++)
                {
                    if(roomsManager.deluxe_singleerrom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch(rtype)
        {
            case 1:
                amount+=4000;
                System.out.println("\nRoom Charge - "+4000);
                System.out.println("\n===============");
                System.out.println("main.Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:roomsManager.luxury_doublerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getCode()-1],obb.getQuantity(),obb.getPrice());
                }

                break;
            case 2:amount+=3000;
                System.out.println("Room Charge - "+3000);
                System.out.println("\nmain.Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:roomsManager.deluxe_doublerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getCode()-1],obb.getQuantity(),obb.getPrice());
                }
                break;
            case 3:amount+=2200;
                System.out.println("Room Charge - "+2200);
                System.out.println("\nmain.Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:roomsManager.luxury_singleerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getCode()-1],obb.getQuantity(),obb.getPrice());
                }
                break;
            case 4:amount+=1200;
                System.out.println("Room Charge - "+1200);
                System.out.println("\nmain.Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb: roomsManager.deluxe_singleerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getCode()-1],obb.getQuantity(),obb.getPrice());
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:
                if(roomsManager.luxury_doublerrom[rn]!=null)
                    System.out.println("Room used by "+roomsManager.luxury_doublerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    roomsManager.luxury_doublerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 2:
                if(roomsManager.deluxe_doublerrom[rn]!=null)
                    System.out.println("Room used by "+roomsManager.deluxe_doublerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    roomsManager.deluxe_doublerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 3:
                if(roomsManager.luxury_singleerrom[rn]!=null)
                    System.out.println("Room used by "+roomsManager.luxury_singleerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    roomsManager.luxury_singleerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 4:
                if(roomsManager.deluxe_singleerrom[rn]!=null)
                    System.out.println("Room used by "+roomsManager.deluxe_singleerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    roomsManager.deluxe_singleerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try{
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();

                switch(rtype){
                    case 1: roomsManager.luxury_doublerrom[rn].food.add(new Food(i,q));
                        break;
                    case 2: roomsManager.deluxe_doublerrom[rn].food.add(new Food(i,q));
                        break;
                    case 3: roomsManager.luxury_singleerrom[rn].food.add(new Food(i,q));
                        break;
                    case 4: roomsManager.deluxe_singleerrom[rn].food.add(new Food(i,q));
                        break;
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0);
            }while(wish=='y'||wish=='Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }

     */
}
