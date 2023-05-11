package org.campus02.Uebungsblaetter.UebungMitMarkus;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class ServerHandler implements Runnable{
    private Socket cliSo;

    public ServerHandler(Socket cliSo) {
        this.cliSo = cliSo;
    }

    private void handleCommands(){
        try( BufferedReader br = new BufferedReader(new InputStreamReader(cliSo.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliSo.getOutputStream()));
        ) {
            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println("Command >> " + zeile);
                //square zahl*zahl  //multiply - 2 zahlen multiplizieren //add -summe aller z // exit - session ende
                if (zeile.startsWith("square")){
                    String[] spalten = zeile.split(" ");
                    int zahl = Integer.parseInt(spalten[1]);
                    int quadratZahl = zahl * zahl;
                    bw.write( "Die Quadratzahl der Zahl " + zahl + " = " + quadratZahl);
                    bw.newLine();

                    //bw.write(Integer.toString(quadratZahl));
                    //bw.newLine();
                }
                // add 3 4 5 6  = 5
                else if (zeile.startsWith("add")){
                    int sum = 0;
                    String[] spalten = zeile.split(" ");
                    for (int i = 1; i < spalten.length ; i++) {
                        sum = sum + Integer.parseInt(spalten[i]);
                    }
                    bw.write(Integer.toString(sum));
                    bw.newLine();

                }
                else if (zeile.startsWith("multiply")){
                    String[] spalten = zeile.split(" ");
                    int zahl1 =  Integer.parseInt(spalten[1]);
                    int zahl2 = Integer.parseInt(spalten[2]);
                    int sum = zahl2 * zahl1;
                    bw.write(Integer.toString(sum));
                    bw.newLine();
                }
                else if (zeile.equalsIgnoreCase("exit")){
                    bw.write("Bye");
                    bw.newLine();
                    System.out.println("Verbindung getrennt ");
                    break;
                }
                else {
                    bw.write("Bitte gueltige Anforderung senden");
                    bw.newLine();
                }

                bw.flush();
                System.out.println("Anforderung beendet");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
       try {
           handleCommands();
       } finally {
           try {
               cliSo.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

    }
}
