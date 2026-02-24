package edu.malaka96.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class NoteResponse {
    private Long id;
    private String userEmail;
    private String title;
    private Boolean isFavorite;
    private String body;

}
