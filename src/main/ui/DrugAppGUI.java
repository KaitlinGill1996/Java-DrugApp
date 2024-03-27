package ui;

import model.Drug;
import model.FavouriteDrugs;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// represents the GUI for the main frame of the DrugApp
public class DrugAppGUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton newDrugButton;
    private JButton newDrugListButton;
    private JButton newDrugLoadButton;
    private JButton newRemoveDrugButton;
    private JButton newCheapDrugButton;
    private JButton newExpensiveDrugButton;
    private JButton newDrugsInClassButton;
    private JButton newQuitButton;
    private JPanel grayPanel;
    private JPanel panel;
    private JPanel greenPanel;
    private JLabel menuLabel;
    private JLabel drugListLabel;
    private FavouriteDrugs favouriteDrugs;
    private JTextField genNameField;
    private JTextField brandNameField;
    private JTextField drugClassField;
    private JTextField priceField;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: creates the JFrame and adds JLabels and JButtons for the DrugApp GUI
    public DrugAppGUI() {
        JFrame frame = new JFrame(); //creates new Frame
        createMainJFrame();
        createGreenPanel();
        this.add(greenPanel);
        createMenuJLabel();
        this.add(menuLabel);
        createDrugListLabel();
        this.add(drugListLabel);
        createGrayPanel();
        this.add(grayPanel);
        createButtonsForFrame();
        favouriteDrugs = new FavouriteDrugs();
        newDrugButton.addActionListener(this);
        newRemoveDrugButton.addActionListener(this);
        newCheapDrugButton.addActionListener(this);
        newExpensiveDrugButton.addActionListener(this);
        newDrugsInClassButton.addActionListener(this);
        newQuitButton.addActionListener(this);
        newDrugListButton.addActionListener(this);
        newDrugLoadButton.addActionListener(this);
        jsonWriter = new JsonWriter(DrugApp.getJsonStore());
        jsonReader = new JsonReader(DrugApp.getJsonStore());
        this.setVisible(true); // makes the frame visible
    }

    // MODIFIES: This
    // EFFECTS: creates the main JFrame for the GUI
    public void createMainJFrame() {
        this.setLayout(null);
        this.setTitle("DrugApp"); //frame title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits app when clicking x
        this.setResizable(false); //stops frame getting resized
        this.setSize(900, 600); // x and y dimensions of frame
        this.getContentPane().setBackground(new Color(173,214,235));

    }

    // EFFECTS: creates a JButton to add a new drug to the list
    public void createNewDrugButton() {
        newDrugButton = new JButton();
        newDrugButton.setBounds(20, 60, 200, 30);
        newDrugButton.setText("Add new drug to list");
        newDrugButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to remove a drug from the list
    public void createRemoveDrugButton() {
        newRemoveDrugButton = new JButton();
        newRemoveDrugButton.setBounds(20, 120, 200, 30);
        newRemoveDrugButton.setText("Remove a drug from list");
        newRemoveDrugButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to find the cheapest drug in the list
    public void createNewCheapestDrugButton() {
        newCheapDrugButton = new JButton();
        newCheapDrugButton.setBounds(20, 180, 200, 30);
        newCheapDrugButton.setText("Find cheapest drug");
        newCheapDrugButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to find the most expensive drug in the list
    public void createNewExpensiveDrugButton() {
        newExpensiveDrugButton = new JButton();
        newExpensiveDrugButton.setBounds(20, 240, 200, 30);
        newExpensiveDrugButton.setText("Find most expensive drug");
        newExpensiveDrugButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to return all drugs in the same class
    public void createDrugsInClassButton() {
        newDrugsInClassButton = new JButton();
        newDrugsInClassButton.setBounds(20, 300, 200, 30);
        newDrugsInClassButton.setText("Find all drugs in class");
        newDrugsInClassButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to save all drugs to a list
    public void createNewSaveDrugListButton() {
        newDrugListButton = new JButton();
        newDrugListButton.setBounds(20, 360, 200, 30);
        newDrugListButton.setText("Save drug list");
        newDrugListButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to load list of drugs from file
    public void createNewLoadDrugListButton() {
        newDrugLoadButton = new JButton();
        newDrugLoadButton.setBounds(20, 420, 200, 30);
        newDrugLoadButton.setText("Load previous drug list");
        newDrugLoadButton.setFocusable(false);
    }

    // EFFECTS: creates a JButton to exit the DrugApp
    public void createNewQuitButton() {
        newQuitButton = new JButton();
        newQuitButton.setBounds(20, 480, 200, 30);
        newQuitButton.setText("Quit");
        newQuitButton.setFocusable(false);
    }

    // EFFECTS: creates all the JButtons for the menu panel
    private void createButtonsForFrame() {
        createNewDrugButton();
        createRemoveDrugButton();
        createNewCheapestDrugButton();
        createNewExpensiveDrugButton();
        createDrugsInClassButton();
        createNewSaveDrugListButton();
        createNewLoadDrugListButton();
        createNewQuitButton();
        addButtonsToFrame();
    }

    // MODIFIES: this
    // Adds all the JButtons to the JFrame and adds ActionListener for each
    private void addButtonsToFrame() {
        this.add(newDrugButton);
        this.add(newRemoveDrugButton);
        this.add(newCheapDrugButton);
        this.add(newExpensiveDrugButton);
        this.add(newDrugsInClassButton);
        this.add(newDrugListButton);
        this.add(newDrugLoadButton);
        this.add(newQuitButton);
    }

    // EFFECTS: creates a Gray Panel
    public void createGrayPanel() {
        grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        grayPanel.setBounds(300, 60, 600, 460);
    }

    // EFFECTS: creates a new JPanel
    public void createGreenPanel() {
        greenPanel = new JPanel();
        greenPanel.setBackground(new Color(173, 214, 235));
        greenPanel.setBounds(300, 500, 600, 100);
    }

    // EFFECTS: creates a new JLabel for the DrugApp Menu
    public void createMenuJLabel() {
        menuLabel = new JLabel();
        menuLabel.setText("DrugApp Menu:");
        menuLabel.setBounds(65,20, 100, 30);
    }

    // EFFECTS: creates a new JLabel for the top of the Drug List panel
    public void createDrugListLabel() {
        drugListLabel = new JLabel();
        drugListLabel.setText("Drug List:");
        drugListLabel.setBounds(600,20, 100, 30);
    }

    // MODIFIES: This
    // EFFECTS: determines actions performed when each JButton is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newDrugButton) {
            addNewDrug();
        }
        if (e.getSource() == newRemoveDrugButton) {
            removeDrug();
        }
        if (e.getSource() == newCheapDrugButton) {
            displayCheapestDrug();
        }
        if (e.getSource() == newExpensiveDrugButton) {
            displayExpensiveDrug();
        }
        if (e.getSource() == newDrugsInClassButton) {
            String drugClassName = JOptionPane.showInputDialog(null, "Enter the drug class:");
            if (drugClassName != null && !drugClassName.isEmpty()) {
                displayDrugsInSameClass(drugClassName);
            }
        }
        if (e.getSource() == newQuitButton) {
            quitApplication();
        }
        if (e.getSource() == newDrugListButton) {
            saveDrugList();
        }
        if (e.getSource() == newDrugLoadButton) {
            loadDrugList();
        }
    }


    // EFFECTS: creates a JText field that allows you to enter fields for a new drug
    public void createJTextFields() {
        genNameField = new JTextField(10);
        brandNameField = new JTextField(10);
        drugClassField = new JTextField(10);
        priceField = new JTextField(10);
        panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Generic Name:"));
        panel.add(genNameField);
        panel.add(new JLabel("Brand Name:"));
        panel.add(brandNameField);
        panel.add(new JLabel("Drug Class:"));
        panel.add(drugClassField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

    }

    // MODIFIES: This
    // EFFECTS: Adds a new drug to the list if okay is selected on the JOption Pane
    public void addNewDrug() {
        createJTextFields();
        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Drug",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String genName = genNameField.getText();
            String brandName = brandNameField.getText();
            String drugClass = drugClassField.getText();
            double price = Double.parseDouble(priceField.getText());
            Drug newDrug = new Drug(genName, brandName, drugClass, price);
            favouriteDrugs.addDrug(newDrug);
            displayDrugInformation();
        }
    }

    // EFFECTS: removes a drug from the list if the generic name is entered
    public void removeDrug() {
        String enterGenericName = JOptionPane.showInputDialog(null,
                "Enter generic name of the drug to remove:");
        if (enterGenericName != null && !enterGenericName.isEmpty()) {
            for (Drug d : favouriteDrugs.getFavouriteDrugs()) {
                if (d.getGenName().equalsIgnoreCase(enterGenericName)) {
                    favouriteDrugs.removeDrug(d);
                    displayDrugInformation();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Drug with specified generic name not found.");
        }
    }

    // EFFECTS: returns the cheapest drug in the list and prints it onto the greenPanel
    public void displayCheapestDrug() {
        greenPanel.removeAll();
        greenPanel.setLayout(new BoxLayout(greenPanel, BoxLayout.Y_AXIS));
        if (favouriteDrugs.getNumDrugs() != 0) {
            Drug cheapestDrug = favouriteDrugs.getCheapestDrug();
            JLabel cheapestDrugLabel = new JLabel();
            cheapestDrugLabel.setText("The cheapest drug is " + cheapestDrug.getGenName() + " with a unit cost of $"
                    + cheapestDrug.getUnitCost());
            greenPanel.setLayout(new BorderLayout());
            greenPanel.add(cheapestDrugLabel);
            greenPanel.revalidate();
            greenPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No drugs found in list.");
        }
    }

    // EFFECTS: returns the most expensive drug in the list and prints it onto the greenPanel
    public void displayExpensiveDrug() {
        greenPanel.removeAll();
        greenPanel.setLayout(new BoxLayout(greenPanel, BoxLayout.Y_AXIS));
        if (favouriteDrugs.getNumDrugs() != 0) {
            Drug expensiveDrug = favouriteDrugs.getExpensiveDrug();
            JLabel cheapestDrugLabel = new JLabel();
            cheapestDrugLabel.setText("The most expensive drug is " + expensiveDrug.getGenName()
                    + " with a unit cost of $" + expensiveDrug.getUnitCost());
            greenPanel.setLayout(new BorderLayout());
            greenPanel.add(cheapestDrugLabel);
            greenPanel.revalidate();
            greenPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No drugs found in list.");
        }
    }

    // EFFECTS: Takes each drug in the favouriteDrugs list and creates a JLabel for each that is added
    // to the grayPanel
    public void displayDrugInformation() {
        grayPanel.removeAll();
        grayPanel.setLayout(new BoxLayout(grayPanel, BoxLayout.Y_AXIS));
        grayPanel.add(Box.createVerticalStrut(35));
        for (int i = 0; i < favouriteDrugs.getNumDrugs(); i++) {
            Drug drug = favouriteDrugs.getFavouriteDrugs().get(i);
            JLabel drugLabel = new JLabel();
            String indexString = String.valueOf(i + 1);
            drugLabel.setText(indexString + ".  Generic Name: " + drug.getGenName()
                    + "    Brand Name:  " + drug.getBrandName()  + "    Drug Class:  " + drug.getDrugClass()
                    + "    Unit Cost:  "  + drug.getUnitCost());

            grayPanel.add(drugLabel);
        }
        grayPanel.revalidate();
        grayPanel.repaint();
    }

    // EFFECTS: Takes each drug in the favouriteDrugs list that is in the entered class and creates a JLabel for each
    // that is added to the greenPanel
    public void displayDrugsInSameClass(String drugClassName) {
        greenPanel.removeAll();
        greenPanel.setLayout(new BoxLayout(greenPanel, BoxLayout.Y_AXIS));
        ArrayList<Drug> drugsInSameClass = favouriteDrugs.getDrugsInSameClass(drugClassName);
        if (drugsInSameClass.size() != 0) {
            for (Drug d : drugsInSameClass) {
                JLabel drugLabel = new JLabel();
                drugLabel.setText(d.getGenName() + " is in " + drugClassName);
                greenPanel.add(drugLabel);
            }
            greenPanel.revalidate();
            greenPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No drugs in entered class.");
        }
    }

    // EFFECTS: quits the application once the quit button is selected
    public void quitApplication() {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // EFFECTS: saves the favouriteDrugs list to favouriteDrugs.json
    public void saveDrugList() {
        try {
            jsonWriter.open();
            jsonWriter.write(favouriteDrugs);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Drug list successfully saved!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to write file.");
        }
    }

    // EFFECTS: loads the previously saved favouriteDrugs list from favouriteDrugs.json
    public void loadDrugList() {
        try {
            favouriteDrugs = jsonReader.read();
            JOptionPane.showMessageDialog(null, "Drug list successfully loaded!");
            displayDrugInformation();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file.");
        }
    }


}
