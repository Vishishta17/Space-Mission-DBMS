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
 class MissionControlViewer extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public MissionControlViewer() {
        setTitle("Mission Control Viewer");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Control ID");
        model.addColumn("Location");
        model.addColumn("Director");

        loadData();

        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadData() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT mission_control_id, location, director FROM mission_control";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("mission_control_id"),
                        rs.getString("location"),
                        rs.getString("director")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading mission control data:\n" + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MissionControlViewer().setVisible(true));
    }
}
