package labs;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
public class Salon {

    @NotNull(message = "Id cannot be null")
    @Positive(message = "Id should be positive")
    private Integer id;

    @NotNull(message = "Address field is required")
    @Size(min = 15, max = 30)
    private String address;
    @Size(max = 12)
    @Pattern(regexp = "\\d+\\(\\d{3}\\)\\d+",message = "Don't matches phone pattern 0(950)234867")
    private String phoneNumber;

    private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public List<Car> getCars() {
        return cars;
    }



    public static class Builder{
        private Salon salon;
//        public static String PHONE_PATTERN = "\\d+\\(\\d{3}\\)\\d+";

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
//            if (phoneNumber.length()==12 && phoneNumber.matches(PHONE_PATTERN)){
//            salon.phoneNumber=phoneNumber;}
//            else {throw new IllegalArgumentException("Don't matches telephone format!");}
            salon.phoneNumber=phoneNumber;
            return this;
        }

        public Salon.Builder setCars(List<Car> cars ){
            salon.cars=cars;
            return this;
        }

        public Salon build() {
            Salon salon = this.salon;
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Salon>> violations = validator.validate(salon);
            StringBuilder errorMessage = new StringBuilder();
            for(ConstraintViolation<Salon> violation : violations){
                errorMessage.append(violation.getInvalidValue()).append(violation.getMessage()).append(violation.getPropertyPath());
            }
            if(!errorMessage.isEmpty()){
                throw new IllegalArgumentException(errorMessage.toString());

            }
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
