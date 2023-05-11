package org.campus02.comparableComparator.collections;

import java.util.Comparator;

public class NachnameVornameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) { //Nachname aufsteigend
        int res = o1.getNachname().compareTo(o2.getNachname());
        if (res == 0){ //wenn Nachname gleich - Vorname ABSTEIGEND (wegen minus!)
           return  -  o1.getVorname().compareTo(o2.getVorname());
        }
        return res;
    }
}
