package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.domain.Flight;
import az.ingress.ms1relations.dto.request.BookingRequest;
import az.ingress.ms1relations.dto.request.FlightRequest;
import az.ingress.ms1relations.dto.response.BookingResponse;
import az.ingress.ms1relations.dto.response.FlightResponse;
import az.ingress.ms1relations.service.BookingService;
import az.ingress.ms1relations.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("{id}")
    public ResponseEntity<FlightResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findById(id), HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity<List<FlightResponse>> findById(){
        return  new ResponseEntity<>(flightService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/payments/{paymentid}/users/{userId}")
    public ResponseEntity<FlightResponse> save(@PathVariable Long userId,
                                                @PathVariable Long paymentid,
                                                @RequestBody FlightRequest flightRequest){
        return new ResponseEntity<>(flightService.save(userId,paymentid,flightRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightService.delete(id);

    }
}
