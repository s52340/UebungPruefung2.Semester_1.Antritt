package org.campus02.comparableComparator.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSortieren {
    public static void main(String[] args) {

        Person mama = new Person(1, "Theresa", "Thaler");
        Person papa = new Person(2, "Karl", "Heschl");
        Person nadi = new Person(27, "Nadine", "Jansi");
        Person chri = new Person(17, "Christoph", "Jansi");
        Person dani = new Person(2, "Daniel", "Jansi");

        List<Person> persons = new ArrayList<>();
        persons.add(mama);
        persons.add(papa);
        persons.add(nadi);
        persons.add(chri);
        persons.add(dani);

        System.out.println("Vor Sortierung: ");
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println();


        Collections.sort(persons);
        System.out.println("Nach Sortierung nach iD aufsteigend: ");
        for (Person per : persons) {
            System.out.println(per);
        }

        System.out.println();

        // 4 Möglichkeiten:

        //1.
        Collections.sort(persons, new IdComparatorDesc());
        System.out.println("Nach Sortierung iD absteigend");
        for (Person person : persons) {
            System.out.println(person);
        }

        //2.
        persons.sort(new NachnameVornameComparator());
        System.out.println(" Nachname aufsteigend, Vorname absteigend: ");
        for (Person pe : persons) {
            System.out.println(pe);
        }
        System.out.println();

        //in Main implementierungen:
        //3.
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getiD() < o2.getiD()) return -1;
                if (o1.getiD() > o2.getiD()) return 1;
                return 0;
            }
        });
        System.out.println("nach Id aufsteigend sortieren: ");
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println();


        //4.
        Collections.sort(persons, (p1,p2) -> p1.getVorname().compareTo(p2.getVorname()));
        System.out.println("nach Vorname sortiert: ");
        for (Person person : persons) {
            System.out.println(person);
        }

    }
}
