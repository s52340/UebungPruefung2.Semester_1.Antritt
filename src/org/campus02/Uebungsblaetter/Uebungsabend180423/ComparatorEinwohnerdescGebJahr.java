package org.campus02.Uebungsblaetter.Uebungsabend180423;

import java.util.Comparator;

public class EinwohnerCompdescGebJahr implements Comparator<Einwohner> {

    @Override
    public int compare(Einwohner o1, Einwohner o2) {
        if (o2.getGeburtsjahr() < o1.getGeburtsjahr()){
            return -1;
        }
        if (o2.getGeburtsjahr() > o1.getGeburtsjahr()){
            return 1;
        }
        else {
          return o1.getName().compareTo(o2.getName());

        }
    }
}
