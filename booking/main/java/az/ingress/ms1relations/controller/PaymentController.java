package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.domain.Payment;
import az.ingress.ms1relations.dto.request.HotelRequest;
import az.ingress.ms1relations.dto.request.PaymentRequest;
import az.ingress.ms1relations.dto.response.HotelResponse;
import az.ingress.ms1relations.dto.response.PaymentResponse;
import az.ingress.ms1relations.service.HotelService;
import az.ingress.ms1relations.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/payment")
public class PaymentController {


    private final PaymentService paymentService;

    @GetMapping("{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.findById(id), HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity<List<PaymentResponse>> findById(){
        return  new ResponseEntity<>(paymentService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/payments/{paymentid}/users/{userId}")
    public ResponseEntity<PaymentResponse> save(@PathVariable Long userId,
                                                @PathVariable Long paymentid,
                                                @RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.save(userId,paymentid,paymentRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        paymentService.delete(id);

    }
}
