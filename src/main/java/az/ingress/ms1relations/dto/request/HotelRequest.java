package az.ingress.ms1relations.dto.request;

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
public class HotelRequest {
    String hotelName;

    String location;

    RoomType roomType;

    Double price;
}
