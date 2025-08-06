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

public class AstronautForm extends JFrame {

    private JTextField nameField, dobField, roleField, nationalityField, agencyIdField;
    private JButton submitButton;

    public AstronautForm() {
        setTitle("Add New Astronaut");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        dobField = new JTextField();
        add(dobField);

        add(new JLabel("Role:"));
        roleField = new JTextField();
        add(roleField);

        add(new JLabel("Nationality:"));
        nationalityField = new JTextField();
        add(nationalityField);

        add(new JLabel("Agency ID:"));
        agencyIdField = new JTextField();
        add(agencyIdField);

        submitButton = new JButton("Add Astronaut");
        add(submitButton);
        add(new JLabel()); // empty cell

        submitButton.addActionListener(e -> insertAstronaut());
    }

    private void insertAstronaut() {
        String name = nameField.getText();
        String dob = dobField.getText();
        String role = roleField.getText();
        String nationality = nationalityField.getText();
        int agencyId;

        try {
            agencyId = Integer.parseInt(agencyIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Agency ID must be a number.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Astronaut (name, dob, role, nationality, agency_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, role);
            ps.setString(4, nationality);
            ps.setInt(5, agencyId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Astronaut added successfully!");
                nameField.setText("");
                dobField.setText("");
                roleField.setText("");
                nationalityField.setText("");
                agencyIdField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add astronaut.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AstronautForm().setVisible(true);
        });
    }
}
