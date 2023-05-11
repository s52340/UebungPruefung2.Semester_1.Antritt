package org.campus02.FileIO;

import java.io.*;

public class u9ReaderDemo {
    //IO S.65
    public static void main(String[] args) {
        File f = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Uebungs_Objektspeicher\\u9Reader.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String zeile;
            while ((zeile = br.readLine()) != null){
                System.out.println(zeile);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
