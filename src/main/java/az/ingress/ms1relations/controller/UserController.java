package az.ingress.ms1relations.controller;

import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;
import az.ingress.ms1relations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.save(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,@RequestBody UserRequest userRequest){

        return new ResponseEntity<>(userService.update(id,userRequest),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);

    }

}