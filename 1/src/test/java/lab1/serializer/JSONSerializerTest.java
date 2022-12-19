package lab1.serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab1.Car;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.testng.AssertJUnit.assertEquals;


public class JSONSerializerTest {

    /*Testing JSONSerializer for class Car*/
    //Null data is acceptable
//    @SneakyThrows
    @Test
    public void toFile() {
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.toFile(car, "car.json");
        assertEquals(fileContent("car1.json"), fileContent("car.json"));
    }
    private String fileContent(String fileName){
        Scanner sc= null;
        try {
            sc = new Scanner(new File(fileName));
            StringBuilder sb = new StringBuilder();
            while(sc.hasNextLine()){
                sb.append(sc.nextLine());
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @SneakyThrows
    @Test
    public void jsonCarFromFile(){
        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.fromFile("car.json");
        assertEquals(fileContent("car.json"), fileContent("car1.json"));
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
        assertEquals(fileContent("carList.json"), fileContent("carList1.json"));
    }

    @SneakyThrows
    @Test
    public void jsonCarListFromFile(){
        JSONSerializer<Car> serializer = new JSONSerializer<>();
        serializer.listFromFile("carList.json");
        assertEquals(fileContent("carList.json"), fileContent("carList1.json"));
    }


}
