package model;

import org.json.JSONObject;
import persistence.Writable;

// represents a drug having a generic name, brand name, drug class, and price per unit (capsule/
// tablet) in dollars
public class Drug implements Writable {
    private String genName;        // generic name
    private String brandName;      // brand name
    private String drugClass;      // drug class
    private double price;          // price in dollars

    // EFFECTS: creates a drug with a generic name, brand name, and drug class
    public Drug(String genName, String brandName, String drugClass, double price) {
        this.genName = genName;
        this.brandName = brandName;
        this.drugClass = drugClass;
        this.price = price;
    }

    public String getGenName() {
        return this.genName;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getDrugClass() {
        return this.drugClass;
    }

    public double getUnitCost() {
        return this.price;
    }

    // MODIFIES: This
    // EFFECTS: updates the price of a drug
    public void updateCost(double cost) {
        this.price = cost;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("genName", genName);
        json.put("brandName", brandName);
        json.put("drugClass", drugClass);
        json.put("price", price);
        return json;
    }
}
