/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikit
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

class AstronautAssignmentLogViewer extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public AstronautAssignmentLogViewer() {
        setTitle("Astronaut Assignment Log Viewer");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Log ID");
        model.addColumn("Astronaut Name");
        model.addColumn("Mission Name");
        model.addColumn("Assigned At");

        loadData();

        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadData() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
             Statement stmt = conn.createStatement()) {

            String query = """
                SELECT 
                    aal.log_id,
                    a.name AS astronaut_name,
                    m.name AS mission_name,
                    aal.assigned_at
                FROM Astronaut_Assignment_Log aal
                JOIN Astronaut a ON aal.astronaut_id = a.astronaut_id
                JOIN Mission m ON aal.mission_id = m.mission_id
            """;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("log_id"),
                        rs.getString("astronaut_name"),
                        rs.getString("mission_name"),
                        rs.getTimestamp("assigned_at")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading assignment logs:\n" + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AstronautAssignmentLogViewer().setVisible(true));
    }
}
