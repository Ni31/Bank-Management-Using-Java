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
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
 
    JButton b1;
    JLabel l1;
    
    MiniStatement(String pin) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        // Initialize the labels and button
        l1 = new JLabel();
        l1.setVerticalAlignment(SwingConstants.TOP); // Align text to the top
        JScrollPane scrollPane = new JScrollPane(l1);
        scrollPane.setBounds(20, 140, 360, 340);
        
        JLabel l2 = new JLabel("Indian Bank");
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        b1 = new JButton("Exit");

        // Set the layout and add components
        setLayout(null);
        l2.setBounds(150, 20, 100, 20);
        l3.setBounds(20, 80, 300, 20);
        l4.setBounds(20, 500, 300, 20);
        b1.setBounds(20, 530, 100, 25);

        add(scrollPane);
        add(l2);
        add(l3);
        add(l4);
        add(b1);

        // Fetch card number and transaction details
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (rs.next()) {
                String cardno = rs.getString("cardno");
                l3.setText("Card Number:    " + cardno.substring(0, 4) + "XXXXXXXX" + cardno.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetch transactions and calculate balance
        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            StringBuilder transactions = new StringBuilder("<html>");
            while (rs.next()) {
                transactions.append(rs.getString("date"))
                            .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("type")) // Ensure this matches your DB column name
                            .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("amount"))
                            .append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            transactions.append("</html>");
            l1.setText(transactions.toString());
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add action listener to the button
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(t-++++rue);
    }
}
