package pharmacy.test;

import data.PatientContr;
import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.*;
import pharmacy.Dispensing;
import pharmacy.MedicineDispensingLine;
import pharmacy.ProductSaleLine;
import pharmacy.Sale;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.SaleClosedException;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SaleTest {

    Sale s;
    List<ProductSaleLine> l;
    ProductID productID;
    BigDecimal price;
    PatientContr contr;

    @BeforeEach
    void initSaleTest() throws NullObjectException, EmptyCodeException, BadlyFormedCodeException, SaleClosedException {
        s = new Sale();
        productID = new ProductID("12A13W");
        price = new BigDecimal("2.5");
        contr = new PatientContr(new BigDecimal("50"));
        s.addLine(productID, price, contr );
    }

    @Test
    void addLineTest() throws SaleClosedException {
        s.calculateFinalAmount();
        System.out.println(s.getAmount());
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("1.5125")));
    }

    @Test
    void addLineTest2() throws SaleClosedException {

        s.addLine(productID, price, contr );
        s.calculateFinalAmount();
        System.out.println(s.getAmount());
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("3.025")));
    }

    @Test
    void addLineTest3() throws SaleClosedException {

        s.addLine(productID, price, contr );
        s.addLine(productID, price, contr );
        s.calculateFinalAmount();
        System.out.println(s.getAmount());
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("4.5375")));
    }

    @Test
    void addLineTest4() throws SaleClosedException, NullObjectException, EmptyCodeException, BadlyFormedCodeException {

        s.addLine(productID, price, contr );
        s.addLine(productID, price, contr );


        productID = new ProductID("12B13W");
        price = new BigDecimal("3.55");
        contr = new PatientContr(new BigDecimal("17"));

        s.addLine(productID, price, contr );
        s.calculateFinalAmount();
        System.out.println(s.getAmount());
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("5.267735")));
    }

    @Test
    void addLineSaleClosedExceptionTest() throws SaleClosedException {
        s.calculateFinalAmount();
        SaleClosedException thrown = assertThrows(SaleClosedException.class, () -> s.addLine(productID, price, contr ));
        assertTrue(thrown.getMessage().equals("Venta cerrada"));
    }
}
