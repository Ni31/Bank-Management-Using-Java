/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangment.system;

/**
 *
 * @author Jayant
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        // Balance display label
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        // Back button
        b1 = new JButton("BACK");
        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);

        // Calculate balance
        int balance = 0;
        try {
            Conn c1 = new Conn();
            String query = "SELECT * FROM bank WHERE pin = ?";
            PreparedStatement pstmt = c1.getCon().prepareStatement(query);
            pstmt.setString(1, pin);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type"); // Ensure the column name matches your database
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equals("Deposit")) {
                    balance += amount;
                } else if (type.equals("Withdrawal")) { // Assuming you have a 'Withdrawal' type
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display balance
        l1.setText("Your Current Account Balance is Rs " + balance);

        // Add action listener to back button
        b1.addActionListener(this);

        // JFrame settings
        setLayout(null);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
