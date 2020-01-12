package data.test;

import data.HealthCardID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import data.test.testInterfaces.DataExceptionsInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthCardIDTest implements DataExceptionsInterfaceTest {

    HealthCardID Hcard;
    HealthCardID Hcard1;
    HealthCardID Hcard2;


    @BeforeEach
    void initHealthCardIDTest() throws NullObjectException, EmptyCodeException, BadlyFormedCodeException {
        Hcard1 = new HealthCardID("casa123");
        Hcard2 = new HealthCardID("casa123");
    }

    @Override
    @Test
    public void NullObjectExceptionTest() {
        NullObjectException thrown = assertThrows(NullObjectException.class, () -> Hcard = new HealthCardID(null));
        assertTrue(thrown.getMessage().equals("objeto sin instanciar"));
    }

    @Override
    @Test
    public void EmptyCodeExceptionTest() {
        EmptyCodeException thrown = assertThrows(EmptyCodeException.class, () -> Hcard = new HealthCardID(""));
        assertTrue(thrown.getMessage().equals("código de identificación vacio"));

    }

    @Test
    public void BadlyFormedCodeExceptionTest() {

        BadlyFormedCodeException thrown = assertThrows(BadlyFormedCodeException.class, () -> Hcard = new HealthCardID("%"));
        assertTrue(thrown.getMessage().equals("código de identificación mal formado"));

    }

    @Test
    public void BadlyFormedCodeExceptionTest2() {

        BadlyFormedCodeException thrown = assertThrows(BadlyFormedCodeException.class, () -> Hcard = new HealthCardID(".."));
        assertTrue(thrown.getMessage().equals("código de identificación mal formado"));

    }

    @Test
    public void BadlyFormedCodeExceptionTest3() {

        BadlyFormedCodeException thrown = assertThrows(BadlyFormedCodeException.class, () -> Hcard = new HealthCardID(","));
        assertTrue(thrown.getMessage().equals("código de identificación mal formado"));

    }

}




