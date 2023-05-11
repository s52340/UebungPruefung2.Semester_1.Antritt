package org.campus02.Uebungsblaetter.Uebungsabend180423;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket servSo = new ServerSocket(3333);){
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
