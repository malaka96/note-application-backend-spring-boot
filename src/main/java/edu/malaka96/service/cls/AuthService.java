package edu.malaka96.service.cls;

import edu.malaka96.service.impl.CustomUserDetailsService;
import edu.malaka96.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    public String login(String email, String password){
        // authenticate user
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        //load user details
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
        // generate jwt token and return
        return jwtUtil.generateToken(userDetails);
    }

}
