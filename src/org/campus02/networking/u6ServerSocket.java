package org.campus02.networking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class u6ServerSocket {
    public static void main(String[] args) {

        System.out.println("Server wird erstellt:");
        try (ServerSocket servSo = new ServerSocket(1111);  //Server wird erzeugt
        ){

            while (true){     //Endlosschleife bis sie oben re. rot beendet wird - damit verbindung nicht schließt
                System.out.println("Server wartet auf Client");
                try (Socket client = servSo.accept();  //accept gibt socket zurück
                     BufferedWriter bw = new BufferedWriter(
                             new OutputStreamWriter(client.getOutputStream()));
                ){
                    System.out.println("Client hat sich verbunden, Kanal zum schreiben wurde geöffnet");

                    bw.write("Hallo Client");
                    bw.flush();
                    System.out.println("Daten an Client gesendet");

                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
