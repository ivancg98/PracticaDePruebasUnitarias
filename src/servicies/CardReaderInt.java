package servicies;

import data.HealthCardID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import servicies.exceptions.HealthCardException;

public interface CardReaderInt {
    HealthCardID getHealtCardId() throws HealthCardException, NullObjectException, EmptyCodeException, BadlyFormedCodeException;
}
