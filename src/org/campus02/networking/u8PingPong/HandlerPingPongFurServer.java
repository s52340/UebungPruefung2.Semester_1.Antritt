package org.campus02.networking.u8PingPong;

import java.io.*;
import java.net.Socket;

public class HandlerPingPongFurServer {   //nur für Server!
    private Socket clientSocket;                 //benötigt Client um mit ihm kommunizieren zu können

    public HandlerPingPongFurServer(Socket cliSo) {
        this.clientSocket = cliSo;
    }

    public void process(){

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(clientSocket.getOutputStream()))
        ){
            //Zuerst Lesen:
            String line;
            while ((line = br.readLine()) != null){
                // wenn ping - dann pong //wenn pong - dann ping  // wenn ... -error
               switch (line){
                   case "ping": bw.write("--> pong");
                   break;
                   case "pong": bw.write("--> ping");
                   break;
                   default: bw.write("--> Fehler in Angabe");
               }
               bw.newLine(); //immer mitschicken, "richtiges enter"
               bw.flush();

            }
            System.out.println("Handler Ende");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
