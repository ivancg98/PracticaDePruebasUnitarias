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
        this.amount = new BigDecimal("0");
    }

    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException{
        isClosedException();
        ProductSaleLine p = new ProductSaleLine(prodID, price, contr);
        l.add(p);
    }

    private void calculateAmount(){

        for(int i = 0; i < l.size(); i++){
            amount = amount.add(l.get(i).getPrice().multiply(l.get(i).getPatientContr()).divide(new BigDecimal("100")));
        }
    }

    private void addTaxes() throws SaleClosedException {
        isClosedException();
        amount = amount.multiply(new BigDecimal("21")).divide(new BigDecimal("100")).add(amount);
    }

    public void calculateFinalAmount() throws SaleClosedException{

        isClosedException();
        calculateAmount();
        addTaxes();
        setClosed();

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

    public void isClosedException() throws SaleClosedException {
        if(isClosed()){
            throw new SaleClosedException("Venta cerrada");
        }
    }
}
