package lab1;

import java.util.List;

public class Salon {
    private int id;
    private String address;
    private String phoneNumber;

    private List<Car> cars;

//    ArrayList<Car> carArrayList new Car();

    public int getId(){return id;}
    public String getAddress(){return address;}
    public String getPhoneNumber(){return phoneNumber;}

    public static class Builder{
        private Salon newSalon;

        public Builder(){
            newSalon = new Salon();
        }

        public Salon.Builder setId(int id){
            newSalon.id=id;
            return this;
        }

        public Salon.Builder setAddress(String address){
            newSalon.address=address;
            return this;
        }

        public Salon.Builder setPhoneNumber(String phoneNumber){
            newSalon.phoneNumber=phoneNumber;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Salon{"
                + "id='" + id + '\''
                + ",address=" + address + '\''
                + ",phoneNumber=" + phoneNumber + '\''
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
        Salon someSalon = (Salon) obj;
        return id == someSalon.id&&
                phoneNumber == someSalon.phoneNumber&&
                (address != null && address.equals(someSalon.getAddress())
        );
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }


}
