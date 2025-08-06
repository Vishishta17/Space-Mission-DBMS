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

 class PayloadViewer extends JFrame {

    public PayloadViewer() {
        setTitle("Payloads with Spacecraft and Missions");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Payload Name");
        model.addColumn("Type");
        model.addColumn("Spacecraft Name");
        model.addColumn("Mission Name");

        try (Connection conn = DBConnection.getConnection()) {
            String query = """
                SELECT 
                    p.name AS payload_name,
                    p.type,
                    s.name AS spacecraft_name,
                    m.name AS mission_name
                FROM Payload p
                JOIN Spacecraft s ON p.spacecraft_id = s.spacecraft_id
                JOIN Mission m ON s.spacecraft_id = m.spacecraft_id;
            """;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("payload_name"),
                    rs.getString("type"),
                    rs.getString("spacecraft_name"),
                    rs.getString("mission_name")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading payload data.");
        }

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayloadViewer().setVisible(true));
    }
}
