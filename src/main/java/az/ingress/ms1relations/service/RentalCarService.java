package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.RentalCar;
import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.request.RentalCarRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import az.ingress.ms1relations.dto.response.RentalCarResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface RentalCarService {

    List<RentalCarResponse> findAll();



    RentalCarResponse findById(Long id);


    RentalCarResponse save(Long userId, Long paymentId, RentalCarRequest rentalCarRequest);



    void delete(Long id);
}
