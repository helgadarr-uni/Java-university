package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lab1.Car;
import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        Car toFile
//        ObjectMapper objectMapper = new ObjectMapper();
//        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
//        objectMapper.writeValue(new File("car.json"), car);

//        Car fromFile
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.readValue(new File("car.json"), Car.class));

//        Car listFromFile
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.readValue(new File("car.json"), new TypeReference<List<Car>>(){}));

//        Car listToFile
//        List<Car> cars = new ArrayList<Car>();
//        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
//        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
//        cars.add(car2);
//        cars.add(car1);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("car.json"),cars);

//          toFileXMLCar
//        XmlMapper mapper = new XmlMapper();
//        Car car = new Car.Builder().setId(132).setYear(2021).setMaxSpeed(300).build();
//        mapper.writeValue(new File("XMLObjCar.xml"), car);

//          from fromXMLCar
//        XmlMapper mapper = new XmlMapper();
//        System.out.println(mapper.readValue(new File("XMLObjCar.xml"), Car.class));

//Not work properly
//        List<Car> cars = new ArrayList<Car>();
//        Car car1 = new Car.Builder().setId(122243).setYear(2020).build();
//        Car car2 = new Car.Builder().setId(12422).setYear(2015).setMaxSpeed(130).build();
//        cars.add(car2);
//        cars.add(car1);
//        XmlMapper mapper = new XmlMapper();
//        mapper.writeValue(new File("XMLObjCar1.xml"),cars);
//
//        XmlMapper mapper = new XmlMapper();
//        return mapper.readValue(new File("XMLObjCar1.xml"),
//                new TypeReference<List<Car>>());
    }

}




