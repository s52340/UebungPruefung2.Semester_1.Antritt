package org.campus02.networking;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class u3SocketKlasseWebseite {
    //Folien S. 14
    //rn ???
    public static void main(String[] args) {
                //neuen Socket erzeugen + mit Server verbinden
            try (Socket socketClient = new Socket("info.cern.ch",80);
                 //lesen
                 BufferedReader br = new BufferedReader(
                    new InputStreamReader(socketClient.getInputStream())
                 );
                 //schreiben-senden an Server
                 BufferedWriter bw = new BufferedWriter(
                         new OutputStreamWriter(socketClient.getOutputStream())
                 );

                 BufferedWriter bwSave = new BufferedWriter(new
                         FileWriter("src/org/campus02/networking/htmlFiles/cern.html")
                 );
                 //nur Kanal zum lesen und schreiben geöffnet sonst nichts
            ){
                //was will ich von Server?
                bw.write("GET / HTTP/1.1\r\n");
                bw.write("Host: info.cern.ch\r\n\r\n");
                bw.flush();                                   //!!WICHTIG

                String zeileWebseite;
                while ((zeileWebseite = br.readLine()) != null) {
                    System.out.println(zeileWebseite);
                    bwSave.write(zeileWebseite);
                }
                bwSave.flush();

            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


    }
}
