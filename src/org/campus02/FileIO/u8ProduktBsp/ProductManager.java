package org.campus02.FileIO.u8ProduktBsp;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    private  ArrayList<Product> products = new ArrayList<>();


    public void add (Product p){
     products.add(p);
    }

    public void save(String path){

        File f = new File(path);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            BufferedOutputStream bos = new BufferedOutputStream(oos);//lt Angabe mit bos machen - aber hier unnötig

            for (Product pro : products) {
                oos.writeObject(pro);
            }

            // oos.writeObject(null); oder EOF Exception

            oos.flush();
            oos.close();
            bos.close();

        } catch (EOFException eof){                      //WICHTIG!!!
            //nur bei dieser Exception (nichts) oke!!!!
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void load(String path){

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File(path))
        )){

            Object gelesenesObjekt;
            while ((gelesenesObjekt = ois.readObject()) != null){
                System.out.println(gelesenesObjekt.toString());
            }

            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException efo){             ///WICHTIG!!
            //nichts :)
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
