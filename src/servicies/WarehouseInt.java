package servicies;

import pharmacy.ProductSaleLine;
import servicies.exceptions.InsuficientExistences;

import java.util.List;

public interface WarehouseInt {

    public void updateStock(List<ProductSaleLine> listOfProducts) throws InsuficientExistences;
}
