package org.campus02.Uebungsblaetter.chatserver08ErweiterungenFehlenNoch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    public static void main(String[] args) {

        try (ServerSocket serSo = new ServerSocket(7777);
        ){
            System.out.println("Server wird erstellt");
            ArrayList<ChatClient> chatClients = new ArrayList<>();
            while (true){
                System.out.println("Server wartet auf Client");
                Socket cliSo = serSo.accept();

                    System.out.println("Client hat sich verbunden");
                    Runnable chatClient = new ChatClient(chatClients,cliSo); //bildet clientkomm.ab

                    //chatClient.run(); weg dafür multithreading
                    Thread th = new Thread(chatClient);
                    th.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
