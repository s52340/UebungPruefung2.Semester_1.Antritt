package org.campus02.Uebungsblaetter.UebungMitMarkus;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5555);
        ) {
            System.out.println("Server wurde erstellt");
            while (true) {
                System.out.println("Server wartet auf Client");
                try (Socket cliSo = serverSocket.accept();
                ) {
                    System.out.println("Client hat sich verbunden");
                    ServerHandler serverHandler = new ServerHandler(cliSo);

                    //serverHandler.handleCommands();
                    serverHandler.run();

                    //Thread th = new Thread(serverHandler);
                    //th.start();




                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}