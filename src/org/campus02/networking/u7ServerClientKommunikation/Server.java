package org.campus02.networking.u7ServerClientKommunikation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket servSo = new ServerSocket(1234); //Server wird erstellt
        ){
            while (true){ //soll ewig laufen
                System.out.println("Server wartet auf Client");

                try (Socket clsocket = servSo.accept();  //listen server wartet auf client
                     BufferedWriter bw = new BufferedWriter(
                             new OutputStreamWriter(clsocket.getOutputStream()));
                     BufferedReader br = new BufferedReader(
                             new InputStreamReader(clsocket.getInputStream()))
                ){
                    System.out.println("Client hat sich verbunden + Kanal zum schreiben/lesen geöffnet");
                   // bw.write("Hallo Client");
                    bw.write("2.Anfrage - was möchtest du?");
                    bw.flush();
                    System.out.println("Daten wurden gesendet");

                    //geht wieder oben in while Schleife!!
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
