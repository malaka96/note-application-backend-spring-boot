package edu.malaka96.controller;

import edu.malaka96.model.dto.UserRequest;
import edu.malaka96.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest userRequest){
        try{
            userService.register(userRequest);
            return ResponseEntity.ok("User registration successful");
        }catch (ResponseStatusException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
