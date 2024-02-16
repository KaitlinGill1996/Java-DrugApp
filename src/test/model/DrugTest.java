package model;

import model.Drug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrugTest {
    private Drug testDrug1;
    private Drug testDrug2;
    private Drug testDrug3;

    @BeforeEach
    void runBefore() {
        testDrug1 = new Drug("Metformin", "Glucophage", "Biguanide", 0.50);
        testDrug2 = new Drug("Atorvastatin", "Lipitor", "Statin", 0.23);
        testDrug3 = new Drug("Furosemide", "Lasix", "Diuretic", 0.37);
    }

    @Test
    void testConstructor() {
        assertEquals("Metformin", testDrug1.getGenName());
        assertEquals("Glucophage", testDrug1.getBrandName());
        assertEquals("Biguanide", testDrug1.getDrugClass());
        assertEquals(0.50, testDrug1.getUnitCost());
        assertEquals("Atorvastatin", testDrug2.getGenName());
        assertEquals("Diuretic", testDrug3.getDrugClass());
    }

    @Test
    void testUpdateCost() {
        assertEquals(0.50, testDrug1.getUnitCost());
        testDrug1.updateCost(0.65);
        assertEquals(0.65, testDrug1.getUnitCost());
    }

}