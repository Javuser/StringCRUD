package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/project_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2oo1Nurik";

    public DatabaseConnection(){
    }

    public Connection getConnection() {
        try{
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
