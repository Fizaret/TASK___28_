package az.ingress.ms1relations.service;
import az.ingress.ms1relations.domain.Hotel;
import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.HotelRequest;
import az.ingress.ms1relations.dto.response.HotelResponse;
import az.ingress.ms1relations.errors.ApplicationException;
import az.ingress.ms1relations.errors.Errors;
import az.ingress.ms1relations.repository.HotelRepository;
import az.ingress.ms1relations.repository.PaymentRepository;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

private final HotelRepository hotelRepository;
private final ModelMapper modelMapper;
private final PaymentRepository paymentRepository;
private final UserRepository userRepository;
    @Override
    public List<HotelResponse> findAll(){
        return hotelRepository
                .findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel,HotelResponse.class))
                .collect(Collectors.toList());

    }
    @Override
    public HotelResponse findById(Long id){
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->
                new ApplicationException(Errors.BOOKING_NOT_FOUND));

        return modelMapper.map(hotel,HotelResponse.class);

    }


    @Override
    public HotelResponse save(Long userId, Long paymentId, HotelRequest hotelRequest){
        User user= getUserById(userId);
        Payment payment = getPaymentById(paymentId);
        Hotel hotel= createhotel(user,payment,hotelRequest);
        return  mapToHotelResponse(hotel);
    }

    private Hotel createhotel(User user, Payment payment, HotelRequest hotelRequest) {
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
    private Hotel createHotel(User user,Payment payment,HotelRequest hotelRequest) {
        Hotel hotel =modelMapper.map(hotelRequest,Hotel.class);
        hotel.setPaymentId(payment.getPaymentId());
        hotel.setUser(user);
        return hotelRepository.save(hotel);
    }
    private HotelResponse mapToHotelResponse(Hotel hotel){
        return modelMapper.map(hotel,HotelResponse.class);

    }
    @Override
    public void delete(Long id){
        Hotel hotel= hotelRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Flight is not found by id -%s")
        ));
        hotelRepository.delete(hotel);
    }
}
