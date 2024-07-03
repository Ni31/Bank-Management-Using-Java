/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangment.system;

/**
 *
 * @author Jayant
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    JLabel applicationLabel, personalDetailsLabel, nameLabel, fathersNameLabel, dobLabel, genderLabel, emailLabel, maritalStatusLabel, addressLabel, cityLabel, pinCodeLabel, stateLabel, logoLabel;
    JTextField nameField, fathersNameField, emailField, addressField, cityField, pinCodeField, stateField;
    JRadioButton maleRadioButton, femaleRadioButton, marriedRadioButton, unmarriedRadioButton, otherRadioButton;
    JButton nextButton;
    JDateChooser dobDateChooser;
    Connection con;
    String formNumber;

    SignupOne() {
        try {
            // Initialize database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=7057");

            setTitle("NEW ACCOUNT APPLICATION FORM");

            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
            Image scaledIcon = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon scaledImageIcon = new ImageIcon(scaledIcon);
            logoLabel = new JLabel(scaledImageIcon);
            logoLabel.setBounds(20, 0, 100, 100);
            add(logoLabel);

            applicationLabel = new JLabel();
            applicationLabel.setFont(new Font("Raleway", Font.BOLD, 38));

            personalDetailsLabel = new JLabel("Page 1: Personal Details");
            personalDetailsLabel.setFont(new Font("Raleway", Font.BOLD, 22));

            nameLabel = new JLabel("Name:");
            nameLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            fathersNameLabel = new JLabel("Father's Name:");
            fathersNameLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            dobLabel = new JLabel("Date of Birth:");
            dobLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            genderLabel = new JLabel("Gender:");
            genderLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            emailLabel = new JLabel("Email Address:");
            emailLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            maritalStatusLabel = new JLabel("Marital Status:");
            maritalStatusLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            addressLabel = new JLabel("Address:");
            addressLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            cityLabel = new JLabel("City:");
            cityLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            pinCodeLabel = new JLabel("Pin Code:");
            pinCodeLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            stateLabel = new JLabel("State:");
            stateLabel.setFont(new Font("Raleway", Font.BOLD, 20));

            nameField = new JTextField();
            nameField.setFont(new Font("Raleway", Font.BOLD, 14));

            fathersNameField = new JTextField();
            fathersNameField.setFont(new Font("Raleway", Font.BOLD, 14));

            emailField = new JTextField();
            emailField.setFont(new Font("Raleway", Font.BOLD, 14));

            addressField = new JTextField();
            addressField.setFont(new Font("Raleway", Font.BOLD, 14));

            cityField = new JTextField();
            cityField.setFont(new Font("Raleway", Font.BOLD, 14));

            pinCodeField = new JTextField();
            pinCodeField.setFont(new Font("Raleway", Font.BOLD, 14));

            stateField = new JTextField();
            stateField.setFont(new Font("Raleway", Font.BOLD, 14));

            nextButton = new JButton("Next");
            nextButton.setFont(new Font("Raleway", Font.BOLD, 14));
            nextButton.setBackground(Color.BLACK);
            nextButton.setForeground(Color.WHITE);

            maleRadioButton = new JRadioButton("Male");
            maleRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
            maleRadioButton.setBackground(Color.WHITE);

            femaleRadioButton = new JRadioButton("Female");
            femaleRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
            femaleRadioButton.setBackground(Color.WHITE);

            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);

            marriedRadioButton = new JRadioButton("Married");
            marriedRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
            marriedRadioButton.setBackground(Color.WHITE);

            unmarriedRadioButton = new JRadioButton("Unmarried");
            unmarriedRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
            unmarriedRadioButton.setBackground(Color.WHITE);

            otherRadioButton = new JRadioButton("Other");
            otherRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
            otherRadioButton.setBackground(Color.WHITE);

            ButtonGroup maritalStatusGroup = new ButtonGroup();
            maritalStatusGroup.add(marriedRadioButton);
            maritalStatusGroup.add(unmarriedRadioButton);
            maritalStatusGroup.add(otherRadioButton);

            dobDateChooser = new JDateChooser();
            dobDateChooser.setForeground(new Color(105, 105, 105));
            dobDateChooser.setBounds(137, 337, 200, 29);
            add(dobDateChooser);

            setLayout(null);
            applicationLabel.setBounds(140, 20, 600, 40);
            add(applicationLabel);

            personalDetailsLabel.setBounds(290, 80, 600, 30);
            add(personalDetailsLabel);

            nameLabel.setBounds(100, 140, 100, 30);
            add(nameLabel);

            nameField.setBounds(300, 140, 400, 30);
            add(nameField);

            fathersNameLabel.setBounds(100, 190, 200, 30);
            add(fathersNameLabel);

            fathersNameField.setBounds(300, 190, 400, 30);
            add(fathersNameField);

            dobLabel.setBounds(100, 240, 200, 30);
            add(dobLabel);

            dobDateChooser.setBounds(300, 240, 400, 30);
            add(dobDateChooser);

            genderLabel.setBounds(100, 290, 200, 30);
            add(genderLabel);

            maleRadioButton.setBounds(300, 290, 60, 30);
            add(maleRadioButton);

            femaleRadioButton.setBounds(450, 290, 90, 30);
            add(femaleRadioButton);

            emailLabel.setBounds(100, 340, 200, 30);
            add(emailLabel);

            emailField.setBounds(300, 340, 400, 30);
            add(emailField);

            maritalStatusLabel.setBounds(100, 390, 200, 30);
            add(maritalStatusLabel);

            marriedRadioButton.setBounds(300, 390, 100, 30);
            add(marriedRadioButton);

            unmarriedRadioButton.setBounds(450, 390, 100, 30);
            add(unmarriedRadioButton);

            otherRadioButton.setBounds(635, 390, 100, 30);
            add(otherRadioButton);

            addressLabel.setBounds(100, 440, 200, 30);
            add(addressLabel);

            addressField.setBounds(300, 440, 400, 30);
            add(addressField);

            cityLabel.setBounds(100, 490, 200, 30);
            add(cityLabel);

            cityField.setBounds(300, 490, 400, 30);
            add(cityField);

            pinCodeLabel.setBounds(100, 540, 200, 30);
            add(pinCodeLabel);

            pinCodeField.setBounds(300, 540, 400, 30);
            add(pinCodeField);

            stateLabel.setBounds(100, 590, 200, 30);
            add(stateLabel);

            stateField.setBounds(300, 590, 400, 30);
            add(stateField);

            nextButton.setBounds(620, 660, 80, 30);
            add(nextButton);

            nextButton.addActionListener(this);

            getContentPane().setBackground(Color.WHITE);

            setSize(850, 800);
            setLocation(500, 120);
            setVisible(true);

            generateAndSetFormNumber();  // Generate and set form number on initialization

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String fathersName = fathersNameField.getText();
        String dob = ((JTextField) dobDateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        }

        String email = emailField.getText();
        String maritalStatus = null;
        if (marriedRadioButton.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarriedRadioButton.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (otherRadioButton.isSelected()) {
            maritalStatus = "Other";
        }

        String address = addressField.getText();
        String city = cityField.getText();
        String pinCode = pinCodeField.getText();
        String state = stateField.getText();

        try {
            if (pinCodeField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                String query = "INSERT INTO signup (formno, name, father_name, date_of_birth, gender, email, marital_status, address, city, pincode, state) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, formNumber);
                pstmt.setString(2, name);
                pstmt.setString(3, fathersName);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, maritalStatus);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, pinCode);
                pstmt.setString(11, state);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Application Form Submitted Successfully");
                // Redirect to next page (e.g., SignupTwo)
                new SignupTwo(formNumber).setVisible(true);
                setVisible(false); // Hide the current frame after navigation
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Duplicate Form Number! Generating a new one. Please try again.");
            generateAndSetFormNumber();  // Generate a new form number and retry
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to generate and set form number
    private void generateAndSetFormNumber() {
        boolean isUnique = false;
        while (!isUnique) {
            formNumber = generateFormNumber();
            try {
                String checkQuery = "SELECT COUNT(*) FROM signup WHERE formno = ?";
                PreparedStatement pstmt = con.prepareStatement(checkQuery);
                pstmt.setString(1, formNumber);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    isUnique = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        applicationLabel.setText("APPLICATION FORM NO. " + formNumber);
    }

    // Method to generate form number
    private String generateFormNumber() {
        Random random = new Random();
        long first4Digits = (random.nextLong() % 9000L) + 1000L;
        return String.valueOf(Math.abs(first4Digits));
    }

    public static void main(String[] args) {
        new SignupOne().setVisible(true);
    }
}
