package com.eli.user.service;

import com.eli.user.User;
import com.eli.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserResponseDTO createUser(User user){
        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }
}
