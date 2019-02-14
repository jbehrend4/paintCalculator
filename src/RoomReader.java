
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomReader {

    private String fileName;
        
    public List<Room> readRoomFile(String fileName) {
        this.fileName = fileName;
        Path path = Paths.get("rooms.txt");
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            FileInputStream fi = new FileInputStream("rooms.txt");      
            ObjectInputStream input = new ObjectInputStream(fi);  
            List<Room> r = (List<Room>) input.readObject();
            input.close();
            fi.close(); 
            List<String> line = Collections.emptyList();
            line = Files.readAllLines(path, charset);     
            System.out.println(r.toString());
            return r;            
        }
        catch (ClassNotFoundException e) {
            System.out.println("Rooms class was not found.");
            return null;
        } catch (IOException ex) {
            Logger.getLogger(RoomReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
