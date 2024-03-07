package persistence;

import model.Drug;
import model.FavouriteDrugs;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            FavouriteDrugs fd = new FavouriteDrugs();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyFavouriteDrugs() {
        try {
            FavouriteDrugs fd = new FavouriteDrugs();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFavouriteDrugs.json");
            writer.open();
            writer.write(fd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFavouriteDrugs.json");
            fd = reader.read();
            assertEquals(0, fd.getNumDrugs());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            FavouriteDrugs fd = new FavouriteDrugs();
            fd.addDrug(new Drug("Rosuvastatin", "Crestor", "Statin", 0.39));
            fd.addDrug(new Drug ("Rabeprazole", "Pariet", "PPI", 0.23));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFavouriteDrugs.json");
            writer.open();
            writer.write(fd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFavouriteDrugs.json");
            fd = reader.read();
            List<Drug> drugs = fd.getFavouriteDrugs();
            assertEquals(2, fd.getNumDrugs());
            checkDrug("Rosuvastatin", "Crestor", "Statin", 0.39, drugs.get(0));
            checkDrug("Rabeprazole", "Pariet", "PPI", 0.23, drugs.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
