package lab1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;


public class CarTest {
    @Test
    public void testMaxSpeed(){
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(122).setBrand(BRAND.TOYOTA).setMaxSpeed(90).build());
    }
    @Test
    public void testYear(){
        assertThrows(IllegalArgumentException.class,()->new Car.Builder().setId(122).setBrand(BRAND.TOYOTA).setMaxSpeed(90).setYear(1999).build());
    }

    @Test
    public void testEqualCar(){
        Car car1 = new Car.Builder().setId(122).setBrand(BRAND.BMW).build();
        Car car2 = new Car.Builder().setId(122).setBrand(BRAND.BMW).build();
        Assert.assertEquals(car1,car2);
    }

    @Test
    public void testNegativeEqualCar(){
        Car car1 = new Car.Builder().setId(122).setBrand(BRAND.BMW).build();
        Car car2 = new Car.Builder().setId(122).setBrand(BRAND.BMW).setYear(2012).build();
        Assert.assertNotEquals(car1,car2);
    }
    @DataProvider(name = "hashcode-provider")
    public Object[][]  testHashCodeCarProvider(){
        return new Object[][]{
                {
                    new Car.Builder().setId(122).setBrand(BRAND.TOYOTA).build().hashCode(),
                    new Car.Builder().setId(122).setBrand(BRAND.TOYOTA).build().hashCode()
                },
                {
                    new Car.Builder().setId(1212).setBrand(BRAND.TOYOTA).setEngineType(ENGINE.FIVE).build().hashCode(),
                    new Car.Builder().setId(1212).setBrand(BRAND.TOYOTA).setEngineType(ENGINE.FIVE).build().hashCode()
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
                        new Car.Builder().setId(122).setBrand(BRAND.KIA).setYear(2012).build().hashCode(),
                        new Car.Builder().setId(122).setBrand(BRAND.BMW).setColor(COLOR.RED).build().hashCode()
                },
                {
                        new Car.Builder().setId(132).setBrand(BRAND.TOYOTA).setEngineType(ENGINE.FIVE).build().hashCode(),
                        new Car.Builder().setId(12).setBrand(BRAND.TOYOTA).setEngineType(ENGINE.EIGHT).build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hash-provider")
    public void negativeTestHashCodeCar(int p1, int p2)
    {
        Assert.assertNotEquals(p1,p2);
    }


}
