package org.campus02.Uebungsblaetter.networking05.bsp1TimeServer;

import java.io.*;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        try (Socket socketCl = new Socket("localhost",1111);
             BufferedReader br = new BufferedReader( new InputStreamReader(socketCl.getInputStream()));
             BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(socketCl.getOutputStream()))
        ) {
            String zeile;
            while ((zeile = br.readLine()) != null ){
                System.out.println(zeile);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
