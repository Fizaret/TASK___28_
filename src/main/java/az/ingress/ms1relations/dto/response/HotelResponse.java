package az.ingress.ms1relations.dto.response;

import az.ingress.ms1relations.domain.Booking;
import az.ingress.ms1relations.domain.RoomType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double price;

    Booking booking;
}
