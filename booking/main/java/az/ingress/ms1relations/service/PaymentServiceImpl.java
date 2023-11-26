package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.PaymentRequest;
import az.ingress.ms1relations.dto.response.PaymentResponse;
import az.ingress.ms1relations.errors.ApplicationException;
import az.ingress.ms1relations.errors.Errors;
import az.ingress.ms1relations.repository.PaymentRepository;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService{
private final PaymentRepository paymentRepository;
private final ModelMapper modelMapper;
private final UserRepository userRepository;


    @Override
    public List<PaymentResponse> findAll(){

        return paymentRepository
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment,PaymentResponse.class))
                .collect(Collectors.toList());

    }
    @Override
    public PaymentResponse findById(Long id){
        Payment payment = paymentRepository.findById(id).orElseThrow(()->
                new ApplicationException(Errors.BOOKING_NOT_FOUND));

        return modelMapper.map(payment,PaymentResponse.class);

    }




    @Override
    public PaymentResponse save(Long userId, Long paymentId, PaymentRequest paymentRequest){
        User user= getUserById(userId);
        Payment payment= createPayment(user, paymentRequest);
        return  mapToPaymentResponse(payment);
    }



    private PaymentResponse mapToPaymentResponse(Payment payment) {
        return null;
    }

    private User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
                String.format("User not found by id -%s",userId )));
    }
    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id -%s", paymentId)));
    }
    private Payment createPayment(User user, PaymentRequest paymentRequest) {
        Payment payment= modelMapper.map(paymentRequest,Payment.class).getBooking().getPayment();
        payment.setPaymentId(payment.getPaymentId());
        payment.setUser(user);
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id){
        Payment payment= paymentRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Booking is not found by id -%s")
        ));
        paymentRepository.delete(payment);
    }
}
