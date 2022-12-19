package dao;

import jdbc.SalonJdbc;
import labs.Car;
import labs.Salon;
import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.enums.ENGINE;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SalonDaoImplTest {
    SalonJdbc salonJdbc = new SalonJdbc();
    SalonDao salonDao = new SalonDaoImpl(salonJdbc);

    public SalonDaoImplTest() throws IOException {
    }

    @Test
    public void testCreateSalon() throws SQLException {
        Salon expectedSalon = salonDao.getSalonById(1);
        Salon actualSalon = salonDao.createSalon(expectedSalon);
        Assert.assertEquals(expectedSalon,actualSalon);
    }

    @Test
    public void createSalon(){
        Salon expected = new Salon();
        expected.setAddress("Chernihiv str Popovicha");
        expected.setPhoneNumber("0(950)234819");
        Salon actual = salonDao.createSalon(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testUpdateSalon() throws SQLException {
        Boolean expected = true;
        Salon Salon= new Salon();
        Salon.setId(1);
        Salon.setAddress("Chernivtsi");
        Salon.setPhoneNumber("0(950)234812");
        Boolean actual = salonDao.updateSalon(Salon);
        Assert.assertEquals(expected,actual);
    }
}
