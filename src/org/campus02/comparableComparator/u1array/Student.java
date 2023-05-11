package org.campus02.comparableComparator.u1array;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private int matNr;
    private String vorname;
    private String nachname;

    public Student(int matNr, String vorname, String nachname) {
        this.matNr = matNr;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
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
        return "Student{" +
                "matNr=" + matNr +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        //sortiert von 1 hoch - aufsteigend / absteigend: 1 und -1 vertauschen
        if (this.matNr < o.matNr){
            return -1;
        }
        if (this.matNr > o.matNr){
            return 1;
        }
        return 0;
    }

    // equals() und hashcode mit implementieren! wenn Klasse implementiert Comparable
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return matNr == student.matNr && Objects.equals(vorname, student.vorname) && Objects.equals(nachname, student.nachname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matNr, vorname, nachname);
    }
}
