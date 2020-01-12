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


public class NationalHealthServiceDouble5 implements NationalHealthServiceInt {

    ProductID productID;
    ProductID productID2;
    ProductID productID3;
    ProductID productID4;


    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, ParseException {


        productID = new ProductID("12A13W");
        productID2 = new ProductID("122A13WFDS");
        productID3 = new ProductID("122A3313W");
        productID4 = new ProductID("122A12343W");

        MedicineDispensingLine medicineDispensingLine = new MedicineDispensingLine(productID);
        MedicineDispensingLine medicineDispensingLine2 = new MedicineDispensingLine(productID2);
        MedicineDispensingLine medicineDispensingLine3 = new MedicineDispensingLine(productID3);
        MedicineDispensingLine medicineDispensingLine4 = new MedicineDispensingLine(productID3);
        MedicineDispensingLine medicineDispensingLine5 = new MedicineDispensingLine(productID3);
        MedicineDispensingLine medicineDispensingLine6 = new MedicineDispensingLine(productID4);
        MedicineDispensingLine medicineDispensingLine7 = new MedicineDispensingLine(productID4);

        List<MedicineDispensingLine> listMedicineDispensingLine = new ArrayList<>();
        listMedicineDispensingLine.add(medicineDispensingLine);
        listMedicineDispensingLine.add(medicineDispensingLine2);
        listMedicineDispensingLine.add(medicineDispensingLine3);
        listMedicineDispensingLine.add(medicineDispensingLine4);
        listMedicineDispensingLine.add(medicineDispensingLine5);
        listMedicineDispensingLine.add(medicineDispensingLine6);
        listMedicineDispensingLine.add(medicineDispensingLine7);
        return new Dispensing("25-12-2019", "24-02-2020", listMedicineDispensingLine);
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException, NullObjectException, EmptyCodeException {
        return new PatientContr(new BigDecimal("78.85"));
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        return new ProductSpecification(pID, "a", new BigDecimal("10.50"));
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }
}
