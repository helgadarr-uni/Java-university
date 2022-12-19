package labs;
import java.util.Set;
import java.util.TreeSet;

public class SalonYearService {
    private Salon salon;
    public SalonYearService(Salon salon) {
        this.salon = salon;
    }


    /*Comparable*/
    public Set<Car> aboveYear(int year){
        TreeSet<Car> cars = new TreeSet<Car>();
        for (Car car : salon.getCars()) {
            if (car.getYear() >= year) {
                cars.add(car);
            }
        }
//        return Set.copyOf(cars);
        return cars;
    }

    public Set<Car> lowerYear(int year){
        Set<Car> cars = new TreeSet<>();
        for (Car car : salon.getCars()) {
            if (car.getYear() <= year) {
                cars.add(car);
            }
        }
        return cars;
    }

    public Set<Car> betweenYear(int yearFrom, int yearTo){
        Set<Car> cars = new TreeSet<>();
        for (Car car : salon.getCars()) {
            if (car.getYear() >= yearFrom && car.getYear() <= yearTo) {
                cars.add(car);
            }
        }
        return cars;
    }

//    public void sortAboveSpecifiedYear(int year){
//        List<Car> carList = new ArrayList<Car>();
//        for (Car car : salon.getCars()) {
//            if (car.getYear() >= year) {
//                carList.add(car);
//            }
//        }
//        carList.sort(Car::compareTo);
//    }
//
//    public void sortBetweenSpecifiedYear(int year1,int year2) {
//        List<Car> carList = new ArrayList<Car>();
//        for (Car car : salon.getCars()) {
//            if (car.getYear() >= year1 && car.getYear()<=year2) {
//                carList.add(car);
//            }
//        }
//        carList.sort(Car::compareTo);
//    }
}
