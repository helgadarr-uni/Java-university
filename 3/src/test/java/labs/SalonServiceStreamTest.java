package labs;

import labs.enums.BRAND;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;


public class SalonServiceStreamTest {
    private static Salon salon;
    private static Car car90000;
    private static Car car70000;
    private static Car car80000;
    private static Car car100000;

    @BeforeClass
    public static void beforeClass(){
        car90000 = new Car.Builder().setId(122).setBrand(BRAND.BMW).setMaxSpeed(200000).setYear(2019).setPrice(90000).build();
        car70000 = new Car.Builder().setId(112).setBrand(BRAND.BMW).setMaxSpeed(600000).setYear(2012).setPrice(70000).build();
        car80000 = new Car.Builder().setId(1122).setBrand(BRAND.BMW).setMaxSpeed(700000).setYear(2013).setPrice(80000).build();
        car100000 = new Car.Builder().setId(122).setBrand(BRAND.BMW).setMaxSpeed(500000).setYear(2015).setPrice(100000).build();

        salon = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234867").setCars(List.of(car90000, car70000,car80000, car100000)).build();

    }

    @Test
    public void testStreamSortAboveSpecifiedPrice(){
        SalonServiceStream sortService = new SalonServiceStream(salon);
        List<Car> expected = List.of(car80000, car90000, car100000);
        List<Car> actual = sortService.sortAboveSetPrice(80000);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testStreamSortLowerSpecifiedPrice(){
        List<Car> expected = List.of(car70000, car80000);
        SalonServiceStream sortService = new SalonServiceStream(salon);
        List<Car> actual = sortService.sortLowerSetPrice(80000);

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void tesStreamSortBetweenSpecifiedPrices(){
        List<Car> expected = List.of(car70000, car80000, car90000);
        SalonServiceStream sortService = new SalonServiceStream(salon);
        List<Car> actual = sortService.sortBetweenSetPrice(700000,90000);

        Assert.assertEquals(expected,actual);
    }
}
