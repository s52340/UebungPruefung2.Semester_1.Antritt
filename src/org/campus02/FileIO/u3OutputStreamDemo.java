package org.campus02.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class u3OutputStreamDemo {
    public static void main(String[] args) {

        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\OutputSelbstErzeugt.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);

            String outputText = "Hallo Mani :) ";
            for (char c : outputText.toCharArray()) {
                fos.write((int) c);
            }
            //wieso c in int casten? geht auch ohne ??

            //funktioniert auch ohne .flush und ohne .close
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
