package dao;

import labs.Salon;

import java.sql.SQLException;
import java.util.List;

public interface SalonDao {
    Salon getSalonById(Integer salonId);

    List<Salon> getAllSalons(String query);

    Salon createSalon(Salon salon);

    Boolean updateSalon(Salon salon) throws SQLException;

    Boolean deleteSalon(Integer id) throws SQLException;
}
