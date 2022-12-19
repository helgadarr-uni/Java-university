package labs;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{
    @Override
    public int compare(Car car1, Car car2) {
       return Double.compare(car1.getPrice(), car2.getPrice());


//        return (int)(car1.getPrice()-car2.getPrice());

//        if (car1.getPrice() == car2.getPrice()) {
//            return 0;
//        }
//        if (car1.getPrice() > car2.getPrice()) {
//            return 1;
//        }
//        else {
//            return -1;
//        }
    }


}
