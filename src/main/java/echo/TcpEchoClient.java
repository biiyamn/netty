package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpEchoClient {
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8080"));

    public static void main(String[] args) {

        String ipServer = HOST;
        int port = PORT;
        String message = "Hello World";
        if (args.length == 1) {
            System.out.println("Echo client will use default ip server [" + HOST + "] and port [" + PORT + "]");
            message = args[0];
        } else if (args.length == 3) {
            ipServer = args[0];
            port = Integer.parseInt(args[1]);
            message = args[2];
        } else {
            throw new IllegalArgumentException("Arguments:<Server ip> <port> <message>");
        }
        int numberOfBytesToRead = message.getBytes().length;

        // Create socket that is connected to server on specified port

        try (Socket socket = new Socket(ipServer, port);
             InputStream in = socket.getInputStream();
             OutputStream os = socket.getOutputStream()) {
            System.out.println("client successfully connected to echo server ... sending echo message [" + message + "]");
            os.write(message.getBytes());
            byte[] receivedData = new byte[numberOfBytesToRead];
            int totalBytesRead = 0;

            while (totalBytesRead < numberOfBytesToRead) {
                int bytesRemaining = numberOfBytesToRead - totalBytesRead;
                int bytesRead = in.read(receivedData, totalBytesRead, bytesRemaining);
                if (bytesRead == -1) {
                    throw new RuntimeException("Connection is closed");
                }
                totalBytesRead += bytesRead;
            }

            System.out.println("Received message [" + new String(receivedData) + "] from server.");
            // Process the received data as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
