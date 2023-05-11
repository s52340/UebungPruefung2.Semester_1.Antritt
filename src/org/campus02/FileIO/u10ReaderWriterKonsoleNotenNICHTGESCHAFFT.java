package org.campus02.FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class u10ReaderWriterKonsoleNoten {
    // IO Folien S. 74
    public static void main(String[] args) {
        File f = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Uebungs_Objektspeicher\\u10Noten.txt");
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(f))
        ){
            char eingabeChar = (char) System.in.read();  //System... gibt int retour wird in char gecastet
            String zeile = null;
            while (eingabeChar != 10){
                Character ch = Character.valueOf(eingabeChar);
                zeile = zeile + ch;
                eingabeChar = (char) System.in.read();
                while (zeile != "stop"){
                    pw.print(zeile);
                    System.out.println("sout: " + zeile);
                    zeile = String.valueOf(System.in.read());
                }

            }



            pw.flush();
            pw.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
