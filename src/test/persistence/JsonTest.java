package persistence;

import model.Drug;

import static org.junit.jupiter.api.Assertions.assertEquals;

//code inspired by JsonSerializationDemo
public class JsonTest {
    protected void checkDrug(String genName, String brandName, String drugClass, double price, Drug drug) {
        assertEquals(genName, drug.getGenName());
        assertEquals(brandName, drug.getBrandName());
        assertEquals(drugClass, drug.getDrugClass());
        assertEquals(price, drug.getUnitCost());
    }
}
