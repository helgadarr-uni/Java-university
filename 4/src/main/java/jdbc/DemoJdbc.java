package jdbc;

import java.sql.*;

public class DemoJdbc {
    /** JDBC Driver and database url*/
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/JdbcDemo";
    static final String USER = "postgres";
    static final String PASSWORD = "123456a";


//    private static Connection getDBConnection() {
//        Connection connection;
//        Statement statement;
//        try {
//            Class.forName(DB_DRIVER);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
//            return connection;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return connection;
//    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        System.out.println("Registering JDBC driver...");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        System.out.println("Executing statement...");


        System.out.println("Closing connection and releasing resources...");
        connection.close();
    }
}


