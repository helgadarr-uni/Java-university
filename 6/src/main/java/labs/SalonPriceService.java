package labs;

import labs.enums.SORT;

import java.util.*;


public class SalonPriceService {
    private Salon salon;
    private PriceComparator priceComparator;

    public SalonPriceService(Salon salon) {
        this.salon = salon;
        priceComparator = new PriceComparator();
    }

    /*Sorting with Comparator*/
    public Set<Car> abovePrice(double price, SORT type) {
        TreeSet<Car> cars = new TreeSet<Car>(priceComparator);
        for (Car car : salon.getCars()) {
            if (car.getPrice() >= price) {
                cars.add(car);
            }
        }
        if (type==SORT.ASC){
            return cars;
        }
        return cars.descendingSet();
    }

    public Set<Car> belowPrice(double price, SORT type) {
        TreeSet<Car> cars = new TreeSet<Car>(priceComparator);
        for (Car car : salon.getCars()) {
            if (car.getPrice() <= price) {
                cars.add(car);
            }
        }
        if (type==SORT.DSC){
            return cars.descendingSet();
        }
        return cars;
    }

    public Set<Car> betweenSpecifiedPrices(double priceFrom, double priceTo, SORT type) {
        TreeSet<Car> cars = new TreeSet<Car>(priceComparator);
        for (Car car : salon.getCars()) {
            if (car.getPrice() >= priceFrom && car.getPrice()<=priceTo) {
                cars.add(car);
            }
        }
        if (type==SORT.ASC){
            return cars;
        }
        return cars.descendingSet();
    }







}
