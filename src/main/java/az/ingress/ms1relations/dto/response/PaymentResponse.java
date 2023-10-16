package az.ingress.ms1relations.dto.response;

import az.ingress.ms1relations.domain.Booking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long paymentId;

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

    Booking booking;

}
