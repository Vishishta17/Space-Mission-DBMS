///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author nikit
// */
//import javax.swing.*;
//import java.awt.*;
//
//public class HomePage extends JFrame {
//    public HomePage() {
//        setTitle("Space Mission Control Center");
//        setSize(500, 300);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        JLabel title = new JLabel("Welcome to Space Mission Control", JLabel.CENTER);
//        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
//        title.setForeground(Color.BLUE);
//        add(title, BorderLayout.NORTH);
//
//        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 10));
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
//
//        JButton dashboardBtn = new JButton("Add New Entries");
//        JButton mainDashboardBtn = new JButton("View Dashboard");
//
//        dashboardBtn.setBackground(new Color(70, 130, 180));
//        dashboardBtn.setForeground(Color.WHITE);
//        dashboardBtn.setFont(new Font("Arial", Font.BOLD, 16));
//
//        mainDashboardBtn.setBackground(new Color(34, 139, 34));
//        mainDashboardBtn.setForeground(Color.WHITE);
//        mainDashboardBtn.setFont(new Font("Arial", Font.BOLD, 16));
//
//        centerPanel.add(dashboardBtn);
//        centerPanel.add(mainDashboardBtn);
//
//        add(centerPanel, BorderLayout.CENTER);
//
//        // Action Listeners
//        dashboardBtn.addActionListener(e -> {
//            dispose();
//            new Dashboard().setVisible(true);  // assumes Dashboard.java exists
//        });
//
//        mainDashboardBtn.addActionListener(e -> {
//            dispose();
//            new MainDashboard().setVisible(true);  // assumes MainDashboard.java exists
//        });
//    }
//
//    // Run this to start the whole app
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new HomePage().setVisible(true);
//        });
//    }
//}
//


//
//import javax.swing.*;
//import java.awt.*;
//
//public class HomePage extends JFrame {
//    public HomePage() {
//        setTitle("🚀 Space Mission Control Center");
//        setSize(600, 400);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setContentPane(new GradientPanel());
//
//        setLayout(new BorderLayout());
//
//        JLabel title = new JLabel("Welcome to Space Mission Control", JLabel.CENTER);
//        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
//        title.setForeground(Color.WHITE);
//        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
//        add(title, BorderLayout.NORTH);
//
//        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 30, 10)) {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                setOpaque(false);
//            }
//        };
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
//
//        JButton dashboardBtn = createStyledButton("📊 View Dashboard", new Color(70, 130, 180));
//        JButton mainDashboardBtn = createStyledButton("➕ Add New Entries", new Color(60, 179, 113));
//
//        centerPanel.add(dashboardBtn);
//        centerPanel.add(mainDashboardBtn);
//        add(centerPanel, BorderLayout.CENTER);
//
//        // Actions
//        dashboardBtn.addActionListener(e -> {
//            dispose();
//            new Dashboard().setVisible(true);
//        });
//
//        mainDashboardBtn.addActionListener(e -> {
//            dispose();
//            new MainDashboard().setVisible(true);
//        });
//    }
//
//    // Custom JButton with round corners and hover effects
//    private JButton createStyledButton(String text, Color bgColor) {
//        JButton button = new JButton(text);
//        button.setFocusPainted(false);
//        button.setFont(new Font("Verdana", Font.BOLD, 16));
//        button.setBackground(bgColor);
//        button.setForeground(Color.WHITE);
//        button.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
//        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        return button;
//    }
//
//    // Gradient Background Panel
//    class GradientPanel extends JPanel {
//        @Override
//        protected void paintComponent(Graphics g) {
//            Graphics2D g2d = (Graphics2D) g;
//            Color color1 = new Color(25, 25, 112);
//            Color color2 = new Color(100, 149, 237);
//            int width = getWidth();
//            int height = getHeight();
//            GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
//            g2d.setPaint(gp);
//            g2d.fillRect(0, 0, width, height);
//        }
//    }
//
//    // Entry Point
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new HomePage().setVisible(true);
//        });
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Space Mission Control Center");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Gradient panel
        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(36, 123, 160);
                Color color2 = new Color(112, 193, 179);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        gradientPanel.setLayout(new BoxLayout(gradientPanel, BoxLayout.Y_AXIS));
        gradientPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel titleLabel = new JLabel("Space Mission Control");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

        JButton dashboardButton = createStyledButton("Add Information");
        JButton entryButton = createStyledButton("Veiw existing entries");

        dashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Dashboard().setVisible(true);
            }
        });

        entryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainDashboard().setVisible(true);
            }
        });

        gradientPanel.add(titleLabel);
        gradientPanel.add(dashboardButton);
        gradientPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gradientPanel.add(entryButton);

        add(gradientPanel);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}
