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

class SpacecraftViewer extends JFrame {
    private JTextField nameField, manufacturerField, capacityField, statusField;
    private JTextArea displayArea;

    public SpacecraftViewer() {
        setTitle("Spacecraft Viewer");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Spacecraft"));

        nameField = new JTextField();
        manufacturerField = new JTextField();
        capacityField = new JTextField();
        statusField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Manufacturer:"));
        inputPanel.add(manufacturerField);
        inputPanel.add(new JLabel("Capacity:"));
        inputPanel.add(capacityField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusField);

        JButton addButton = new JButton("Add Spacecraft");
        JButton viewButton = new JButton("View All Spacecrafts");
        inputPanel.add(addButton);
        inputPanel.add(viewButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(e -> addSpacecraft());
        viewButton.addActionListener(e -> displaySpacecrafts());
    }

    private void addSpacecraft() {
        String name = nameField.getText();
        String manufacturer = manufacturerField.getText();
        int capacity;
        try {
            capacity = Integer.parseInt(capacityField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Capacity must be an integer.");
            return;
        }
        String status = statusField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Spacecraft (name, manufacturer, capacity, status) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, name);
            stmt.setString(2, manufacturer);
            stmt.setInt(3, capacity);
            stmt.setString(4, status);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Spacecraft added successfully.");
            nameField.setText("");
            manufacturerField.setText("");
            capacityField.setText("");
            statusField.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void displaySpacecrafts() {
        displayArea.setText("");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Spacecraft")) {

            while (rs.next()) {
                displayArea.append("ID: " + rs.getInt("spacecraft_id") +
                        ", Name: " + rs.getString("name") +
                        ", Manufacturer: " + rs.getString("manufacturer") +
                        ", Capacity: " + rs.getInt("capacity") +
                        ", Status: " + rs.getString("status") + "\n");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching spacecrafts: " + ex.getMessage());
        }
    }
}

