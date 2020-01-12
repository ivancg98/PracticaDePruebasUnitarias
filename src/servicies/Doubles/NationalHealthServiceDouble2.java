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

import java.net.ConnectException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class NationalHealthServiceDouble2 implements NationalHealthServiceInt {


    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, ParseException {

        ProductID productID = new ProductID("12A13W");
        MedicineDispensingLine medicineDispensingLine = new MedicineDispensingLine(productID);
        List<MedicineDispensingLine> listMedicineDispensingLine = new ArrayList<>();
        listMedicineDispensingLine.add(medicineDispensingLine);
        return new Dispensing("25-12-2019", "26-12-2019", listMedicineDispensingLine);
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        throw null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }
}
