package pharmacy.test;

import data.ProductID;
import pharmacy.DispensingTerminal;
import pharmacy.exceptions.DispensingNotAvailableException;
import pharmacy.exceptions.SaleClosedException;
import pharmacy.exceptions.SaleNotInitiatedException;

import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.*;
import servicies.Doubles.*;
import servicies.exceptions.HealthCardException;
import servicies.exceptions.NotValidePrescriptionException;
import servicies.exceptions.ProductIDException;


import java.net.ConnectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTerminalExceptionTest {

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
    CardReaderDouble2 cardReaderDouble2;
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
        cardReaderDouble = new CardReaderDouble();
        cardReaderDouble2 = new CardReaderDouble2();

    }

    @Test
    void getePrescriptionHealthCardExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble2);
        HealthCardException thrown = assertThrows(HealthCardException.class, () -> dTerminal.getePrescription(option));
        assertTrue(thrown.getMessage().equals("Lector no reconoce la tarjeta"));
    }

    @Test
    void getePrescriptionNotValidePrescriptionExceptionTest() {
        NationalHealthServiceDouble4 SNSdouble4 = new NationalHealthServiceDouble4();
        dTerminal.setNationalHealthService(SNSdouble4);
        dTerminal.setCardReader(cardReaderDouble);
        NotValidePrescriptionException thrown = assertThrows(NotValidePrescriptionException.class, () -> dTerminal.getePrescription(option));
        assertTrue(thrown.getMessage().equals("El paciente no tiene ninguna receta asociada"));
    }

    @Test
    void getePrescriptionConnectExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble3);
        dTerminal.setCardReader(cardReaderDouble);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.getePrescription(option));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));
    }

    @Test
    void initNewSaleDispensingNotAvailableException() throws ParseException, ConnectException, BadlyFormedCodeException, NotValidePrescriptionException, EmptyCodeException, HealthCardException, NullObjectException {
        dTerminal.setNationalHealthService(SNSdouble2);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        DispensingNotAvailableException thrown = assertThrows(DispensingNotAvailableException.class, () -> dTerminal.initNewSale());
        assertTrue(thrown.getMessage().equals("Retirada fuera del periodo de dispensación"));
    }

    @Test
    void enterProductConnectExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.setNationalHealthService(SNSdouble3);
        ConnectException thrown = assertThrows(ConnectException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("Fallo con la conexión"));
    }

    @Test
    void enterProductProductIDExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException {
        NationalHealthServiceDouble4 SNSdouble4 = new NationalHealthServiceDouble4();
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.setNationalHealthService(SNSdouble4);
        ProductIDException thrown = assertThrows(ProductIDException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("El identificador del producto no se encuentra en el catalogo"));
    }



    @Test
    void enterProductSaleNotInitiadedExceptionTest() {
        dTerminal.setNationalHealthService(SNSdouble3);
        dTerminal.setCardReader(cardReaderDouble);
        SaleNotInitiatedException thrown = assertThrows(SaleNotInitiatedException.class, () -> dTerminal.enterProduct(new ProductID("X123")));
        assertTrue(thrown.getMessage().equals("Venta no iniciada"));
    }


    @Test
    void enterProductSaleClosedExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble);
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
        dTerminal.setCardReader(cardReaderDouble);
        SaleNotInitiatedException thrown = assertThrows(SaleNotInitiatedException.class, () -> dTerminal.finalizeSale());
        assertTrue(thrown.getMessage().equals("Venta no iniciada"));
    }

    @Test
    void finalizeSaleSaleClosedExceptionTest() throws ConnectException, ParseException, NotValidePrescriptionException, EmptyCodeException, NullObjectException, HealthCardException, BadlyFormedCodeException, DispensingNotAvailableException, SaleNotInitiatedException, ProductIDException, SaleClosedException {
        dTerminal.setNationalHealthService(SNSdouble);
        dTerminal.setCardReader(cardReaderDouble);
        dTerminal.getePrescription(option);
        dTerminal.initNewSale();
        dTerminal.enterProduct(new ProductID("X123"));
        dTerminal.finalizeSale();
        SaleClosedException thrown = assertThrows(SaleClosedException.class, () -> dTerminal.finalizeSale());
        assertTrue(thrown.getMessage().equals("Venta cerrada"));
    }
}







