import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.*;
import java.io.*;

public class Server {

    public static final String fileName = "index.html";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4322);
        Socket socket = serverSocket.accept();


        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("HTTP/1.0 200 OK");
        printWriter.println("Content-Type: text/html");

        String fileContent = readFile(fileName);

        printWriter.println(fileContent);
        
    }

    private static String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }
    
}
