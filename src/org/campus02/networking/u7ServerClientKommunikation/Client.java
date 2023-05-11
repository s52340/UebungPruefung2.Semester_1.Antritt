package org.campus02.networking.u7ServerClientKommunikation;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try (Socket sockCl = new Socket("localhost", 1234);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(sockCl.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(sockCl.getOutputStream()));
             BufferedWriter bwText = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Uebungs_Objektspeicher\\Client-Server.txt")))
        ){
            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println(zeile);
                bwText.write(zeile);
            }
            bwText.flush();
            System.out.println("Alles erfolgreich durchlaufen");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
