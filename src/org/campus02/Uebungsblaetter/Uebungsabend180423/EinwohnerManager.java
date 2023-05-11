package org.campus02.Uebungsblaetter.Uebungsabend180423;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerManager {

    public static void main(String[] args) {

        EinwohnerManager einwohnerManager = new EinwohnerManager();
        try {
            ArrayList<Einwohner> einwohnerListe = einwohnerManager.load();
            System.out.println("einwohnerListe.size() = " + einwohnerListe.size());
            for (Einwohner einwohner : einwohnerListe) {
                System.out.println(einwohner.toString());
            }
        } catch (DataFileException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Einwohner> load() throws DataFileException {
        ArrayList<Einwohner> einwohnerList = new ArrayList<>();
        File file = new File("src/org/campus02/Uebungsblaetter/Uebungsabend180423/testdata/testdata-einwohner.csv");
        //Lehrer - geht auch: String file = "src/org/campus02/Uebungsblaetter/Uebungsabend180423/testdata/testdata-einwohner.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file));
        ){
            String zeileKommasepariert;
            br.readLine();               //Überschrift wird ignoriert - wird einfach ausgelesen
            while ((zeileKommasepariert = br.readLine()) != null){
                String[] einwohnerData = zeileKommasepariert.split(";");
                if (einwohnerData.length != 4){
                    throw new DataFileException("Ungültiger Datensatz - nicht vollständig");
                }
                // 1;Cirstoforo Heys;Steiermark;2002
                // -> .split(";")
                // einwohnerData[0] = 1
                // einwohnerData[1] = Cirstoforo Heys
                // einwohnerData[2] = Steiermark
                // einwohnerData[3] = 2002
                int id = Integer.parseInt(einwohnerData[0]);
                Einwohner einwohner = new Einwohner(id,einwohnerData[1],
                            einwohnerData[2],Integer.parseInt(einwohnerData[3]));
                einwohnerList.add(einwohner);

                //Einwohner Sortieren -Comparator:
                einwohnerList.sort(new ComparatorEinwohnerdescGebJahr());

                //Einwohner Sortieren - Comparable:
                Collections.sort(einwohnerList);

            }

        } catch (FileNotFoundException e) {
            throw new DataFileException("File wurde nicht gefunden", e);
        } catch (IOException e) {
            throw new DataFileException("Can not read file", e);
        }
        return einwohnerList;
    }
}
