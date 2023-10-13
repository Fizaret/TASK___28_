package az.ingress.ms1relations.dto.response;

import az.ingress.ms1relations.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long id;

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

    Booking booking;

}
