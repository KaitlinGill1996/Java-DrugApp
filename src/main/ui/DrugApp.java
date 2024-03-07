package ui;

import model.Drug;
import model.FavouriteDrugs;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Drug application - that allows you to create a drug list and find the cheapest/expensive drugs
// Code inspired by TellerApp provided by CPSC 210
public class DrugApp {
    private static final String JSON_STORE = "./data/favouriteDrugs.json";
    private FavouriteDrugs favouriteDrugs;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: runs the drug application
    public DrugApp() {
        runDrugApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runDrugApp() {
        boolean keepRunning = true;
        String command = null;

        init();

        while (keepRunning) {
            drugMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepRunning = false;
            } else {
                processCommand(command);
            }

        }
        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes empty drug list
    private void init() {
        favouriteDrugs = new FavouriteDrugs();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            createNewDrug();
        } else if (command.equals("b")) {
            getFavouriteDrugs();
        } else if (command.equals("c")) {
            removeDrugFromList();
        } else if (command.equals("d")) {
            findCheapestDrug();
        } else if (command.equals("e")) {
            getMostExpensiveDrug();
        } else if (command.equals("f")) {
            getDrugsInClass();
        } else if (command.equals("g")) {
            saveFavouriteDrugs();
        } else if (command.equals("h")) {
            loadFavouriteDrugs();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void drugMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Create new drug to add to list");
        System.out.println("\tb -> View all drugs currently in list");
        System.out.println("\tc -> Remove a drug from list");
        System.out.println("\td -> Find cheapest drug in list");
        System.out.println("\te -> Find most expensive drug in list");
        System.out.println("\tf -> Return all drugs in a class");
        System.out.println("\tg -> Save favourite drug list to file");
        System.out.println("\th -> Load favourite drug list from file");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: create a new drug and then adds it to the list
    private void createNewDrug() {
        System.out.println("\nEnter the generic name of the drug:");
        String g = input.next();
        System.out.println("\nEnter the brand name of the drug:");
        String b = input.next();
        System.out.println("\nEnter the class the drug is in:");
        String d = input.next();
        System.out.println("\nEnter the unit price of the drug (cost per tablet/capsule):");
        double u = input.nextDouble();
        Drug drug = new Drug(g, b, d, u);
        favouriteDrugs.addDrug(drug);
    }

    // REQUIRES: favouriteDrugList.getNumDrugs > 0
    // MODIFIES: this
    // EFFECTS: removes the entered drug from the list, if not found returns error message
    private void removeDrugFromList() {
        if (favouriteDrugs.getNumDrugs() == 0) {
            System.out.println("There are no drugs in the list");
        } else {
            System.out.println("\nEnter the generic name of the drug to remove from list:");
            String drugToRemove = input.next();
            for (Drug d : favouriteDrugs.getFavouriteDrugs()) {
                if (d.getGenName().equals(drugToRemove)) {
                    favouriteDrugs.removeDrug(d);
                    return;
                }
            }
            System.out.println("\n Error: drug entered is not in list");
        }
    }


    // EFFECTS: finds the cheapest drug in the list and prints the generic name of it, gives
    // return message of empty list if no drugs are in the list
    private void findCheapestDrug() {
        if (favouriteDrugs.getNumDrugs() == 0) {
            System.out.println("There are no drugs in the list");
        } else {
            Drug cheapestDrug;
            cheapestDrug = favouriteDrugs.getCheapestDrug();
            System.out.println(cheapestDrug.getGenName());
        }
    }

    // EFFECTS: prints the generic names of all the drugs in the list and gives
    // return message of empty list if no drugs are in the list
    private void getFavouriteDrugs() {
        if (favouriteDrugs.getNumDrugs() == 0) {
            System.out.println("There are no drugs in the list");
        } else {
            for (Drug d : favouriteDrugs.getFavouriteDrugs()) {
                System.out.println(d.getGenName());
            }
        }
    }

    // EFFECTS: finds the cheapest drug in the list and prints the generic name of it and gives
    // return message of empty list if no drugs are in the list
    private void getMostExpensiveDrug() {
        if (favouriteDrugs.getNumDrugs() == 0) {
            System.out.println("There are no drugs in the list");
        } else {
            Drug expensiveDrug;
            expensiveDrug = favouriteDrugs.getExpensiveDrug();
            System.out.println(expensiveDrug.getGenName());
        }
    }

    // EFFECTS: returns all the drugs in the entered class, gives
    // return message of empty list if no drugs are in the list
    private void getDrugsInClass() {
        if (favouriteDrugs.getNumDrugs() == 0) {
            System.out.println("There are no drugs in the list");
        } else {
            System.out.println("\n Enter a drug class to return:");
            String drugInClass = input.next();
            for (Drug d : favouriteDrugs.getDrugsInSameClass(drugInClass)) {
                System.out.println(d.getGenName());
            }
        }
    }

    // EFFECTS: saves the favourite drug list to file
    private void saveFavouriteDrugs() {
        try {
            jsonWriter.open();
            jsonWriter.write(favouriteDrugs);
            jsonWriter.close();
            System.out.println("Saved favourite drugs to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadFavouriteDrugs() {
        try {
            favouriteDrugs = jsonReader.read();
            System.out.println("Loaded favourite drugs from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
