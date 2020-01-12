package pharmacy.test;

import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacy.Dispensing;
import pharmacy.DispensingTerminal;
import pharmacy.Sale;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;
import servicies.Doubles.CardReaderDouble;
import servicies.Doubles.NationalHealthServiceDouble5;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DispensingTerminalTest {

    DispensingTerminal dTerminal;
    NationalHealthServiceDouble5 SNSdouble5;
    char option;
    CardReaderDouble cardReaderDouble;
    Sale s;
    Dispensing d;

    @BeforeEach
    public void initDispensingTerminalTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal = new DispensingTerminal();
        SNSdouble5 = new NationalHealthServiceDouble5();
        cardReaderDouble = new CardReaderDouble();
        dTerminal.setNationalHealthService(SNSdouble5);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("12A13W"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.enterProduct(new ProductID("122A3313W"));

    }

    @Test
    public void finalizeSaleGetAmountTest() throws SaleClosedException, SaleNotInitiatedException {
        dTerminal.finalizeSale();
        s = dTerminal.getSale();
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("30.0536775")));

    }

    @Test
    public void finalizeSaleisCompletedTest() throws SaleClosedException, SaleNotInitiatedException {
        dTerminal.finalizeSale();
        d = dTerminal.getDispensing();
        assertTrue(!d.isCompleted());
    }

    @Test
    public void finalizeSaleGetAmountTest2() throws SaleClosedException, SaleNotInitiatedException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, DispensingNotAvailableException, ConnectException, ProductIDException, ParseException {
        dTerminal.enterProduct(new ProductID("122A13WFDS"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.enterProduct(new ProductID("122A12343W"));
        dTerminal.enterProduct(new ProductID("122A12343W"));
        dTerminal.finalizeSale();
        s = dTerminal.getSale();
        assertEquals(0, s.getAmount().compareTo(new BigDecimal("70.1252475")));

    }

    @Test
    public void finalizeSaleisCompletedTest2() throws SaleClosedException, SaleNotInitiatedException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, DispensingNotAvailableException, ConnectException, ProductIDException, ParseException {
        dTerminal.enterProduct(new ProductID("122A13WFDS"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.enterProduct(new ProductID("122A12343W"));

        dTerminal.finalizeSale();
        d = dTerminal.getDispensing();
        assertTrue(!d.isCompleted());
    }

    @Test
    public void finalizeSaleisCompletedTest3() throws SaleClosedException, SaleNotInitiatedException, NullObjectException, EmptyCodeException, BadlyFormedCodeException, DispensingNotAvailableException, ConnectException, ProductIDException, ParseException {
        dTerminal.enterProduct(new ProductID("122A13WFDS"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.enterProduct(new ProductID("122A12343W"));
        dTerminal.enterProduct(new ProductID("122A12343W"));
        dTerminal.finalizeSale();
        d = dTerminal.getDispensing();
        assertTrue(d.isCompleted());
    }

}



