package network.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

    public static void main(String[] args) {

        try {
            ServerSocket soc = new ServerSocket(6013);

//            now listen for connections
            while (true) {
                Socket client = soc.accept();

                PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

//                write what you want to this client
                pout.println("You have connected to this client @ "+soc.getLocalPort()+" on "+new Date().toString());

//                close the socket and resume
//                listening to connections
//                client.close();
            }
        }catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}
