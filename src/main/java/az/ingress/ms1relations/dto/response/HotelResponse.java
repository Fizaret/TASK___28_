package az.ingress.ms1relations.dto.response;

import az.ingress.ms1relations.domain.Booking;
import az.ingress.ms1relations.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double price;

    Booking booking;
}
