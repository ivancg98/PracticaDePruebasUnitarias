package pharmacy;

import data.PatientContr;
import data.ProductID;
import pharmacy.exceptions.SaleClosedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed;
    List<ProductSaleLine> l;


    public Sale (){
        this.saleCode = 1;
        this.date = new Date();
        l = new ArrayList<>();
        isClosed = false;
    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException{
        if(isClosed()){
            throw new SaleClosedException("Venta cerrada");
        }
        ProductSaleLine p = new ProductSaleLine(prodID, price, contr);
        l.add(p);
    }

    private void calculateAmount(){
        amount = new BigDecimal("0");
        for(int i = 0; i < l.size(); i++){
            amount.add(l.get(i).getPrice().multiply(l.get(i).getPatientContr()).divide(new BigDecimal("100")));
        }
    }

    private void addTaxes() throws SaleClosedException {
        if(isClosed()){
            throw new SaleClosedException("Venta cerrada");
        }
        amount.multiply(new BigDecimal("21")).divide(new BigDecimal("100")).add(amount);
    }

    public void calculateFinalAmount() throws SaleClosedException{

        if(isClosed()){
            throw new SaleClosedException("Venta cerrada");
        }
        calculateAmount();
        addTaxes();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setClosed(){
        isClosed = true;
    }

    public boolean isClosed(){
        return isClosed;
    }


}
