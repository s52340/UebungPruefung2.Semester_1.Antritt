package org.campus02.Uebungsblaetter.networking05.bsp1TimeServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {
    public static void main(String[] args) {

        try (ServerSocket servSo = new ServerSocket(1111);
        ){
            while (true){
                try (Socket client = servSo.accept();
                     BufferedWriter bw = new BufferedWriter(
                             new OutputStreamWriter(client.getOutputStream()))
                ){
                    LocalDateTime dateTime = LocalDateTime.now();

                    System.out.println("hello" + dateTime);
                    bw.write("hello client" + dateTime);
                    bw.flush();
                    System.out.println("Daten an Client gesendet");

                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
