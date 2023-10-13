package az.ingress.ms1relations.service;

import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    UserResponse findById(Long id);
}
