package edu.malaka96.service;

import edu.malaka96.model.dto.NoteRequest;
import edu.malaka96.model.dto.NoteResponse;

import java.util.List;

public interface NoteService {
    void addNote(String email, NoteRequest noteRequest);
    List<NoteResponse> getAllNotes(String email);
    void updateNote(String email, Long id, NoteRequest noteRequest);
}
