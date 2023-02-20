package ru.netology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {


        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), Server.PORT);
            PrintWriter clientWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner clientScanner = new Scanner(System.in);
            clientWriter.println(clientScanner.nextLine());
            clientWriter.flush();

            String serverMessage = clientReader.readLine();
            System.out.println("Server says: " + serverMessage);

        } catch (Exception e) {
            System.out.println("Can't connecting to server");
            e.printStackTrace();
        }
    }
}