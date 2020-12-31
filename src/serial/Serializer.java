package serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {


    public void serialize(Object o, String to){
        try {
            final FileOutputStream fileOut = new FileOutputStream(to);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.println("Data is serialized successfully to "+to);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
