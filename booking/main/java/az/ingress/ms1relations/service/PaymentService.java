package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.request.PaymentRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import az.ingress.ms1relations.dto.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentService {

        List<PaymentResponse> findAll();



        PaymentResponse findById(Long id);


        PaymentResponse save(Long userId, Long paymentId, PaymentRequest paymentRequest);



        void delete(Long id);
}
