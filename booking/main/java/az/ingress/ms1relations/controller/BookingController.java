package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import az.ingress.ms1relations.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/booking")
public class BookingController {


   private final BookingService bookingService;

@GetMapping("{id}")
    public ResponseEntity<BookingResponse> findById(@PathVariable Long id){
    return new ResponseEntity<>(bookingService.findById(id), HttpStatus.OK);

}
@GetMapping()
    public ResponseEntity<List<BookingResponse>> findById(){
    return  new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
}
@PostMapping("/payments/{paymentid}/users/{userId}")
public ResponseEntity<BookingResponse> save(@PathVariable Long userId,
                                                                 @PathVariable Long paymentid,
                                                                 @RequestBody BookingRequest bookingRequest){
    return new ResponseEntity<>(bookingService.save(userId,paymentid,bookingRequest), HttpStatus.CREATED);
        }
        @DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
 bookingService.delete(id);

        }
}
