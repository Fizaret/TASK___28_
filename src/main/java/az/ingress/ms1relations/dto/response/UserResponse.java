package az.ingress.ms1relations.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {


    Long id;

    String name;

    String surname;

    String email;

    String phoneNumber;

    List<BookingResponse> booking;
}
