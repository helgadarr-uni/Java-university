package lab1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertThrows;

public class SalonTest {

    @Test
    public void negativeTestPhoneNumber(){
        assertThrows (IllegalArgumentException.class,()->new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("+0(501)234567").build());
    }
    @Test
    public void TestPhoneNumber(){
        Salon salon1 = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(501)234567").build();
    }
    @Test
    public void testTestEquals() {
        Salon salon1 = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234867").build();
        Salon salon2 = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234867").build();
        Assert.assertEquals(salon1,salon2);
    }

    @Test
    public void negativeTestTestEquals() {

        Salon salon1 = new Salon.Builder().setId(122).setAddress("Komarova str").setPhoneNumber("0(950)234812").build();
        Salon salon2 = new Salon.Builder().setId(121).setAddress("Holovna str").setPhoneNumber("0(950)234867").build();

        Assert.assertNotEquals(salon1,salon2);
    }

    @DataProvider(name = "hashcode-provider")
    public Object[][]  testHashCodeSalonProvider(){
        return new Object[][]{
                {
                        new Salon.Builder().setId(122).setPhoneNumber("0(950)234812").setAddress("Komarova str").build().hashCode(),
                        new Salon.Builder().setId(122).setPhoneNumber("0(950)234812").setAddress("Komarova str").build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hashcode-provider")
    public void TestHashCodeSalon(int p1, int p2)
    {
        Assert.assertEquals(p1,p2);
    }

    @DataProvider(name = "hash-provider")
    public Object[][]  negativeTestHashCodeSalonProvider(){
        return new Object[][]{
                {
                        new Salon.Builder().setId(122).setPhoneNumber("0(950)234812").setAddress("Komarova str").build().hashCode(),
                        new Salon.Builder().setId(124).setPhoneNumber("0(980)234971").setAddress("Holovna str").build().hashCode()
                }
        };
    }

    @Test(dataProvider = "hash-provider")
    public void negativeTestTestHashCodeSalon(int p1, int p2)
    {
        Assert.assertNotEquals(p1,p2);
    }

}