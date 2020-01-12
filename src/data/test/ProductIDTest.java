package data.test;

import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import data.test.testInterfaces.DataExceptionsInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductIDTest implements DataExceptionsInterfaceTest {

    ProductID Hcard;
    ProductID Hcard1;
    ProductID Hcard2;


    @BeforeEach
    void initHealthCardIDTest() throws NullObjectException, EmptyCodeException, BadlyFormedCodeException {
        Hcard1 = new ProductID("casa123");
        Hcard2 = new ProductID("casa123");
    }


    @Override
    @Test
    public void NullObjectExceptionTest() {
        NullObjectException thrown = assertThrows(NullObjectException.class, () -> Hcard = new ProductID(null));
        assertTrue(thrown.getMessage().equals("objeto sin instanciar"));
    }

    @Override
    @Test
    public void EmptyCodeExceptionTest() {
        EmptyCodeException thrown = assertThrows(EmptyCodeException.class, () -> Hcard = new ProductID(""));
        assertTrue(thrown.getMessage().equals("código de identificación vacio"));

    }

    @Test
    public void BadlyFormedCodeExceptionTest() {

        BadlyFormedCodeException thrown = assertThrows(BadlyFormedCodeException.class, () -> Hcard = new ProductID("%"));
        assertTrue(thrown.getMessage().equals("código de identificación mal formado"));

    }

}

