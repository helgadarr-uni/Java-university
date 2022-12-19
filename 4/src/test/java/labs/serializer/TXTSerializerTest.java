package labs.serializer;

import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.Car;
import labs.enums.ENGINE;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TXTSerializerTest {
    FileContent fileContent = new FileContent();
    @Test
    public void toFile() throws IOException, ClassNotFoundException {
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).setModel("Sportage").setEngineType(ENGINE.EIGHT)
                .setBrand(BRAND.KIA).setColor(COLOR.BLACK).build();
        TXTSerializer<Car> serializer = new TXTSerializer<>();
        serializer.toFile(car, "car.txt");
        assertEquals(fileContent.fileContent("car.txt"), fileContent.fileContent("car1.txt"));
    }

    @Test
    public void fromFile(){
        TXTSerializer<Car> serializer = new TXTSerializer<>();
        serializer.fromFile("car.txt");
        assertEquals(fileContent.fileContent("car.txt"), fileContent.fileContent("car1.txt"));
    }
    @Test
    public void listToFile(){
        List<Car> cars = new ArrayList<Car>();
        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
        Car car3 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
        cars.add(car2);
        cars.add(car1);
        cars.add(car3);
        TXTSerializer<Car> serializer = new TXTSerializer<>();
        serializer.listToFile(cars, "carListToFile.txt");
        assertEquals(fileContent.fileContent("carListToFile.txt"), fileContent.fileContent("carListToFile1.txt"));
    }

    @Test
    public void listFromFile(){
        TXTSerializer<Car> serializer = new TXTSerializer<>();
        serializer.listFromFile("carList.txt");
        assertEquals(fileContent.fileContent("carList.txt"), fileContent.fileContent("carList1.txt"));
    }
}
