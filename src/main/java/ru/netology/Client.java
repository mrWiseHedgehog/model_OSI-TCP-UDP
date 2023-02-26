package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int PORT = 8787;
    public static final String HOST = "127.0.0.1";
    private static PrintWriter clientWriter;
    private static BufferedReader clientReader;

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter clientWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
             Scanner clientScanner = new Scanner(System.in);

            clientWriter.println(clientScanner.nextLine());
            clientWriter.flush();

            String serverMessage = clientReader.readLine();
            System.out.println("Server says: " + serverMessage);


        }
    }
}
