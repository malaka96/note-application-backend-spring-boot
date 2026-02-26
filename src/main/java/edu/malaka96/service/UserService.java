package edu.malaka96.service;

import edu.malaka96.model.dto.UserRequest;
import edu.malaka96.model.dto.UserResponse;

public interface UserService {
    void register(UserRequest userRequest);
    UserResponse getDetails(String email);
}
