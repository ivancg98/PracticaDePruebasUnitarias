package servicies.Doubles;

import data.HealthCardID;
import servicies.CardReaderInt;
import servicies.exceptions.HealthCardException;

public class CardReaderDouble2 implements CardReaderInt {
    @Override
    public HealthCardID getHealtCardId() throws HealthCardException {
         throw new HealthCardException("Lector no reconoce la tarjeta") ;
    }
}
