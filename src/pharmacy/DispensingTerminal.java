package pharmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.SaleClosedException;
import servicies.NationalHealthService;
import servicies.NationalHealthServiceDB;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.net.ConnectException;
import java.util.List;

public class DispensingTerminal{

    NationalHealthServiceDB SNS = new NationalHealthServiceDB();
    HealthCardID hcID;
    Dispensing d;
    PatientContr contr;
    Sale sale;

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




}
