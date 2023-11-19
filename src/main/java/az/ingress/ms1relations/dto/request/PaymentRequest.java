package az.ingress.ms1relations.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

}
