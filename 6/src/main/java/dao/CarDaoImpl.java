package dao;

import jdbc.SalonJdbc;
import labs.Car;
import labs.Salon;
import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.enums.ENGINE;
import labs.enums.SORT;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class CarDaoImpl implements CarDao {
    SalonJdbc salonJdbc;

    public CarDaoImpl(SalonJdbc salonJdbc) {
        this.salonJdbc = salonJdbc;
    }

    private static final HashMap<Integer, Car> cache = new HashMap<Integer, Car>();


    @Override
    public Car getCarById(Integer carId) throws SQLException {
        return getAllCars("SELECT * FROM car where id = " + carId).get(0);
    }

    public List<Car> getCars() throws SQLException {
        return getAllCars("SELECT * FROM car");
    }

    @Override
    public List<Car> getAllCars(String query) throws SQLException {
        List<Car> list = new ArrayList<>();
        Statement stmt = salonJdbc.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Car car = resultSetToCar(rs);
            list.add(car);
        }
        return list;
    }

    private Car resultSetToCar(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setBrand(BRAND.valueOf(rs.getString("brand")));
        car.setColor(COLOR.valueOf(rs.getString("color")));
        car.setEngineType(ENGINE.valueOf(rs.getString("enginetype")));
        car.setMaxSpeed(rs.getDouble("maxspeed"));
        car.setModel(rs.getString("model"));
        car.setPrice(rs.getDouble("price"));
        car.setYear(rs.getInt("year"));
        return car;
    }

    @Override
    public Car createCar(Car car, Salon salon) {
        String ADD_NEW_CAR = "INSERT INTO car(" +
                "brand, color, enginetype, maxspeed, model, price, salon_id, year)"
                + "values(?,?,?,?::double precision,?,?::double precision,?,?::integer)";
        try (var carStatement = salonJdbc.connection.prepareStatement(ADD_NEW_CAR)) {
            carStatement.setString(1, car.getBrand().toString());
            carStatement.setString(2, car.getColor().toString());
            carStatement.setString(3, car.getEngineType().toString());
            carStatement.setString(4, String.valueOf(car.getMaxSpeed()));
            carStatement.setString(5, car.getModel());
            carStatement.setDouble(6, car.getPrice());
            carStatement.setInt(7, salon.getId());
            carStatement.setInt(8, car.getYear());
            carStatement.executeUpdate();
        } catch (SQLException throwable) {
            throw new RuntimeException(throwable);
        }
        return car;
    }

    @Override
    public Boolean deleteCar(Integer id) throws SQLException {
        Statement stmt = salonJdbc.connection.createStatement();
        int count = 0;
        if (stmt == null) return false;
        String query = "DELETE FROM car WHERE id = " + id;
        try {
            count = stmt.executeUpdate(query);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        cache.remove(id);
        return count > 0;
    }

    @Override
    public Boolean updateCar(Car car) throws SQLException {
        String query = "UPDATE car SET brand= '" + car.getBrand() + "', " +
                "color = '" + car.getColor() + "', " +
                "enginetype = '" + car.getEngineType() + "', " +
                "maxspeed = '" + car.getMaxSpeed() + "', " +
                "model = '" + car.getModel() + "', " +
                "price = '" + car.getPrice() + "', " +
                "year = '" + car.getYear() + "' " +
                "WHERE id = '" + car.getId() + "'";
        try (Statement stmt = salonJdbc.connection.createStatement()) {
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }


    //Methods like in 3 lab
    public List<Car> abovePrice(double price, SORT type) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query;
        if (type == SORT.ASC)
            query = "SELECT * from car WHERE price > " + price + " ORDER BY price";
        else query = "SELECT * from car WHERE price > " + price + " ORDER BY price DESC";
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public List<Car> belowPrice(double price, SORT type) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query;
        if (type == SORT.ASC)
            query = "SELECT * from car WHERE price < " + price + " ORDER BY price";
        else query = "SELECT * from car WHERE price < " + price + " ORDER BY price DESC";
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public List<Car> betweenPrice(double priceFrom, double priceTo, SORT type) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query;
        if (type == SORT.ASC)
            query = "SELECT * from car WHERE price BETWEEN " + priceFrom + " AND " + priceTo + " ORDER BY price";
        else query = "SELECT * from car WHERE price BETWEEN " + priceFrom + " AND " + priceTo + " ORDER BY price DESC";
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public List<Car> carsAboveYear(int year) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * from car WHERE year > " + year;
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public List<Car> carsBelowYear(int year) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * from car WHERE year < " + year;
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public List<Car> carsBetweenYears(int yearFrom, int yearTo) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * from car WHERE year BETWEEN " + yearFrom + " AND " + yearTo;
        try(Statement stmt = salonJdbc.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = resultSetToCar(rs);
                cars.add(car);
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return cars;
    }

    public static void main(String[] args) throws SQLException, IOException {
        SalonJdbc salonJdbc = new SalonJdbc();
        CarDaoImpl carDao = new CarDaoImpl(salonJdbc);
        System.out.println(carDao.getCars());

    }
}
