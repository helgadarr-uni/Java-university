package dao;

import jdbc.SalonJdbc;
import labs.Car;
import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.enums.ENGINE;
import labs.enums.SORT;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImplTest {
    private final CarDaoImpl carDao;
    private static Car car80000;
    private static Car car90000;
    private static Car car2020;
    private static Car car2021;

    public CarDaoImplTest() throws IOException {
        SalonJdbc salonJdbc = new SalonJdbc();
        carDao = new CarDaoImpl(salonJdbc);
    }

    @BeforeClass
    public static void beforeClass() {
        car90000 = new Car.Builder().setId(1).setBrand(BRAND.BMW).setModel("X5 new").setColor(COLOR.RED).setMaxSpeed(70).setYear(2020).setPrice(90000).setEngineType(ENGINE.EIGHT).build();
        car80000 = new Car.Builder().setId(7).setBrand(BRAND.BMW).setModel("X5 new").setColor(COLOR.RED).setMaxSpeed(70).setYear(2021).setPrice(80000).setEngineType(ENGINE.EIGHT).build();
        car2020 = new Car.Builder().setId(1).setBrand(BRAND.BMW).setModel("X5 new").setColor(COLOR.RED).setMaxSpeed(70).setYear(2020).setPrice(90000).setEngineType(ENGINE.EIGHT).build();
        car2021 = new Car.Builder().setId(7).setBrand(BRAND.BMW).setModel("X5 new").setColor(COLOR.RED).setMaxSpeed(70).setYear(2021).setPrice(80000).setEngineType(ENGINE.EIGHT).build();

    }

    @Test
    public void testGetCarById() throws SQLException {
        Car actual = carDao.getCarById(1);
        Assert.assertEquals(car90000, actual);
    }

    @Test
    public void testGetCars() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car90000);
        expected.add(car80000);
        List<Car> actual = carDao.getCars();
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteCar() throws SQLException {
        Boolean expected = true;
        Boolean actual = carDao.deleteCar(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateCar() throws SQLException {
        Boolean expected = true;
        Boolean actual = carDao.updateCar(car80000);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedAboveCarPriceASC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car80000);
        expected.add(car90000);
        List<Car> actual = carDao.abovePrice(70000, SORT.ASC);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedAboveCarPriceDSC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car90000);
        expected.add(car80000);
        List<Car> actual = carDao.abovePrice(70000, SORT.DSC);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedBelowCarPriceASC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car80000);
        expected.add(car90000);
        List<Car> actual = carDao.belowPrice(100000, SORT.ASC);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedBelowCarPriceDSC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car90000);
        expected.add(car80000);
        List<Car> actual = carDao.belowPrice(100000, SORT.DSC);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedBetweenPriceASC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car80000);
        expected.add(car90000);
        List<Car> actual = carDao.betweenPrice(70000, 100000, SORT.ASC);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedBetweenPriceDSC() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car90000);
        expected.add(car80000);
        List<Car> actual = carDao.betweenPrice(70000, 100000, SORT.DSC);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testAboveCarYear() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car2020);
        expected.add(car2021);
        List<Car> actual = carDao.carsAboveYear(2019);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBelowYear() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car2020);
        expected.add(car2021);
        List<Car> actual = carDao.carsBelowYear(2022);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortedBetweenYears() throws SQLException {
        List<Car> expected = new ArrayList<>();
        expected.add(car2020);
        expected.add(car2021);
        List<Car> actual = carDao.carsBetweenYears(2018, 2022);
        Assert.assertEquals(expected, actual);
    }

}
