package lab1.serializer;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab1.Car;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLSerializerTest {
    @SneakyThrows
    @Test
    public void xmlCarToFile(){
        XmlMapper mapper = new XmlMapper();
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
        mapper.writeValue(new File("XMLObjCar.xml"), car);
    }

    @SneakyThrows
    @Test
    public void testCarListToFile() {
        List<Car> entities = new ArrayList<Car>();
        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
        entities.add(car2);
        entities.add(car1);
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File("XMLObjCar1.xml"),entities);
    }
}
