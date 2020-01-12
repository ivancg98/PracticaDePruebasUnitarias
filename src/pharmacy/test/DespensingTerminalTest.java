package pharmacy.test;

import data.ProductID;
import pharmacy.DispensingTerminal;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.QuantityMinorThanImport;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;
import servicies.*;

import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.*;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.InsuficientExistences;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;


import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DespensingTerminalTest {

    NationalHealthServiceDouble SNSdouble;
    NationalHealthServiceDouble2 SNSdouble2;
    NationalHealthServiceDouble3 SNSdouble3;
    WarehouseDouble warehouseDouble;
    WarehouseDouble2 warehouseDouble2;
    WarehouseDouble3 warehouseDouble3;
    SalesHistoryDouble salesHistoryDouble;
    SalesHistoryDouble2 salesHistoryDouble2;
    DispensingTerminal dTerminal;
    char option;

    @BeforeEach
    void initDispensingTerminalTest() {
        dTerminal = new DispensingTerminal();
        SNSdouble = new NationalHealthServiceDouble();
        SNSdouble2 = new NationalHealthServiceDouble2();
        SNSdouble3 = new NationalHealthServiceDouble3();
        warehouseDouble = new WarehouseDouble();
        warehouseDouble2 = new WarehouseDouble2();
        warehouseDouble3 = new WarehouseDouble3();
        salesHistoryDouble = new SalesHistoryDouble();
        salesHistoryDouble2 = new SalesHistoryDouble2();
    }

    @Test
    void getePrescriptionConnectExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble3);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.getePrescription(option));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));
    }

    @Test
    void initNewSaleDispensingNotAvailableException() throws ParseException, ConnectException, BadlyFormedCodeException, NotValidePrescriptionException, EmptyCodeException, HealthCardException, NullObjectException {
        dTerminal.setNationalHealthService(SNSdouble2);
        dTerminal.getePrescription(option);
        DispensingNotAvailableException thrown = assertThrows(DispensingNotAvailableException.class, () -> dTerminal.initNewSale());
        assertTrue(thrown.getMessage().equals("Retirada fuera del periodo de dispensación"));
    }

    @Test
    void enterProductConnectExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.setNationalHealthService(SNSdouble3);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));
    }

    @Test
    void enterProductSaleNotInitiadedExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble3);
        SaleNotInitiatedException thrown = assertThrows(SaleNotInitiatedException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("Venta no iniciada"));
    }


    @Test
    void enterProductSaleClosedExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("X123"));
        dTerminal.finalizeSale();
        SaleClosedException thrown = assertThrows(SaleClosedException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("Venta cerrada"));
    }

    @Test
    void finalizeSaleSaleNotInitiatedExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble3);
        SaleNotInitiatedException thrown = assertThrows(SaleNotInitiatedException.class, () -> dTerminal.finalizeSale());
        assertTrue(thrown.getMessage().equals("Venta no iniciada"));
    }

    @Test
    void finalizeSaleSaleClosedExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("X123"));
        dTerminal.finalizeSale();
        SaleClosedException thrown = assertThrows(SaleClosedException.class, () -> dTerminal.finalizeSale());
        assertTrue(thrown.getMessage().equals("Venta cerrada"));
    }
}







