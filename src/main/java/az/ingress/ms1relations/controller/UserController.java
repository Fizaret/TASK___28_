package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;
import az.ingress.ms1relations.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userServiceImpl.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userServiceImpl.save(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/id")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceImpl.findById(id), HttpStatus.OK);
    }


}
