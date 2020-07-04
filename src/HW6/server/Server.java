package HW6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(99);
        Socket connect = server.accept();
        System.out.println("Connected to : " + connect.getInetAddress());
        DataInputStream in = new DataInputStream(connect.getInputStream());
        DataOutputStream out = new DataOutputStream(connect.getOutputStream());
        Scanner input = new Scanner(System.in);
        Thread inMessage = new Thread(() -> {
            while (true) {
                try {
                    String clientMessage = in.readUTF();
                    if(clientMessage.equals("Exit")){
                        System.out.println("Bye, bye.");
                        System.exit(0);
                    }else {
                        System.out.println(clientMessage);
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
                    String serverMessage = input.nextLine();
                    if (serverMessage.equals("Exit")) {
                        out.writeUTF(serverMessage);
                        out.flush();
                        System.exit(0);
                    } else {
                        out.writeUTF("Message from server: " + serverMessage);
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