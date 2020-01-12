package pharmacy.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacy.CashPayment;
import pharmacy.exceptions.QuantityMinorThanImport;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CashPaymentTest {

    BigDecimal Change;
    CashPayment cashPayment;

    @BeforeEach
    public void initCashPaymentTest() {
        cashPayment = new CashPayment();
        cashPayment.setImport(new BigDecimal("6.6"));
        cashPayment.setChange(new BigDecimal("12.12"));
    }

    @Test
    public void setChangeTest() {
        int s = cashPayment.getChange().compareTo(new BigDecimal("12.12"));
        assertEquals(0, s);
    }

    @Test
    public void setImportTest() {
        int s = cashPayment.getImport().compareTo(new BigDecimal("6.6"));
        assertEquals(0, s);
    }

    @Test
    public void CalculateChangeTest() throws QuantityMinorThanImport {
        Change = cashPayment.CalculateChange(new BigDecimal("7.6"));
        int s = Change.compareTo(new BigDecimal("1"));
        assertEquals(0, s);
    }

    @Test
    public void CalculateChangeTest2() throws QuantityMinorThanImport {
        Change = cashPayment.CalculateChange(new BigDecimal("12.5"));
        int s = Change.compareTo(new BigDecimal("5.9"));
        assertEquals(0, s);
    }

    @Test
    public void CalculateChangeTest3() throws QuantityMinorThanImport {
        Change = cashPayment.CalculateChange(new BigDecimal("13.28"));
        int s = Change.compareTo(new BigDecimal("6.68"));
        assertEquals(0, s);
    }

    @Test
    void QuantityMinorThanImportExceptionTest() {
        QuantityMinorThanImport thrown = assertThrows(QuantityMinorThanImport.class, () -> cashPayment.CalculateChange(new BigDecimal("3.3")));
        assertTrue(thrown.getMessage().equals("La cantidad es menor que el importe total"));
    }


}
