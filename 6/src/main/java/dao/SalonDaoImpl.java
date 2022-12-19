package dao;

import jdbc.SalonJdbc;
import labs.Salon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalonDaoImpl implements SalonDao {
    SalonJdbc salonJdbc;
    private static final HashMap<Integer, Salon> cache = new HashMap<Integer, Salon>();

    public SalonDaoImpl(SalonJdbc salonJdbc) {
        this.salonJdbc = salonJdbc;
    }

    @Override
    public Salon getSalonById(Integer salonId) {
        return getAllSalons("SELECT * FROM salon where id = " + salonId).get(0);
    }

    public List<Salon> getSalons() {
        return getAllSalons("SELECT * FROM salon");
    }

    @Override
    public List<Salon> getAllSalons(String query) {
        List<Salon> list = new ArrayList<>();
        try (Statement stmt = salonJdbc.connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Salon salon = resultSetToSalon(rs);
                list.add(salon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private Salon resultSetToSalon(ResultSet rs) throws SQLException {
        Salon salon = new Salon();
        salon.setId(rs.getInt("id"));
        salon.setAddress(rs.getString("address"));
        salon.setPhoneNumber(rs.getString("phonenumber"));
        return salon;
    }

    @Override
    public Salon createSalon(Salon salon) {
        String ADD_NEW_SALON = "INSERT INTO salon(" +
                "address, phonenumber)"
                + "values(?,?)";
        try (var salonStatement = salonJdbc.connection.prepareStatement(ADD_NEW_SALON)) {
            salonStatement.setString(1, salon.getAddress().toString());
            salonStatement.setString(2, salon.getPhoneNumber().toString());
            salonStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return salon;
    }

    @Override
    public Boolean updateSalon(Salon salon){
        String query = "UPDATE salon SET address= '" + salon.getAddress() + "', " +
                "phonenumber = '" + salon.getPhoneNumber() + "' " +
                "WHERE id = '" + salon.getId() + "'";
        try (Statement stmt = salonJdbc.connection.createStatement()) {
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public Boolean deleteSalon(Integer id){
        int count = 0;
        String query = "DELETE FROM salon WHERE id = " + id;
        try(Statement stmt = salonJdbc.connection.createStatement()) {
            count = stmt.executeUpdate(query);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        cache.remove(id);
        return count > 0;
    }
}
