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

public class AddAgencyForm extends JFrame {
    public AddAgencyForm() {
        setTitle("Add New Agency");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Agency Name:");
        JTextField nameField = new JTextField();

        JLabel countryLabel = new JLabel("Country:");
        JTextField countryField = new JTextField();

        JLabel yearLabel = new JLabel("Founding Year:");
        JTextField yearField = new JTextField();

        JButton addBtn = new JButton("Add Agency");
        JButton cancelBtn = new JButton("Cancel");

        add(nameLabel); add(nameField);
        add(countryLabel); add(countryField);
        add(yearLabel); add(yearField);
        add(addBtn); add(cancelBtn);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String country = countryField.getText();
            String year = yearField.getText();

            try (Connection con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
                 PreparedStatement pst = con.prepareStatement(
                     "INSERT INTO Agency (name, country, founding_year) VALUES (?, ?, ?)")) {

                pst.setString(1, name);
                pst.setString(2, country);
                pst.setInt(3, Integer.parseInt(year));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Agency added successfully!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        cancelBtn.addActionListener(e -> dispose());
    }
}
