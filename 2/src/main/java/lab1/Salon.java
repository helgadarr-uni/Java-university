package lab1;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Salon {
    private int id;
    private String address;
    private String phoneNumber;


    private List<Car> cars;


    public static class Builder{
        private Salon salon;
        public static String PHONE_PATTERN = "\\d+\\(\\d{3}\\)\\d+";

        public Builder(){
            salon = new Salon();
        }

        public Salon.Builder setId(int id){
            salon.id=id;
            return this;
        }

        public Salon.Builder setAddress(String address){
            salon.address=address;
            return this;
        }

        public Salon.Builder setPhoneNumber(String phoneNumber){
            if (phoneNumber.length()==12 && phoneNumber.matches(PHONE_PATTERN)){
            salon.phoneNumber=phoneNumber;}
            else {throw new IllegalArgumentException("Don't matches telephone format!");}
            return this;
        }

        public Salon.Builder setCars(List<Car> cars ){
            salon.cars=cars;
            return this;
        }

        public Salon build() {
            return salon;
        }


    }

    @Override
    public String toString() {
        return "Salon{"
                + "id='" + id + '\''
                + ",address=" + address + '\''
                + ",phoneNumber=" + phoneNumber + '\''
                + ",cars= "+ cars + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj){
        if (obj==this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Salon salon = (Salon) obj;
        return id == salon.id ||
                phoneNumber.equals(salon.phoneNumber)&&
                (address != null && address.equals(salon.getAddress())
        );
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,address,phoneNumber);
    }


}
