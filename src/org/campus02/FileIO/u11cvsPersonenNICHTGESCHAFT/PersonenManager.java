package org.campus02.FileIO.u11cvsPersonenNICHTGESCHAFT;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PersonenManager {

    //Folien S. 93 !!
    ArrayList<Person> persons = new ArrayList<>();
    public void load(String path){
        try (BufferedReader br = new BufferedReader(
                new FileReader(new File(path), StandardCharsets.UTF_8)
        )){
            String zeile;
            while ((zeile = br.readLine()) != null){
                zeile.split(",");
               // Person p = new Person();
               // persons.add(p);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
