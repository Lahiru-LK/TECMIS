package com.tecmis.project.connection_DB;

import java.sql.*;

public class JDBC {
    public Connection databaseLink;
    public Connection getConnection() {


        String url = "jdbc:mysql://localhost:3306/tecmis";
        String user = "root";
        String password = "";


//---------------try catch use karanwa DB wala error hoyaganna lesi wenna
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");       //use drive
            databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("DB Conneted Successful!\n");


        } catch (Exception e) {
            e.printStackTrace();//error print
            e.getCause();

        }
        return databaseLink;
    }
}
