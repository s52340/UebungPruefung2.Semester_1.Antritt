package org.campus02.comparableComparator.u1array;

import java.util.Arrays;

public class ArraySortieren {
    public static void main(String[] args) {

    //int Array:
        int [] zahlen = { 3, 7, 2, 1, 4};
        System.out.println("Vor sortierung: "+ Arrays.toString(zahlen));

        //sortieren
        Arrays.sort(zahlen);
        System.out.println("Nach sortierung: "+ Arrays.toString(zahlen));

    //String Array:
        String[] namen = { "Bianca", "Verena", "Alina"};
        System.out.println("Vor sortieren: " + Arrays.toString(namen));

        //sortieren
        Arrays.sort(namen);
        System.out.println("Nach sortieren: " + Arrays.toString(namen));

    //Student Array:
        Student bi = new Student(1, "Bianca", "Thaler");
        Student re = new Student(93, "Regina", "Koi");
        Student je = new Student(33, "Jenny", "Deutsch");
        Student ma = new Student(33,"Matthias", "Thoma");

        Student[] students = {bi, re, je, ma};
        System.out.println("vor S: " + Arrays.toString(students));

        //sortieren
        Arrays.sort(students);
        System.out.print("nach S: ");
        for (Student s : students) {   //iter
            System.out.print(s);
        }

    }
}
