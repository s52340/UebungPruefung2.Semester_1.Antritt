package org.campus02.Uebungsblaetter.Uebungsabend180423;

public class DataFileException extends Exception{

    public DataFileException() {
    }

    public DataFileException(String message) {
        super(message);
    }

    //Lt. Angabe
    public DataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileException(Throwable cause) {
        super(cause);
    }
}
