package servicies;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.net.ConnectException;
import java.text.ParseException;
import java.util.List;

public interface NationalHealthServiceInt {
    Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, ParseException;

    PatientContr getPatientContr(HealthCardID hcID) throws ConnectException, NullObjectException, EmptyCodeException;

    ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException;

    List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException;
}

