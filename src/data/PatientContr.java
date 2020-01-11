package data;

import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;

import java.math.BigDecimal;

public class PatientContr {

    private final BigDecimal PatientContr;

    public PatientContr(BigDecimal PatientContr) throws NullObjectException, EmptyCodeException {
        NullObject(PatientContr);
        EmptyCode(PatientContr);
        this.PatientContr = PatientContr;
    }

    public BigDecimal getPatientContr(){
        return PatientContr;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContr p = (PatientContr) o;
        return PatientContr.equals(p.PatientContr);
    }

    @Override
    public int hashCode() { return PatientContr.hashCode(); }

    @Override
    public String toString() {
        return "PatientContr{" + "percentage patient='" + PatientContr + '\'' + '}';
    }

    public void NullObject(BigDecimal PatientContr) throws NullObjectException {
        if(PatientContr == null){
            throw new NullObjectException("objeto sin instanciar");
        }
    }

    public void EmptyCode(BigDecimal PatientContr) throws EmptyCodeException {
        if(PatientContr.compareTo(BigDecimal.ZERO) == 0){
            throw new EmptyCodeException("Porcentaje vacio");
        }
    }
}
