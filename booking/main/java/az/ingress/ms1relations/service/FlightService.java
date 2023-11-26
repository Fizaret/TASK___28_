package az.ingress.ms1relations.service;
import az.ingress.ms1relations.dto.request.FlightRequest;
import az.ingress.ms1relations.dto.response.FlightResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface  FlightService {

    List<FlightResponse> findAll();



    FlightResponse findById(Long id);


    FlightResponse save(Long userId, Long paymentId, FlightRequest flightRequest);



    void delete(Long id);
}
