package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import static java.lang.System.out;

public class Server {
    public static final int PORT = 8787;


    public static void main(String[] args) throws IOException {


        try (ServerSocket server = new ServerSocket(PORT)) { // Open port 8787
            out.println("Server " + server.getInetAddress() + " online " + " used port is " + PORT);

            while (true) {

                try (Socket clientSocket = server.accept(); // Opening port for getting connect clients
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    out.println("Connected client " + clientSocket.getPort());

                    Scanner scanner = new Scanner(System.in);
                    writer.println(scanner.nextLine());
                    String clientMessage = reader.readLine(); //TODO In this line can be added saving to a file
                    out.println("Client " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " message: " + clientMessage);

                }
            }
        }
    }
}

