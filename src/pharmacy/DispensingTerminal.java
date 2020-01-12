package pharmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.QuantityMinorThanImport;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;
import servicies.*;
import servicies.exceptions.*;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;


public class DispensingTerminal{

    NationalHealthServiceInt SNS;
    HealthCardID hcID;
    Dispensing d;
    PatientContr contr;
    Sale sale;
    CashPayment p;
    SalesHistoryInt salesHistory;
    WarehouseInt w;



    public void getePrescription( char option) throws NotValidePrescriptionException, HealthCardException, ConnectException, EmptyCodeException, ParseException, BadlyFormedCodeException, NullObjectException {
        d = SNS.getePrescription(hcID);
    }

    public void initNewSale() throws DispensingNotAvailableException, ParseException {
        d.dispensingEnabled();
        sale = new Sale();
    }

    public void enterProduct (ProductID pID) throws ProductIDException, ConnectException, SaleClosedException, DispensingNotAvailableException, ParseException, SaleNotInitiatedException,  NullObjectException, EmptyCodeException, BadlyFormedCodeException {
        SaleNotInitiatedException();
        ProductSpecification ps = SNS.getProductSpecific(pID);
        sale.addLine(ps.UPCode, ps.price, SNS.getPatientContr(hcID));
        if(d.dispensingEnabled()){
            d.setProductAsDispensed(pID);
        }
    }

    public void finalizeSale() throws SaleClosedException, SaleNotInitiatedException {
        SaleNotInitiatedException();
        sale.calculateFinalAmount();
        if(d.isCompleted()){
            d.setCompleted();
        }
    }

    public void realizaPayment(BigDecimal quantity) throws InsuficientExistences, ConnectException, QuantityMinorThanImport {
        p = new CashPayment();
        p.setImport(sale.getAmount());
        p.setChange(p.CalculateChange(quantity));
        System.out.println(p.getChange());
        salesHistory.registerSale(sale);
        w.updateStock(sale.l);
        SNS.updateePrescription(hcID, d);
        }


    public void setNationalHealthService(NationalHealthServiceInt SNS) {
        this.SNS = SNS;
    }

    public void setWarehouse(WarehouseInt w) {
        this.w = w;
    }

    public void setSalesHistory(SalesHistoryInt salesHistory) {
        this.salesHistory = salesHistory;
    }

    public void SaleNotInitiatedException() throws SaleNotInitiatedException {
        if(this.sale == null){
            throw new SaleNotInitiatedException("Venta no iniciada");
        }
    }


    }





