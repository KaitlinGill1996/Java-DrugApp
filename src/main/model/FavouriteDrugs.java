package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// represents a list of drugs that have been manually added by user
public class FavouriteDrugs implements Writable {
    private ArrayList<Drug> favouriteDrugs;

    // EFFECTS creates an empty favouriteDrugs list
    public FavouriteDrugs() {
        favouriteDrugs = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a drug to the favouriteDrugs list
    public void addDrug(Drug drug) {
        favouriteDrugs.add(drug);
        EventLog.getInstance().logEvent(new Event("Drug added to favorite list: " + drug.getGenName()));
    }

    // MODIFIES: this
    // EFFECTS: removes a drug to the favouriteDrugs list
    public void removeDrug(Drug drug) {
        favouriteDrugs.remove(drug);
        EventLog.getInstance().logEvent(new Event("Drug removed from favorite list: " + drug.getGenName()));
    }

    // EFFECTS: returns the number of drugs in the favouriteDrugs list
    public int getNumDrugs() {
        return favouriteDrugs.size();
    }

    // EFFECTS: returns the list of drugs
    public ArrayList<Drug> getFavouriteDrugs() {
        return favouriteDrugs;
    }


    // REQUIRES: favouriteDrugs.size() > 0
    // EFFECTS: returns the drug in the list with the cheapest unit price
    // if 2 drugs with same cheapest unit price, return first in list
    public Drug getCheapestDrug() {
        Drug cheapestDrug = favouriteDrugs.get(0);
        for (Drug d : favouriteDrugs) {
            if (d.getUnitCost() < cheapestDrug.getUnitCost()) {
                cheapestDrug = d;
            }
        }
        EventLog.getInstance().logEvent(new Event("Cheapest drug retrieved: " + cheapestDrug.getGenName()));
        return cheapestDrug;
    }

    // REQUIRES: favouriteDrugs.size() > 0
    // EFFECTS: returns the drug in the list with the most expensive unit price
    // if 2 drugs with same unit price, return first expensive one in the list
    public Drug getExpensiveDrug() {
        Drug expensiveDrug = favouriteDrugs.get(0);
        for (Drug d : favouriteDrugs) {
            if (d.getUnitCost() > expensiveDrug.getUnitCost()) {
                expensiveDrug = d;
            }
        }
        EventLog.getInstance().logEvent(new Event("Most expensive drug retrieved: " + expensiveDrug.getGenName()));
        return expensiveDrug;
    }


    // REQUIRES: favouriteDrugs.size() > 0
    // EFFECTS: returns all the drugs from the favouriteDrugs list in the specified class of drugs
    public ArrayList<Drug> getDrugsInSameClass(String className) {
        ArrayList<Drug> drugsInSameClass = new ArrayList<>();
        for (Drug d : favouriteDrugs) {
            if (d.getDrugClass().equals(className)) {
                drugsInSameClass.add(d);
            }
        }
        return drugsInSameClass;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("drugs", drugsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray drugsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Drug d : favouriteDrugs) {
            jsonArray.put(d.toJson());
        }
        return jsonArray;
    }

}
