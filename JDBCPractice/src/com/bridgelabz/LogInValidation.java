package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogInValidation 
{
    public static void main(String[] args) 
    {
    	Scanner scan=new Scanner(System.in);
        PreparedStatement pstmt = null;
        Connection con = null;
        ResultSet rs = null;
        String qry = "select * from capgenimi.facebook where facebookUserNames =? and facebookPassword=?";
        System.out.println("enter username");
        String facebookUserNames = scan.next();
        System.out.println("enter password");
        String facebookPassword = scan.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, facebookUserNames);
            pstmt.setString(2, facebookPassword);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                System.out.println("successfully login to facebook");
            } else
                System.err.println("invalid username or password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

