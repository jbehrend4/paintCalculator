
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalculator {

    private List<Paintable> paintableList = new ArrayList<Paintable>();
    private Scanner keyboard;

    public static void main(String[] args) {
        new PaintCalculator();
    }

    public PaintCalculator() {
        keyboard = new Scanner(System.in);

        int option = 0;

        while (option != 6) {
            printMenu();

            String s = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        createRoom();
                        break;
                    case 2:
                        writeFile();
                        break;
                    case 3:
                        readFile();
                        break;
                    case 4:
                        printRooms();
                        break;
                    case 5:
                        createCounter();
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }

    }

    private void printRooms() {
        if (paintableList.isEmpty()) {
            System.out.println("No rooms yet");
        }

        for (Paintable room : paintableList) {
            System.out.println(room.toString());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Add a new counter");
        System.out.println("6. Exit");
        System.out.println();
    }

    private void readFile() {
        RoomReader reader = new RoomReader();
        paintableList = reader.readRoomFile("rooms.dat");
    }

    private void writeFile() {
        RoomWriter writer = new RoomWriter();
        writer.writeRoomFile("rooms.dat", paintableList);
    }

    private int promptForDimension(String name) {
        System.out.print("Enter the room's " + name + ": ");
        String response = keyboard.nextLine();
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void createRoom() {
        int length = promptForDimension("length");
        int width = promptForDimension("width");
        int height = promptForDimension("height");

        try {
            Room room = new Room(length, width, height);
            paintableList.add(room);

            System.out.println("Room successfully created");
        } catch (BadWidthException | BadHeightException e) {
            System.out.println("Could not create room.");
        }

    }
    
    private void createCounter() {
        int cLength, cWidth, cHeight;
        String surfaceMaterial;
        
        System.out.print("Enter the counter's length: ");
        cLength = keyboard.nextInt();
        System.out.print("Enter the counter's width: ");
        cWidth = keyboard.nextInt();
        System.out.print("Enter the counter's height: ");
        cHeight = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("What material is the counter made of: ");
        surfaceMaterial = keyboard.nextLine();
        Counter c = new Counter (cWidth, cHeight, cLength, surfaceMaterial);
        paintableList.add(c);
        System.out.println("Counter successfully created");
    }
}
