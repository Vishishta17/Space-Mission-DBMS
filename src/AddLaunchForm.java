/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikit
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddLaunchForm extends JFrame {

    private JTextField launchTimeField, launchSiteField, outcomeField, missionIdField, spacecraftIdField;

    public AddLaunchForm() {
        setTitle("Add New Launch");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Launch Time (yyyy-MM-dd HH:mm:ss):"));
        launchTimeField = new JTextField();
        add(launchTimeField);

        add(new JLabel("Launch Site:"));
        launchSiteField = new JTextField();
        add(launchSiteField);

        add(new JLabel("Outcome:"));
        outcomeField = new JTextField();
        add(outcomeField);

        add(new JLabel("Mission ID:"));
        missionIdField = new JTextField();
        add(missionIdField);

        add(new JLabel("Spacecraft ID:"));
        spacecraftIdField = new JTextField();
        add(spacecraftIdField);

        JButton submitButton = new JButton("Add Launch");
        submitButton.addActionListener(e -> addLaunch());
        add(submitButton);

        add(new JLabel()); // empty cell
    }

    private void addLaunch() {
        String launchTime = launchTimeField.getText();
        String launchSite = launchSiteField.getText();
        String outcome = outcomeField.getText();
        int missionId = Integer.parseInt(missionIdField.getText());
        int spacecraftId = Integer.parseInt(spacecraftIdField.getText());

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Launch (launch_time, launch_site, outcome, mission_id, spacecraft_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, launchTime);
            stmt.setString(2, launchSite);
            stmt.setString(3, outcome);
            stmt.setInt(4, missionId);
            stmt.setInt(5, spacecraftId);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Launch added successfully!");
            dispose(); // close window
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding launch: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddLaunchForm().setVisible(true));
    }
}

