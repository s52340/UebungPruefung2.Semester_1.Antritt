package org.campus02.FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//geht mit .txt Datei, aber nicht mit Word!
public class u2InputStreamDemo {
    public static void main(String[] args) {

        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Zahlen.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            int byteRead;
            int anzahlZeichen = 0;
            while ((byteRead = fis.read()) != -1){
                System.out.println("Ohne Umwandlung/ int: " + byteRead);
                char[] chars = Character.toChars(byteRead); //geht nicht in einzelnen char zu speichern
                System.out.println("Umwandlung char: " + chars[0]);
                anzahlZeichen ++;
            }
            fis.close();
            System.out.println("anzahlZeichen = " + anzahlZeichen);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
