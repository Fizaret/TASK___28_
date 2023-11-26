package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.Flight;
import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.FlightRequest;
import az.ingress.ms1relations.dto.response.FlightResponse;
import az.ingress.ms1relations.errors.ApplicationException;
import az.ingress.ms1relations.errors.Errors;
import az.ingress.ms1relations.repository.FlightRepository;
import az.ingress.ms1relations.repository.PaymentRepository;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;


    @Override
    public List<FlightResponse> findAll(){
        return flightRepository
                .findAll()
                .stream()
                .map(flight -> modelMapper.map(flight,FlightResponse.class))
                .collect(Collectors.toList());

    }
    @Override
    public FlightResponse findById(Long id){
        Flight flight = flightRepository.findById(id).orElseThrow(()->
                new ApplicationException(Errors.BOOKING_NOT_FOUND));

        return modelMapper.map(flight,FlightResponse.class);

    }


    @Override
    public FlightResponse save(Long userId, Long paymentId, FlightRequest flightRequest){
        User user= getUserById(userId);
        Payment payment = getPaymentById(paymentId);
        Flight flight= createFlight(user,payment,flightRequest);
        return  mapToFlightResponse(flight);
    }
    private User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
                String.format("User not found by id -%s",userId )));
    }
    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id -%s", paymentId)));
    }
    private Flight createFlight(User user,Payment payment,FlightRequest flightRequest) {
        Flight flight =modelMapper.map(flightRequest,Flight.class);
        flight.setPaymentId(payment.getPaymentId());
        flight.setUser(user);
        return flightRepository.save(flight);
    }
    private FlightResponse mapToFlightResponse(Flight flight){
        return modelMapper.map(flight,FlightResponse.class);

    }
    @Override
    public void delete(Long id){
        Flight flight= flightRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Flight is not found by id -%s")
        ));
        flightRepository.delete(flight);
    }
}
