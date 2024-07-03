/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangment.system;

/**
 *
 * @author Jayant
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    Connection con;
      public Statement s;

    public Conn() {
        try {
            // Register JDBC driver (optional for newer JDBC drivers)
            // Class.forName("com.mysql.cj.jdbc.Driver");
 con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=7057"
            );
            s = con.createStatement();
          

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}