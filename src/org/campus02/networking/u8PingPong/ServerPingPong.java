package org.campus02.networking.u8PingPong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPingPong {
    public static void main(String[] args) {

        try (ServerSocket servSo = new ServerSocket(2222);
        ){
            while (true){
                System.out.println("Server wartet auf Client");
                try (Socket clSocket = servSo.accept()){
                    HandlerPingPongFurServer handler = new HandlerPingPongFurServer(clSocket);
                    handler.process();
                    //Mit Putty versuchen
                }
                System.out.println("Server Ende beginnt von vorne(while)");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
