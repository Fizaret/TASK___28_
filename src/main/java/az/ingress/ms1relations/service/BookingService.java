package az.ingress.ms1relations.service;

import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface BookingService {
    List<BookingResponse> findAll();

    BookingResponse findById(Long id);
    BookingResponse save(Long userId, Long paymantId, BookingRequest bookingRequest);

    void delete(Long id);
}
