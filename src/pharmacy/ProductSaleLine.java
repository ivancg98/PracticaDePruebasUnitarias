package pharmacy;

import data.PatientContr;
import data.ProductID;
import java.math.BigDecimal;

public class ProductSaleLine {

    ProductID prodID;
    BigDecimal price;
    PatientContr contr;

    public ProductSaleLine(ProductID prodID, BigDecimal price, PatientContr contr){

        this.prodID = prodID;
        this.price = price;
        this.contr = contr;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public BigDecimal getPatientContr(){
        return contr.getPatientContr();
    }


}
