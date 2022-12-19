package labs;

import labs.enums.BRAND;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;


public class CarTest {

    @Test
    public void testEqualCar(){
        Car car1 = new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build();
        Car car2 = new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build();
        Assert.assertEquals(car1,car2);
    }

    @Test
    public void testNegativeEqualCar(){
        Car car1 = new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build();
        Car car2 = new Car.Builder().setId(1722).setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(90).setYear(2015).setPrice(40000).build();
        Assert.assertNotEquals(car1,car2);
    }

    @DataProvider(name = "hashcode-provider")
    public Object[][]  testHashCodeCarProvider(){
        return new Object[][]{
                {
                    new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build().hashCode(),
                    new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build().hashCode()
                },
                {
                        new Car.Builder().setId(2333).setBrand(BRAND.NISSAN).setModel("V i70").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode(),
                        new Car.Builder().setId(2333).setBrand(BRAND.NISSAN).setModel("V i70").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hashcode-provider")
    public void testHashCodeCar(int p1, int p2)
    {
        Assert.assertEquals(p1,p2);
    }

    @DataProvider(name = "hash-provider")
    public Object[][]  negativeTestHashCodeCarProvider(){
        return new Object[][]{
                {
                        new Car.Builder().setId(2333).setBrand(BRAND.NISSAN).setModel("V i70").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode(),
                        new Car.Builder().setId(2333).setBrand(BRAND.KIA).setModel("V i70").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode(),
                },
                {
                        new Car.Builder().setId(2333).setBrand(BRAND.NISSAN).setModel("V i70").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode(),
                        new Car.Builder().setId(2312).setBrand(BRAND.NISSAN).setModel("V i71").setMaxSpeed(90).setYear(2015).setPrice(40000).build().hashCode(),
                }
        };
    }

    @Test(dataProvider = "hash-provider")
    public void negativeTestHashCodeCar(int p1, int p2)
    {
        Assert.assertNotEquals(p1,p2);
    }


    @Test
    public void testNullId() {
     assertThrows(IllegalArgumentException.class,()->new Car.Builder().setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build());
    }
    @Test
    public void testNegativeId() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(-12202).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(41000).build());
    }

    @Test
    public void testBrand() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(232).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(40000).build());
    }

    @Test
    public void testBelowMinLengthModel() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(1302).setBrand(BRAND.BMW).setModel("5").setMaxSpeed(80).setYear(2015).setPrice(41000).build());
    }
    @Test
    public void testAboveMaxLengthModel() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(1302).setBrand(BRAND.BMW).setModel("X10 super 1").setMaxSpeed(80).setYear(2015).setPrice(41000).build());
    }

    @Test
    public void testBelowMinMaxSpeed(){
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(60).setYear(2015).setPrice(40000).build());
    }

    @Test
    public void testAboveMaxValMaxSpeed(){
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(201).setYear(2015).setPrice(40000).build());
    }

    @Test
    public void testBelowYear(){
        assertThrows(IllegalArgumentException.class, () -> new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2006).setPrice(40000).build());

    }

    @Test
    public void testBelowMinPrice() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(39000).build());
    }
    @Test
    public void testAboveMaxPrice() {
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(232).setBrand(BRAND.BMW).setModel("IX M60").setMaxSpeed(80).setYear(2015).setPrice(101000).build());
    }
}
