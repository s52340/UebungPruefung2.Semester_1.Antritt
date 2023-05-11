package org.campus02.Uebungsblaetter.personServer07FunktioniertNichtALLESKontrolliert;

public class PersonLoadException extends Exception{
    public PersonLoadException(String message) {
        super(message);
    }

    public PersonLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonLoadException(Throwable cause) {
        super(cause);
    }
}
