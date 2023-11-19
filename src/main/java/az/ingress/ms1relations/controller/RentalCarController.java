package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.dto.request.RentalCarRequest;
import az.ingress.ms1relations.dto.response.RentalCarResponse;
import az.ingress.ms1relations.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/rental_car")
public class RentalCarController {


    private final RentalCarService rentalCarService;

    @GetMapping("{id}")
    public ResponseEntity<RentalCarResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(rentalCarService.findById(id), HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity<List<RentalCarResponse>> findById(){
        return  new ResponseEntity<>(rentalCarService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/payments/{paymentid}/users/{userId}")
    public ResponseEntity<RentalCarResponse> save(@PathVariable Long userId,
                                                @PathVariable Long paymentid,
                                                @RequestBody RentalCarRequest rentalCarRequest){
        return new ResponseEntity<>(rentalCarService.save(userId,paymentid,rentalCarRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rentalCarService.delete(id);
    }
}

