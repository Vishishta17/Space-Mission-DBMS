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

 class MissionLogViewer extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public MissionLogViewer() {
        setTitle("Mission Log Viewer");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Log ID");
        model.addColumn("Mission Name");
        model.addColumn("Inserted At");

        loadData();

        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadData() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/space_mission_db", "root", "NeetNik");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT log_id, mission_name, inserted_at FROM Mission_Log";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("log_id"),
                        rs.getString("mission_name"),
                        rs.getTimestamp("inserted_at")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading mission log:\n" + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MissionLogViewer().setVisible(true));
    }
}
