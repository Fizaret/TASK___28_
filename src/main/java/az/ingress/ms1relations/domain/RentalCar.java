package az.ingress.ms1relations.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rental_cars")

public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;


    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;


    public void setPaymentId(Long paymentId) {
    }

    public void setUser(User user) {
    }
}
