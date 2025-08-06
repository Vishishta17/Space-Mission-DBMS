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

public class AssignAstronaut extends JFrame {

    private JComboBox<String> missionCombo, astronautCombo;
    private JButton assignBtn;

    public AssignAstronaut() {
        setTitle("Assign Astronaut to Mission");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        missionCombo = new JComboBox<>();
        astronautCombo = new JComboBox<>();
        assignBtn = new JButton("Assign");

        add(new JLabel("Select Mission:"));
        add(missionCombo);
        add(new JLabel("Select Astronaut:"));
        add(astronautCombo);
        add(new JLabel());
        add(assignBtn);

        loadMissions();
        loadAstronauts();

        assignBtn.addActionListener(e -> assignAstronaut());
    }

    private void loadMissions() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT mission_id, name FROM Mission")) {
            while (rs.next()) {
                missionCombo.addItem(rs.getInt("mission_id") + " - " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadAstronauts() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT astronaut_id, name FROM Astronaut")) {
            while (rs.next()) {
                astronautCombo.addItem(rs.getInt("astronaut_id") + " - " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void assignAstronaut() {
        try (Connection conn = DBConnection.getConnection()) {
            String missionStr = (String) missionCombo.getSelectedItem();
            String astronautStr = (String) astronautCombo.getSelectedItem();

            int missionId = Integer.parseInt(missionStr.split(" - ")[0]);
            int astronautId = Integer.parseInt(astronautStr.split(" - ")[0]);

            String sql = "INSERT INTO Mission_Astronaut (mission_id, astronaut_id) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, missionId);
            pstmt.setInt(2, astronautId);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Astronaut assigned successfully! ✅");

        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "This astronaut is already assigned to the mission.");
            } else {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error assigning astronaut.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AssignAstronaut().setVisible(true));
    }
}
