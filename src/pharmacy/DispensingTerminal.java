package pharmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.SaleClosedException;
import servicies.NationalHealthService;
import servicies.NationalHealthServiceDB;
import servicies.SalesHistory;
import servicies.Warehouse;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.InsuficientExistences;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Formatter;
import java.util.List;

public class DispensingTerminal{

    NationalHealthServiceDB SNS;
    HealthCardID hcID;
    Dispensing d;
    PatientContr contr;
    Sale sale;
    CashPayment p;
    SalesHistory salesHistory;
    Warehouse w;



    public void getePrescription( char option) throws NotValidePrescriptionException, HealthCardException, ConnectException {
        d = SNS.getePrescription(hcID);
        contr = SNS.getPatientContr(hcID);
    }

    public void initNewSale(){
        sale = new Sale();
    }

    public void enterProduct (ProductID pID) throws ProductIDException, ConnectException, SaleClosedException, DispensingNotAvailableException {
        ProductSpecification ps = SNS.getProductSpecific(pID);
        sale.addLine(ps.UPCode, ps.price, SNS.getPatientContr(hcID));
        if(d.dispensingEnabled()){
            d.setProductAsDispensed(pID);
        }
    }

    public void finalizeSale() throws SaleClosedException {
        sale.calculateFinalAmount();
        if(d.isCompleted()){
            d.setCompleted();
        }
    }

    public void realizaPayment(BigDecimal quantity) throws InsuficientExistences, ConnectException {
        p = new CashPayment();
        p.setImport(sale.getAmount());
        p.setChange(quantity.subtract(p.getImport()));
        salesHistory.registerSale(sale);
        w.updateStock(sale.l);
        SNS.updateePrescription(hcID, d);
        }


    public void setNationalHealthServiceDB(NationalHealthServiceDB SNS) {
        this.SNS = SNS;
    }

    public void setWarehouse(Warehouse w) {
        this.w = w;
    }

    public void setSalesHistory(SalesHistory salesHistory) {
        this.salesHistory = salesHistory;
    }

    }





