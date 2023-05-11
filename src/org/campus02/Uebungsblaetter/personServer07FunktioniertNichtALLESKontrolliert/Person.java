package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    //Um Gesammte Objekte schreiben und lesen zu können - imple.Serializable!
    private int id;
    private String firstname;
    private String lastname;

    public Person(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    //Setter : wenn Atribute verändert werden können sollen;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
