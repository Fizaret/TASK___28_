package az.ingress.ms1relations.service;

import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;


    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    public UserResponse save(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    public UserResponse findById(Long id) {
        User user = modelMapper.map(id, User.class);
        userRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapper.map(user, UserResponse.class);
    }
}
