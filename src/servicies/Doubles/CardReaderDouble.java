package servicies.Doubles;

import data.HealthCardID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import servicies.CardReaderInt;
import servicies.exceptions.HealthCardException;

public class CardReaderDouble implements CardReaderInt {
    @Override
    public HealthCardID getHealtCardId() throws HealthCardException, NullObjectException, EmptyCodeException, BadlyFormedCodeException {

        return new HealthCardID("789U");
    }
}
