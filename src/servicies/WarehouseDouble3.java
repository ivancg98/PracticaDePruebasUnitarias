package servicies;

import pharmacy.ProductSaleLine;
import servicies.exceptions.InsuficientExistences;

import java.net.ConnectException;
import java.util.List;

public class WarehouseDouble3 implements WarehouseInt {
    @Override
    public void updateStock(List<ProductSaleLine> listOfProducts) throws InsuficientExistences, ConnectException {

        throw new InsuficientExistences("No hay suficiente stock");
    }
}
