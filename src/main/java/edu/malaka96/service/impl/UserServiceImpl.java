package edu.malaka96.service.impl;

import edu.malaka96.model.Entity.UserEntity;
import edu.malaka96.model.dto.UserRequest;
import edu.malaka96.repository.UserRepository;
import edu.malaka96.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User is already exists");
        userRepository.save(UserEntity.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .isAccountVerified(false)
                .build());
    }
}
