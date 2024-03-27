package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrameGUI extends JFrame implements ActionListener {
    private JLabel startLabel;
    private JButton newStartButton;
    private ImageIcon imageIcon;


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
        createStartButton();
        this.add(newStartButton);
        newStartButton.addActionListener(this);
        this.setVisible(true);
    }

    public void createStartImageJLabel() {
        imageIcon = new ImageIcon("DrugRack.png");
        startLabel = new JLabel();
        startLabel.setText("Welcome to DrugApp");
        startLabel.setBounds(225, 200, 400, 400);
        startLabel.setIcon(imageIcon);
    }

    public void createStartButton() {
        newStartButton = new JButton();
        newStartButton.setBounds(200, 500, 200, 30);
        newStartButton.setText("Start");
        newStartButton.setFocusable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newStartButton) {
            DrugAppGUI drugAppGUI = new DrugAppGUI();
            drugAppGUI.setVisible(true);
            this.setVisible(false);
        }
    }

}
