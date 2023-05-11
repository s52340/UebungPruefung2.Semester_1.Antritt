package org.campus02.networking;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

public class u5SSLSocketHTTPS {
    //Folien S. 15
    public static void main(String[] args) {
        try (Socket so = SSLSocketFactory.getDefault().createSocket("news.orf.at",443);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(so.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
             BufferedWriter bwDatei = new BufferedWriter(
                     new FileWriter("src/org/campus02/networking/htmlFiles/orfHttps.html"));

        ){
            bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
            bw.flush();

            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println(zeile);
                bwDatei.write(zeile);
            }
            bwDatei.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
