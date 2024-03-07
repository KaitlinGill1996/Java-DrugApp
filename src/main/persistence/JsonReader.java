package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Drug;
import model.FavouriteDrugs;
import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
// code inspired by JsonReader in JsonSerializationDemo provided in CPSC 210
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FavouriteDrugs read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFavouriteDrugs(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private FavouriteDrugs parseFavouriteDrugs(JSONObject jsonObject) {
        FavouriteDrugs fd = new FavouriteDrugs();
        addDrugs(fd, jsonObject);
        return fd;
    }

    // MODIFIES: fd
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addDrugs(FavouriteDrugs fd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("drugs");
        for (Object json : jsonArray) {
            JSONObject nextDrug = (JSONObject) json;
            addDrug(fd, nextDrug);
        }
    }

    // MODIFIES: fd
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addDrug(FavouriteDrugs fd, JSONObject jsonObject) {
        String genName = jsonObject.getString("genName");
        String brandName = jsonObject.getString("brandName");
        String drugClass = jsonObject.getString("drugClass");
        Double price = jsonObject.getDouble("price");
        Drug drug = new Drug(genName, brandName, drugClass, price);
        fd.addDrug(drug);
    }
}
