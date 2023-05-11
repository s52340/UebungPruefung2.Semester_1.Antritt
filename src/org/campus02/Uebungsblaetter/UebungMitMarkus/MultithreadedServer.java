package org.campus02.Uebungsblaetter.UebungMitMarkus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5555);
        ) {
            System.out.println("Server wurde erstellt");
            while (true) {
                System.out.println("Server wartet auf Client");
                Socket cliSo = serverSocket.accept();

                    System.out.println("Client hat sich verbunden");
                    Runnable serverHandler = new ServerHandler(cliSo);
                    //serverHandler.run();

                   Thread th = new Thread(serverHandler);
                   th.start();
                   //th.join();

                //0. Serverhandler
                //1. Servhandler - Runnable umstellen,
                //Serverhandler.run
                //2.Thread + start + join
                //3.join weg +  try with resoucres weg - dafür in Run close implementieren



            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
