package org.campus02.Uebungsblaetter.chatserver08ErweiterungenFehlenNoch;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatClient implements Runnable{
    private BufferedReader reader;
    private PrintWriter printWriter;
    private ArrayList<ChatClient> clients;
    private Socket client;
    private String name;


    public ChatClient(ArrayList<ChatClient> clients, Socket client) {
        this.clients = clients;
        this.client = client;
        this.name = "not-set";
        try {
            this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.printWriter =  new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            clients.add(this);
        } catch (IOException e) {
           close();
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        printWriter.println(message);          //nicht write weil dann keine neue Zeile!!
        printWriter.flush();

    }

    public void close(){
        try {
            clients.stream().forEach(chatClient -> chatClient.sendMessage(name + " hat den chat verlassen"));

            reader.close();
            printWriter.close();
            clients.remove(this);                  //this? client meine lösung
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void run() {
        String inputLine;
            try {
                while ((inputLine = reader.readLine()) != null){
                    System.out.println("inputLine= " + inputLine );

                    if (inputLine.startsWith("<name>")){
                        String[] spalten = inputLine.split(":");
                        String name = spalten[1];
                        setName(name);
                        for (ChatClient chatClient : clients) {
                            chatClient.sendMessage("Neuer CLient hat sich verbunden");
                        }
                        printWriter.println("verstanden, dein Name ist jetzt: " + name);
                        printWriter.flush();
                    }

                    else if (inputLine.startsWith("<msg>")){
                        String[] spalten = inputLine.split(":");
                        String message = spalten[1];
                        for (ChatClient chatClient : clients) {
                            chatClient.sendMessage(message);
                        }
                        printWriter.write("verstanden, diese Nachricht wurde an alle geschickt: " + message);
                        printWriter.flush();
                    }

                    else if (inputLine.startsWith("<msgto>")){
                        String[] spalten = inputLine.split(":");
                        String empfaenger = spalten[1];
                        String nachricht = spalten[2];
                        for (ChatClient chatClient : clients) {
                            if (chatClient.getName().equals(empfaenger)){
                                chatClient.sendMessage(nachricht);
                            }
                        }
                    }
                    else if (inputLine.equals("<bye>")){
                        close();
                        //clients.remove(client);          //lt. angabe entfernen???
                        return;
                    }
                    else {
                        printWriter.println("Falscher Input, bitte erneut senden");
                        printWriter.flush();
                    }

            }

        } catch (IOException e) {
                throw new RuntimeException(e);
        } finally {
                close();
            }

    }



}
