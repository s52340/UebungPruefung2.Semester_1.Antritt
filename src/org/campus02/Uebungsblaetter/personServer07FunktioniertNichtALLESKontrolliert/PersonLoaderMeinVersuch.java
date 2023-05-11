package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.*;
import java.util.ArrayList;

public class PersonLoaderMeinVersuch {
    //Konstru. Pfad CSV Datei
    //MEIN Versuch funktioniert auch in Anwendung

    private File file;

    public PersonLoaderMeinVersuch(String pathToCSV) {
        this.file = new File(pathToCSV);
    }

    public ArrayList<Person> load() throws PersonLoadException {
        ArrayList<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file));
        ){
            String zeile;
            while ((zeile = br.readLine()) != null){
                String[] spalten = zeile.split(";");
                if (spalten.length != 3){
                    break;                   //??
                }
                Person p = new Person(Integer.parseInt(spalten[0]), spalten[1], spalten[2]);
                persons.add(p);
            }

        } catch (FileNotFoundException e) {
            throw new PersonLoadException("File wurde nicht gefunden", e);
        } catch (IOException e) {
            throw new PersonLoadException("File konnte nicht geladen werden", e);
        }

        return persons;
    }


}
