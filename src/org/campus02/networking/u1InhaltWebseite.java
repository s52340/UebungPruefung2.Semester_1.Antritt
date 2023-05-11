package org.campus02.networking;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class u1InhaltWebseite {
    //Folien S.21
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.campus02.at");

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()));
                 BufferedWriter bw = new BufferedWriter(
                         new FileWriter("src/org/campus02/networking/htmlFiles/campus02.html")
                 )
            ){
                String line;
                while ((line = br.readLine()) != null){ //Zeile für Zeile Lesen
                    System.out.println(line);
                    bw.write(line);
                    bw.newLine(); //Zeilenumbruch
                }
                bw.flush();

                System.out.println("url.getProtocol() = " + url.getProtocol());
                System.out.println("url.getHost() = " + url.getHost());
                System.out.println("url.getPort() = " + url.getPort());
                System.out.println("url.getDefaultPort() = " + url.getDefaultPort());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
