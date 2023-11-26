package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.Booking;
import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.domain.RentalCar;
import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.RentalCarRequest;
import az.ingress.ms1relations.dto.response.RentalCarResponse;
import az.ingress.ms1relations.errors.ApplicationException;
import az.ingress.ms1relations.errors.Errors;
import az.ingress.ms1relations.repository.PaymentRepository;
import az.ingress.ms1relations.repository.RentalCarRepository;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class RentalCarServiceImpl implements RentalCarService{
private final RentalCarRepository rentalCarRepository;
private final ModelMapper modelMapper;
private final PaymentRepository paymentRepository;
private final UserRepository userRepository;

    @Override
    public List<RentalCarResponse> findAll(){
        return rentalCarRepository
                .findAll()
                .stream()
                .map(rentalCar -> modelMapper.map(rentalCar,RentalCarResponse.class))
                .collect(Collectors.toList());

    }
    @Override
    public RentalCarResponse findById(Long id){
        RentalCar rentalCar = rentalCarRepository.findById(id).orElseThrow(()->
                new ApplicationException(Errors.BOOKING_NOT_FOUND));

        return modelMapper.map(rentalCar,RentalCarResponse.class);

    }




    @Override
    public RentalCarResponse save(Long userId, Long paymentId, RentalCarRequest rentalCarRequest){
        User user= getUserById(userId);
        Payment payment = getPaymentById(paymentId);
        RentalCar rentalCar= createRentalCar(user,payment,rentalCarRequest);
        return  mapToRentalCarResponse(rentalCar);
    }
    private User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
                String.format("User not found by id -%s",userId )));
    }
    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id -%s", paymentId)));
    }
    private RentalCar createRentalCar(User user,Payment payment,RentalCarRequest rentalCarRequest) {
        RentalCar rentalCar =modelMapper.map(rentalCarRequest,RentalCar.class);
        rentalCar.setPaymentId(payment.getPaymentId());
        rentalCar.setUser(user);
        return rentalCarRepository.save(rentalCar);
    }
    private RentalCarResponse mapToRentalCarResponse(RentalCar rentalCar){
        return modelMapper.map(rentalCar,RentalCarResponse.class);

    }
    @Override
    public void delete(Long id){
        RentalCar rentalCar= rentalCarRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Booking is not found by id -%s")
        ));
        rentalCarRepository.delete(rentalCar);
    }
}
