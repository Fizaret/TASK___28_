package az.ingress.ms1relations.controller;
import az.ingress.ms1relations.dto.request.HotelRequest;
import az.ingress.ms1relations.dto.response.HotelResponse;
import az.ingress.ms1relations.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/hotel")
public class HotelController {


    private final HotelService hotelService;

    @GetMapping("{id}")
    public ResponseEntity<HotelResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity<List<HotelResponse>> findById(){
        return  new ResponseEntity<>(hotelService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/payments/{paymentid}/users/{userId}")
    public ResponseEntity<HotelResponse> save(@PathVariable Long userId,
                                               @PathVariable Long paymentid,
                                               @RequestBody HotelRequest hotelRequest){
        return new ResponseEntity<>(hotelService.save(userId,paymentid,hotelRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        hotelService.delete(id);

    }
}
