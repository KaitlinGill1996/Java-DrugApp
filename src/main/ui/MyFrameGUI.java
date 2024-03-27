package ui;

import model.Drug;
import model.FavouriteDrugs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrameGUI extends JFrame implements ActionListener {
    private JButton newDrugButton;
    private JButton newDrugListButton;
    private JButton newDrugLoadButton;
    private JButton newRemoveDrugButton;
    private JButton newCheapDrugButton;
    private JButton newExpensiveDrugButton;
    private JButton newDrugsInClassButton;
    private JButton newQuitButton;
    private JPanel grayPanel;
    private JPanel drugPanel;
    private JLabel drugPanelLabel;
    private JLabel grayPanelLabel;
    private JLabel menuLabel;
    private JLabel drugListLabel;
    private FavouriteDrugs favouriteDrugs;

    public MyFrameGUI() {
        JFrame frame = new JFrame(); //creates new Frame
        this.setLayout(null);
        this.setTitle("DrugApp"); //frame title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits app when clicking x
        this.setResizable(false); //stops frame getting resized
        this.setSize(900, 600); // x and y dimensions of frame
        this.getContentPane().setBackground(new Color(173,214,235));
        createMenuJLabel();
        this.add(menuLabel);
        createDrugListLabel();
        this.add(drugListLabel);
        createGrayPanel();
        this.add(grayPanel);
        createButtonsForFrame();
        addButtonsToFrame();
        favouriteDrugs = new FavouriteDrugs();
        newDrugButton.addActionListener(this);
        this.setVisible(true); // makes the frame visible
    }

    public void createNewDrugButton() {
        newDrugButton = new JButton();
        newDrugButton.setBounds(20, 60, 200, 30);
        newDrugButton.setText("Add new drug to list");
        newDrugButton.setFocusable(false);
    }

    public void createRemoveDrugButton() {
        newRemoveDrugButton = new JButton();
        newRemoveDrugButton.setBounds(20, 120, 200, 30);
        newRemoveDrugButton.setText("Remove a drug from list");
        newRemoveDrugButton.setFocusable(false);
    }

    public void createNewCheapestDrugButton() {
        newCheapDrugButton = new JButton();
        newCheapDrugButton.setBounds(20, 180, 200, 30);
        newCheapDrugButton.setText("Find cheapest drug");
        newCheapDrugButton.setFocusable(false);
    }

    public void createNewExpensiveDrugButton() {
        newExpensiveDrugButton = new JButton();
        newExpensiveDrugButton.setBounds(20, 240, 200, 30);
        newExpensiveDrugButton.setText("Find most expensive drug");
        newExpensiveDrugButton.setFocusable(false);
    }

    public void createDrugsInClassButton() {
        newDrugsInClassButton = new JButton();
        newDrugsInClassButton.setBounds(20, 300, 200, 30);
        newDrugsInClassButton.setText("Find all drugs in class");
        newDrugsInClassButton.setFocusable(false);
    }

    public void createNewSaveDrugListButton() {
        newDrugListButton = new JButton();
        newDrugListButton.setBounds(20, 360, 200, 30);
        newDrugListButton.setText("Save drug list");
        newDrugListButton.setFocusable(false);
    }

    public void createNewLoadDrugListButton() {
        newDrugLoadButton = new JButton();
        newDrugLoadButton.setBounds(20, 420, 200, 30);
        newDrugLoadButton.setText("Load previous drug list");
        newDrugLoadButton.setFocusable(false);
    }

    public void createNewQuitButton() {
        newQuitButton = new JButton();
        newQuitButton.setBounds(20, 480, 200, 30);
        newQuitButton.setText("Quit");
        newQuitButton.setFocusable(false);
    }

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


    public void createGrayPanel() {
        grayPanel = new JPanel();
        grayPanel.setBackground(Color.LIGHT_GRAY);
        grayPanel.setBounds(300, 60, 600, 600);
    }

    public void createDrugPanel() {
        drugPanelLabel = new JLabel();
        drugPanelLabel.setText("Drug List:");
        drugPanel = new JPanel();
        drugPanel.setBackground(Color.LIGHT_GRAY);
        drugPanel.setBounds(300, 0, 600, 60);
    }

    public void createMenuJLabel() {
        menuLabel = new JLabel();
        menuLabel.setText("DrugApp Menu:");
        menuLabel.setBounds(65,20, 100, 30);
    }

    public void createDrugListLabel() {
        drugListLabel = new JLabel();
        drugListLabel.setText("Drug List:");
        drugListLabel.setBounds(600,20, 100, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newDrugButton) {
            addNewDrug();
        }
    }

    public void addNewDrug() {
        JTextField genNameField = new JTextField(10);
        JTextField brandNameField = new JTextField(10);
        JTextField drugClassField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Generic Name:"));
        panel.add(genNameField);
        panel.add(new JLabel("Brand Name:"));
        panel.add(brandNameField);
        panel.add(new JLabel("Drug Class:"));
        panel.add(drugClassField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
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



}
