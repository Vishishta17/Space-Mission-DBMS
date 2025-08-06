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

public class FullMissionReportViewer extends JFrame {

    public FullMissionReportViewer() {
        setTitle("Full Mission Report");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Mission");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Spacecraft");
        model.addColumn("Launch Site");
        model.addColumn("Outcome");
        model.addColumn("Director");
        model.addColumn("Total Astronauts");

        try (Connection conn = DBConnection.getConnection()) {
            String query = """
                SELECT 
                    m.name AS mission_name,
                    m.start_date,
                    m.end_date,
                    s.name AS spacecraft_name,
                    l.launch_site,
                    l.outcome,
                    mc.director AS mission_director,
                    COUNT(ma.astronaut_id) AS total_astronauts
                FROM Mission m
                JOIN Spacecraft s ON m.spacecraft_id = s.spacecraft_id
                JOIN Launch l ON m.launch_id = l.launch_id
                JOIN mission_control mc ON m.mission_control_id = mc.mission_control_id
                LEFT JOIN Mission_Astronaut ma ON m.mission_id = ma.mission_id
                GROUP BY m.mission_id;
            """;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("mission_name"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getString("spacecraft_name"),
                    rs.getString("launch_site"),
                    rs.getString("outcome"),
                    rs.getString("mission_director"),
                    rs.getInt("total_astronauts")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading mission report.");
        }

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FullMissionReportViewer().setVisible(true));
    }
}

