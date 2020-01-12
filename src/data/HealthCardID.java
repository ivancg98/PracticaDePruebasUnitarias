package data;

import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;

public class HealthCardID {

    private final String personalID;

    public HealthCardID(String code) throws NullObjectException, BadlyFormedCodeException, EmptyCodeException {
        NullObjectException(code);
        EmptyCodeException(code);
        this.personalID = code;
        BadlyFormedCodeException(this.personalID);
    }

    public String getPersonalID() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }

    @Override
    public int hashCode() {
        return personalID.hashCode();
    }

    @Override
    public String toString() {
        return "HealthCardID{" + "personal code='" + personalID + '\'' + '}';

    }

    public void BadlyFormedCodeException(String code) throws BadlyFormedCodeException {
        for (int i = 0; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i)) && !Character.isLetter(code.charAt(i))) {
                throw new BadlyFormedCodeException("código de identificación mal formado");
            }
        }
    }

    public void NullObjectException(String code) throws NullObjectException {
        if (code == null) {
            throw new NullObjectException("objeto sin instanciar");
        }
    }

    public void EmptyCodeException(String code) throws EmptyCodeException {
        if (code == "") {
            throw new EmptyCodeException("código de identificación vacio");
        }
    }
}
