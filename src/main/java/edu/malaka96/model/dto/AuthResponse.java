package edu.malaka96.model.dto;

import lombok.*;

@AllArgsConstructor
@Builder
public class AuthResponse {
    private String email;
    private String token;
}
