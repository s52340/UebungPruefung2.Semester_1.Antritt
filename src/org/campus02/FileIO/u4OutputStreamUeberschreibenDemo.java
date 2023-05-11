package org.campus02.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class u4OutputStream2UeberschreibenDemo {
    public static void main(String[] args) {

        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\OutputSelbstErzeugt.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {

            String neuerOutputText = "Ich bin schon müde";
            for (char c : neuerOutputText.toCharArray()) {
                fos.write((int) c);
            }
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
