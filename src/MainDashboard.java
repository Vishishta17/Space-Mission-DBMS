/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikit
 */
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class MainDashboard extends JFrame {
//
//    public MainDashboard() {
//        setTitle("Space Mission Dashboard");
//        setSize(400, 450);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(0, 1, 10, 10));
//
//        JButton agencyBtn = new JButton("View Agencies");
//        JButton astronautBtn = new JButton("View Astronauts");
//        JButton spacecraftBtn = new JButton("View Spacecraft");
//        JButton payloadBtn = new JButton("View Payloads");
//        JButton missionBtn = new JButton("View Missions");
//        JButton launchBtn = new JButton("View Launches");
//        JButton reportBtn = new JButton("View Mission Reports");
//
//        // Action Listeners
//        agencyBtn.addActionListener(e -> new AgencyViewer().setVisible(true));
//        astronautBtn.addActionListener(e -> new AstronautAssignmentLogViewer().setVisible(true));
//        spacecraftBtn.addActionListener(e -> new SpacecraftViewer().setVisible(true));
//        payloadBtn.addActionListener(e -> new PayloadViewer().setVisible(true));
//        missionBtn.addActionListener(e -> new MissionViewer().setVisible(true));
//        launchBtn.addActionListener(e -> new LaunchViewer().setVisible(true));
//        reportBtn.addActionListener(e -> new MissionReportViewer().setVisible(true));
//
//        // Add to frame
//        add(agencyBtn);
//        add(astronautBtn);
//        add(spacecraftBtn);
//        add(payloadBtn);
//        add(missionBtn);
//        add(launchBtn);
//        add(reportBtn);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
//    }
//}
//


//import javax.swing.*;
//import java.awt.*;
//
//public class MainDashboard extends JFrame {
//
//    public MainDashboard() {
//        setTitle("🚀 Space Mission Dashboard");
//        setSize(400, 450);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridLayout(0, 1, 10, 10));
//
//        // Font and color styling
//        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
//        Color bgColor = new Color(60, 63, 65); // dark background
//        Color fgColor = Color.WHITE;
//
//        JButton agencyBtn = new JButton("🏢 View Agencies");
//        JButton astronautBtn = new JButton("🧑‍🚀 View Astronauts");
//        JButton spacecraftBtn = new JButton("🚀 View Spacecraft");
//        JButton payloadBtn = new JButton("📦 View Payloads");
//        JButton missionBtn = new JButton("🛰️ View Missions");
//        JButton launchBtn = new JButton("📅 View Launches");
//        JButton reportBtn = new JButton("📋 View Mission Reports");
//
//        JButton[] buttons = {
//            agencyBtn, astronautBtn, spacecraftBtn,
//            payloadBtn, missionBtn, launchBtn, reportBtn
//        };
//
//        for (JButton btn : buttons) {
//            btn.setFont(buttonFont);
//            btn.setBackground(bgColor);
//            btn.setForeground(fgColor);
//        }
//
//        // Action Listeners
//        agencyBtn.addActionListener(e -> new AgencyViewer().setVisible(true));
//        astronautBtn.addActionListener(e -> new AstronautAssignmentLogViewer().setVisible(true));
//        spacecraftBtn.addActionListener(e -> new SpacecraftViewer().setVisible(true));
//        payloadBtn.addActionListener(e -> new PayloadViewer().setVisible(true));
//        missionBtn.addActionListener(e -> new MissionViewer().setVisible(true));
//        launchBtn.addActionListener(e -> new LaunchViewer().setVisible(true));
//        reportBtn.addActionListener(e -> new MissionReportViewer().setVisible(true));
//
//        // Add to frame
//        for (JButton btn : buttons) {
//            add(btn);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
//    }
//}


import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {

    public MainDashboard() {
        setTitle("Space Mission Dashboard");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        // Custom font and colors
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color buttonColor = new Color(70, 130, 180); // Steel Blue
        Color textColor = Color.WHITE;

        // Buttons
        JButton agencyBtn = new JButton("View Agencies");
        JButton astronautBtn = new JButton("View Astronauts");
        JButton spacecraftBtn = new JButton("View Spacecraft");
        JButton payloadBtn = new JButton("View Payloads");
        JButton missionBtn = new JButton("View Missions");
        JButton launchBtn = new JButton("View Launches");
        JButton reportBtn = new JButton("View Mission Reports");

        // Button styling
        JButton[] buttons = {
            agencyBtn, astronautBtn, spacecraftBtn,
            payloadBtn, missionBtn, launchBtn, reportBtn
        };

        for (JButton btn : buttons) {
            btn.setFont(buttonFont);
            btn.setBackground(buttonColor);
            btn.setForeground(textColor);
            btn.setFocusPainted(false);
        }

        // Action Listeners
        agencyBtn.addActionListener(e -> new AgencyViewer().setVisible(true));
        astronautBtn.addActionListener(e -> new AstronautAssignmentLogViewer().setVisible(true));
        spacecraftBtn.addActionListener(e -> new SpacecraftViewer().setVisible(true));
        payloadBtn.addActionListener(e -> new PayloadViewer().setVisible(true));
        missionBtn.addActionListener(e -> new MissionViewer().setVisible(true));
        launchBtn.addActionListener(e -> new LaunchViewer().setVisible(true));
        reportBtn.addActionListener(e -> new MissionReportViewer().setVisible(true));

        // Add to layout
        for (JButton btn : buttons) {
            add(btn);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}
