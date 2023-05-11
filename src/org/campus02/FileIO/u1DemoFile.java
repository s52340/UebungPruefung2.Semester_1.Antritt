package org.campus02.FileIO;

import java.io.File;
import java.util.Arrays;

public class DemoFile {
    public static void main(String[] args) {

        File file = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\ZahlenWord.docx");
        System.out.println("file.canRead() = " + file.canRead());
        System.out.println("file.canWrite() = " + file.canWrite());
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.length() = " + file.length());


        File fileArr = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele");
        File[] files = fileArr.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println("files.length = " + files.length);

        System.out.println();
        printAndGetSize(fileArr);

    }

    public static long printAndGetSize(File f){
        File[] files = f.listFiles();
        long size = 0;
        for (File file : files) {
            System.out.println(file);
            size = size + file.length();
        }
        System.out.println("Groeße: " + size);
        return size;
    }
}
