package org.campus02.FileIO.u8ProduktBsp;

public class ProductDemo {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        productManager.add(new Product("Apfel", 2.03, "Obst"));
        productManager.add(new Product("Gurke", 1.08, "Gemüse"));
        productManager.add(new Product("Birne", 1.56, "Obst"));

        System.out.println("Save: ");
        productManager.save("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Uebungs_Objektspeicher\\ProductBsp1.txt");

        System.out.println("Load: ");
        productManager.load("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\Uebungs_Objektspeicher\\ProductBsp1.txt");
    }
}
