package servicies.Doubles;

import pharmacy.Sale;
import servicies.SalesHistoryInt;

import java.net.ConnectException;

public class SalesHistoryDouble2 implements SalesHistoryInt {
    @Override
    public void registerSale(Sale sale) throws ConnectException {
        throw new ConnectException("Fallo con la conexión");
    }
}
