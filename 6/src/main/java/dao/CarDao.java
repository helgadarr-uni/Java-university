package dao;

import labs.Car;
import labs.Salon;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    Car getCarById(Integer id) throws SQLException;

    List<Car> getAllCars(String query) throws SQLException;

    Car createCar(Car car, Salon salon);

    Boolean deleteCar(Integer id) throws SQLException;

    Boolean updateCar(Car car) throws SQLException;

}
