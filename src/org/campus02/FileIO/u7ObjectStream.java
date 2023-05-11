package org.campus02.FileIO;

import java.io.*;

public class u7ObjectStream {
    public static void main(String[] args) {

        File f = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\object.dat");

        String stringObjekt = "Huhuhuhuhuhuhu :) ";
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            /* durch .writeObject kann ich mir viel code ersparen:
            for (char c : stringObjekt.toCharArray()) {
                oos.writeObject((int) c);
            }
            */
            oos.writeObject(stringObjekt);
            oos.flush();
            oos.close();
            //fos.close();  muss ich nicht extra closen


            FileInputStream fis= new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            String gelesenerText = (String) ois.readObject();
            System.out.println(gelesenerText);

            ois.close(); //!!!!!

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
