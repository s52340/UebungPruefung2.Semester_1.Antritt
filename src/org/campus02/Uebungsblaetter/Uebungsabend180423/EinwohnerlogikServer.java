package org.campus02.Uebungsblaetter.Uebungsabend180423;

import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerlogikServer {
    private Socket cliSo;

    public EinwohnerlogikServer(Socket cliSo) {
        this.cliSo = cliSo;
    }

    public void process() throws DataFileException, IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(cliSo.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(cliSo.getOutputStream()));
        ){
            ArrayList<Einwohner> einwohnerListe = new EinwohnerManager().load();

            String anfrage;
            while ((anfrage = br.readLine()) != null){
                System.out.println(anfrage);
               if (anfrage.startsWith("GET ")){
                   ArrayList<Einwohner> einwohnerFiltered = new ArrayList<>();
                   String[] cmd = anfrage.split(" ");
                   if (cmd.length == 2){ //z.B. GET Steiermark (größe 2)
                       //ArrayList<Einwohner> einwohnerPerBundesland = getbyBundesland(cmd[1], einwohnerListe);
                        einwohnerFiltered = getbyBundesland(cmd[1], einwohnerListe);
                   }
                   else {     //z.B. GET 1990 order by name (größe 5)
                        //ArrayList<Einwohner> einwohnerPerGebJahr = getByGeburtsjahr(Integer.parseInt(cmd[1]), einwohnerListe);
                        einwohnerFiltered = getByGeburtsjahr(Integer.parseInt(cmd[1]), einwohnerListe);
                   }

                   for (Einwohner einwohner : einwohnerFiltered) {
                       bw.write(einwohner.toString());
                       bw.newLine();
                   }
               }
               //Exit, EXIT, exit, eXit
               else if (anfrage.equalsIgnoreCase("exit")){
                    break; //Verbindung beenden
               }
               //kein exit, kein GET - falscher input
               else {
                   bw.write("falscher Input");
               }

               bw.newLine();
               bw.flush();

            }

        }
    }

    private ArrayList<Einwohner> getbyBundesland(String bundesland, ArrayList<Einwohner> einwohners){
        ArrayList<Einwohner> gefilterteEWListe = new ArrayList<>();
        for (Einwohner einwohner : einwohners) {
            if (einwohner.getBundesland().equalsIgnoreCase(bundesland)){
                gefilterteEWListe.add(einwohner);
            }
        }
        return gefilterteEWListe;
    }

    private ArrayList<Einwohner> getByGeburtsjahr(int geburtsjahr, ArrayList<Einwohner> einwohners){
        ArrayList<Einwohner> gefilterteEWListe = new ArrayList<>();
        for (Einwohner einwohner : einwohners) {
            if (einwohner.getGeburtsjahr() == geburtsjahr){
                gefilterteEWListe.add(einwohner);
            }
        }
        Collections.sort(gefilterteEWListe);
        return gefilterteEWListe;
    }

}
