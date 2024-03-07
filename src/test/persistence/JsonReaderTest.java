package persistence;

import model.Drug;
import model.FavouriteDrugs;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// code inspired by JsonSerializationDemo from CPSC 210
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            FavouriteDrugs fd = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFavouriteDrugs() {
        JsonReader reader = new JsonReader("./data/testReaderFavouriteDrugs.json");
        try {
            FavouriteDrugs fd = reader.read();
            assertEquals(0, fd.getNumDrugs());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFavouriteDrugs() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFavouriteDrugs.json");
        try {
            FavouriteDrugs fd = reader.read();
            List<Drug> drugs = fd.getFavouriteDrugs();
            assertEquals(2, fd.getNumDrugs());
            checkDrug("Rosuvastatin", "Crestor", "Statin", 0.39, drugs.get(0));
            checkDrug("Rabeprazole", "Pariet", "PPI", 0.23, drugs.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
