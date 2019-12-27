package data.test;

import data.HealthCardID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import data.test.testInterfaces.DataExceptionsInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HealthCardIDTest implements DataExceptionsInterfaceTest {

    HealthCardID Hcard;
    Date date;


    @Override
    @Test
    public void NullObjectExceptionTest() {
        NullObjectException thrown = assertThrows(NullObjectException.class, () -> Hcard = new HealthCardID(null));
        this.date = new Date();
        System.out.println(date);
        assertTrue(thrown.getMessage().equals("objeto sin instanciar"));
    }

    @Override
    @Test
    public void EmptyCodeExceptionTest() {
        EmptyCodeException thrown = assertThrows(EmptyCodeException.class, () -> Hcard = new HealthCardID(""));
        assertTrue(thrown.getMessage().equals("código de identificación vacio"));
        }



    @Override
    @Test
    public void BadlyFormedCodeExceptionTest() {

        BadlyFormedCodeException thrown = assertThrows(BadlyFormedCodeException.class, () -> Hcard = new HealthCardID("%"));
        assertTrue(thrown.getMessage().equals("código de identificación mal formado"));

    }

}


