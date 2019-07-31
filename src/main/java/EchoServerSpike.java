import java.io.*;
import java.net.*;

public class EchoServerSpike {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private String string;

    public void start(int port) throws Exception {
        serverSocket = new ServerSocket(port);
        System.err.println("--Server started on port: " + port + "--");

        clientSocket = serverSocket.accept();
        System.err.println("--Accepted connection--");

        // autoFlush true ensures input is ony printed once. Otherwise creates infinite printing loop
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.err.println("--IO Streams opened--");

        while ((string = input.readLine()) != null) {
            output.println(string);
        }

        System.err.println("--Closing connection with client. Bye--");
        output.close();
        input.close();
        clientSocket.close();
    }
}