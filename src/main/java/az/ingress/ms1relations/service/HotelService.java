package az.ingress.ms1relations.service;
import az.ingress.ms1relations.dto.request.HotelRequest;
import az.ingress.ms1relations.dto.response.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HotelService {

        List<HotelResponse> findAll();



        HotelResponse findById(Long id);


        HotelResponse save(Long userId, Long paymentId, HotelRequest hotelRequest);



        void delete(Long id);
}
