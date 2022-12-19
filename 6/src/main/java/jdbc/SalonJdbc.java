package jdbc;
import dao.CarDaoImpl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class SalonJdbc {
     public Connection connection;

    public SalonJdbc() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/app.properties"));
        try {
            connection = getConnection(
                    properties.getProperty("db.host"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean createSalon() throws SQLException {
         try (Statement statement = connection.createStatement()) {
            String salon = "CREATE TABLE salon(" +
                    "id serial PRIMARY KEY," +
                    "address VARCHAR(30) NOT NULL," +
                    "phoneNumber CHAR(12)" +
                    ");";
            return statement.execute(salon);
        }
    }

    public Boolean createCar() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String car = "CREATE TABLE car(" +
                    "id serial PRIMARY KEY, " +
                    "salon_id INT NOT NULL, " +
                    "brand VARCHAR(20) NOT NULL, " +
                    "model VARCHAR(20), " +
                    "color VARCHAR(20), " +
                    "maxSpeed DECIMAL, " +
                    "year INT, " +
                    "price DECIMAL,"+
                    "engineType VARCHAR(25), " +
                    "FOREIGN KEY (salon_id) REFERENCES  salon(id) " +
                    ");";
            return statement.execute(car);
        }
    }

    public Boolean createTables() throws SQLException {
        return createSalon() && createCar();
    }

    public void dropCar() throws SQLException, IOException {
        Statement statement = connection.createStatement();
        String dropCar = "DROP TABLE IF EXISTS car;";
        statement.execute(dropCar);
    }

    public void dropSalon() throws SQLException{
        Statement statement = connection.createStatement();
        String dropSalon = "DROP TABLE IF EXISTS salon;";
        statement.execute(dropSalon);
    }

    public void dropTables() throws SQLException, IOException {
        dropCar();
        dropSalon();
    }

    public static void main(String[] args) throws SQLException, IOException {
        SalonJdbc salonJdbc = new SalonJdbc();
//        salonJdbc.createTables();
        salonJdbc.createCar();
//        salonJdbc.dropTables();

    }
}


