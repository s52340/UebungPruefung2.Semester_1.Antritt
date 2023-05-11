package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoPersonServer {
    public static void main(String[] args) throws PersonLoadException {

        /* Ausagebetest fürs File einlesen:
        PersonLoaderMeinVersuch personL = new PersonLoaderMeinVersuch("src/org/campus02/Uebungsblaetter/personServer07/data/persons.csv");
            ArrayList<Person> people = personL.load();
            for (Person person : people) {
                System.out.println(person.toString());
            }
            */

        try (ServerSocket servSo = new ServerSocket(1234);
        ){
            System.out.println("Server wurde erstellt");
            int session = 10;
            while (session > 0){
                session --;
                System.out.println("Server wartet auf client");
                    Socket cliSo = servSo.accept(); //Warte auf CLient;
                    System.out.println("Client hat sich verbunden");
                    ClientCommunication clientCommunication = new ClientCommunication(cliSo);
                    //Thread th = new Thread(clientCommunication);
                    //th.start();  // !!!
                    clientCommunication.handleCommands();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

