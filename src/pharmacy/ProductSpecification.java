package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {

    ProductID UPCode;
    String description;
    BigDecimal price;

    public ProductSpecification(ProductID UPCode, String description, BigDecimal price){
        this.UPCode = UPCode;
        this.description = description;
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    public BigDecimal getPrice(){
        return price;
    }
}
