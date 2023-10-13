package az.ingress.ms1relations.dto.request;

import az.ingress.ms1relations.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequest {
    String hotelName;

    String location;

    RoomType roomType;

    Double price;
}
