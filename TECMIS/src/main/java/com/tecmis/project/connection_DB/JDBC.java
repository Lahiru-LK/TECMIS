package com.tecmis.project.connection_DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    public static Connection databaseLink;
    public static Connection getConnection() {



        try {

            Class.forName("com.mysql.cj.jdbc.Driver");       //use drive

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/tecmis", "root", "");
            System.out.println("DB Connected Successful!\n");
            return connect;

        } catch (Exception e) {e.printStackTrace();}

        return null;
    }
}
