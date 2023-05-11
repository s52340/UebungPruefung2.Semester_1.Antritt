package org.campus02.networking;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class u4SocketKlasseWebseite {
    public static void main(String[] args) {

        try (Socket socket = new Socket("news.orf.at",80);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedWriter bwDatei = new BufferedWriter(
                     new FileWriter("src/org/campus02/networking/htmlFiles/orf.html"));
        ) {
            bw.write("GET / HTTP/1.1\r\n");
            bw.write("Host: news.orf.at\r\n\r\n");
            bw.flush();

            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println(zeile);
                bwDatei.write(zeile);
            }
            bwDatei.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
