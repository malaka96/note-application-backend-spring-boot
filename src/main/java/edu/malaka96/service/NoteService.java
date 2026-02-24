package edu.malaka96.service;

import edu.malaka96.model.dto.NoteRequest;

public interface NoteService {
    void addNote(String email, NoteRequest noteRequest);
}
