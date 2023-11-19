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
public class RentalCarRequest {


    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;
}
