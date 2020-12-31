package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InternetAvailabilityChecker {

    public static void main(String[] args) {
        System.out.println(isInternetAvailable());
    }

    public static boolean isInternetAvailable(){
        try {
            return isHostAvailable("google.com") || isHostAvailable("amazon.com")
                    || isHostAvailable("facebook.com")|| isHostAvailable("utg.gm");

        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            return false;
        }
    }

    private static boolean isHostAvailable(String hostName) throws IOException {
        try {
            final Socket socket = new Socket();
            final int port = 80;
            final InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 7000);//7 seconds

            return true;
        } catch(UnknownHostException unknownHost) {
            return false;
        }
    }
}
