package labs;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.enums.ENGINE;
import labs.serializer.TXTSerializable;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;


@Getter
@JacksonXmlRootElement(localName="MyCars")
public class Car implements TXTSerializable<Car>, Comparable<Car>{
//    @Min(value=4, message = "id ....")
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "brand")
    public BRAND brand;
//    @Size(min=2, max=100)
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

    @JacksonXmlProperty(localName = "price")
    private double price;

    @Override
    public int compareTo(@NotNull Car car) {
        if (this.year == car.year) {
            return 0;
        }
        if (this.year > car.year) {
            return 1;
        }
        else {
            return -1;
        }

    }


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

        public Builder setPrice(double price) {
            Car.price = price;
            return this;
        }

        public Car build() {
//            ValidatoFactory

            return Car;
        }

    }

    @Override
    public String toString() {
        return "Car{"
                +"id='" + id + '\''
                + ",brand='" + brand + '\''
                + ",model=" + model + '\''
                + ",color=" + color + '\''
                + ",maxSpeed='" + maxSpeed + '\''
                + ",year='" + year + '\''
                + ",engineType='" + engineType + '\''
                + ",price='" + price + '\''
                + "};";
    }

    public String toStringSerialize(){
        return  "id=" + id +
                ",brand=" + brand +
                ",model=" + model+
                ",color=" + color+
                ",maxSpeed=" + maxSpeed+
                ",year=" + year +
                ",engineType="+engineType +
                ",price=" + price;
    }

    @Override
    public Car fromStringSerialize(String content) {
        Car car = new Car();
        String[] carString = content.split(",");
        var values = new ArrayList<String>();
        for (String item : carString) {
            String[] innerItem=item.split("=");
            values.add(innerItem[1]);
        }
        car.id=Integer.parseInt(values.get(0).trim());
        car.brand=BRAND.valueOf(values.get(1).trim());
        car.model= values.get(2).trim();
        car.color=COLOR.valueOf(values.get(3).trim());
        car.maxSpeed= Double.parseDouble(values.get(4).trim());
        car.year= Integer.parseInt(values.get(5).trim());
        car.engineType=ENGINE.valueOf(values.get(6).trim());
        car.price=Double.parseDouble(values.get(7).trim());
        return car;
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
                && price == someCar.price
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


