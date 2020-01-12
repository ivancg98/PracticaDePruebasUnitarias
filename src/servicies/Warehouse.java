package servicies;

import pharmacy.ProductSaleLine;
import servicies.exceptions.InsuficientExistences;

import java.util.List;

public class Warehouse implements WarehouseInt {

    @Override
    public void updateStock(List<ProductSaleLine> listOfProducts) throws InsuficientExistences {

    }
}
