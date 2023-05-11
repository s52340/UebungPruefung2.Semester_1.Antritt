package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable {
    private Socket socket;

    public ClientCommunication(Socket socket) {
        this.socket = socket;
    }


    public void handleCommands(){
        System.out.println("handleCommands gestartet");
        PersonLoaderLehrer personL = new PersonLoaderLehrer("src/org/campus02/Uebungsblaetter/personServer07/data/persons.csv");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             ObjectOutputStream oos = new ObjectOutputStream(
                     new BufferedOutputStream(socket.getOutputStream()));
        ) {
            System.out.println("Streams erzeugt");
            ArrayList<Person> personen = personL.load();
            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println("command >> " + zeile);
                if (zeile.equals("GETALL")){
                    for (Person person : personen) {
                        oos.writeObject(person);
                    }
                    oos.writeObject(null); //um zu wissen dass wir am ende sind!
                    oos.flush();

                }
                else if (zeile.startsWith("GET ")){
                    String[] spalten = zeile.split(" ");
                    if (spalten.length != 2){
                        System.out.println("anforderung error");
                        oos.writeObject(null);
                    }
                   else{ int id = Integer.parseInt(spalten[1]);
                        for (Person person : personen) {
                            if (person.getId() == id){
                                oos.writeObject(person);
                                oos.flush();
                            }
                        }
                   }

                } else if (zeile.equalsIgnoreCase("exit")) {
                    String bye = "Auf Wiedersehen";
                    oos.writeObject(bye);
                    oos.flush();
                    break;
                }
                else {
                    String undefined = "Bitte Exit, GET .. oder GETALL eingeben";
                    oos.writeObject(undefined);
                    oos.flush();

                }
                //oder hier dann nicht extra überall in code
                oos.flush();
            }

    } catch (IOException e) {
            e.printStackTrace();
        } catch (PersonLoadException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        handleCommands();
    }
}
