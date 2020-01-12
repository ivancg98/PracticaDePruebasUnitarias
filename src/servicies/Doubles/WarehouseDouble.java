package servicies.Doubles;

import pharmacy.ProductSaleLine;
import servicies.WarehouseInt;
import servicies.exceptions.InsuficientExistences;

import java.util.List;

public class WarehouseDouble implements WarehouseInt {
    @Override
    public void updateStock(List<ProductSaleLine> listOfProducts) throws InsuficientExistences {

    }
}
