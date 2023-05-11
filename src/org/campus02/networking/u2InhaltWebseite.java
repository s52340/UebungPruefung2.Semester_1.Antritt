package org.campus02.networking;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class u2InhaltWebseite {
    public static void main(String[] args) {

        try {
            URL myUrl = new URL("https://www.wetter.at/");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.openStream()));
                 BufferedWriter bw = new BufferedWriter(new FileWriter("src/org/campus02/networking/htmlFiles/wetter.html"))
            ){

                String zeile;
                while ((zeile = br.readLine()) != null){
                    bw.write(zeile);
                    System.out.println(zeile);
                }
                bw.flush();
                bw.close();
                br.close();

                System.out.println();
                System.out.println("myUrl.getProtocol() = " + myUrl.getProtocol());
                System.out.println("myUrl.getPort() = " + myUrl.getPort());
                System.out.println("myUrl.getDefaultPort() = " + myUrl.getDefaultPort());
                System.out.println("myUrl.getHost() = " + myUrl.getHost());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }
}
