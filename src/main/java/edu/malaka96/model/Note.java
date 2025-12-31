package edu.malaka96.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Note {
    private Integer id;
    private String title;
    private String body;
    private boolean isFavorite;
}
