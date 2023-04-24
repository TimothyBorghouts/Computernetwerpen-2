import java.net.*;
import java.io.*;

class Client {
    public static final String ipAdress = "127.0.0.1";
    public static final int port = 4322;

    public static void main(String[] args) {
 
        try {
            Socket clientSocket = new Socket(ipAdress, port);
            System.out.println("Connected to server with ip " + ipAdress + " and on port " + port + ".");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while(true){
                
            String messageFromServer = in.readLine().toString();
            System.out.println(messageFromServer);
            }

        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

}