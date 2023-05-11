package org.campus02.FileIO;

import java.io.*;

public class u5OutputStreamInputstream {
    public static void main(String[] args) {
        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\GuteNachtGeschichte.txt");

        System.out.println("file.canRead() = " + file.canRead());


        try (FileOutputStream fos = new FileOutputStream(file); FileInputStream fis = new FileInputStream(file)){
            String guteNacht = "Es war einmal eine kleine Bianca, und weil sie so müde war, schlief sie gleich ein";
            for (char c : guteNacht.toCharArray()) {
                fos.write((int) c);
            }
            fos.flush();
            fos.close();

            int byteRead;
            while ((byteRead = fis.read()) != -1){
                //System.out.println(byteRead);
                char[] c = Character.toChars(byteRead);
                System.out.print(c);
            }
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
