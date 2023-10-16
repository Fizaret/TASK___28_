package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.Booking;
import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import az.ingress.ms1relations.repository.BookingRepository;
import az.ingress.ms1relations.repository.PaymentRepository;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

@Override
    public List<BookingResponse> findAll(){
        List<BookingResponse>bookingResponses=bookingRepository
                .findAll()
                .stream()
                .map(booking -> modelMapper.map(booking,BookingResponse.class))
                .collect(Collectors.toList());
        return bookingResponses;

    }
    @Override
    public BookingResponse findById(Long id){
        Booking booking = bookingRepository.findById(id).orElseThrow(()-> new RuntimeException(
                String.format("Booking not found by id -%s",id)
        ));
        return modelMapper.map(booking,BookingResponse.class);

    }


@Override
    public BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest){
    User user= getUserById(userId);
    Payment payment = getPaymentById(paymentId);
    Booking booking= createBooking(user,payment,bookingRequest);
    return  mapToBookingResponse(booking);
    }
    private User getUserById(Long userId){
    return userRepository.findById(userId).orElseThrow(()-> new RuntimeException(
               String.format("User not found by id -%s",userId )));
    }
    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id -%s", paymentId)));
//        pwelofigubeiwolruibrnerol
    }
    private Booking createBooking(User user,Payment payment,BookingRequest bookingRequest) {
    Booking booking =modelMapper.map(bookingRequest,Booking.class);
    booking.setPayment(payment);
    booking.setUser(user);
    return bookingRepository.save(booking);
    }
    private BookingResponse mapToBookingResponse(Booking booking){
    return modelMapper.map(booking,BookingResponse.class);

    }
    @Override
    public void delete(Long id){
    Booking booking= bookingRepository.findById(id).orElseThrow(()->new RuntimeException(
            String.format("Booking is not found by id -%s")
    ));
    bookingRepository.delete(booking);
    }


}
