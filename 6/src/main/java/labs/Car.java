package labs;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import jakarta.validation.constraints.*;
import labs.enums.BRAND;
import labs.enums.COLOR;
import labs.enums.ENGINE;
import labs.serializer.TXTSerializable;
import lombok.Getter;


import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;


@Getter
@JacksonXmlRootElement(localName="MyCars")
public class Car implements TXTSerializable<Car>, Comparable<Car>{
    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(BRAND brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngineType(ENGINE engineType) {
        this.engineType = engineType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @NotNull(message = "Can't be null, required field")
//    @Positive(message = "Id should be positive")
    @JacksonXmlProperty(localName = "id")
    //car_id
    private Integer id;


    @NotNull(message = "Required field")
    @JacksonXmlProperty(localName = "brand")
    public BRAND brand;

    @Size(min=2, max=10, message = "Min length = 2 characters; Max length = 10 characters")
    @JacksonXmlProperty(localName = "model")
    private String model;

    @JacksonXmlProperty(localName = "color")
    private COLOR color;

    @Min(value = 70, message = "Min maxSpeed = 70")
    @Max(value = 200, message = "Max maxSpeed = 200")
    @JacksonXmlProperty(localName = "maxSpeed")
    private double maxSpeed;

    @JacksonXmlProperty(localName = "year")
    private int year;

    @JacksonXmlProperty(localName = "engineType")
    private ENGINE engineType;

    @Min(40000)
    @Max(100000)
    @JacksonXmlProperty(localName = "price")
    private double price;


    public Car() {
    }

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
        private final Car car;

        public Builder() {
            car = new Car();
        }

        public Builder setId(int id) {
            car.id = id;
            return this;
        }

        public Builder setBrand(BRAND brand) {
            car.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            car.model = model;
            return this;
        }

        public Builder setColor(COLOR color) {
            car.color = color;
            return this;
        }

        public Builder setMaxSpeed(double maxSpeed) {
            car.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setYear(int year) {
            int currentYear = Year.now().getValue();
            if (year<currentYear-15){
                throw new IllegalArgumentException("the car must not be older than 15 years ");
            }
            car.year = year;
            return this;
        }

        public Builder setEngineType(ENGINE engineType) {
            car.engineType = engineType;
            return this;
        }
//        public Builder setSalonId(Integer salonId){
//            car.salonId = salonId;
//            return this;
//        }

        public Builder setPrice(double price) {
            car.price = price;
            return this;
        }

        public Car build() {
            Car car = this.car;
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Car>> violations = validator.validate(car);
            StringBuilder errorMessage = new StringBuilder();
            for(ConstraintViolation<Car> violation : violations){
                errorMessage.append(violation.getInvalidValue() + violation.getMessage() + violation.getPropertyPath());
            }
            if(!errorMessage.isEmpty()){
                throw new IllegalArgumentException(errorMessage.toString());

            }
            return car;
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
//        car.salonId=Integer.valueOf(values.get(7).trim());
        car.price=Double.parseDouble(values.get(8).trim());
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
        return id.equals(someCar.id)
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
