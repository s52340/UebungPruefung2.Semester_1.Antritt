package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.*;
import java.util.ArrayList;

public class PersonLoaderLehrer {
    private String pathToFile;

    public PersonLoaderLehrer(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public ArrayList<Person> load() throws PersonLoadException {
        ArrayList<Person> personen = new ArrayList<>();
        File file = new File(pathToFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file));){
            String line;
            while ((line = br.readLine()) != null){
                String[] spalten = line.split(";");
                Person p = new Person(Integer.parseInt(spalten[0]), spalten[1],spalten[2]);
                personen.add(p);
            }

        return personen;

        } catch (FileNotFoundException e) {
            throw new PersonLoadException("File not found", e);
        } catch (IOException e) {
            throw new PersonLoadException("Can not read file", e);
        }

    }
}
