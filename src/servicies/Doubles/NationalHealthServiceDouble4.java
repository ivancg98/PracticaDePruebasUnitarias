package servicies.Doubles;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import servicies.NationalHealthServiceInt;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.net.ConnectException;
import java.text.ParseException;
import java.util.List;


public class NationalHealthServiceDouble4 implements NationalHealthServiceInt {


    @Override
    public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, ParseException {
        throw new NotValidePrescriptionException("El paciente no tiene ninguna receta asociada");
    }

    @Override
    public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
        return null;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        return null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        return null;
    }
}
