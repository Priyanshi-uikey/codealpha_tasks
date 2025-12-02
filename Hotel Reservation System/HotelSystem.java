import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Add sample rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Standard"));
        rooms.add(new Room(105, "Suite"));

        System.out.println("===== HOTEL RESERVATION SYSTEM =====");

        while (true) {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booked Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom(sc);
                    break;

                case 3:
                    cancelRoom(sc);
                    break;

                case 4:
                    viewBookedRooms();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            System.out.println("Room " + r.getRoomNumber() + " | Type: " + r.getType() + " | Booked: " + r.isBooked());
        }
    }

    public static void bookRoom(Scanner sc) {
        System.out.print("\nEnter Room Number to Book: ");
        int num = sc.nextInt();

        for (Room r : rooms) {
            if (r.getRoomNumber() == num) {
                if (r.isBooked()) {
                    System.out.println("Room already booked!");
                } else {
                    r.bookRoom();
                    System.out.println("Room " + num + " booked successfully!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    public static void cancelRoom(Scanner sc) {
        System.out.print("\nEnter Room Number to Cancel Booking: ");
        int num = sc.nextInt();

        for (Room r : rooms) {
            if (r.getRoomNumber() == num) {
                if (!r.isBooked()) {
                    System.out.println("Room is not booked!");
                } else {
                    r.cancelBooking();
                    System.out.println("Room " + num + " booking cancelled!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    public static void viewBookedRooms() {
        System.out.println("\nBooked Rooms:");
        for (Room r : rooms) {
            if (r.isBooked()) {
                System.out.println("Room " + r.getRoomNumber() + " | Type: " + r.getType());
            }
        }
    }
}