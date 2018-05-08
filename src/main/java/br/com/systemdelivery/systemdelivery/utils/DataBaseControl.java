package br.com.systemdelivery.systemdelivery.utils;

import java.sql.*;

public class DataBaseControl {

    final static String DATABASE_URL = "jdbc:mysql://192.168.0.4:3306/";
    static Connection connection = null;
    static Statement statement = null;

    public static void createDatabase(String nome) throws SQLException {
        try {
            DriverManager.setLoginTimeout(23);
            connection = DriverManager.getConnection(DATABASE_URL, "apps3", "Br@sil3000");

            String sql_stmt = "CREATE DATABASE IF NOT EXISTS " + nome + ";";

            statement = connection.createStatement();

            statement.executeUpdate(sql_stmt);

            System.out.println("customers_db has successfully been created");
            
        } catch (SQLException ex) {
            System.out.println("The following exception has occured: " + ex.getMessage());
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println("The following exception has occured: " + ex.getMessage());
            }
        }
    }
}