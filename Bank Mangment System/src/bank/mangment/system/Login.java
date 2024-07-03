/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangment.system;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Jayant
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
      JButton signin,signup,cl;
       JTextField cardTextField;
       JPasswordField  pinTextField;
       
      Login() {
        setTitle("Automated Teller Machine");
        setLayout(null);

        // Load and scalelogo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        // Create and position the logo label
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Create and position the text label
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Arial", Font.BOLD, 38));
        add(text);

        // Create and position the card number label
        JLabel carNo = new JLabel("Card NO:");
        carNo.setBounds(120, 150, 400, 40);
        carNo.setFont(new Font("Raleway", Font.BOLD, 28));
        add(carNo);

        // Initialize and add the card text field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));

        add(cardTextField);

        // Create and position the pin number label
        JLabel pin = new JLabel("Pin NO:");
        pin.setBounds(120, 220, 350, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
                cardTextField.setFont(new Font("Arial", Font.BOLD, 14));

        add(pin);

        // Initialize and add the pin text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
                pinTextField.setFont(new Font("Arial", Font.BOLD, 14));

        add(pinTextField);

        // Initialize and add the sign in button
        signin = new JButton("Sign in");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        // Initialize and add the clear button
        cl = new JButton("Clear");
        cl.setBounds(430, 300, 100, 30);
        cl.setBackground(Color.BLACK);
        cl.setForeground(Color.WHITE);
        cl.addActionListener(this);
        add(cl);

        // Initialize and add the sign up button
        signup = new JButton("Sign up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Set the background color of the frame
        getContentPane().setBackground(Color.WHITE);

        // Set the size, location, and visibility of the frame
        setSize(800, 500);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cl) {
            pinTextField.setText("");
            cardTextField.setText("");
        } else if (ae.getSource() == signin) {
            // Sign in logic
           Conn c1 = new Conn();
            String cardno = cardTextField.getText();
            String pin = new String(pinTextField.getPassword());
            String q = "select * from login where cardno = ? and pin = ?";

            try {
                PreparedStatement ps = c1.con.prepareStatement(q);
                ps.setString(1, cardno);
                ps.setString(2, pin);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else { 
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while signing in. Please try again.");
            }
        } else if (ae.getSource() == signup) {
            // Sign up logic
             setVisible(false);
            SignupOne signup=new SignupOne();
            signup.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
   