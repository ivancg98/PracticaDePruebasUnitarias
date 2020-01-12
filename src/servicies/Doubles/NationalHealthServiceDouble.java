package servicies.Doubles;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import pharmacy.Dispensing;
import pharmacy.MedicineDispensingLine;
import pharmacy.ProductSpecification;
import servicies.NationalHealthServiceInt;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class NationalHealthServiceDouble implements NationalHealthServiceInt {

    ProductID productID;
    ProductID productID2;


    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, ParseException {


        productID = new ProductID("12A13W");
        productID2 = new ProductID("122A13W");

        MedicineDispensingLine medicineDispensingLine = new MedicineDispensingLine(productID);
        MedicineDispensingLine medicineDispensingLine2 = new MedicineDispensingLine(productID);
        MedicineDispensingLine medicineDispensingLine3 = new MedicineDispensingLine(productID);

        List<MedicineDispensingLine> listMedicineDispensingLine = new ArrayList<>();
        listMedicineDispensingLine.add(medicineDispensingLine);
        listMedicineDispensingLine.add(medicineDispensingLine2);
        listMedicineDispensingLine.add(medicineDispensingLine3);
        return new Dispensing("25-12-2019", "24-02-2020",  listMedicineDispensingLine);
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException, NullObjectException, EmptyCodeException {
        return new PatientContr(new BigDecimal("50"));
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException{
        return new ProductSpecification(productID, "a", new BigDecimal("10.50"));
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }
}
