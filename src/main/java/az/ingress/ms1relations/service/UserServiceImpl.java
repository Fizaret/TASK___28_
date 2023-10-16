package az.ingress.ms1relations.service;

import az.ingress.ms1relations.domain.User;
import az.ingress.ms1relations.dto.request.UserRequest;
import az.ingress.ms1relations.dto.response.UserResponse;
import az.ingress.ms1relations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }


    @Override
    public UserResponse findById(Long id) {
        User user = (User) userRepository.findById(id).orElseThrow(() -> new RuntimeException(
            String.format("User not found by id -%s", id)
        ));
        return modelMapper.map(user, UserResponse.class);
    }
    @Override
    public UserResponse update(Long id,UserRequest userRequest){
        userRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("User not found for updating by id -%s" ,id)
        ));
        User responseUser = modelMapper.map(userRequest,User.class);
        responseUser.setUserId(id);
        return modelMapper.map(userRepository.save(responseUser),UserResponse.class);

    }
    @Override
    public void delete(Long id){
        User user =userRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("User not found for deleting by id -%s" ,id)
        ));
userRepository.delete(user);
    }




}