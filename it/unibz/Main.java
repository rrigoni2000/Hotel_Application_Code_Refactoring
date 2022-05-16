package it.unibz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * as done in the code, provide some input files to populate the rooms available and the reservations for them
         */
            /*
            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (RoomsManager) ois.readObject();
            }
             */

            /*
            int ch,ch2;
            char wish;
            x:
            do{
                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("\nChoose room type :");
                        Map<Integer,String> roomNames = RoomService.getRoomNames(Hotel.rooms);
                        printAsNumberedList(RoomService.getRoomNames(Hotel.rooms));
                        ch2 = sc.nextInt();
                        // check that the character is within the range
                        System.out.println(RoomService.getRoomDetailsByRoomName(roomNames.get(ch2),Hotel.rooms));
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.order(ch2-41,4);
                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t = new Thread(new Serializer(Hotel.hotel_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }

    }
    */

    }

    /*
    private static String printAsNumberedList(Collection<String> options) {
        StringBuilder builder = new StringBuilder();
        int counter = 1;

        options.stream().forEach(option -> builder.append("\n" + counter + ". " + options));

        // remove initial new line character
        return builder.toString().substring(1);
    }

    private static String printAsNumberedList(Map<Integer, String> names) {
        List<Map.Entry<Integer,String>> entries = new ArrayList<>(names.entrySet());

        StringBuilder builder = new StringBuilder();

        entries.stream().sorted(Map.Entry.comparingByKey()).forEach(name -> builder.append("\n").append(name.getKey()).append(". ").append(name.getValue()));

        return builder.substring(1);
    }

     */
}