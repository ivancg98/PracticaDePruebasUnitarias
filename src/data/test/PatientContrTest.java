package data.test;

import data.HealthCardID;
import data.PatientContr;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import data.test.testInterfaces.DataExceptionsInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PatientContrTest implements DataExceptionsInterfaceTest {


    PatientContr patient;

    @Override
    @Test
    public void NullObjectExceptionTest() {
        NullObjectException thrown = assertThrows(NullObjectException.class, () -> patient = new PatientContr(null));
        assertTrue(thrown.getMessage().equals("objeto sin instanciar"));
    }

    @Override
    @Test
    public void EmptyCodeExceptionTest() {
        EmptyCodeException thrown = assertThrows(EmptyCodeException.class, () -> patient = new PatientContr(new BigDecimal("0")));
        assertTrue(thrown.getMessage().equals("Porcentaje vacio"));

    }






}
