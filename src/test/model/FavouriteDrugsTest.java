package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class FavouriteDrugsTest {
    private FavouriteDrugs testFavouriteDrugs;
    private ArrayList<Drug> expectedDrugs;
    private ArrayList<Drug> expectedDrugs2;
    private Drug testDrug1;
    private Drug testDrug2;
    private Drug testDrug3;
    private Drug testDrug4;
    private Drug testDrug5;
    private Drug testDrug6;
    private Drug testDrug7;

    @BeforeEach
    public void runBefore() {
        testFavouriteDrugs = new FavouriteDrugs();
        expectedDrugs = new ArrayList<Drug>();
        expectedDrugs2 = new ArrayList<Drug>();
        testDrug1 = new Drug("Metformin", "Glucophage", "Biguanide", 0.50);
        testDrug2 = new Drug("Atorvastatin", "Lipitor", "Statin", 0.23);
        testDrug3 = new Drug("Furosemide", "Lasix", "Diuretic", 0.37);
        testDrug4 = new Drug("Ramipril", "Altace", "ACEI", 0.50);
        testDrug5 = new Drug("Quinapril", "Accupril", "ACEI", 0.23);
        testDrug6 = new Drug("Benazapril", "Lotensin", "ACEI", 0.49);
        testDrug7 = new Drug("Rosuvastatin", "Crestor", "Statin", 0.24);
    }
    @Test
    void testConstructor() {
        assertEquals(0, testFavouriteDrugs.getNumDrugs()); // check empty list of drugs
    }

    @Test
    void testAddDrug() {
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals (1, testFavouriteDrugs.getNumDrugs()); // test adding one drug
        testFavouriteDrugs.addDrug(testDrug2);
        assertEquals(2, testFavouriteDrugs.getNumDrugs()); // test adding two drugs
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals(3, testFavouriteDrugs.getNumDrugs()); // test adding same drug twice
    }

    @Test
    void testRemoveDrug() {
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals(1, testFavouriteDrugs.getNumDrugs());
        testFavouriteDrugs.removeDrug(testDrug1);
        assertEquals(0, testFavouriteDrugs.getNumDrugs()); // test removing 1 drug from list of 1
        testFavouriteDrugs.addDrug(testDrug1);
        testFavouriteDrugs.addDrug(testDrug2);
        testFavouriteDrugs.addDrug(testDrug3);
        assertEquals(3, testFavouriteDrugs.getNumDrugs());
        testFavouriteDrugs.removeDrug(testDrug1);
        assertEquals(2, testFavouriteDrugs.getNumDrugs()); // remove first drug in a list of 3 drugs
        testFavouriteDrugs.removeDrug(testDrug3);
        assertEquals(1, testFavouriteDrugs.getNumDrugs()); // remove second drug in list of 2 drugs
    }

    @Test
    void testGetNumDrugs() {
        testFavouriteDrugs.addDrug(testDrug2);
        assertEquals(1, testFavouriteDrugs.getNumDrugs()); // test size with 1 drug
        testFavouriteDrugs.addDrug(testDrug2);
        assertEquals(2, testFavouriteDrugs.getNumDrugs());
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals(3, testFavouriteDrugs.getNumDrugs()); // test adding 3 drugs
    }

    @Test
    void testGetFavouriteDrugs() {
        testFavouriteDrugs.addDrug(testDrug1);
        expectedDrugs.add(testDrug1);
        assertEquals(expectedDrugs,testFavouriteDrugs.getFavouriteDrugs()); // test case with 1 drug in list
        testFavouriteDrugs.addDrug(testDrug2);
        testFavouriteDrugs.addDrug(testDrug3);
        expectedDrugs.add(testDrug2);
        expectedDrugs.add(testDrug3);
        assertEquals(expectedDrugs, testFavouriteDrugs.getFavouriteDrugs()); // test case with 3 drugs in list
    }


    @Test
    void testGetCheapestDrug() {
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals(testDrug1, testFavouriteDrugs.getCheapestDrug()); // test getting cheapest drug in list of 1
        testFavouriteDrugs.addDrug(testDrug2);
        testFavouriteDrugs.addDrug(testDrug3);
        assertEquals(testDrug2, testFavouriteDrugs.getCheapestDrug()); // test getting cheapest drug in list of 3
        testFavouriteDrugs.addDrug(testDrug7);
        assertEquals(testDrug2, testFavouriteDrugs.getCheapestDrug()); // test boundary case
        testFavouriteDrugs.addDrug(testDrug5);
        assertEquals(testDrug2, testFavouriteDrugs.getCheapestDrug()); // test when 2 drugs have same cheapest cost
    }

    @Test
    void testGetExpensiveDrug() {
        testFavouriteDrugs.addDrug(testDrug1);
        assertEquals(testDrug1, testFavouriteDrugs.getExpensiveDrug()); // test getting expensive drug in list of 1
        testFavouriteDrugs.addDrug(testDrug2);
        testFavouriteDrugs.addDrug(testDrug3);
        assertEquals(testDrug1, testFavouriteDrugs.getExpensiveDrug()); // test getting expensive drug in list of 3
        testFavouriteDrugs.addDrug(testDrug6);
        assertEquals(testDrug1, testFavouriteDrugs.getExpensiveDrug()); // test boundary case
        testFavouriteDrugs.addDrug(testDrug4);
        assertEquals(testDrug1, testFavouriteDrugs.getExpensiveDrug()); // test for when 2 drugs with same price
    }

    @Test
    void testGetDrugsInSameClass() {
        testFavouriteDrugs.addDrug(testDrug2);
        testFavouriteDrugs.addDrug(testDrug1);
        testFavouriteDrugs.addDrug(testDrug7);
        expectedDrugs.add(testDrug2);
        expectedDrugs.add(testDrug7);
        assertEquals(expectedDrugs, testFavouriteDrugs.getDrugsInSameClass("Statin"));
        testFavouriteDrugs.addDrug(testDrug4);
        testFavouriteDrugs.addDrug(testDrug5);
        testFavouriteDrugs.addDrug(testDrug6);
        expectedDrugs2.add(testDrug4);
        expectedDrugs2.add(testDrug5);
        expectedDrugs2.add(testDrug6);
        assertEquals(expectedDrugs2, testFavouriteDrugs.getDrugsInSameClass("ACEI"));
    }



}
