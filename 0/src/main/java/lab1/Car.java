package lab1;

import java.util.Objects;

enum BRAND {BMW, MERCEDES, TOYOTA, MITSUBISHI, KIA, NISSAN, SKODA}
enum COLOR {RED, SILVER, BLACK, GREEN, MAGENTA}
enum ENGINE {TWIN, THREE, FOUR, FIVE, SIX, EIGHT}

public class Car {
    private int id;
    private BRAND brand;
    private String model;
    private COLOR color;
    private double maxSpeed;
    private int year;
    private ENGINE engineType;



    public int getId() {
        return id;
    }

    public Enum<BRAND> getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Enum<COLOR> getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getYear() {
        return year;
    }

    public Enum<ENGINE> getEngineType() {
        return engineType;
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
            Car.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setYear(int year) {
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
//        int result = 17;
//        result = 31 * result + id;
//        result = 31 * result + brand.hashCode();
//        result = 31 * result + model.hashCode();
//        result = 31 * result + color.hashCode();
//        result = (int) (31 * result + maxSpeed);
//        result = 31 * result + year;
//        result = 31 * result + engineType.hashCode();
//        return result;
    }

}


