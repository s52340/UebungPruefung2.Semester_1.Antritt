package org.campus02.Uebungsblaetter.Uebungsabend180423;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_EWdata {
    public static void main(String[] args) throws DataFileException {

        try (ServerSocket servSo = new ServerSocket(3333);
        ){
            while (true){
                System.out.println("warte auf Client");
                try (Socket cliSo = servSo.accept();
                ) {
                    System.out.println("Client hat sich verbunden");

                    EinwohnerlogikServer logik = new EinwohnerlogikServer(cliSo);
                    logik.process();


                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
