package pharmacy.test;

import data.ProductID;
import data.exceptions.BadlyFormedCodeException;
import data.exceptions.EmptyCodeException;
import data.exceptions.NullObjectException;
import org.junit.jupiter.api.*;
import pharmacy.Dispensing;
import pharmacy.MedicineDispensingLine;
import pharmacy.exceptions.DispensingNotAvailableException;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    Dispensing d;
    Dispensing d2;
    ProductID productID;
    ProductID productID2;
    MedicineDispensingLine medicineDispensingLine;
    MedicineDispensingLine medicineDispensingLine2;
    MedicineDispensingLine medicineDispensingLine3;
    List<MedicineDispensingLine> listMedicineDispensingLine;


    @BeforeEach
    void initDispensingTest () throws ParseException, NullObjectException, EmptyCodeException, BadlyFormedCodeException {
        productID = new ProductID("12A13W");
        productID2 = new ProductID("122A13W");
        medicineDispensingLine = new MedicineDispensingLine(productID);
        medicineDispensingLine2 = new MedicineDispensingLine(productID);
        medicineDispensingLine3 = new MedicineDispensingLine(productID);

        listMedicineDispensingLine = new ArrayList<>();
        listMedicineDispensingLine.add(medicineDispensingLine);
        listMedicineDispensingLine.add(medicineDispensingLine2);
        listMedicineDispensingLine.add(medicineDispensingLine3);
        d = new Dispensing("25-12-2019", "12-01-2020",  listMedicineDispensingLine);
        d2 = new Dispensing("25-12-2019", "09-01-2020",  listMedicineDispensingLine);

    }

    @Test
    public void dispensingEnabledTest() throws DispensingNotAvailableException, ParseException {
        d.setFinalDate(d.createDateActual());
        assertTrue(d.dispensingEnabled());
    }

    @Test
    public void dispensingEnabledDispensingNotAvailableExceptionTest(){
        DispensingNotAvailableException thrown = assertThrows(DispensingNotAvailableException.class, () -> d2.dispensingEnabled());
        assertTrue(thrown.getMessage().equals("Retirada fuera del periodo de dispensación"));
    }

    @Test
    public void setProductAsDispensedTest() {
        d.setProductAsDispensed(productID);
        assertTrue(d.l.get(0).isAdquired());
    }

    @Test
    public void isCompletedTest(){
        assertTrue(!d.isCompleted());
    }

    @Test
    public void isCompletedTest2(){
        d.setProductAsDispensed(productID);
        assertTrue(!d.isCompleted());
    }


    @Test
    public void isCompletedTest3(){
        d.setProductAsDispensed(productID);
        d.setProductAsDispensed(productID);
        d.setProductAsDispensed(productID);
        assertTrue(d.isCompleted());
    }

    @Test
    public void setInitDateTest() throws ParseException {
        d.setInitDate(d.createDate("22-11-2011"));
        assertEquals(0, d.getInitDate().compareTo(d.createDate("22-11-2011")) );
    }

    @Test
    public void setFinalDateTest() throws ParseException {
        d.setFinalDate(d.createDate("26-11-2015"));
        assertEquals(0, d.getFinalDate().compareTo(d.createDate("26-11-2015")));
    }
}

