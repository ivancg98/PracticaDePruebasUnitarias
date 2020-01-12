package pharmacy;

import pharmacy.exceptions.QuantityMinorThanImport;

import java.math.BigDecimal;

public class CashPayment extends Payment {

    BigDecimal Change;

    public void setChange(BigDecimal Change) {

        this.Change = Change;
    }

    public BigDecimal getChange() {
        return Change;
    }

    public BigDecimal CalculateChange(BigDecimal quant) throws QuantityMinorThanImport {
        if (quant.compareTo(Import) < 0) {
            throw new QuantityMinorThanImport("La cantidad es menor que el importe total");
        }
        return quant.subtract(Import);
    }
}

