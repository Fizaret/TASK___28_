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
public class FlightRequest {
    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String arrivalTime;

    String airline;
}
