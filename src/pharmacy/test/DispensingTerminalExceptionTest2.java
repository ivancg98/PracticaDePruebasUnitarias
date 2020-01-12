package pharmacy.test;

import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacy.DispensingTerminal;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.QuantityMinorThanImport;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;
import servicies.Doubles.*;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.InsuficientExistences;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DispensingTerminalExceptionTest2 {

    NationalHealthServiceDouble SNSdouble;
    NationalHealthServiceDouble2 SNSdouble2;
    NationalHealthServiceDouble3 SNSdouble3;
    WarehouseDouble warehouseDouble;
    WarehouseDouble2 warehouseDouble2;
    WarehouseDouble3 warehouseDouble3;
    SalesHistoryDouble salesHistoryDouble;
    SalesHistoryDouble2 salesHistoryDouble2;
    DispensingTerminal dTerminal;
    CardReaderDouble cardReaderDouble;
    char option;

    @BeforeEach
    void initDispensingTerminalTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal = new DispensingTerminal();
        SNSdouble = new NationalHealthServiceDouble();
        SNSdouble2 = new NationalHealthServiceDouble2();
        SNSdouble3 = new NationalHealthServiceDouble3();
        warehouseDouble = new WarehouseDouble();
        warehouseDouble2 = new WarehouseDouble2();
        warehouseDouble3 = new WarehouseDouble3();
        salesHistoryDouble = new SalesHistoryDouble();
        salesHistoryDouble2 = new SalesHistoryDouble2();
        cardReaderDouble = new CardReaderDouble();
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("X123"));
        dTerminal.finalizeSale();
    }


    @Test
    void realizePaymentConnectException1Test() {
        dTerminal.setSalesHistory(salesHistoryDouble2);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.realizaPayment(new BigDecimal("50")));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));

    }

    @Test
    void realizePaymentConnectException2Test() {
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.setWarehouse(warehouseDouble2);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.realizaPayment(new BigDecimal("50")));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));

    }

    @Test
    void realizePaymentConnectException3Test() {
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.setWarehouse(warehouseDouble);
        dTerminal.setNationalHealthService(SNSdouble3);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.realizaPayment(new BigDecimal("50")));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));

    }

    @Test
    void realizePaymentQuantityMinorThanImportTest() {
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.setWarehouse(warehouseDouble);
        QuantityMinorThanImport thrown = assertThrows(QuantityMinorThanImport.class, () -> dTerminal.realizaPayment(new BigDecimal("5")));
        assertTrue(thrown.getMessage().equals("La cantidad es menor que el importe total"));

    }

    @Test
    void realizePaymentInsuficientExistencesTest() {
        dTerminal.setSalesHistory(salesHistoryDouble);
        dTerminal.setWarehouse(warehouseDouble3);
        InsuficientExistences thrown = assertThrows(InsuficientExistences.class, () -> dTerminal.realizaPayment(new BigDecimal("50")));
        assertTrue(thrown.getMessage().equals("No hay suficiente stock"));


    }
}







