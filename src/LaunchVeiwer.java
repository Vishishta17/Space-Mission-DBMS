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
import java.sql.*;

class LaunchViewer extends JFrame {

    public LaunchViewer() {
        setTitle("All Launches");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Launch ID", "Launch Time", "Launch Site", "Outcome", "Mission ID", "Spacecraft ID"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Launch")) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("launch_id"),
                    rs.getTimestamp("launch_time"),
                    rs.getString("launch_site"),
                    rs.getString("outcome"),
                    rs.getInt("mission_id"),
                    rs.getInt("spacecraft_id")
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading launches: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LaunchViewer().setVisible(true));
    }
}
