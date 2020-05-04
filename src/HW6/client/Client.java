package HW6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 99);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        Thread inMessage = new Thread(() -> {
            while (true) {
                try {
                    String serverMessage = in.readUTF();
                    if (serverMessage.equals("Exit")) {
                        System.out.println("Bye, bye.");
                        System.exit(0);
                    } else {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        inMessage.start();
        Thread outMessage = new Thread(() -> {
            while (true) {
                try {
                    String clientMessage = input.nextLine();
                    if (clientMessage.equals("Exit")) {
                        out.writeUTF(clientMessage);
                        out.flush();
                        System.exit(0);
                    } else {
                        out.writeUTF("Message from client: " + clientMessage);
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        outMessage.start();
    }
}
