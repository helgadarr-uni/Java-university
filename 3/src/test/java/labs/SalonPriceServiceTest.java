package labs;

import labs.enums.BRAND;
import labs.enums.SORT;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SalonPriceServiceTest {
    private static Salon salon;
    private static Car car90000;
    private static Car car70000;
    private static Car car80000;
    private static Car car100000;

    @BeforeClass
    public static void beforeClass() {
        car70000 = new Car.Builder().setId(1121).setBrand(BRAND.BMW).setYear(2012).setPrice(70000).build();
        car80000 = new Car.Builder().setId(11231).setBrand(BRAND.BMW).setYear(2012).setPrice(80000).build();
        car90000 = new Car.Builder().setId(1223).setBrand(BRAND.BMW).setPrice(90000).build();
        car100000 = new Car.Builder().setId(1224).setBrand(BRAND.BMW).setPrice(100000).build();

        salon = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234867").setCars(List.of(car90000, car80000, car70000, car100000)).build();
    }

    @Test
    public void testAbovePriceASC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car80000);
        expected.add(car90000);
        expected.add(car100000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.abovePrice(80000, SORT.ASC);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testAbovePriceDSC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car100000);
        expected.add(car90000);
        expected.add(car80000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.abovePrice(80000, SORT.DSC);

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testLowerPriceASC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car70000);
        expected.add(car80000);
        expected.add(car90000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.lowerPrice(90000, SORT.ASC);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testLowerPriceDSC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car90000);
        expected.add(car80000);
        expected.add(car70000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.lowerPrice(90000, SORT.DSC);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testBetweenPriceASC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car70000);
        expected.add(car80000);
        expected.add(car90000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.betweenSpecifiedPrices(70000, 90000, SORT.ASC);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testBetweenPriceDSC() {
        Set<Car> expected = new LinkedHashSet<>();
        expected.add(car90000);
        expected.add(car80000);
        expected.add(car70000);
        SalonPriceService sortService = new SalonPriceService(salon);
        Set<Car> actual = sortService.betweenSpecifiedPrices(70000, 90000, SORT.DSC);
        Assert.assertEquals(expected.toString(), actual.toString());
    }


}