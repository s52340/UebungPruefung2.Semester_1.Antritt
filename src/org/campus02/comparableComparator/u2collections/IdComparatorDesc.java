package org.campus02.comparableComparator.collections;

import java.util.Comparator;

public class IdComparatorDesc implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getiD() < o2.getiD()){
            return 1;
        }
        if (o1.getiD() > o2.getiD()){
            return -1;
        }
        return 0;
    }
}
