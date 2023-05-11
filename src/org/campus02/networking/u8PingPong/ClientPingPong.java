package org.campus02.networking.u8PingPong;

import java.io.*;
import java.net.Socket;

public class ClientPingPong {
    public static void main(String[] args) {
            //Client verbindet sich mit Server (?)
        try (Socket servSocket = new Socket("localhost",2222);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(servSocket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(servSocket.getOutputStream()));
             BufferedReader brKonsoleCli = new BufferedReader(
                     new InputStreamReader(System.in));
        ){
            // Zuerst von KommandoZeile Lesen - dann an Server schreiben - dann lesen vom Server

            String input; //Zeile
            while ((input = brKonsoleCli.readLine()) != null) {
                if (input.equals("exit")) {  //wenn input = exit -> beenden!
                    break;                  //beenden
                }

                bw.write(input);
                bw.newLine(); // geht ohne dem nicht!!
                bw.flush();

                //Antwort vom Server lesen

            /*FALSCH
            String antwort;
            while ((antwort = br.readLine()) != null){
                System.out.println(antwort);
            }*/
                String antwort = br.readLine();
                System.out.println(antwort);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Client hat die Verbindung beendet");
    }

}
