package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.*;
import java.net.Socket;

public class DemoPersonClient {
    public static void main(String[] args) {

        try (Socket cliSocket = new Socket("localhost", 1234);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(cliSocket.getOutputStream()));
             ObjectInputStream ois = new ObjectInputStream(
                     new BufferedInputStream(cliSocket.getInputStream()));
        ){
            System.out.println("client is conected");
            // 1xsenden
            bw.write("GET 25");
            System.out.println("GET 25");
            bw.newLine();
            bw.flush();
            //1 Person retour bekommen
            Person person25 = (Person) ois.readObject();
            System.out.println(person25);


            //1x senden
            bw.write("GETALL");
            bw.newLine();
            bw.flush();
            //Alle Personen Lesen
            Person person;
            while ((person = (Person) ois.readObject()) != null){
                System.out.println(person);
            }

            System.out.println("exit");
            bw.write("exit");
            bw.newLine();
            bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
