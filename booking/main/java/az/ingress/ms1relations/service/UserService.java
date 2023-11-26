package az.ingress.ms1relations.service;

import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    UserResponse findById(Long id);

    UserResponse update(Long id,UserRequest userRequest);

    void delete(Long id);

}
