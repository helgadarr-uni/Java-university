package labs.serializer;

import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.Car;
import labs.enums.ENGINE;
import lombok.SneakyThrows;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class JSONSerializerTest {
    FileContent fileContent = new FileContent();
    /*Testing JSONSerializer for class Car*/
    //Null data is acceptable
//    @SneakyThrows
    @Test
    public void toFile() {
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).setModel("Sportage").setEngineType(ENGINE.EIGHT)
                .setBrand(BRAND.KIA).setColor(COLOR.BLACK).build();
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.toFile(car, "car.json");
        assertEquals(fileContent.fileContent("car.json"), fileContent.fileContent("car1.json"));
    }


    @SneakyThrows
    @Test
    public void jsonCarFromFile(){
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.fromFile("car.json");
        assertEquals(fileContent.fileContent("car.json"), fileContent.fileContent("car1.json"));
    }

    @SneakyThrows
    @Test
    public void jsonCarListToFile(){
        List<Car> cars = new ArrayList<Car>();
        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
        cars.add(car2);
        cars.add(car1);
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.listToFile(cars,"carList.json");
        assertEquals(fileContent.fileContent("carList.json"), fileContent.fileContent("carList1.json"));
    }

    @SneakyThrows
    @Test
    public void jsonCarListFromFile(){
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.listFromFile("carList.json");
        assertEquals(fileContent.fileContent("carList.json"), fileContent.fileContent("carList1.json"));
    }

}
