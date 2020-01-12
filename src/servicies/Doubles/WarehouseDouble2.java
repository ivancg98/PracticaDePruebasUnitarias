package servicies.Doubles;

import pharmacy.ProductSaleLine;
import servicies.WarehouseInt;
import servicies.exceptions.InsuficientExistences;

import java.net.ConnectException;
import java.util.List;

public class WarehouseDouble2 implements WarehouseInt {
    @Override
    public void updateStock(List<ProductSaleLine> listOfProducts) throws InsuficientExistences, ConnectException {

        throw new ConnectException("Fallo con la conexión");
    }
}
