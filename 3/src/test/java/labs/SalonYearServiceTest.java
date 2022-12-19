package labs;

import labs.enums.BRAND;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SalonYearServiceTest {
    private static Salon salon;
    private static Car car2012;
    private static Car car2013;
    private static Car car2014;
    private static Car car2016;

    @BeforeClass
    public static void beforeClass() {
        car2012 = new Car.Builder().setId(1223).setBrand(BRAND.BMW).setYear(2012).setPrice(90000).build();
        car2013 = new Car.Builder().setId(1121).setBrand(BRAND.BMW).setYear(2013).setPrice(70000).build();
        car2014 = new Car.Builder().setId(11231).setBrand(BRAND.BMW).setYear(2014).setPrice(80000).build();
        car2016 = new Car.Builder().setId(1224).setBrand(BRAND.BMW).setYear(2016).setPrice(100000).build();

        salon = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234867").setCars(List.of(car2013, car2012, car2014, car2016)).build();
    }

    @Test
    public void testAboveYear() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car2013);
        expected.add(car2014);
        expected.add(car2016);
        SalonYearService sortService = new SalonYearService(salon);
        Set<Car> actual = sortService.aboveYear(2013);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testLowerYear() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car2012);
        expected.add(car2013);
        expected.add(car2014);
        expected.add(car2016);
        SalonYearService sortService = new SalonYearService(salon);
        Set<Car> actual = sortService.lowerYear(2016);

        Assert.assertEquals(expected.toString(), actual.toString());

    }

    @Test
    public void testBetweenYears(){
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car2012);
        expected.add(car2013);
        expected.add(car2014);
        SalonYearService sortService = new SalonYearService(salon);
        Set<Car> actual = sortService.betweenYear(2012,2014);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}
