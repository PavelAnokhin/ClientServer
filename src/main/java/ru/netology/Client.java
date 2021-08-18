package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static final String host = "127.0.0.1";
    private static final int port = 8080;

    public static void main( String[] args ){

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("User," +" your host: " + host );

            String resp = in.readLine();
            System.out.println(resp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
