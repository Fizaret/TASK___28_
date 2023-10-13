package az.ingress.ms1relations.dto.response;

import az.ingress.ms1relations.domain.Flight;
import az.ingress.ms1relations.domain.Hotel;
import az.ingress.ms1relations.domain.RentalCar;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    Long id;

    String bookingDate;

    String totalCost;

    List<Flight> flights;

    List<Hotel> hotels;

    List<RentalCar> rentalCars;

    PaymentResponse payment;




}
