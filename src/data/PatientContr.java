package data;

import java.math.BigDecimal;

public class PatientContr {
    private final BigDecimal PatientContr;

    public PatientContr(BigDecimal PatientContr){
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
}
