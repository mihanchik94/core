package osi.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 1164;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (!server.isClosed()) {
                try (Socket clientSocket = server.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    System.out.printf("Client port is %d%n", clientSocket.getPort());


                    writer.println("Write your name");
                    String userName = reader.readLine();
                    if (userName.equals("close")) {
                        writer.println("server is closing");
                        server.close();
                        break;
                    }
                    writer.println("Are you child? (yes/no)");
                    String answer = reader.readLine();
                    if (answer.equals("close")) {
                        writer.println("server is closing");
                        server.close();
                        break;
                    }
                    if (answer.equals("yes")) {
                        writer.println(String.format("Welcome to the kids area, %s Let's play!%n", userName));
                    } else if (answer.equals("no")) {
                        writer.println(String.format("Welcome to the adult zone %s! Have a good rest, or a good working day!%n", userName));
                    } else {
                        writer.println("Your answer is wrong! Please enter \"yes\" to confirm that you are child, \"no\" to confirm that you are adult or \"close\" to close connection");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}