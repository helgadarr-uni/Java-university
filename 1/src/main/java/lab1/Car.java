package lab1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.Objects;

enum BRAND {BMW, MERCEDES, TOYOTA, MITSUBISHI, KIA, NISSAN, SKODA}
enum COLOR {RED, SILVER, BLACK, GREEN, MAGENTA}
enum ENGINE {TWIN, THREE, FOUR, FIVE, SIX, EIGHT}

@Getter
@JacksonXmlRootElement(namespace = "urn:stackify:jacksonxml", localName="MyCars")
public class Car {
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "brand")
    private BRAND brand;
    @JacksonXmlProperty(localName = "model")
    private String model;
    @JacksonXmlProperty(localName = "color")
    private COLOR color;
    @JacksonXmlProperty(localName = "maxSpeed")
    private double maxSpeed;
    @JacksonXmlProperty(localName = "year")
    private int year;
    @JacksonXmlProperty(localName = "engineType")
    private ENGINE engineType;


    public static class Builder {
        private Car Car;

        public Builder() {
            Car = new Car();
        }

        public Builder setId(int id) {
            Car.id = id;
            return this;
        }

        public Builder setBrand(BRAND brand) {
            Car.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            Car.model = model;
            return this;
        }

        public Builder setColor(COLOR color) {
            Car.color = color;
            return this;
        }

        public Builder setMaxSpeed(double maxSpeed) {
            if(maxSpeed<120){
                throw new IllegalArgumentException("Minimum maximum speed == 120");
            }
            Car.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setYear(int year) {
            if (year<2012){
                throw new IllegalArgumentException("Year must must be >= 2012 ");
            }
            Car.year = year;
            return this;
        }

        public Builder setEngineType(ENGINE engineType) {
            Car.engineType = engineType;
            return this;
        }

        public Car build() {
            return Car;
        }

    }

    @Override
    public String toString() {
        return "Car{"
                +"id='" + id + '\''
                + "brand='" + brand + '\''
                + ",model=" + model + '\''
                + ",color=" + color + '\''
                + "maxSpeed='" + maxSpeed + '\''
                + "year='" + year + '\''
                + "engineType='" + engineType + '\''
                + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Car someCar = (Car) obj;
        return id == someCar.id
                && year == someCar.year
                && maxSpeed == someCar.maxSpeed
                && (brand == someCar.brand
                || (model != null && model.equals(someCar.getModel()))
                || (color != null && color.equals(someCar.getColor()))
                || (engineType != null && engineType.equals(someCar.getEngineType()))
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, maxSpeed, brand, model, color, engineType);
    }

}


