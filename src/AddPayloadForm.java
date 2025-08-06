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
import java.sql.*;

public class AddPayloadForm extends JFrame {
    public AddPayloadForm() {
        setTitle("Add New Payload");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Payload Name:");
        JTextField nameField = new JTextField();

        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField();

        JLabel statusLabel = new JLabel("Status:");
        JTextField statusField = new JTextField();

        JLabel spacecraftIdLabel = new JLabel("Spacecraft ID:");
        JTextField spacecraftIdField = new JTextField();

        JButton addBtn = new JButton("Add Payload");
        JButton cancelBtn = new JButton("Cancel");

        add(nameLabel); add(nameField);
        add(typeLabel); add(typeField);
        add(statusLabel); add(statusField);
        add(spacecraftIdLabel); add(spacecraftIdField);
        add(addBtn); add(cancelBtn);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String type = typeField.getText();
            String status = statusField.getText();
            int spacecraftId = Integer.parseInt(spacecraftIdField.getText());

            try (Connection con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
                 PreparedStatement pst = con.prepareStatement(
                     "INSERT INTO Payload (name, type, status, spacecraft_id) VALUES (?, ?, ?, ?)")) {

                pst.setString(1, name);
                pst.setString(2, type);
                pst.setString(3, status);
                pst.setInt(4, spacecraftId);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Payload added successfully!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> dispose());
    }
}

