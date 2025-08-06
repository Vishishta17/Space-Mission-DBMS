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

public class AddSpacecraftForm extends JFrame {
    public AddSpacecraftForm() {
        setTitle("Add New Spacecraft");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        JTextField manufacturerField = new JTextField();

        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField();

        JLabel statusLabel = new JLabel("Status:");
        JTextField statusField = new JTextField();

        JButton addBtn = new JButton("Add Spacecraft");
        JButton cancelBtn = new JButton("Cancel");

        add(nameLabel); add(nameField);
        add(manufacturerLabel); add(manufacturerField);
        add(capacityLabel); add(capacityField);
        add(statusLabel); add(statusField);
        add(addBtn); add(cancelBtn);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String manufacturer = manufacturerField.getText();
            int capacity = Integer.parseInt(capacityField.getText());
            String status = statusField.getText();

            try (Connection con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
                 PreparedStatement pst = con.prepareStatement(
                     "INSERT INTO Spacecraft (name, manufacturer, capacity, status) VALUES (?, ?, ?, ?)")) {

                pst.setString(1, name);
                pst.setString(2, manufacturer);
                pst.setInt(3, capacity);
                pst.setString(4, status);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Spacecraft added successfully!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> dispose());
    }
}
