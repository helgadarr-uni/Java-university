package labs.serializer;

import labs.Car;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class XMLSerializerTest {
    FileContent fileContent = new FileContent();

    @SneakyThrows
    @Test
    public void xmlCarToFile() {
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
        XMLSerializer<Car> serializer = new XMLSerializer<>();
        serializer.toFile(car, "XMLObjCar.xml");
        assertEquals(fileContent.fileContent("XMLObjCar.xml"), fileContent.fileContent("XMLObjCar1.xml"));
    }

    @SneakyThrows
    @Test
    public void xmlCarFromFile() {
        XMLSerializer<Car> serializer = new XMLSerializer<>();
        serializer.fromFile("XMLObjCar.xml");
        assertEquals(fileContent.fileContent("XMLObjCar.xml"), fileContent.fileContent("XMLObjCar1.xml"));
    }

    @SneakyThrows
    @Test
    public void testCarListToFile() {
        List<Car> entities = new ArrayList<Car>();
        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
        entities.add(car2);
        entities.add(car1);
        XMLSerializer<Car> serializer = new XMLSerializer<>();
        serializer.listToFile(entities, "XMLCarList.xml");
        assertEquals(fileContent.fileContent("XMLCarList.xml"), fileContent.fileContent("XMLCarList1.xml"));
    }

    @SneakyThrows
    @Test
    public void xmlCarListFromFile() {
        XMLSerializer<Car> serializer = new XMLSerializer<>();
        serializer.listFromFile("XMLCarList.xml");
        assertEquals(fileContent.fileContent("XMLCarList.xml"), fileContent.fileContent("XMLCarList1.xml"));
    }
}
