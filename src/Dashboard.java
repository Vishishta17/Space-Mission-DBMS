///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author nikit
// */
//import javax.swing.*;
//import java.awt.*;
//
//public class Dashboard extends JFrame {
//
//    public Dashboard() {
//        setTitle("Space Mission Database - Add Details");
//        setSize(400, 500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(0, 1, 10, 10));
//
//        // Buttons for adding data
//        JButton addAgencyBtn = new JButton("➕ Add Agency");
//        JButton addAstronautBtn = new JButton("➕ Add Astronaut");
//        JButton addSpacecraftBtn = new JButton("➕ Add Spacecraft");
//        JButton addMissionBtn = new JButton("➕ Add Mission");
//        JButton addLaunchBtn = new JButton("➕ Add Launch");
//        JButton addPayloadBtn = new JButton("➕ Add Payload");
//        JButton exitBtn = new JButton("🚪 Exit");
//
//        // Add to layout
//        add(addAgencyBtn);
//        add(addAstronautBtn);
//        add(addSpacecraftBtn);
//        add(addMissionBtn);
//        add(addLaunchBtn);
//        add(addPayloadBtn);
//        add(exitBtn);
//
//        // Actions for each button
//        addAgencyBtn.addActionListener(e -> new AddAgencyForm().setVisible(true));
//        addAstronautBtn.addActionListener(e -> new AssignAstronaut().setVisible(true));
//        addSpacecraftBtn.addActionListener(e -> new AddSpacecraftForm().setVisible(true));
//        addMissionBtn.addActionListener(e -> new AddMissionForm().setVisible(true));
//        addLaunchBtn.addActionListener(e -> new AddLaunchForm().setVisible(true));
//        addPayloadBtn.addActionListener(e -> new AddPayloadForm().setVisible(true));
//        exitBtn.addActionListener(e -> System.exit(0));
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
//    }
//}
//


//import javax.swing.*;
//import java.awt.*;
//
//public class Dashboard extends JFrame {
//
//    public Dashboard() {
//        setTitle("Space Mission Database - Add Details");
//        setSize(400, 500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Use a JPanel with padding and background color
//        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));
//        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        mainPanel.setBackground(new Color(230, 240, 255)); // Light blue background
//
//        // Create buttons with a uniform style
//        JButton addAgencyBtn = createStyledButton("➕ Add Agency");
//        JButton addAstronautBtn = createStyledButton("➕ Add Astronaut");
//        JButton addSpacecraftBtn = createStyledButton("➕ Add Spacecraft");
//        JButton addMissionBtn = createStyledButton("➕ Add Mission");
//        JButton addLaunchBtn = createStyledButton("➕ Add Launch");
//        JButton addPayloadBtn = createStyledButton("➕ Add Payload");
//        JButton exitBtn = createStyledButton("🚪 Exit");
//
//        // Add buttons to the panel
//        mainPanel.add(addAgencyBtn);
//        mainPanel.add(addAstronautBtn);
//        mainPanel.add(addSpacecraftBtn);
//        mainPanel.add(addMissionBtn);
//        mainPanel.add(addLaunchBtn);
//        mainPanel.add(addPayloadBtn);
//        mainPanel.add(exitBtn);
//
//        // Add action listeners (same logic)
//        addAgencyBtn.addActionListener(e -> new AddAgencyForm().setVisible(true));
//        addAstronautBtn.addActionListener(e -> new AssignAstronaut().setVisible(true));
//        addSpacecraftBtn.addActionListener(e -> new AddSpacecraftForm().setVisible(true));
//        addMissionBtn.addActionListener(e -> new AddMissionForm().setVisible(true));
//        addLaunchBtn.addActionListener(e -> new AddLaunchForm().setVisible(true));
//        addPayloadBtn.addActionListener(e -> new AddPayloadForm().setVisible(true));
//        exitBtn.addActionListener(e -> System.exit(0));
//
//        add(mainPanel);
//    }
//
//    private JButton createStyledButton(String text) {
//        JButton button = new JButton(text);
//        button.setFocusPainted(false);
//        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
//        button.setForeground(Color.WHITE);
//        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        return button;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
//    }
//}


import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("🚀 Space Mission Dashboard - Add Details");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        Font emojiFont = new Font("Segoe UI Emoji", Font.PLAIN, 16);

        // Buttons with emojis
        JButton addAgencyBtn = new JButton("🏢 Add Agency");
        JButton addAstronautBtn = new JButton("🧑‍🚀 Assign Astronaut");
        JButton addSpacecraftBtn = new JButton("🚀 Add Spacecraft");
        JButton addMissionBtn = new JButton("🛰️ Add Mission");
        JButton addLaunchBtn = new JButton("📅 Add Launch");
        JButton addPayloadBtn = new JButton("📦 Add Payload");
        JButton exitBtn = new JButton("❌ Exit");

        // Apply styling
        JButton[] buttons = {
            addAgencyBtn, addAstronautBtn, addSpacecraftBtn,
            addMissionBtn, addLaunchBtn, addPayloadBtn, exitBtn
        };

        for (JButton btn : buttons) {
            btn.setFont(emojiFont);
            btn.setBackground(new Color(60, 63, 65));
            btn.setForeground(Color.WHITE);
        }

        // Add buttons to frame
        add(addAgencyBtn);
        add(addAstronautBtn);
        add(addSpacecraftBtn);
        add(addMissionBtn);
        add(addLaunchBtn);
        add(addPayloadBtn);
        add(exitBtn);

        // Button actions
        addAgencyBtn.addActionListener(e -> new AddAgencyForm().setVisible(true));
        addAstronautBtn.addActionListener(e -> new AssignAstronaut().setVisible(true));
        addSpacecraftBtn.addActionListener(e -> new AddSpacecraftForm().setVisible(true));
        addMissionBtn.addActionListener(e -> new AddMissionForm().setVisible(true));
        addLaunchBtn.addActionListener(e -> new AddLaunchForm().setVisible(true));
        addPayloadBtn.addActionListener(e -> new AddPayloadForm().setVisible(true));
        exitBtn.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}

