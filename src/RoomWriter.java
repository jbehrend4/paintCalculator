
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RoomWriter{
    
    private String fileName;
    private List<Room> roomList;
    
    public void writeRoomFile(String fileName, List<Room> roomList) {
        this.fileName = fileName;
        this.roomList = roomList;
        try {
            FileOutputStream fo = new FileOutputStream("rooms.txt");
            ObjectOutputStream output = new ObjectOutputStream(fo);
            output.writeObject(roomList);
            output.close();
            fo.close();
            System.out.println("Data saved in rooms.txt");
        }
        catch (IOException e) {
            System.out.println("The file does not exist.");            
        }        
    }
}
