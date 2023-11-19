package az.ingress.ms1relations.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long paymentId;
    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

    @OneToOne(mappedBy = "payment")
    Booking booking;
 public void setUser(User user){

 }

}
