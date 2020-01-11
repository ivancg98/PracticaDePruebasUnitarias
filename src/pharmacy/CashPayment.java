package pharmacy;

import java.math.BigDecimal;

public class CashPayment extends Payment {
    BigDecimal Change;

    public void setChange(BigDecimal Change){
        this.Change = Change;
    }

    public BigDecimal getChange(){
        return Change;
    }
}
