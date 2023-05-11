package org.campus02.comparableComparator.u2collections;

public class Person implements Comparable<Person>{
    private int iD;
    private String vorname;
    private String nachname;

    public Person(int iD, String vorname, String nachname) {
        this.iD = iD;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "iD=" + iD +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.iD < o.iD) {
            return -1;
        }
        if (this.iD > o.iD){
            return 1;
        }
        return 0;
    }
}
