package pharmacy.test;

import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacy.CashPayment;
import pharmacy.DispensingTerminal;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.QuantityMinorThanImport;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;
import servicies.Doubles.CardReaderDouble;
import servicies.Doubles.NationalHealthServiceDouble5;
import servicies.Doubles.SalesHistoryDouble;
import servicies.Doubles.WarehouseDouble;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.InsuficientExistences;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispensingTerminalTest2 {

    DispensingTerminal dTerminal;
    NationalHealthServiceDouble5 SNSdouble5;
    char option;
    WarehouseDouble warehouseDouble;
    SalesHistoryDouble salesHistoryDouble;
    CardReaderDouble cardReaderDouble;
    CashPayment c;


    @BeforeEach
    public void initDispensingTerminalTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal = new DispensingTerminal();
        SNSdouble5 = new NationalHealthServiceDouble5();
        warehouseDouble = new WarehouseDouble();
        salesHistoryDouble = new SalesHistoryDouble();
        cardReaderDouble = new CardReaderDouble();
        dTerminal.setNationalHealthService(SNSdouble5);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("12A13W"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.enterProduct(new ProductID("122A3313W"));
        dTerminal.finalizeSale();

    }

    @Test
    public void finalize() throws SaleClosedException, SaleNotInitiatedException, ConnectException, QuantityMinorThanImport, InsuficientExistences {

        dTerminal.setWarehouse(warehouseDouble);
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.realizaPayment(new BigDecimal("50.45"));
        c = dTerminal.getCashPayment();
        assertEquals(0, c.getChange().compareTo(new BigDecimal("20.3963225")));

    }

    @Test
    public void finalize2() throws SaleClosedException, SaleNotInitiatedException, ConnectException, QuantityMinorThanImport, InsuficientExistences {

        dTerminal.setWarehouse(warehouseDouble);
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.realizaPayment(new BigDecimal("34.45"));
        c = dTerminal.getCashPayment();
        assertEquals(0, c.getChange().compareTo(new BigDecimal("4.3963225")));

    }

    @Test
    public void finalize3() throws SaleClosedException, SaleNotInitiatedException, ConnectException, QuantityMinorThanImport, InsuficientExistences {

        dTerminal.setWarehouse(warehouseDouble);
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.realizaPayment(new BigDecimal("30.0536775"));
        c = dTerminal.getCashPayment();
        assertEquals(0, c.getChange().compareTo(new BigDecimal("0")));

    }


}



