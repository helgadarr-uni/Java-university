package labs;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalonServiceStream {

    private Salon salon;

    public SalonServiceStream(Salon salon) {
        this.salon = salon;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public List<Car> sortAboveSetPrice(double price){
        return salon.getCars().stream()
                .filter(car -> car.getPrice()>=price)
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
    }


    public List<Car> sortBelowSetPrice(double price){
        return salon.getCars().stream()
                .filter(car -> car.getPrice()<=price)
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
    }


    public List<Car> sortBetweenSetPrice(double priceFrom, double priceTo){
        return salon.getCars().stream()
                .filter(car -> car.getPrice()<=priceFrom && car.getPrice()<=priceTo)
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
    }
}
