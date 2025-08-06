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
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddMissionForm extends JFrame {

    private JTextField nameField, startDateField, endDateField;
    private JComboBox<String> statusBox;
    private JTextField spacecraftIdField, missionControlIdField, launchIdField;

    public AddMissionForm() {
        setTitle("Add New Mission");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Mission Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Start Date (YYYY-MM-DD):"));
        startDateField = new JTextField();
        add(startDateField);

        add(new JLabel("End Date (YYYY-MM-DD or blank):"));
        endDateField = new JTextField();
        add(endDateField);

        add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"Active", "Completed", "Planned", "Cancelled"});
        add(statusBox);

        add(new JLabel("Spacecraft ID:"));
        spacecraftIdField = new JTextField();
        add(spacecraftIdField);

        add(new JLabel("Mission Control ID:"));
        missionControlIdField = new JTextField();
        add(missionControlIdField);

        add(new JLabel("Launch ID (optional):"));
        launchIdField = new JTextField();
        add(launchIdField);

        JButton addButton = new JButton("Add Mission");
        addButton.addActionListener(this::addMission);
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void addMission(ActionEvent e) {
        String name = nameField.getText();
        String start = startDateField.getText();
        String end = endDateField.getText().isEmpty() ? null : endDateField.getText();
        String status = (String) statusBox.getSelectedItem();
        int spacecraftId = Integer.parseInt(spacecraftIdField.getText());
        int missionControlId = Integer.parseInt(missionControlIdField.getText());
        String launchIdText = launchIdField.getText();
        Integer launchId = launchIdText.isEmpty() ? null : Integer.parseInt(launchIdText);

        String sql = "INSERT INTO Mission (name, start_date, end_date, status, spacecraft_id, mission_control_id, launch_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, start);
            if (end == null) {
                stmt.setNull(3, java.sql.Types.DATE);
            } else {
                stmt.setString(3, end);
            }
            stmt.setString(4, status);
            stmt.setInt(5, spacecraftId);
            stmt.setInt(6, missionControlId);
            if (launchId == null) {
                stmt.setNull(7, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(7, launchId);
            }

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Mission added successfully! ✅");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding mission: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddMissionForm().setVisible(true));
    }
}
