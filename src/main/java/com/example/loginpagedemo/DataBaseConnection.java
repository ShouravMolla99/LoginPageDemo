package com.example.loginpagedemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "plutologin";
        String databaseUser = "root";
        String databasePassword = "s1234M";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
