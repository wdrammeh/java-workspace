package network.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

    public static void main(String[] args) {
//        make a connection to server socket
        try {
            Socket soc = new Socket("127.0.0.1",6013);
            InputStream in = soc.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

//            read the data from the socket
            String line = null;
            while ( (line = bin.readLine()) != null ) {
                System.out.println(line);

//                close the socket
//                soc.close();
            }
        }catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
