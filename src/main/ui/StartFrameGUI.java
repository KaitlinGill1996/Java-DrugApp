package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the GUI for the opening frame when the DrugApp opens up
public class StartFrameGUI extends JFrame implements ActionListener {
    private JLabel startLabel;
    private JButton newStartButton;
    private ImageIcon imageIcon;
    private JLabel welcomeLabel;

// MODIFIES: this
// EFFECTS: creates the frame and adds JLabels and JButtons
    public StartFrameGUI() {
        JFrame frame = new JFrame(); //creates new Frame
        this.setLayout(null);
        this.setTitle("Welcome to DrugApp"); //frame title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits app when clicking x
        this.setResizable(false); //stops frame getting resized
        this.setSize(600, 600); // x and y dimensions of frame
        this.getContentPane().setBackground(new Color(173,214,235));
        createStartImageJLabel();
        this.add(startLabel);
        createWelcomeLabel();
        this.add(welcomeLabel);
        createStartButton();
        this.add(newStartButton);
        newStartButton.addActionListener(this);
        this.setVisible(true);
    }

    // EFFECTS: creates the image on the opening start panel
    public void createStartImageJLabel() {
        imageIcon = new ImageIcon(getClass().getResource("BlueBottle.png"));
        Image drugImage = imageIcon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIcon drugIcon = new ImageIcon(drugImage);
        startLabel = new JLabel();
        startLabel.setBounds(190, 50, 400, 400);
        startLabel.setIcon(drugIcon);
    }

    // EFFECTS: creates the start JButton
    public void createStartButton() {
        newStartButton = new JButton();
        newStartButton.setBounds(200, 500, 200, 30);
        newStartButton.setText("Start");
        newStartButton.setFocusable(false);
    }

    // EFFECTS: creates the th  JLabel for the welcome to DrugApp title
    public void createWelcomeLabel() {
        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to DrugApp!");
        welcomeLabel.setBounds(230,400, 300, 30);
    }

    // MODIFIES: this
    // EFFECTS: opens the DrugAppGUI frame when the start button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newStartButton) {
            DrugAppGUI drugAppGUI = new DrugAppGUI();
            drugAppGUI.setVisible(true);
            this.setVisible(false);
        }
    }

}
