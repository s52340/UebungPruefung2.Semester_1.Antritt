package org.campus02.FileIO.u11cvsPersonenNICHTGESCHAFT;

import java.util.Objects;

public class Person {
    private String vorname;
    private String nachname;
    private String geburtsort;

    public Person(String vorname, String nachname, String geburtsort) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsort = geburtsort;
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

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(vorname, person.vorname) && Objects.equals(nachname, person.nachname) && Objects.equals(geburtsort, person.geburtsort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname, geburtsort);
    }

    @Override
    public String toString() {
        return "Person{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                '}';
    }
}
