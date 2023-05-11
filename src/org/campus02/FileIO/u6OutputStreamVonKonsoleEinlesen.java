package org.campus02.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class u6OutputStreamVonKonsoleEinlesen {
    public static void main(String[] args) {

        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\KonsoleEinfügen.txt");

        try (FileOutputStream fos = new FileOutputStream(file);){
            //int text = System.in.read(); //gibt mir int retour
            //char[] c = Character.toChars(text);   BESSER:

            char c = (char) System.in.read(); //ist ein automatischer Inputstream
            while ( c != 'x'){
                fos.write((int)c);
                c = (char) System.in.read();
            }
            if ( c == 'x'){
                System.out.println("Abbruchbedingung wurde erfüllt mit Zeichen x");
            }
            //do while // überprüft erst nach ausführung der Klammer ob es true/flase ist un ob es weitergehen soll - läuft mindestens 1x

            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
